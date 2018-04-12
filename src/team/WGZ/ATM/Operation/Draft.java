package team.WGZ.ATM.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Person.Creditclient;

public class Draft extends Operation{

	private int draftmoney;
    private double poundage=0;
	public void setDraftmoney(int draftmoney) {
		this.draftmoney = draftmoney;
	}

	@Override
	public String work() {
		    String sql=null;
		    if(super.getClient().getClass().getName().equals("team.WGZ.ATM.Person.Creditclient"))
		    {
		    	if(super.getClient().getBalance()>(double)(this.draftmoney)*0.01+this.draftmoney) {
		    		sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.draftmoney-(double)(this.draftmoney)*0.01)+",today_draft=" +
			    	        String.valueOf(super.getClient().getTodaydraw()-this.draftmoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
		    	}else {
		    		Creditclient c= (Creditclient)super.getClient();
		    		sql = "Update Account set Balance=0"+",today_draft=" +
			    	        String.valueOf(super.getClient().getTodaydraw()-this.draftmoney)+ ",Remain_overdraft="+String.valueOf(c.getRemain_overdraft()-(this.draftmoney+(double)(this.draftmoney)*0.01-super.getClient().getBalance()))
			    	        +"where User_ID='"+super.getClient().getUser_ID()+"';";
		    	}
		    	this.poundage=(double)(this.draftmoney)*0.01;
		    }else {
		    	if(super.getClient().getBank_name().equals("招商银行")) {
		    		sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.draftmoney)+",today_draft=" +
		    		        String.valueOf(super.getClient().getTodaydraw()-this.draftmoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
		    	}else {
		    		//System.out.println((double)(this.draftmoney)*0.01);
		    		sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()-this.draftmoney-(double)(this.draftmoney)*0.01)+",today_draft=" +
			    	        String.valueOf(super.getClient().getTodaydraw()-this.draftmoney)+"where User_ID='"+super.getClient().getUser_ID()+"';";
		    		this.poundage=(double)(this.draftmoney)*0.01;
		    	}
		    }
			return sql;
	}
	@Override
	public String record() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String sql = "insert into TradeDetail (User_ID,Trade_time,Bank_name,Operation_type,Trade_place,Trade_money,poundage,NO) values('"+
				this.getClient().getUser_ID()+"','" +time+"','"+this.getClient().getBank_name()+"','取款','广东省广州市','"+this.draftmoney+"','"+this.poundage +"','"+Test.databaseconnection.getNextRowID()+"')";
		return sql;
	}
}
