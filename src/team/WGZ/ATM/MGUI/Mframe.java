package team.WGZ.ATM.MGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import team.WGZ.ATM.GUI.Mypanel;

public class Mframe extends JFrame{
	private Mypanel imagepanel;
	private JLabel label;
	/**
	 * @wbp.parser.entryPoint
	 */
	public Mframe() {
		super("招商银行ATM系统");
		this.setSize(1280,820);
		this.setLocationRelativeTo(null);
		Mlogin u =new Mlogin();
		this.add(u);
		//this.setVisible(true);
		this.setUndecorated(true);
}
}