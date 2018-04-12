package team.WGZ.ATM.MGUI;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Coperation;
import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MFind extends Mpanel{
	private JTextField textField;
	private Client client;
	public MFind() {
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5F85\u67E5\u8BE2\u7684\u8D26\u53F7");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		lblNewLabel.setBounds(513, 204, 360, 41);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,19));
		textField.setBounds(513, 303, 470, 52);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");//È·¶¨
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client=null;
				client = Test.databaseconnection.validateID(textField.getText());
				if(client== null){
					String str="ÕËºÅ²»´æÔÚ£¡";
					MFind.this.setNextPanel(new MMessage(str,MFind.this));
				}else{
					MFind.this.setNextPanel(new MFind2(client.getUser_ID()));
				}
			}
		});
		btnNewButton.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		btnNewButton.setBounds(565, 429, 153, 52);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("·µ»Ø");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFind.this.setNextPanel(new Moperation());
			}
		});
		btnNewButton_1.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		btnNewButton_1.setBounds(811, 429, 153, 52);
		add(btnNewButton_1);
		
		
	}
}
