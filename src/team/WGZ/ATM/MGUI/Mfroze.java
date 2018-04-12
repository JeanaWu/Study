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
import team.WGZ.ATM.Service.Freeze;
import team.WGZ.ATM.Service.Open;

public class Mfroze extends Mpanel {
	private JTextField textField;
    private Client client;
	/**
	 * Create the panel.
	 */
	public Mfroze() {
		this.setLayout(null);
		this.setSize(1280,800);
		
	
		
		JLabel label = new JLabel("���붳���˻��˺ţ�");
		label.setFont(new Font("����", Font.PLAIN, 25));
		label.setBounds(238, 253, 248, 44);
		add(label);
		
		JButton button1 = new JButton("ȷ��");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client=null;
				client = Test.databaseconnection.validateID(textField.getText());
				if(client==null){
					String str ="�˻������ڣ�";
					Mfroze.this.setNextPanel(new MMessage(str,Mfroze.this));
				}else{
					
					if(client.getBank_name().equals("��������")){
					if(client.getState().equals("����")){
						String str ="���˻��Ѿ�������";
						Mfroze.this.setNextPanel(new MMessage(str,new Mfroze()));
					}else{
						Freeze freeze = new Freeze();
						freeze.setClient(client);
						client=Test.databaseconnection.manageService(freeze);
						Mfroze.this.setNextPanel(new Mfromessage(client.getUser_ID()));
					}
					}else{
						String str ="�Ǳ����˻��޷�ִ�иù��ܣ���";
						Mfroze.this.setNextPanel(new MMessage(str,new Mfroze()));
					}
				}
			}
		});
		button1.setFont(new Font("����", Font.PLAIN, 25));
		button1.setBounds(515, 437, 106, 44);
		add(button1);
		
		textField = new JTextField();
		textField.setBounds(483, 253, 414, 37);
		textField.setFont(new Font("��Բ", Font.BOLD, 25));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,19));
		add(textField);
		textField.setColumns(10);
		
		JButton button2 = new JButton("����");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mfroze.this.setNextPanel(new Moperation());
			}
		});
		button2.setFont(new Font("����", Font.PLAIN, 25));
		button2.setBounds(691, 437, 106, 44);
		add(button2);
	}


	

}
