package team.WGZ.ATM.MGUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Mypanel;
import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Listener.TransferListener;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Person.Creditclient;
import team.WGZ.ATM.Person.Currentclient;
import team.WGZ.ATM.Service.Create;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MCreation extends Mpanel {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JPasswordField textField;
	private Client upclient;
	public MCreation(){
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel label1 = new JLabel("请选择开户类型:");
		label1.setFont(new Font("宋体", Font.PLAIN, 25));
		label1.setBounds(299, 97, 197, 43);
		add(label1);
		
		
		
		JLabel label2 = new JLabel("\u5E74\u9F84\uFF1A");//年龄
		label2.setFont(new Font("宋体", Font.PLAIN, 25));
		label2.setBounds(299, 405, 88, 43);
		add(label2);
		
		JLabel label3 = new JLabel("姓名：");
		label3.setFont(new Font("宋体", Font.PLAIN, 25));
		label3.setBounds(299, 183, 88, 43);
		add(label3);
		
		JLabel label4 = new JLabel("性别：");
		label4.setFont(new Font("宋体", Font.PLAIN, 25));
		label4.setBounds(299, 295, 88, 43);
		add(label4);
		
		JLabel label5 = new JLabel("手机：");
		label5.setFont(new Font("宋体", Font.PLAIN, 25));
		label5.setBounds(299, 351, 88, 43);
		add(label5);
		
		JLabel label6 = new JLabel("账户金额：");
		label6.setFont(new Font("宋体", Font.PLAIN, 25));
		label6.setBounds(299, 461, 143, 43);
		add(label6);
		
		
		JLabel label7 = new JLabel("透支额度：");
		label7.setEnabled(false);
		label7.setFont(new Font("宋体", Font.PLAIN, 25));
		label7.setBounds(287, 609, 130, 43);
		add(label7);
		
		JLabel label8 = new JLabel("身份证：");
		label8.setFont(new Font("宋体", Font.PLAIN, 25));
		label8.setBounds(299, 239, 118, 43);
		add(label8);
		
		JRadioButton r3 = new JRadioButton("男");
		r3.setSelected(true);
		r3.setFont(new Font("宋体", Font.PLAIN, 25));
		r3.setBounds(433, 305, 84, 23);
		r3.setContentAreaFilled(false);
		add(r3);
		
		JRadioButton r4 = new JRadioButton("女");
		r4.setFont(new Font("宋体", Font.PLAIN, 25));
		r4.setBounds(586, 305, 77, 23);
		r4.setContentAreaFilled(false);
		add(r4);
		
		textField = new JPasswordField();//密码
		textField.setBounds(417, 530, 262, 30);
		textField.setFont(new Font("幼圆", Font.BOLD, 25));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,6));
		add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();//年龄
		textField1.setFont(new Font("宋体", Font.PLAIN, 25));
		textField1.setBounds(417, 410, 262, 32);
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addKeyListener(new NumlengthListener(textField1,3));
		add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();//姓名
		textField2.setFont(new Font("宋体", Font.PLAIN, 25));
		textField2.setColumns(10);
		textField2.setBounds(417, 188, 262, 32);
		add(textField2);
		
		textField3 = new JTextField();//身份证
		textField3.setFont(new Font("宋体", Font.PLAIN, 25));
		textField3.addKeyListener(new OnlyNumListener());
		textField3.addKeyListener(new NumlengthListener(textField3,18));
		textField3.setColumns(10);
		textField3.setBounds(417, 244, 262, 32);
		add(textField3);
		
		textField4 = new JTextField();//手机
		textField4.setFont(new Font("宋体", Font.PLAIN, 25));
		textField4.setColumns(10);
		textField4.addKeyListener(new OnlyNumListener());
		textField4.addKeyListener(new NumlengthListener(textField4,11));
		textField4.setBounds(417, 356, 262, 32);
		add(textField4);
		
		textField5 = new JTextField();//账户金额
		textField5.setFont(new Font("宋体", Font.PLAIN, 25));
		textField5.setColumns(10);
		textField5.addKeyListener(new OnlyNumListener());
		textField5.addKeyListener(new TransferListener(textField5));
		textField5.setBounds(417, 466, 262, 32);
		add(textField5);
		
		textField6 = new JTextField();//透支额
		textField6.setEnabled(false);
		textField6.addKeyListener(new OnlyNumListener());
		textField6.setFont(new Font("宋体", Font.PLAIN, 25));
		textField6.setColumns(10);
		textField6.setBounds(417, 613, 262, 33);
		add(textField6);
		this.setVisible(true);
		
		JRadioButton r1 = new JRadioButton("活期账户");
		r1.setSelected(true);
		r1.setFont(new Font("宋体", Font.PLAIN, 25));
		r1.setBounds(508, 107, 125, 23);
		add(r1);
		r1.setContentAreaFilled(false);//设置透明
		r1.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label7.setEnabled(false);
				textField6.setEnabled(false);
				label7.updateUI();
				textField6.updateUI();
				
			}
		});
		
		JRadioButton r2 = new JRadioButton("信用卡账户");
		r2.setFont(new Font("宋体", Font.PLAIN, 25));
		r2.setBounds(658, 107, 161, 23);
		r2.setContentAreaFilled(false);
		add(r2);
		
		r2.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label7.setEnabled(true);
				textField6.setEnabled(true);
				label7.updateUI();
				textField6.updateUI();
				
			}
		});
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(r1);
		buttonGroup1.add(r2);
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(r3);
		buttonGroup2.add(r4);
		
		JButton button1 = new JButton("确认");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat  s = new SimpleDateFormat("yyyy-MM-dd");
				String time = s.format(new Date());
				String sex=null;
				if(r3.isSelected()){
				     sex = r3.getText();
				}
				if(r4.isSelected()){
					 sex=r4.getText();
				}
				if(r2.isSelected()){
					Creditclient cr = new Creditclient(textField3.getText() ,textField2.getText(),Integer.parseInt(textField1.getText()), textField4.getText(), Create.produce(),String.valueOf(textField.getPassword()), sex, "广东省汕头市",time, Integer.parseInt(textField5.getText()), "正常", 20000, 50000,"招商银行", 5, Integer.parseInt(textField6.getText()),Integer.parseInt(textField6.getText()));
					Create create = new Create();
					create.setClient(cr);
					MCreation.this.upclient=Test.databaseconnection.manageService(create);
				}
                if(r1.isSelected()){
                	Currentclient cu = new Currentclient (textField3.getText() ,textField2.getText(),Integer.parseInt(textField1.getText()), textField4.getText(), Create.produce(),String.valueOf(textField.getPassword()), sex, "广东省汕头市",time, Integer.parseInt(textField5.getText()), "正常", 20000, 50000,"招商银行", 5);
                	Create create = new Create();
                	create.setClient(cu);
                	MCreation.this.upclient=MCreation.this.upclient=Test.databaseconnection.manageService(create);
           
				}
                String str="您的账号为：";
                MCreation.this.setNextPanel(new MMessage(str+upclient.getUser_ID(),new Moperation()));
			}
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 20));
		button1.setBounds(417, 665, 100, 33);
		add(button1);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MCreation.this.setNextPanel(new Moperation());
			
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(563, 665, 100, 33);
		add(button);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(299, 520, 143, 43);
		add(label);
		
	}
}
