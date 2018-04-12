package team.WGZ.ATM.MGUI;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Person.Creditclient;
import team.WGZ.ATM.Service.AlterMessage;

import javax.swing.JTextField;
import java.awt.Color;

public class MFindMessage extends Mpanel{
	private String account;
	private Client client;
	private JTextField name;
	private JTextField sex;
	private JTextField ago;
	private JTextField tele;
	public MFindMessage(String account) {
		this.account= account;
		this.setLayout(null);
		this.setSize(1280,800);
		client = Test.databaseconnection.validateID(account);
		
		
		JButton button = new JButton("\u8FD4\u56DE");//返回
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFindMessage.this.setNextPanel(new MFind2(account));
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 25));
		button.setBounds(14, 674, 153, 52);
		add(button);
		
		JLabel label = new JLabel("账号：");
		label.setFont(new Font("幼圆", Font.BOLD, 25));
		label.setBounds(258, 51, 143, 30);
		add(label);
		
		JLabel User_ID = new JLabel("");
		User_ID.setForeground(Color.RED);
		User_ID.setFont(new Font("幼圆", Font.BOLD, 25));
		User_ID.setBounds(415, 51, 298, 30);
		User_ID.setText(client.getUser_ID());
		add(User_ID);
		
		JLabel label_1 = new JLabel("所在银行：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 25));
		label_1.setBounds(258, 130, 143, 30);
		add(label_1);
		
		JLabel Bankname = new JLabel("");
		Bankname.setFont(new Font("幼圆", Font.BOLD, 25));
		Bankname.setForeground(Color.RED);
		Bankname.setText(client.getBank_name());
		Bankname.setBounds(415, 130, 298, 30);
		add(Bankname);
		
		JLabel label_2 = new JLabel("身份证号：");
		label_2.setFont(new Font("幼圆", Font.BOLD, 25));
		label_2.setBounds(258, 203, 143, 30);
		add(label_2);
		
		JLabel ID_card = new JLabel("");
		ID_card.setFont(new Font("幼圆", Font.BOLD, 25));
		ID_card.setBounds(415, 203, 298, 30);
		ID_card.setText(client.getIDcard());
		 ID_card.setForeground(Color.RED);
		add(ID_card);
		
		JLabel label_3 = new JLabel("开户时间：");
		label_3.setFont(new Font("幼圆", Font.BOLD, 25));
		label_3.setBounds(258, 279, 143, 30);
		add(label_3);
		
		JLabel time = new JLabel("");
		time.setFont(new Font("幼圆", Font.BOLD, 25));
		time.setForeground(Color.RED);
		time.setText(client.getAccount_time());
		time.setBounds(415, 279, 298, 30);
		add(time);
		
		JLabel label_5 = new JLabel("开户地点：");
		label_5.setFont(new Font("幼圆", Font.BOLD, 25));
		label_5.setBounds(258, 351, 143, 30);
		add(label_5);
		
		JLabel place = new JLabel("");
		place.setFont(new Font("幼圆", Font.BOLD, 25));
		place.setForeground(Color.RED);
		place.setText(client.getAccount_place());
		place.setBounds(415, 351, 298, 30);
		add(place);
		
		JLabel label_7 = new JLabel("账号状态：");
		label_7.setFont(new Font("幼圆", Font.BOLD, 25));
		label_7.setBounds(258, 419, 143, 30);
		add(label_7);
		
		JLabel state = new JLabel("");
		state.setFont(new Font("幼圆", Font.BOLD, 25));
		state.setText(client.getState());
		state.setForeground(Color.RED);
		state.setBounds(415, 419, 298, 30);
		add(state);
		
		JLabel label_9 = new JLabel("户主姓名：");
		label_9.setFont(new Font("幼圆", Font.BOLD, 25));
		label_9.setBounds(791, 130, 143, 30);
		add(label_9);
		
		name = new JTextField();
		name.setFont(new Font("幼圆", Font.BOLD, 25));
		name.setBounds(987, 130, 251, 30);
		name.setText(client.getName());
		name.setEditable(false);
		add(name);
		name.setColumns(10);
		
		JLabel label_4 = new JLabel("户主性别：");
		label_4.setFont(new Font("幼圆", Font.BOLD, 25));
		label_4.setBounds(791, 203, 143, 30);
		add(label_4);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setFont(new Font("幼圆", Font.BOLD, 25));
		sex.setEditable(false);
		sex.setText(client.getSex());
		sex.setBounds(987, 203, 251, 30);
		add(sex);
		
		JLabel label_6 = new JLabel("户主年龄：");
		label_6.setFont(new Font("幼圆", Font.BOLD, 25));
		label_6.setBounds(791, 279, 143, 30);
		add(label_6);
		
		ago = new JTextField();
		ago.setColumns(10);
		ago.setFont(new Font("幼圆", Font.BOLD, 25));
		ago.setText(String.valueOf(client.getAgo()));
		ago.setEditable(false);
		ago.setBounds(987, 279, 251, 30);
		add(ago);
		
		JLabel label_8 = new JLabel("户主手机：");
		label_8.setFont(new Font("幼圆", Font.BOLD, 25));
		label_8.setBounds(791, 351, 143, 30);
		add(label_8);
		
		tele = new JTextField();
		tele.setColumns(10);
		tele.setFont(new Font("幼圆", Font.BOLD, 25));
		tele.setText(client.getTele());
		tele.setEditable(false);
		tele.setBounds(987, 351, 251, 30);
		add(tele);
		
		JLabel label_10 = new JLabel("账户性质：");
		label_10.setFont(new Font("幼圆", Font.BOLD, 25));
		label_10.setBounds(258, 488, 143, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("透支额：");
		label_11.setFont(new Font("幼圆", Font.BOLD, 25));
		label_11.setBounds(258, 613, 143, 30);
		add(label_11);
		
		JLabel type = new JLabel("");
		type.setForeground(Color.RED);
		if(client.getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
			type.setText("信用卡用户");
		}else{
			type.setText("活期用户");
		}
		type.setFont(new Font("幼圆", Font.BOLD, 25));
		type.setBounds(415, 488, 298, 30);
		add(type);
		
		JLabel overdraft = new JLabel("");
		overdraft.setForeground(Color.RED);
		if(client.getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
			Creditclient c= (Creditclient)client;
			overdraft.setText(String.valueOf(c.getOverdraft()));
		}else{
			overdraft.setEnabled(false);
		}
		overdraft.setFont(new Font("幼圆", Font.BOLD, 25));
		overdraft.setBounds(415, 613, 298, 30);
		add(overdraft);
		
		JLabel label_12 = new JLabel("剩余透支额：");
		label_12.setFont(new Font("幼圆", Font.BOLD, 25));
		label_12.setBounds(258, 685, 168, 30);
		add(label_12);
		
		JLabel Remain_overdraft = new JLabel("");
		Remain_overdraft.setForeground(Color.RED);
		if(client.getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
			Creditclient c= (Creditclient)client;
			Remain_overdraft.setText(String.valueOf(c.getRemain_overdraft()));
		}else{
			Remain_overdraft.setEnabled(false);
		}
		Remain_overdraft.setFont(new Font("幼圆", Font.BOLD, 25));
		Remain_overdraft.setBounds(415, 685, 298, 30);
		add(Remain_overdraft);
		
		JLabel label_13 = new JLabel("账户余额：");
		label_13.setFont(new Font("幼圆", Font.BOLD, 25));
		label_13.setBounds(258, 551, 143, 30);
		add(label_13);
		
		JLabel balance = new JLabel("");
		balance .setForeground(Color.RED);
		balance.setText(String.valueOf(client.getBalance()));
		balance.setFont(new Font("幼圆", Font.BOLD, 25));
		balance.setBounds(415, 551, 298, 30);
		add(balance);
		
		
		JButton button_2 = new JButton("确认修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				client.setSex(sex.getText());
				client.setAgo(Integer.parseInt(ago.getText()));
				client.setTele(tele.getText());
				client.setName(name.getText());
			    AlterMessage altermessage = new AlterMessage();
			    altermessage.setClient(client);
			    client=Test.databaseconnection.manageService(altermessage);
			    JOptionPane.showMessageDialog(null, "修改成功！");

				ago.setEditable(false);
				name.setEditable(false);
				sex.setEditable(false);
				tele.setEditable(false);
				button_2.setVisible(false);
			}
		});
		button_2.setFont(new Font("幼圆", Font.BOLD, 25));
		button_2.setBounds(942, 424, 153, 52);
		button_2.setVisible(false);
		add(button_2);
		
		JButton button_1 = new JButton("修改信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client=null;
				client= Test.databaseconnection.validateID(account);
				if(!client.getBank_name().equals("招商银行")){
					String str="非本行用户无法修改信息！";
					MFindMessage.this.setNextPanel(new MMessage(str,MFindMessage.this));
				}else{
					if(!client.getState().equals("正常")){
						String str="该账户处于非正常状态，无法操作！";
						MFindMessage.this.setNextPanel(new MMessage(str,MFindMessage.this));
					}else{
						ago.setEditable(true);
						name.setEditable(true);
						sex.setEditable(true);
						tele.setEditable(true);
						button_2.setVisible(true);
					}
				}
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 25));
		button_1.setBounds(14, 576, 153, 52);
		add(button_1);
		if(client.getState().equals("销户")){
			button_1.setEnabled(false);
		}else{
			button_1.setEnabled(true);
		}
	}

}
