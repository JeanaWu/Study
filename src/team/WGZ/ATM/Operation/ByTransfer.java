package team.WGZ.ATM.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.GUI.Test;

public class ByTransfer extends Operation{
	
    private String sourceAccount;
    private double transfermoney;
	@Override
	public String work() {
		String sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()+this.transfermoney)+" where User_ID='"+super.getClient().getUser_ID()+"';";
		return sql;
	}

	@Override
	public String record() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String sql = "insert into TradeDetail (User_ID,Trade_time,Bank_name,Operation_type,Trade_place,Trade_money,Poundage,NO,Target_account) values('"+
				this.getClient().getUser_ID()+"','" +time+"','"+this.getClient().getBank_name()+"','收到汇款','广东省广州市','"+this.transfermoney+"','"+0+"','"+Test.databaseconnection.getNextRowID()+"','"+this.sourceAccount+"')";
		return sql;
	}
	
	public void setSourceTransfer(String sourceAccount, double transfermoney){
		this.sourceAccount=sourceAccount;
		this.transfermoney=transfermoney;
	}

}
