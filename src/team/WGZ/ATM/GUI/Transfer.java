package team.WGZ.ATM.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Listener.TargetAccountExistListener;
import team.WGZ.ATM.Listener.TransferListener;
import team.WGZ.ATM.Operation.ByTransfer;
import team.WGZ.ATM.Person.Client;
import team.WGZ.ATM.Person.Creditclient;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfer extends Mypanel {
	private JTextField textField2;
	private JTextField textField1;
	private Client targetclient;

	/**
	 * Create the panel.
	 */
	public Transfer() {
		this.setLayout(null);
		this.setSize(1280,800);

		
		JLabel label1 = new JLabel("������Ŀ���˻���");
		label1.setFont(new Font("��Բ", Font.BOLD, 35));
		label1.setBounds(307, 282, 300, 74);
		add(label1);
		
		textField2 = new JTextField();//����ת�˽��
		textField2.setBounds(662, 426, 277, 56);
		textField2.addKeyListener(new NumlengthListener(textField2,8));
		textField2.addKeyListener(new TransferListener(textField2));
		textField2.setFont(new Font("��Բ", Font.BOLD, 35));
		add(textField2);
		textField2.setColumns(10);
		
		JLabel label2 = new JLabel("������ת�˽�");
		label2.setFont(new Font("��Բ", Font.BOLD, 35));
		label2.setBounds(303, 411, 304, 74);
		add(label2);
		
		JLabel lblNewLabel_1 = new JLabel();//��ʾ
		lblNewLabel_1.setBounds(307, 536, 632, 60);
		lblNewLabel_1.setFont(new Font("��Բ", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.RED);
		add(lblNewLabel_1);
		
		textField1 = new JTextField();//����Ŀ���˻�
		textField1.setColumns(10);
		textField1.addKeyListener(new NumlengthListener(textField1,19));
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addFocusListener(new TargetAccountExistListener(targetclient,textField1,lblNewLabel_1));
		System.out.print(targetclient);
		textField1.setBounds(662, 297, 439, 56);
		textField1.setFont(new Font("��Բ", Font.BOLD, 35));
		add(textField1);
		
		MyButton button3 = new MyButton("ȷ��");
		button3.setFont(new Font("��Բ", Font.BOLD, 30));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client targetclient=Test.databaseconnection.validateID(textField1.getText());
				if(targetclient==null){
					String str="���󣺴��տ��˺Ų����ڣ����������룡";
					Transfer.this.setNextPanel(new Message(str,new Transfer()));
				}else{
					if(targetclient.getUser_ID().equals(Test.nowclient.getUser_ID())){
						String str="���󣺲������Լ�ת�ˣ�";
						Transfer.this.setNextPanel(new Message(str,new Transfer()));
					}else{
					if(targetclient.getState().equals("��ʧ")||targetclient.getState().equals("����")){
						String str="���󣺴��տ��˺���"+targetclient.getState()+"�޷�����ת�ˣ�";
						Transfer.this.setNextPanel(new Message(str,new Transfer()));
					}else{
						if((Double.parseDouble(textField2.getText()))>=10000){
							String str ="����������Ľ�����10000.00�����������룡";
							Transfer.this.setNextPanel(new Message(str,new Transfer()));
						}else{
							if(Double.parseDouble(textField2.getText())>Test.nowclient.getTodaytransfer()){
								String str ="���󣺽���ʣ���ת�˵Ľ��㣡";
								Transfer.this.setNextPanel(new Message(str,new Transfer()));
							}else{
								if(Test.nowclient.getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")){
									Creditclient c=(Creditclient)Test.nowclient;
									if(c.getBalance()+c.getRemain_overdraft()>=Double.parseDouble(Transfer.this.textField2.getText())*1.01){
										//��
										boolean isOther; 
										if(targetclient.getBank_name().equals("��������"))isOther=false;
										else isOther=true;
										team.WGZ.ATM.Operation.Transfer transfer = new team.WGZ.ATM.Operation.Transfer();
						                transfer.setClient(Test.nowclient);
						                transfer.setTarget(targetclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()), isOther);
						                Test.nowclient=Test.databaseconnection.correspondingOperation(transfer);
						                
						                //�տ
						                ByTransfer bytransfer = new ByTransfer();
						                bytransfer.setClient(targetclient);
						                bytransfer.setSourceTransfer(Test.nowclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()));
						                Test.databaseconnection.correspondingOperation(bytransfer);
						                String str="ת�˳ɹ���ף��������죡";
						                Transfer.this.setNextPanel(new Message_2(str,new Coperation(),new Transfer()));
									}else{
										String str ="ת��ʧ�ܣ��������㣡";
										Transfer.this.setNextPanel(new Message(str,new Transfer()));
									}
								}else{
									if(!targetclient.getBank_name().equals("��������")){
										if(Test.nowclient.getBalance()<Double.parseDouble(Transfer.this.textField2.getText())*1.01){
											String str ="ת��ʧ�ܣ��������㣡";
											Transfer.this.setNextPanel(new Message(str,new Transfer()));
										}else{
											//��
											boolean isOther; 
											if(targetclient.getBank_name().equals("��������"))isOther=false;
											else isOther=true;
											team.WGZ.ATM.Operation.Transfer transfer = new team.WGZ.ATM.Operation.Transfer();
							                transfer.setClient(Test.nowclient);
							                transfer.setTarget(targetclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()), isOther);
							                Test.nowclient=Test.databaseconnection.correspondingOperation(transfer);
							                
							                //�տ
							                ByTransfer bytransfer = new ByTransfer();
							                bytransfer.setClient(targetclient);
							                bytransfer.setSourceTransfer(Test.nowclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()));
							                Test.databaseconnection.correspondingOperation(bytransfer);
							                String str="ת�˳ɹ���ף��������죡";
							                Transfer.this.setNextPanel(new Message_2(str,new Coperation(),new Transfer()));
										}
									}else{
										//��
										boolean isOther; 
										if(targetclient.getBank_name().equals("��������"))isOther=false;
										else isOther=true;
										team.WGZ.ATM.Operation.Transfer transfer = new team.WGZ.ATM.Operation.Transfer();
						                transfer.setClient(Test.nowclient);
						                transfer.setTarget(targetclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()), isOther);
						                Test.nowclient=Test.databaseconnection.correspondingOperation(transfer);
						                
						                //�տ
						                ByTransfer bytransfer = new ByTransfer();
						                bytransfer.setClient(targetclient);
						                bytransfer.setSourceTransfer(Test.nowclient.getUser_ID(), Double.parseDouble(Transfer.this.textField2.getText()));
						                Test.databaseconnection.correspondingOperation(bytransfer);
						                String str="ת�˳ɹ���ף��������죡";
						                Transfer.this.setNextPanel(new Message_2(str,new Coperation(),new Transfer()));
									}
									
								}
							}
						}
					}
						
				}
				}
			}
		});
		button3.setBounds(1034, 604, 232, 80);
		add(button3);
		
		MyButton button1 = new MyButton("����");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transfer.this.setNextPanel(new Coperation());
			}
		});
		button1.setFont(new Font("��Բ", Font.BOLD, 30));
		button1.setBounds(14, 509, 232, 80);
		add(button1);
		
		MyButton button2 = new MyButton("�˿�");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Test.nowclient=null;
			     Transfer.this.setNextPanel(new FirstPanel());
			}
		});
		button2.setFont(new Font("��Բ", Font.BOLD, 30));
		button2.setBounds(14, 635, 232, 80);
		add(button2);
		
		
	}

}
