package team.WGZ.ATM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Message extends Mypanel{
	public Message(String message,Mypanel respond) {
		this.setLayout(null);
		this.setSize(1280,800);

		
		JLabel label = new JLabel(message);
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		label.setForeground(Color.RED);
		label.setBounds(390, 248, 876, 112);
		add(label);
				
		MyButton button = new MyButton("·µ»Ø");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Message.this.setNextPanel(respond);
			}
		});
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button.setBounds(14, 607, 232, 80);
		add(button);
	}
}
