package team.WGZ.ATM.DataConnection;

import java.sql.*;

import team.WGZ.ATM.Operation.Find;
import team.WGZ.ATM.Operation.Operation;
import team.WGZ.ATM.Service.Service;
import team.WGZ.ATM.Person.Administrator;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Person.Creditclient;
import team.WGZ.ATM.Person.Currentclient;
import team.WGZ.ATM.Person.Person;

public class DatabaseConnection {
    private Client client;
    private Administrator administrator;
    private Operation operation;
    private Service service;
    private String targetID;
    private String url="jdbc:sqlserver://localhost:1433;DatabaseName=ATM机_new";
    private String user="sa";
    private String password="123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet result=null;
    public DatabaseConnection() {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		conn = DriverManager.getConnection(url,user,password);
    	}catch(Exception e){
    		System.out.print(e.toString());
    	}
    }
    public Administrator validateAD(String ad) {
    	String sql="select * from Administrator where Ad_ID='"+ad+"';";
        Boolean isexist=false;
		try {
			    this.stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			    this.result=this.stmt.executeQuery(sql);
			    isexist=this.result.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print(e.toString());
			}
		if(isexist){
			try {
				this.administrator=new Administrator(this.result.getString("ID_card"),this.result.getString("Name"),  this.result.getInt("ago"), this.result.getString("Tele"),this.result.getString("Ad_ID"),this.result.getString("Apassword"), this.result.getString("sex"));
				this.stmt.close();
			    return this.administrator;
			} catch (SQLException e) {
				System.out.println("111111111");
				System.out.print(e.toString());
				return null;
			}
		}else{
			return null;
		}
    }
    public Client validateID(String accountID) {//检查ID是否存在，存在返回该用户的对象
    	String sql="select * from account where User_ID='"+accountID+"';";
        Boolean isexist=false;
		try {
			    this.stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			    this.result=this.stmt.executeQuery(sql);
			    isexist=this.result.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print(e.toString());
			}
		if(!isexist) {//查询无果
			try {
				this.stmt.close();
			} catch (SQLException e) {
				System.out.print(e.toString());
			}
			return null;
		}else {
			boolean isCurrent = false;//标记
			try {
				isCurrent=this.result.getString("User_type").equals("活期用户");
			} catch (SQLException e) {
				System.out.print(e.toString());
				
			}
			if(isCurrent) {//查询结果为普通用户
				try {
				this.client  = new Currentclient(this.result.getString("ID_card"),this. result.getString("Name"),result.getInt("Ago") , this.result.getString("Tele"), this.result.getString("User_ID"), this.result.getString("Password"),this.result.getString("Sex"),
						this.result.getString("Account_place"), this.result.getString("Account_time"), this.result.getDouble("Balance"),this. result.getString("State"),this. result.getInt("Today_draft"),
						this.result.getDouble("Today_transfer"), this.result.getString("Bank_name"),this.result.getInt("wrong_time")) ;
				this.stmt.close();
				//this.result.close();
				}catch(SQLException e) {
					System.out.print(e.toString());
				}
				return this.client;
			}else {//查询结果为信用卡用户
				try {
					this.client = new Creditclient(this.result.getString("ID_card"), this.result.getString("Name"),this.result.getInt("Ago") , this.result.getString("Tele"),this. result.getString("User_ID"),this.result.getString("Password"),this.result.getString("Sex"),
							this.result.getString("Account_place"), this.result.getString("Account_time"), this.result.getDouble("Balance"), this.result.getString("State"), this.result.getInt("Today_draft"),
							this.result.getDouble("Today_transfer"),this. result.getString("Bank_name"),this.result.getInt("wrong_time"),this. result.getDouble("overdraft"),this. result.getDouble("remain_overdraft"));
					this.stmt.close();
					//this.result.close();
				} catch (SQLException e) {
					System.out.print(e.toString());
				}
				return this.client;
			}
		}
    }
    //============================================================================================
    public Client correspondingOperation(Operation operation)  {//执行操作
    	if(operation.getClass().getName().equals("team.WGZ.ATM.Operation.Find")) {
    		try {
				this.stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				this.result = this.stmt.executeQuery(operation.work());
				operation.getClient().setRecord(this.result);
				//this.stmt.close();
				return operation.getClient();
			} catch (Exception e) {
				System.out.print(e.toString());
			}
    		
    	}	//==============================find
    	try {
			this.stmt = this.conn.createStatement();
			
			int n=this.stmt.executeUpdate(operation.work());//执行操作
			if(n!=0) {
				this.stmt.executeUpdate(operation.record());
			}
			this.stmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return validateID(operation.getClient().getUser_ID());
    }
  //==============================================================================  
 //服务的访问
    public Client manageService(Service service) {
    	try {
			this.stmt = this.conn.createStatement();
			
			int n=this.stmt.executeUpdate(service.work());//执行操作
			if(n==0) {
				return null;
			}
			this.stmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
    	return validateID(service.getClient().getUser_ID());  	
    }
    //========================================================================
    //================================
    public void UpdateClientState(Client client){//更新状态
        String sql = "Update Account set State='"+client.getState()+"' where User_ID='"+client.getUser_ID()+"';";
        try {
			this.stmt = this.conn.createStatement();
			int n=this.stmt.executeUpdate(sql);
			 //System.out.println(n);
			this.stmt.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
    }
    public void UpdateClientTime(Client client) {
    	String sql="Update Account set Wrong_time="+client.getWrong_time()+" where User_ID='"+client.getUser_ID()+"';";
        try {
			this.stmt = this.conn.createStatement();
			this.stmt.executeUpdate(sql);
			this.stmt.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
    }
	public Connection getConn() {
		return conn;
	}
    public void closeConnection() {
    	try {
			this.conn.close();
			this.result.close();
		} catch (SQLException e) {
            System.out.println(e.toString());
		}
    }
    public int getNextRowID() {  //返回数据记录流水号
    	try {
			this.stmt=this.conn.createStatement();
	    	String sql = "select count(NO) from TradeDetail";
	    	this.result=this.stmt.executeQuery(sql);
	    	this.result.next();
	    	int n=this.result.getInt(1)+1;
	    	//System.out.println(n);
	    	this.stmt.close();
	    	//this.result.close();
	    	return n;
		} catch (SQLException e) {
	        System.out.println(e.toString());
	        return 0;
		}
    }
    
}
