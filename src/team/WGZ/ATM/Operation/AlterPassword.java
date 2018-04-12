package team.WGZ.ATM.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Person.Administrator;

public class AlterPassword extends Operation{

    private String password;
	public String work() {
        String sql= "Update Account set Password="+this.password+" where User_ID='"+super.getClient().getUser_ID()+"';";
		return sql;// 编写数据库访问语句sql
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String record() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String sql = "insert into TradeDetail (User_ID,Trade_time,Bank_name,Operation_type,Trade_place,NO) values('"+
				this.getClient().getUser_ID()+"','" +time+"','"+this.getClient().getBank_name()+"','修改密码','广东省广州市','"+Test.databaseconnection.getNextRowID()+"');";
		return sql;
	}
}
