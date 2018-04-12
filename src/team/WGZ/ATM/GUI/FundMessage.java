package team.WGZ.ATM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FundMessage extends Mypanel{
	public FundMessage() {
		this.setLayout(null);
		this.setSize(1280,800);
				
		MyButton button = new MyButton("·µ»Ø");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                 FundMessage.this.setNextPanel(new FindChoose());
			}
		});
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		button.setBounds(14, 607, 232, 80);
		add(button);
		
		MyButton myButton = new MyButton("");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FundMessage.this.setNextPanel(new Coperation());
			}
		});
		myButton.setText("¼ÌÐø½»Ò×");
		myButton.setFont(new Font("Ó×Ô²", Font.BOLD, 30));
		myButton.setBounds(1034, 607, 232, 80);
		add(myButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(241, 196, 800, 491);
		panel.setLayout(null);
		panel.setOpaque(false);
	    panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label.setBounds(289, 70, 226, 56);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("\u4EBA\u6C11\u5E01\uFF08CNY\uFF09");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		lblNewLabel.setBounds(322, 150, 172, 31);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("      \u8D26\u6237\u4F59\u989D");
		label_1.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_1.setBounds(200, 205, 183, 31);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u4ECA\u65E5\u5269\u4F59\u53EF\u53D6\u6B3E\u6570");
		label_2.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_2.setBounds(184, 273, 199, 31);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u4ECA\u65E5\u5269\u4F59\u53EF\u8F6C\u8D26\u6570");
		label_3.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_3.setBounds(184, 343, 199, 31);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");//Óà¶î
		label_4.setText(String.valueOf(Test.nowclient.getBalance())+"Ôª");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_4.setBounds(469, 205, 183, 31);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");//½ñÈÕÈ¡¿î
		label_5.setText(String.valueOf(Test.nowclient.getTodaydraw())+"Ôª");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_5.setBounds(469, 273, 183, 31);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");//½ñÈÕ×ªÕË
		label_6.setForeground(Color.RED);
		label_6.setText(String.valueOf(Test.nowclient.getTodaytransfer())+"Ôª");
		label_6.setFont(new Font("Ó×Ô²", Font.BOLD, 23));
		label_6.setBounds(469, 343, 183, 31);
		panel.add(label_6);
		
		
	}
}
