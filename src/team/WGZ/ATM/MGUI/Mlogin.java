package team.WGZ.ATM.MGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import team.WGZ.ATM.GUI.Message;
import team.WGZ.ATM.GUI.Mypanel;
import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Listener.NumlengthListener;
import team.WGZ.ATM.Listener.OnlyNumListener;
import team.WGZ.ATM.Person.Administrator;

public class Mlogin extends Mpanel {
	private JTextField textField1;
	private JPasswordField textField2;
	public static Administrator nowAd;
	/**
	 * Create the panel.
	 */
	public Mlogin() {
		this.setLayout(null);
		this.setSize(1280,800);
		this.setVisible(true);
		
		JLabel label1 = new JLabel("ª∂”≠¿¥µΩ’–…Ã“¯––ATMπ‹¿Ì‘±œµÕ≥");
		label1.setFont(new Font("”◊‘≤", Font.BOLD, 45));
		label1.setBounds(335, 133, 692, 138);
		add(label1);
		
		JLabel label2 = new JLabel("«Î ‰»Î’À∫≈");
		label2.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		label2.setBounds(306, 318, 232, 62);
		add(label2);
		
		JLabel label3 = new JLabel("«Î ‰»Î√‹¬Î");
		label3.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		label3.setBounds(306, 460, 232, 62);
		add(label3);
		
		textField1 = new JTextField();// ‰»Îø®∫≈
		textField1.setBounds(616, 328, 353, 41);
		textField1.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		textField1.addKeyListener(new OnlyNumListener());
		textField1.addKeyListener(new NumlengthListener(textField1,10));
		add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JPasswordField();// ‰»Î√‹¬Î
		textField2.setBounds(616, 470, 353, 41);
		textField2.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		textField2.addKeyListener(new OnlyNumListener());
		textField2.addKeyListener(new NumlengthListener(textField2,6));
		add(textField2);
		textField2.setColumns(10);
		
		JButton button1 = new JButton("»∑»œ");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mlogin.this.nowAd=null;
				Mlogin.this.nowAd=Test.databaseconnection.validateAD(textField1.getText());
				if(Mlogin.this.nowAd==null){
					JOptionPane.showMessageDialog(null, "µ«¬º ß∞‹","Ã· æ£∫", JOptionPane.ERROR_MESSAGE);
				}else{
					Mlogin.this.setNextPanel(new Moperation());
				}
			}
		});
		button1.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		button1.setBounds(422, 619, 166, 68);
		add(button1);
		
		JButton button2 = new JButton("ÕÀ≥ˆ");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Test.mf.setVisible(false);
				Test.q.setVisible(true);
			}
		});
		button2.setFont(new Font("”◊‘≤", Font.BOLD, 35));
		button2.setBounds(733, 619, 166, 68);
		add(button2);
		
		
	}

}

