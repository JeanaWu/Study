package team.WGZ.ATM.Person;

import java.sql.ResultSet;

public abstract class Client extends Person{

	private String account_place;
	private String account_time;
	private double balance;
	private String state;
	private int todaydraw;//今日剩余取款
	private double todaytransfer;//今日剩余转账
	private String bank_name;
	private int  wrong_time;
	private ResultSet record=null;//存放交易数据，用完记得close
	public Client(String iDcard, String name, int ago, String tele, String user_ID, String password,String sex,
			String account_place, String account_time, double balance, String state, int todaydraw,
			double todaytransfer, String bank_name,int wrong_time) {
		super(iDcard, name, ago, tele, user_ID, password,sex);
		this.account_place = account_place;
		this.account_time = account_time;
		this.balance = balance;
		this.state = state;
		this.todaydraw = todaydraw;
		this.todaytransfer = todaytransfer;
		this.bank_name = bank_name;
		this.wrong_time=wrong_time;
	}

	public int getWrong_time() {
		return wrong_time;
	}

	public void setWrong_time(int wrong_time) {
		this.wrong_time = wrong_time;
	}

	public String getAccount_place() {
		return account_place;
	}
	public void setAccount_place(String account_place) {
		this.account_place = account_place;
	}
	public String getAccount_time() {
		return account_time;
	}
	public void setAccount_time(String account_time) {
		this.account_time = account_time;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getTodaydraw() {
		return todaydraw;
	}
	public void setTodaydraw(int todaydraw) {
		this.todaydraw = todaydraw;
	}
	public double getTodaytransfer() {
		return todaytransfer;
	}
	public void setTodaytransfer(double todaytransfer) {
		this.todaytransfer = todaytransfer;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public ResultSet getRecord() {
		return record;
	}
	public void setRecord(ResultSet record) {
		this.record = record;
	}


}
