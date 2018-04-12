package team.WGZ.ATM.Person;

public class Creditclient extends Client{
    private double overdraft;//可透支额
    private double remain_overdraft;
	public Creditclient(String iDcard, String name, int ago, String tele, String user_ID, String password,String sex,
			String account_place, String account_time, double balance, String state, int todaydraft,
			double todaytransfer, String bank_name,int wrong_time, double overdraft, double remain_overdraft) {
		super(iDcard, name, ago, tele, user_ID, password,sex, account_place, account_time, balance, state, todaydraft,
				todaytransfer, bank_name,wrong_time);
		this.overdraft = overdraft;
		this.remain_overdraft = remain_overdraft;
	}
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	public double getRemain_overdraft() {
		return remain_overdraft;
	}
	public void setRemain_overdraft(double remain_overdraft) {
		this.remain_overdraft = remain_overdraft;
	}
	@Override
	public String toString() {
		return "Creditclient [overdraft=" + overdraft + ", remain_overdraft=" + remain_overdraft + ", getWrong_time()="
				+ getWrong_time() + ", getAccount_place()=" + getAccount_place() + ", getAccount_time()="
				+ getAccount_time() + ", getBalance()=" + getBalance() + ", getState()=" + getState()
				+ ", getTodaydraw()=" + getTodaydraw() + ", getTodaytransfer()=" + getTodaytransfer()
				+ ", getBank_name()=" + getBank_name() + ", getIDcard()=" + getIDcard() + ", getName()=" + getName()
				+ ", getAgo()=" + getAgo() + ", getTele()=" + getTele() + ", getUser_ID()=" + getUser_ID()
				+ ", getPassword()=" + getPassword() +"性别:" +getSex()+"]";
	}	
}
