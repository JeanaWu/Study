package team.WGZ.ATM.MGUI;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MFind2 extends Mpanel{
	private String account;
	public MFind2(String account) {
		this.account= account;
		this.setLayout(null);
		this.setSize(1280,800);
		
		JButton button = new JButton("\u8FD4\u56DE");//·µ»Ø
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFind2.this.setNextPanel(new MFind());
			}
		});
		button.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		button.setBounds(14, 695, 153, 52);
		add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u4EA4\u6613\u660E\u7EC6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFind2.this.setNextPanel(new MCFindDetail(MFind2.this.account));
			}
		});
		button_1.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		button_1.setBounds(976, 381, 290, 46);
		add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u53CA\u4FEE\u6539\u8D26\u6237\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFind2.this.setNextPanel(new MFindMessage(account));
			}
		});
		button_2.setFont(new Font("Ó×Ô²", Font.BOLD, 25));
		button_2.setBounds(976, 510, 290, 52);
		add(button_2);
		
	}

}
