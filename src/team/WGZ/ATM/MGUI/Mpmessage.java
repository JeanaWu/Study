package team.WGZ.ATM.MGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mpmessage extends Mpanel {
	public Mpmessage(){
		this.setLayout(null);
		this.setSize(1280,800);

		JLabel label1 = new JLabel("�޸�����ɹ�");
		label1.setFont(new Font("����", Font.BOLD, 30));
		label1.setBounds(510, 316, 210, 65);
		add(label1);
		
		JButton button1 = new JButton("����");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mpmessage.this.setNextPanel(new Moperation());
			}
		});
		button1.setFont(new Font("����", Font.PLAIN, 25));
		button1.setBounds(550, 512, 107, 50);
		add(button1);
		
	}

}
