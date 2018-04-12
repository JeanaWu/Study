package team.WGZ.ATM.Person;

public abstract class Person {
     private String IDcard;
     private String name;
     private int ago;
     private String tele;
     private String user_ID;
     private String password;
     private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAgo() {
		return ago;
	}
	public void setAgo(int ago) {
		this.ago = ago;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person(String iDcard, String name, int ago, String tele, String user_ID, String password,String sex) {
		IDcard = iDcard;
		this.name = name;
		this.ago = ago;
		this.tele = tele;
		this.user_ID = user_ID;
		this.password = password;
		this.sex=sex;
	}
    
}
