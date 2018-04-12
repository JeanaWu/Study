package team.WGZ.ATM.GUI;

import java.awt.*;

import javax.swing.*;

public class ATMframe  extends JFrame{
	private Mypanel imagepanel;
	private JLabel label;
	/**
	 * @wbp.parser.entryPoint
	 */
	public ATMframe() {
		super("招商银行ATM系统");
		this.setSize(1280,820);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation((int)((size.width - this.getWidth())),(int)((size.height -this.getHeight()) ));
		this.setLocationRelativeTo(null);
		FirstPanel u =new FirstPanel();
		this.add(u);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setResizable(false); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
