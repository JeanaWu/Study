package team.WGZ.ATM.MGUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Listener.PasswordEnterListener;
import team.WGZ.ATM.Listener.PasswordSumEnterListener;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Service.Alter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MCpassword extends Mpanel {
	private JTextField textField1;
	private JPasswordField password1;
	private JPasswordField password2;
	private Client client;

	/**
	 * Create the panel.
	 */
	public MCpassword() {
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel label1 = new JLabel("输入账号：");
		label1.setFont(new Font("宋体", Font.PLAIN, 25));
		label1.setBounds(295, 201, 132, 45);
		add(label1);
		
		JLabel label2 = new JLabel("输入新密码：");
		label2.setFont(new Font("宋体", Font.PLAIN, 25));
		label2.setBounds(276, 291, 150, 45);
		add(label2);
		
		JLabel label = new JLabel("再次输入新密码：");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(225, 377, 217, 45);
		add(label);
		
		textField1 = new JTextField();//账号
		textField1.setFont(new Font("宋体", Font.PLAIN, 25));
		textField1.setBounds(452, 217, 263, 29);
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addKeyListener(new NumlengthListener(textField1,19));
		add(textField1);
		textField1.setColumns(10);
		
		
		
		password1 = new JPasswordField();//密码
		password1.setFont(new Font("宋体", Font.PLAIN, 25));
		password1.addKeyListener(new NumlengthListener(password1,6));
		password1.addKeyListener(new OnlyNumListener());
		password1.setColumns(10);
		password1.setBounds(452, 298, 263, 29);
		add(password1);
		
		password2 = new JPasswordField();//密码（再次）
		password2.setFont(new Font("宋体", Font.PLAIN, 25));
		password2.setColumns(10);
		password2.addKeyListener(new NumlengthListener(password2,6));
		password2.addKeyListener(new OnlyNumListener());
		password2.setBounds(452, 384, 263, 29);
		add(password2);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MCpassword.this.client=null;
				MCpassword.this.client = Test.databaseconnection.validateID(textField1.getText());
				if(MCpassword.this.client ==null){
					String str ="账户不存在！";
					MCpassword.this.setNextPanel(new MMessage(str,MCpassword.this));
				}else{
					if(!MCpassword.this.client .getBank_name().equals("招商银行")){
						String str ="非本行账户无法执行该功能！！";
						MCpassword.this.setNextPanel(new MMessage(str,new MCpassword()));
					}else{
						if(!String.valueOf(password2.getPassword()).equals(String.valueOf(password1.getPassword()))){
							String str="两次密码输入不一致！";
							MCpassword.this.setNextPanel(new MMessage(str,MCpassword.this));
						}else{
							if(MCpassword.this.client .getState().equals("正常")){
								Alter alter  = new Alter();
								alter.setClient(client);
							    alter.setPassword(String.valueOf(password1.getPassword()));
								Test.databaseconnection.manageService(alter);
								MCpassword.this.setNextPanel(new Mpmessage());
							}else{
								if(MCpassword.this.client.getState().equals("销户")){
									String str ="该账户已经销户！";
									MCpassword.this.setNextPanel(new MMessage(str,new MCpassword()));
								}else{
									String str ="该账户处于非正常操作状态！";
									MCpassword.this.setNextPanel(new MMessage(str,new MCpassword()));
								}
							}
						}
					}
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(427, 584, 98, 39);
		add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MCpassword.this.setNextPanel(new Moperation());
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBounds(613, 584, 98, 39);
		add(button_1);
	}
}
