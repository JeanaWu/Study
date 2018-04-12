package team.WGZ.ATM.Service;

public class Close extends Service{

	@Override
	public String work() {
		String sql = "Update Account set State='Ïú»§' where User_ID='"+super.getClient().getUser_ID()+"'";
		return sql ;
	}

}
