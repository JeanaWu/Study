package team.WGZ.ATM.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Operation.Deposit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Save extends Mypanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Save() {
		this.setLayout(null);
		this.setSize(1280,800);
		
		JLabel lblNewLabel = new JLabel("����������");
		lblNewLabel.setFont(new Font("��Բ", Font.BOLD, 35));
		lblNewLabel.setBounds(522, 285, 271, 96);
		add(lblNewLabel);
		
		textField = new JTextField();//��������
		textField.setBounds(491, 409, 336, 52);
		textField.setFont(new Font("��Բ", Font.BOLD, 35));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,5));
		add(textField);
		textField.setColumns(10);
		
		MyButton button1 = new MyButton("�˿�");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.nowclient=null;
				Save.this.setNextPanel(new FirstPanel());
			}
		});
		button1.setFont(new Font("��Բ", Font.BOLD, 30));
		button1.setBounds(0, 559, 232, 80);
		add(button1);
		
		MyButton button2 = new MyButton("����");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				Save.this.repaint();
			}
		});
		button2.setFont(new Font("��Բ", Font.BOLD, 30));
		button2.setBounds(1052, 559, 232, 80);
		add(button2);
		
		MyButton button3 = new MyButton("ȷ��");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Double.parseDouble(textField.getText())>10000){
					String str="���ʧ�ܣ�������Ľ�����10000��";
					Save.this.setNextPanel(new Message(str,new Save()));
				}else {
				if(Double.parseDouble(textField.getText())%100!=0) {
					//Save s = new Save();
					//s.textField.setText(String.valueOf(Integer.parseInt(textField.getText())/100*100));
					String str="���ʧ�ܣ�������Ľ���������";
					//String str = "�˻�����"+String.valueOf(Integer.parseInt(textField.getText())%100)+"RMB";
					Save.this.setNextPanel(new Message(str,new Save()));
				}else {
					Deposit deposit = new Deposit();
				    //System.out.println(Test.nowclient.toString());
					deposit.setClient(Test.nowclient);
					deposit.setDepositmoney(Integer.parseInt(Save.this.textField.getText()));;
					Test.nowclient=Test.databaseconnection.correspondingOperation(deposit);
					String str="���ɹ���ף��������죡";
					//�ĳ�m2
					Save.this.setNextPanel(new Message_2(str,new Coperation(),new Save()));
				    //System.out.println(Test.nowclient);
				}
			}
			}
		});
		button3.setFont(new Font("��Բ", Font.BOLD, 30));
		button3.setBounds(1052, 654, 232, 80);
		add(button3);
		
		MyButton button4 = new MyButton("����");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save.this.setNextPanel(new Coperation());
			}
		});
		button4.setFont(new Font("��Բ", Font.BOLD, 30));
		button4.setBounds(0, 654, 232, 80);
		add(button4);
	}
}
