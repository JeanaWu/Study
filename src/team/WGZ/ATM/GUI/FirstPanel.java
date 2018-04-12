package team.WGZ.ATM.GUI;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import team.WGZ.ATM.MGUI.Mlogin;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstPanel extends Mypanel{
	public FirstPanel() {
		this.setLayout(null);
		this.setSize(1280,800);
		this.setPicname("background2.jpg");

		
		JLabel label = new JLabel("\u62DB \u5546 \u94F6 \u884C\uFF0C\u56E0 \u60A8 \u800C \u53D8");
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 33));
		label.setForeground(Color.RED);
		label.setBounds(192, 309, 437, 49);
		add(label);
		

		
		Mylabel mlblAa = new Mylabel("Ó£»¨2.gif");
		mlblAa.setBounds(26, 150, 728, 478);
		add(mlblAa);
		
		JButton btnNewButton = new JButton("½øÈë·þÎñ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstPanel.this.setNextPanel(new Clogin());
			}
		});
		btnNewButton.setBounds(854, 177, 349, 68);
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		btnNewButton.setForeground(Color.RED);
		add(btnNewButton);
		
		JButton button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button.setBounds(854, 398, 349, 68);
		add(button);
		
		JButton button_1 = new JButton("\u8FDB\u5165\u7BA1\u7406\u5458\u7CFB\u7EDF");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Test.q.setVisible(false);
				Test.mf.setVisible(true);
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button_1.setBounds(854, 287, 349, 68);
		add(button_1);
			
	}
}
