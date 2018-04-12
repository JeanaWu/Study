package team.WGZ.ATM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class FindChoose extends Mypanel{
	public FindChoose() {
		this.setLayout(null);
		this.setSize(1280,800);

		
		/*JLabel label = new JLabel("");
		label.setFont(new Font("幼圆", Font.BOLD, 35));
		label.setForeground(Color.RED);
		label.setBounds(390, 248, 876, 112);
		add(label);*/
				
		MyButton button = new MyButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     FindChoose.this.setNextPanel(new Coperation());
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 30));
		button.setBounds(14, 607, 232, 80);
		add(button);
		
		MyButton myButton = new MyButton("交易明细");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindChoose.this.setNextPanel(new FindDetail());
			}
		});
		myButton.setFont(new Font("幼圆", Font.BOLD, 25));
		myButton.setBounds(1034, 444, 232, 80);
		add(myButton);
		
		MyButton myButton_1 = new MyButton("账户资金信息");
		myButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindChoose.this.setNextPanel(new FundMessage());
			}
		});
		myButton_1.setFont(new Font("幼圆", Font.BOLD, 25));
		myButton_1.setBounds(1034, 225, 232, 80);
		add(myButton_1);
	}
}
