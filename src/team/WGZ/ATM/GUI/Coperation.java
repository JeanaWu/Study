package team.WGZ.ATM.GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Coperation extends Mypanel {

	/**
	 * Create the panel.
	 */
	public Coperation() {
		this.setLayout(null);
		this.setSize(1280,800);

		
		MyButton button1 = new MyButton("��ѯ");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Coperation.this.setNextPanel(new FindChoose());
			}
		});
		button1.setFont(new Font("��Բ", Font.BOLD, 30));
		button1.setBounds(0, 163, 285, 108);
		add(button1);
		
		MyButton button2 = new MyButton("ת��");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Test.nowclient.getBank_name().equals("��������")) {
					JOptionPane.showMessageDialog(null, "�Ǳ����˻�����ת��","��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
					if(Test.nowclient.getState().substring(0,2).equals("����")) {
						JOptionPane.showMessageDialog(null, "�����˻��ѱ����ᣡ","��ʾ��", JOptionPane.ERROR_MESSAGE);
					}else {
						Coperation.this.setNextPanel(new Transfer());
					}
				}		
			}
		});
		button2.setFont(new Font("��Բ", Font.BOLD, 30));
		button2.setBounds(995, 306, 285, 108);
		add(button2);
		
		MyButton button3 = new MyButton("���");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Test.nowclient.getBank_name().equals("��������")) {
					JOptionPane.showMessageDialog(null, "�Ǳ����˻����ܴ��","��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
						Coperation.this.setNextPanel(new Save());
				}
				
			}
		});
		button3.setFont(new Font("��Բ", Font.BOLD, 30));
		button3.setBounds(995, 454, 285, 108);
		add(button3);
		
		MyButton button4 = new MyButton("�˿�");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.nowclient=null;
				Coperation.this.setNextPanel(new FirstPanel());
			}
		});
		button4.setFont(new Font("��Բ", Font.BOLD, 30));
		button4.setBounds(-10, 624, 285, 108);
		add(button4);
		
		MyButton button6 = new MyButton("�޸�����");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Test.nowclient.getBank_name().equals("��������"))
				{
					JOptionPane.showMessageDialog(null, "�Ǳ����û������޸����룡","��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else{
				if(Test.nowclient.getState().substring(0,2).equals("����")) {
					JOptionPane.showMessageDialog(null, "�����˻��ѱ����ᣡ","��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
				Coperation.this.setNextPanel(new Calter());
				}
			}
			}
		});
		button6.setFont(new Font("��Բ", Font.BOLD, 27));
		button6.setBounds(0, 306, 285, 108);
		add(button6);
		
		MyButton button5 = new MyButton("ȡ��");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Test.nowclient.getState().substring(0,2).equals("����")) {
					JOptionPane.showMessageDialog(null, "�����˻��ѱ����ᣡ","��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
				Coperation.this.setNextPanel(new Draft());
				}
			}
		});
		button5.setFont(new Font("��Բ", Font.BOLD, 30));
		button5.setBounds(995, 163, 285, 108);
		add(button5);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u8FDB\u884C\u7684\u64CD\u4F5C");
		label.setForeground(Color.RED);
		label.setFont(new Font("��Բ", Font.BOLD, 35));
		label.setBounds(457, 397, 392, 77);
		add(label);
		
		String name=null;
		if(Test.nowclient.getSex().substring(0,1).equals("��")){
			name = Test.nowclient.getName().substring(0,1)+"����";
		}else{
			name = Test.nowclient.getName().substring(0,1)+"Ůʿ";
		}
		JLabel label_1 = new JLabel("��ӭ����"+name+"!");
		label_1.setFont(new Font("��Բ", Font.BOLD, 30));
		label_1.setBounds(322, 163, 279, 52);
		add(label_1);
		
		JLabel label_2 = new JLabel("�����˻�״̬Ϊ��"+Test.nowclient.getState());
		label_2.setFont(new Font("��Բ", Font.BOLD, 30));
		label_2.setBounds(468, 237, 392, 52);
		add(label_2);
	}

}
