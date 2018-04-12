package team.WGZ.ATM.Service;

public class AlterMessage extends Service{

	@Override
	public String work() {
		String sql="Update Account set name='"+super.getClient().getName()+"',Ago="+super.getClient().getAgo()+",Tele='"+super.getClient().getTele()
				+"' ,Sex='"+super.getClient().getSex()+"'where User_ID='"+super.getClient().getUser_ID()+"';";
		return sql;
	}

}
