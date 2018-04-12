package team.WGZ.ATM.GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Creditclient;

import javax.swing.JLabel;

public class Draft extends Mypanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Draft() {
		this.setLayout(null);
		this.setSize(1280,800);
		
		MyButton button6 = new MyButton("2000");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("2000");
				Draft.this.repaint();
			}
		});
		button6.setFont(new Font("宋体", Font.BOLD, 30));
		button6.setBounds(1040, 407, 232, 80);
		add(button6);
		
		MyButton button4 = new MyButton("1000");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("1000");
				Draft.this.repaint();
			}
		});
		button4.setFont(new Font("宋体", Font.BOLD, 30));
		button4.setBounds(1040, 142, 232, 80);
		add(button4);
		
		MyButton button5 = new MyButton("1500");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("1500");
				Draft.this.repaint();	
			}
		});
		button5.setFont(new Font("宋体", Font.BOLD, 30));
		button5.setBounds(1040, 273, 232, 80);
		add(button5);
		
		MyButton button7 = new MyButton("3000");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("3000");
				Draft.this.repaint();
			}
		});
		button7.setFont(new Font("宋体", Font.BOLD, 30));
		button7.setBounds(1040, 546, 232, 80);
		add(button7);
		
		MyButton button3 = new MyButton("300");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("300");
				Draft.this.repaint();
			}
		});
		button3.setFont(new Font("宋体", Font.BOLD, 30));
		button3.setBounds(14, 407, 232, 80);
		add(button3);
		
		MyButton button9 = new MyButton("确认");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Double.parseDouble(textField.getText())>3000) {
					String str="取款失败，您的取款金额大于3000";
					Draft.this.setNextPanel(new Message(str,Draft.this));
				}else {
					if(Double.parseDouble(textField.getText())%100!=0) {
						String str="取款失败，请输入整百数";
						Draft.this.setNextPanel(new Message(str,new Draft()));
					}else {
						if(Double.parseDouble(textField.getText())>Test.nowclient.getTodaydraw()) {
							String str="取款失败，您的取款金额大于今日可取款金额";
							Draft.this.setNextPanel(new Message(str,new Draft()));
						}else {
							//System.out.println(Test.nowclient.getClass().getName());
							if(Test.nowclient.getClass().getName().equals("team.WGZ.ATM.Person.Creditclient")) {
								Creditclient c=(Creditclient)Test.nowclient;
								if(c.getBalance()+c.getRemain_overdraft()>=Double.parseDouble(Draft.this.textField.getText())*1.01) {
									String str="取款成功，祝您生活愉快！";
									team.WGZ.ATM.Operation.Draft draft = new team.WGZ.ATM.Operation.Draft();
									//System.out.println(c.toString());
									draft.setClient(c);
									draft.setDraftmoney(Integer.parseInt(textField.getText()));
									Test.nowclient=Test.databaseconnection.correspondingOperation(draft);
									//改m2
									Draft.this.setNextPanel(new Message_2(str,new Coperation(),new Draft()));
									//System.out.println(c.toString()); 
								}else {
									String str="取款失败，您的余额不足";
									Draft.this.setNextPanel(new Message(str,new Draft()));
								}
							}else {
								if(Test.nowclient.getBalance()>=Double.parseDouble(Draft.this.textField.getText())) {
									String str="取款成功，祝您生活愉快！";
									team.WGZ.ATM.Operation.Draft draft = new team.WGZ.ATM.Operation.Draft();
									//System.out.println(c.toString());
									draft.setClient(Test.nowclient);
									draft.setDraftmoney(Integer.parseInt(textField.getText()));
									Test.nowclient=Test.databaseconnection.correspondingOperation(draft);
									Draft.this.setNextPanel(new Message_2(str,new Coperation(),new Draft()));
									//System.out.println(c.toString()); 
								}else {
									String str="取款失败，您的余额不足";
									Draft.this.setNextPanel(new Message(str,new Draft()));
								}
							}
						}
					}
				}
			}
		});
		button9.setFont(new Font("宋体", Font.BOLD, 30));
		button9.setBounds(1040, 693, 232, 80);
		add(button9);
		
		MyButton button1 = new MyButton("100");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("100");
				Draft.this.repaint();
			}
		});
		button1.setFont(new Font("宋体", Font.BOLD, 30));
		button1.setBounds(14, 142, 232, 80);
		add(button1);
		
		MyButton button2 = new MyButton("200");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.textField.setText("200");
				Draft.this.repaint();
			}
		});
		button2.setFont(new Font("宋体", Font.BOLD, 30));
		button2.setBounds(14,273, 232, 80);
		add(button2);
		
		MyButton button8 = new MyButton("返回");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Draft.this.setNextPanel(new Coperation());
			}
		});
		button8.setFont(new Font("宋体", Font.BOLD, 30));
		button8.setBounds(14, 693, 232, 80);
		add(button8);
		
		textField = new JTextField();//输入取账金额
		textField.setBounds(404, 439, 448, 89);
		textField.setFont(new Font("宋体", Font.BOLD, 35));
		textField.addKeyListener(new OnlyNumListener());
		textField.addKeyListener(new NumlengthListener(textField,4));
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("请输入取款金额并确认");
		label.setFont(new Font("幼圆", Font.BOLD, 35));
		label.setBounds(447, 303, 382, 113);
		add(label);
		
		MyButton myButton = new MyButton("\u8FD4\u56DE");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Test.nowclient=null;
				Draft.this.setNextPanel(new FirstPanel());
			}
		});
		myButton.setText("\u9000\u5361");
		myButton.setFont(new Font("宋体", Font.BOLD, 30));
		myButton.setBounds(14, 586, 232, 80);
		add(myButton);

	}
}
