package team.WGZ.ATM.GUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.PasswordView;

import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Listener.PasswordEnterListener;
import team.WGZ.ATM.Listener.PasswordSumEnterListener;
import team.WGZ.ATM.Listener.PasswordTwiceEnterListener;
import team.WGZ.ATM.Operation.AlterPassword;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calter extends Mypanel {
	private JPasswordField password1;
	private JPasswordField password2;
	private JPasswordField password3;
	public Calter() {

		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel label1 = new JLabel("请输入原密码：");
		label1.setFont(new Font("幼圆", Font.BOLD, 35));
		label1.setBounds(298, 250, 259, 40);
		add(label1);
		
		JLabel label3 = new JLabel("请输入新密码：");
		label3.setFont(new Font("幼圆", Font.BOLD, 35));
		label3.setBounds(298, 351, 259, 40);
		add(label3);
		
		JLabel label_1 = new JLabel("请再次输入新密码：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 35));
		label_1.setBounds(219, 460, 338, 40);
		add(label_1);
		
		JLabel password1tip = new JLabel("");//1
		password1tip.setBounds(1020, 258, 154, 37);
		password1tip.setFont(new Font("幼圆", Font.BOLD, 25));
		password1tip.setForeground(Color.RED);
		add(password1tip);
		
		JLabel password2tip = new JLabel("");
		password2tip.setBounds(1020, 359, 260, 37);
		password2tip.setFont(new Font("幼圆", Font.BOLD, 25));
		password2tip.setForeground(Color.RED);
		add(password2tip);
		
		JLabel password3tip = new JLabel("");//3
		password3tip.setBounds(1020, 460, 148, 40);
		password3tip.setFont(new Font("幼圆", Font.BOLD, 25));
		password3tip.setForeground(Color.RED);
		add(password3tip);
		
		password1 = new JPasswordField();//输入原密码
		password1.setBounds(678, 258, 317, 37);
		password1.addKeyListener(new NumlengthListener(password1,6));
		password1.addKeyListener(new OnlyNumListener());
		password1.addFocusListener(new PasswordEnterListener(password1tip,password1));
		password1.setFont(new Font("宋体", Font.BOLD, 30));
		add(password1);
		password1.setColumns(10);
		
		password2 = new JPasswordField();//输入新密码
		password2.setColumns(10);
		password2.addKeyListener(new NumlengthListener(password2,6));
		password2.setFont(new Font("宋体", Font.BOLD, 30));
		password2.addKeyListener(new OnlyNumListener());
		password2.addFocusListener(new PasswordSumEnterListener(password2, password2tip));
		password2.setBounds(678, 359, 317, 37);
		add(password2);
		
		password3 = new JPasswordField();//再次输入新密码
		password3.setColumns(10);
		password3.addKeyListener(new OnlyNumListener());
		password3.setBounds(678, 460, 317, 37);
		password3.setFont(new Font("宋体", Font.BOLD, 30));
		password3.addKeyListener(new NumlengthListener(password3,6));
		password3.addKeyListener(new PasswordTwiceEnterListener(password3tip,password2,password3));
		add(password3);
		
		MyButton button2 = new MyButton("退卡");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calter.this.setNextPanel(new FirstPanel());
			}
		});
		button2.setFont(new Font("幼圆", Font.BOLD, 30));
		button2.setBounds(14, 672, 232, 80);
		add(button2);
		
		MyButton button1 = new MyButton("返回");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calter.this.setNextPanel(new Coperation());
			}
		});
		button1.setFont(new Font("幼圆", Font.BOLD, 30));
		button1.setBounds(14, 562,232, 80);
		add(button1);
		
		MyButton button3 = new MyButton("确认");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(String.valueOf(password1.getPassword()).equals(Test.nowclient.getPassword())){
					if(password2.getPassword().length<6){
						Calter.this.setNextPanel(new Message("新密码小于6位，请重新输入！", new Calter()));
					}else{
					if(String.valueOf(password2.getPassword()).equals(String.valueOf(password3.getPassword()))){
						AlterPassword alterpassword = new AlterPassword();
						alterpassword.setClient(Test.nowclient);
						alterpassword.setPassword(String.valueOf(password3.getPassword()));
						Test.nowclient=Test.databaseconnection.correspondingOperation(alterpassword);
						Calter.this.setNextPanel(new Message("密码修改成功！",new Coperation()));
					}else{
						Calter.this.setNextPanel(new Message("两次新密码不一致，请重新输入！", new Calter()));
					}
					}
				}else{
					Calter.this.setNextPanel(new Message("原始密码不正确，请重新输入！", new Calter()));
				}
	
			}
		});
		button3.setFont(new Font("幼圆", Font.BOLD, 30));
		button3.setBounds(1034, 632, 232, 80);
		add(button3);
		
		
	}
}