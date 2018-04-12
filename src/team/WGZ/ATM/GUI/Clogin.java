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

		
		JLabel label1 = new JLabel("��ӭ������������ATM�ͻ�ϵͳ");
		label1.setFont(new Font("��Բ", Font.BOLD, 45));
		label1.setBounds(335, 133, 692, 138);
		add(label1);
		
		JLabel label2 = new JLabel("�����뿨��");
		label2.setFont(new Font("��Բ", Font.BOLD, 35));
		label2.setBounds(306, 379, 232, 62);
		add(label2);
		
		JLabel label3 = new JLabel("����������");
		label3.setFont(new Font("��Բ", Font.BOLD, 35));
		label3.setBounds(306, 483, 232, 62);
		add(label3);
		
		textField1 = new JTextField();//���뿨��
		textField1.setBounds(577, 399, 340, 35);
		textField1.setFont(new Font("����", Font.BOLD, 25));
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addKeyListener(new NumlengthListener(textField1,19));
		textField1.setText("");//6217003100003628202
		add(textField1);
		textField1.setColumns(10);
		
		password = new JPasswordField(6);//��������
		password.setBounds(577, 503, 340, 35);
		password.setFont(new Font("����", Font.BOLD, 25));
		password.setText("");
		password.addKeyListener(new NumlengthListener(password,6));
		password.addKeyListener(new OnlyNumListener());
		add(password);
		password.setColumns(10);
		
		MyButton btnNewButton = new MyButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                    Test.nowclient=null;
					Test.nowclient = Test.databaseconnection.validateID(textField1.getText());
				if(Test.nowclient==null) {//�������˺�
					   String str = "����������ȷ���˺ţ�";
					   Clogin.this.setNextPanel(new Message(str,new Clogin()));
				}else if(Test.nowclient.getState().equals("����")||Test.nowclient.getState().equals("����")) {//�����˺ţ��ж�״̬
					if(Test.nowclient.getPassword().equals(String.valueOf(password.getPassword()))) {//�ж�����
						Clogin.this.setNextPanel(new Coperation());//=====================================
					}else {
						if(Test.nowclient.getWrong_time()>=1) {//������δ����Զ������˻�
							Test.nowclient.setWrong_time(Test.nowclient.getWrong_time()-1);
							String str="�������������"+Test.nowclient.getWrong_time()+"�λ���";
							Test.databaseconnection.UpdateClientTime(Test.nowclient);
							Clogin.this.setNextPanel(new Message(str,new Clogin()));
						}else {
							Test.nowclient.setState("����");
							Test.databaseconnection.UpdateClientState(Test.nowclient);
							String str = "������������˺��ѱ�����";
							Clogin.this.setNextPanel(new Message(str,new Clogin()));
						}
					}
				}else {
					if(Test.nowclient.getState().equals("��ʧ"))
					{
						String str = "�����˺��ѹ�ʧ���޷���½";
						Clogin.this.setNextPanel(new Message(str,new Clogin())); 
					}
					if(Test.nowclient.getState().equals("����")) {
						String str="�����˺����������޷���½";
						Clogin.this.setNextPanel(new Message(str,new Clogin())); 
					}
				}
			}
		});
		btnNewButton.setFont(new Font("��Բ", Font.BOLD, 30));
		btnNewButton.setBounds(1036, 624, 230,80);//232,80
		add(btnNewButton);
		
		
		MyButton button = new MyButton("�˿�");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.nowclient=null;
				Clogin.this.setNextPanel(new FirstPanel());
			}
		});
		button.setFont(new Font("��Բ", Font.BOLD, 30));
		button.setBounds(14, 624, 232, 80);
		add(button);
	}

}
