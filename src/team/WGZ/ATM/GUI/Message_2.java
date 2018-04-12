package team.WGZ.ATM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Message_2 extends Mypanel{
	public Message_2(String message,Mypanel respond,Mypanel continuePanel) {
		this.setLayout(null);
		this.setSize(1280,800);

		
		JLabel label = new JLabel(message);
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		label.setForeground(Color.RED);
		label.setBounds(369, 149, 1000, 500);
		add(label);
				
		MyButton button = new MyButton("·µ»Ø");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Message_2.this.setNextPanel(respond);
			}
		});
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button.setBounds(14, 547, 232, 80);
		add(button);
		
		MyButton button_1 = new MyButton("¼ÌÐø½»Ò×");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Message_2.this.setNextPanel(continuePanel);
			}
		});
		button_1.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button_1.setBounds(1034, 608, 232,80);
		add(button_1);
		
		MyButton myButton = new MyButton("ÍË¿¨");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Test.nowclient=null;
				Message_2.this.setNextPanel(new FirstPanel());
			}
		});
		myButton.setText("\u9000\u5361");
		myButton.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		myButton.setBounds(14, 663, 232, 80);
		add(myButton);
	}
}
