package team.WGZ.ATM.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.WGZ.ATM.Person.Creditclient;

public class Create extends Service{

	private static String autoAccount;
	@Override
	public String work() {
		String type;
		double overdraft=0;
		if(super.getClass().getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
			type="信用卡用户";
		    Creditclient cl = (Creditclient)super.getClient();
		    overdraft= cl.getOverdraft();
		}else{
			type="活期用户";
		}
		String sql="insert into Account(User_ID,Bank_name,ID_card,Password,Account_time,"
				+ "Account_place,State,Name,Sex,Ago,Tele,Balance,User_type,overdraft,Remain_overdraft,"
				+ "Wrong_time) "
				+ "values('"+super.getClient().getUser_ID()+"','"+super.getClient().getBank_name()+"','"+super.getClient().getIDcard()+"','"+super.getClient().getPassword()+"','"+super.getClient().getAccount_time()
				+"','广东省广州市','"+super.getClient().getState()+"','"+super.getClient().getName()
				+"','"+super.getClient().getSex()+"','"+super.getClient().getAgo()+"','"+super.getClient().getTele()+"','"+super.getClient().getBalance()+"','"+ type+"','"+overdraft+"','"+overdraft+"','"+5+"');";
		return sql;
	}
	public static String produce() {
		SimpleDateFormat  s = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String f = s.format(new Date());
		String[] e = f.split("-");
		String autoAccount="6226"+e[0]+e[1]+e[2]+e[3]+e[4]+e[5];
		return autoAccount;
	}
}
