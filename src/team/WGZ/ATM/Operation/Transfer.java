package team.WGZ.ATM.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Person.Creditclient;

public class Transfer extends Operation{

    private double transfermoney;
    private double poundage=0;
    private String targetAccount;
    private boolean isOther=false;//是否跨行
	public String work() {
		String sql;
		if(super.getClient().getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
			if(super.getClient().getBalance()>(double)(this.transfermoney)*0.01+this.transfermoney) {
	    		sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.transfermoney-(double)(this.transfermoney)*0.01)+",today_transfer=" +
		    	        String.valueOf(super.getClient().getTodaytransfer()-this.transfermoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
	    	}else {
	    		Creditclient c= (Creditclient)super.getClient();
	    		sql = "Update Account set Balance=0"+",today_transfer=" +
		    	        String.valueOf(super.getClient().getTodaytransfer()-this.transfermoney)+ ",Remain_overdraft="+String.valueOf(c.getRemain_overdraft()-(this.transfermoney+(double)(this.transfermoney)*0.01-super.getClient().getBalance()))
		    	        +"where User_ID='"+super.getClient().getUser_ID()+"';";
	    	}
	    	this.poundage=(double)(this.transfermoney)*0.01;
		}else{
             if(isOther){
            	 sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.transfermoney-(double)(this.transfermoney)*0.01)+",today_transfer=" +
			    	        String.valueOf(super.getClient().getTodaytransfer()-this.transfermoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
		    	 this.poundage=(double)(this.transfermoney)*0.01;
			}else{
				sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.transfermoney)+",today_transfer=" +
	    		        String.valueOf(super.getClient().getTodaytransfer()-this.transfermoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
			}
		}
		return sql;//编写数据库访问语句sql
	}
    public void setTarget(String targetAccount,double transfermoney,boolean isOther) {

    	this.targetAccount=targetAccount;
    	this.transfermoney=transfermoney;
    	this.isOther=isOther;
    }
	@Override
	public String record() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String sql = "insert into TradeDetail (User_ID,Trade_time,Bank_name,Operation_type,Trade_place,Trade_money,poundage,NO,Target_account) values('"+
				this.getClient().getUser_ID()+"','" +time+"','"+this.getClient().getBank_name()+"','转账','广东省广州市','"+this.transfermoney+"','"+this.poundage +"','"+Test.databaseconnection.getNextRowID()+"','"+this.targetAccount+"')";
		return sql;
	}
}
