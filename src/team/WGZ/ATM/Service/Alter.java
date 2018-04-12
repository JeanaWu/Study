package team.WGZ.ATM.Service;

public class Alter extends Service{

	private String password;
	@Override
	public String  work() {
		String sql = "Update Account set password="+this.getPassword()+" where User_ID='"+super.getClient().getUser_ID()+"'";
		return sql;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
