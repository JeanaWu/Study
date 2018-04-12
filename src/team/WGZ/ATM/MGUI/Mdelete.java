package team.WGZ.ATM.MGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Service.Close;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mdelete extends Mpanel {
	private JTextField textField;
    private Client client;
	/**
	 * Create the panel.
	 */
	public Mdelete() {
		this.setLayout(null);
		this.setSize(1280,800);
		
	
		
		JLabel label = new JLabel("输入注销账户账号：");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(238, 253, 248, 44);
		add(label);
		
		JButton button1 = new JButton("确认");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client=null;
				client=Test.databaseconnection.validateID(textField.getText());
				if(client==null){
					String str="账户不存在！！";
					Mdelete.this.setNextPanel(new MMessage(str,Mdelete.this));
				}else{
					if(client.getState().equals("销户")){
						String str="该用户已销户，请勿重复操作";
						Mdelete.this.setNextPanel(new MMessage(str,Mdelete.this));
					}else{
						Close close = new Close();
						close.setClient(client);
						client=Test.databaseconnection.manageService(close);
						Mdelete.this.setNextPanel(new Mdelemessage(client.getUser_ID()));
					}
				}
			}
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 25));
		button1.setBounds(515, 437, 106, 44);
		add(button1);
		
		textField = new JTextField();
		textField.setBounds(483, 253, 414, 37);
		textField.setFont(new Font("幼圆", Font.BOLD, 25));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,19));
		add(textField);
		textField.setColumns(10);
		
		JButton button2 = new JButton("返回");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mdelete.this.setNextPanel(new Moperation());
			}
		});
		button2.setFont(new Font("宋体", Font.PLAIN, 25));
		button2.setBounds(691, 437, 106, 44);
		add(button2);
	}

}
