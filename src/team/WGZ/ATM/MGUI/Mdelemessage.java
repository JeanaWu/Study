package team.WGZ.ATM.MGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mdelemessage extends Mpanel {

	/**
	 * Create the panel.
	 */
	public Mdelemessage(String account) {
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel label1 = new JLabel("账户："+account+"，已销户");
		label1.setFont(new Font("宋体", Font.PLAIN, 25));
		label1.setBounds(310, 264, 543, 73);
		add(label1);
		
		JButton button1 = new JButton("返回");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mdelemessage.this.setNextPanel(new Moperation());
			}
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 25));
		button1.setBounds(526, 512, 107, 50);
		add(button1);
		
	}

}
