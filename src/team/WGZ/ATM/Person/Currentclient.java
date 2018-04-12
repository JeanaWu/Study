package team.WGZ.ATM.Person;

public class Currentclient extends Client{

	public Currentclient(String iDcard, String name, int ago, String tele, String user_ID, String password,String sex,
			String account_place, String account_time, double balance, String state, int todaydraw,
			double todaytransfer, String bank_name,int wrong_time) {
		super(iDcard, name, ago, tele, user_ID, password,sex, account_place, account_time, balance, state, todaydraw, todaytransfer,
				bank_name,wrong_time);
	}



	@Override
	public String toString() {
		return "Currentclient [getWrong_time()=" + getWrong_time() + ", getAccount_place()=" + getAccount_place()
				+ ", getAccount_time()=" + getAccount_time() + ", getBalance()=" + getBalance() + ", getState()="
				+ getState() + ", getTodaydraw()=" + getTodaydraw() + ", getTodaytransfer()=" + getTodaytransfer()
				+ ", getBank_name()=" + getBank_name() + ", getIDcard()=" + getIDcard() + ", getName()=" + getName()
				+ ", getAgo()=" + getAgo() + ", getTele()=" + getTele() + ", getUser_ID()=" + getUser_ID()
				+ ", getPassword()=" + getPassword() +"ÐÔ±ð:" +getSex()+ "]";
	}

}
