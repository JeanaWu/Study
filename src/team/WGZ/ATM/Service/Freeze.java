package team.WGZ.ATM.Service;
;

public class Freeze extends Service{

	@Override
	public String work() {
		String sql = "Update Account set State='¶³½á' where User_ID='"+super.getClient().getUser_ID()+"'";
		return sql;
	}

}
