package team.WGZ.ATM.GUI;

import javax.swing.JFrame;

import team.WGZ.ATM.DataConnection.DatabaseConnection;
import team.WGZ.ATM.MGUI.Mframe;
import team.WGZ.ATM.Person.Client;

public class Test {
	public static ATMframe q =new ATMframe();
	public static Client nowclient=null;
	public static DatabaseConnection databaseconnection= new DatabaseConnection();
    public static Mframe mf=new Mframe();
	public static void main(String[] args) {
		mf.setVisible(false);
	}
}
