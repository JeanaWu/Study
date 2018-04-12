package team.WGZ.ATM.Operation;

public class Find extends Operation{

    private String starttime;
    private String endtime;
	public String work() {
        String sql="select * from TradeDetail where User_ID='"+super.getClient().getUser_ID()+"' ORDER BY NO ASC;";
		return sql;//±‡–¥ ˝æ›ø‚∑√Œ ”Ôæ‰sql
	}
	public void setTimeQuantum(String starttime,String endtime) {
		this.starttime=starttime;
		this.endtime=endtime;
	}
	@Override
	public String record() {
		return null;
	}
}
