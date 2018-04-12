package team.WGZ.ATM.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import team.WGZ.ATM.DataConnection.DatabaseConnection;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Client;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;


public class Clogin extends Mypanel {
	
	private JTextField textField1;
	private JPasswordField password;
	/**
	 * Create the panel.
	 */
	public Clogin() {
		this.setLayout(null);
		this.setSize(1280,800);
		this.setVisible(true);

		
		JLabel label1 = new JLabel("欢迎来到招商银行ATM客户系统");
		label1.setFont(new Font("幼圆", Font.BOLD, 45));
		label1.setBounds(335, 133, 692, 138);
		add(label1);
		
		JLabel label2 = new JLabel("请输入卡号");
		label2.setFont(new Font("幼圆", Font.BOLD, 35));
		label2.setBounds(306, 379, 232, 62);
		add(label2);
		
		JLabel label3 = new JLabel("请输入密码");
		label3.setFont(new Font("幼圆", Font.BOLD, 35));
		label3.setBounds(306, 483, 232, 62);
		add(label3);
		
		textField1 = new JTextField();//输入卡号
		textField1.setBounds(577, 399, 340, 35);
		textField1.setFont(new Font("宋体", Font.BOLD, 25));
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addKeyListener(new NumlengthListener(textField1,19));
		textField1.setText("");//6217003100003628202
		add(textField1);
		textField1.setColumns(10);
		
		password = new JPasswordField(6);//输入密码
		password.setBounds(577, 503, 340, 35);
		password.setFont(new Font("宋体", Font.BOLD, 25));
		password.setText("");
		password.addKeyListener(new NumlengthListener(password,6));
		password.addKeyListener(new OnlyNumListener());
		add(password);
		password.setColumns(10);
		
		MyButton btnNewButton = new MyButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                    Test.nowclient=null;
					Test.nowclient = Test.databaseconnection.validateID(textField1.getText());
				if(Test.nowclient==null) {//不存在账号
					   String str = "请您输入正确的账号！";
					   Clogin.this.setNextPanel(new Message(str,new Clogin()));
				}else if(Test.nowclient.getState().equals("正常")||Test.nowclient.getState().equals("冻结")) {//存在账号，判断状态
					if(Test.nowclient.getPassword().equals(String.valueOf(password.getPassword()))) {//判断密码
						Clogin.this.setNextPanel(new Coperation());//=====================================
					}else {
						if(Test.nowclient.getWrong_time()>=1) {//输入五次错误，自动冻结账户
							Test.nowclient.setWrong_time(Test.nowclient.getWrong_time()-1);
							String str="密码错误，您还有"+Test.nowclient.getWrong_time()+"次机会";
							Test.databaseconnection.UpdateClientTime(Test.nowclient);
							Clogin.this.setNextPanel(new Message(str,new Clogin()));
						}else {
							Test.nowclient.setState("冻结");
							Test.databaseconnection.UpdateClientState(Test.nowclient);
							String str = "密码错误，您的账号已被冻结";
							Clogin.this.setNextPanel(new Message(str,new Clogin()));
						}
					}
				}else {
					if(Test.nowclient.getState().equals("挂失"))
					{
						String str = "您的账号已挂失，无法登陆";
						Clogin.this.setNextPanel(new Message(str,new Clogin())); 
					}
					if(Test.nowclient.getState().equals("销户")) {
						String str="您的账号已销户，无法登陆";
						Clogin.this.setNextPanel(new Message(str,new Clogin())); 
					}
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 30));
		btnNewButton.setBounds(1036, 624, 230,80);//232,80
		add(btnNewButton);
		
		
		MyButton button = new MyButton("退卡");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.nowclient=null;
				Clogin.this.setNextPanel(new FirstPanel());
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 30));
		button.setBounds(14, 624, 232, 80);
		add(button);
	}

}
