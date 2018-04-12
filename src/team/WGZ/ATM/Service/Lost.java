package team.WGZ.ATM.Service;

public class Lost extends Service{

	@Override
	public String work() {
		String sql = "Update Account set State='นาสง' where User_ID='"+super.getClient().getUser_ID()+"'";
		return sql;
	}

}
