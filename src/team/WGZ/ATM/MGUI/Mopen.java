package team.WGZ.ATM.MGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Service.Open;

public class Mopen extends Mpanel {
	private JTextField textField;
    private Client client;
	public Mopen(){
		this.setLayout(null);
		this.setSize(1280,800);
		
		textField = new JTextField();
		textField.setBounds(449, 292, 414, 37);
		textField.addKeyListener(new OnlyNumListener());
		textField.setFont(new Font("幼圆", Font.BOLD, 25));
		textField.addKeyListener(new NumlengthListener(textField,19));
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("输入需要解冻或解挂的账户账号：");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(476, 191, 375, 44);
		add(label);
		
		JButton button1 = new JButton("确认");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mopen.this.client=null;
				Mopen.this.client = Test.databaseconnection.validateID(textField.getText());
				if(Mopen.this.client==null){
					String str ="账户不存在！";
					Mopen.this.setNextPanel(new MMessage(str,Mopen.this));
				}else{
					if(Mopen.this.client.getBank_name().equals("招商银行")){
					if(Mopen.this.client.getState().equals("销户")){
						String str ="操作失败，该账户已经销户！";
						Mopen.this.setNextPanel(new MMessage(str,new Mopen()));
					}else{
						Open open = new Open();
						open.setClient(Mopen.this.client);
						Test.databaseconnection.manageService(open);
						Mopen.this.setNextPanel(new Mopenmessage());
					}
					}else{
						String str ="非本行账户无法执行该功能！！";
						Mopen.this.setNextPanel(new MMessage(str,new Mopen()));
					}
				}
			}
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 25));
		button1.setBounds(515, 437, 106, 44);
		add(button1);
		
		
		JButton button2 = new JButton("返回");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mopen.this.setNextPanel(new Moperation());
			}
		});
		button2.setFont(new Font("宋体", Font.PLAIN, 25));
		button2.setBounds(691, 437, 106, 44);
		add(button2);
	}

}


