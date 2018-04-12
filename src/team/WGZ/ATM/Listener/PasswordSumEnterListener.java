package team.WGZ.ATM.Listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordSumEnterListener implements FocusListener{

	private JPasswordField oncePassword;
	private JLabel tip;
	public PasswordSumEnterListener(JPasswordField oncePassword, JLabel tip) {
		super();
		this.oncePassword = oncePassword;
		this.tip = tip;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(this.oncePassword.getPassword().length!=6){
			this.tip.setText("密码必须为6位");
		}else{
			this.tip.setText("符合");
		}
		
	}

}
