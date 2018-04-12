package team.WGZ.ATM.MGUI;

import javax.swing.JPanel;

import team.WGZ.ATM.GUI.Mypanel;
import team.WGZ.ATM.GUI.Test;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Moperation extends Mpanel {

	/**
	 * Create the panel.
	 */
	public Moperation() {
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel label1 = new JLabel("\u8BF7\u9009\u62E9\u8981\u8FDB\u884C\u7684\u64CD\u4F5C");
		label1.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		label1.setBounds(485, 114, 340, 88);
		add(label1);
		
		JButton button1 = new JButton("¿ª»§");
		button1.setContentAreaFilled(false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new MCreation());
			}
		});
		button1.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button1.setBounds(329, 278, 190, 81);
		add(button1);
		
		JButton button2 = new JButton("Ïú»§");
		button2.setContentAreaFilled(false);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new Mdelete());
			}
		});
		button2.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button2.setBounds(550, 278, 190, 81);
		add(button2);
		
		JButton button3 = new JButton("²éÑ¯");
		button3.setContentAreaFilled(false);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new MFind());
			}
		});
		button3.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button3.setBounds(775, 278, 190, 81);
		add(button3);
		
		JButton button4 = new JButton("¶³½á");
		button4.setContentAreaFilled(false);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new Mfroze());
			}
		});
		button4.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button4.setBounds(329, 407, 190, 81);
		add(button4);
		
		JButton button5 = new JButton("¹ÒÊ§");
		button5.setContentAreaFilled(false);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new Mlost());
			}
		});
		button5.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button5.setBounds(550, 407, 190, 81);
		add(button5);
		
		JButton button6 = new JButton("½â¶³&½â¹Ò");
		button6.setContentAreaFilled(false);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new Mopen());
			}
		});
		button6.setFont(new Font("Ó×Ô²", Font.BOLD, 32));
		button6.setBounds(775, 408, 190, 81);
		add(button6);
		
		JButton button7 = new JButton("ÐÞ¸ÄÃÜÂë");
		button7.setContentAreaFilled(false);
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new MCpassword());
			}
		});
		button7.setFont(new Font("Ó×Ô²", Font.BOLD, 35));
		button7.setBounds(329, 529, 190, 81);
		add(button7);
		
		JLabel label2 = new JLabel("¹ÜÀíÔ±:"+Mlogin.nowAd.getName());
		label2.setForeground(Color.RED);
		label2.setBounds(888, 10, 233, 37);
		add(label2);
		
		JButton button8 = new JButton("¸ü»»");
		button8.setContentAreaFilled(false);
		button8.setForeground(Color.RED);
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moperation.this.setNextPanel(new Mlogin());
			}
		});
		button8.setBounds(1119, 17, 73, 23);
		add(button8);
		
		JButton button9 = new JButton("ÍË³ö");
		button9.setContentAreaFilled(false);
		button9.setForeground(Color.RED);
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Test.mf.setVisible(false);
				Test.mf.remove(Moperation.this);
				Test.mf.add(new Mlogin());
				Test.q.setVisible(true);
			}
		});
		button9.setBounds(1202, 17, 66, 23);
		add(button9);
		this.setVisible(true);
	}
}
