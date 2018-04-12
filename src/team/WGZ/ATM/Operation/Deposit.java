package team.WGZ.ATM.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.GUI.Test;

public class Deposit extends Operation{

    private int depositmoney;
	public String work() {
        String sql = "Update Account set Balance="+String.valueOf(super.getClient().getBalance()+this.depositmoney)+" where User_ID='"+super.getClient().getUser_ID()+"';";
		return sql;
	}
	public void setDepositmoney(int depositmoney) {
		this.depositmoney = depositmoney;
	}
	@Override
	public String record() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String sql = "insert into TradeDetail (User_ID,Trade_time,Bank_name,Operation_type,Trade_place,Trade_money,Poundage,NO) values('"+
				this.getClient().getUser_ID()+"','" +time+"','"+this.getClient().getBank_name()+"','存款','广东省广州市','"+this.depositmoney+"','"+0+"','"+Test.databaseconnection.getNextRowID()+"')";
		return sql;
	}
}
