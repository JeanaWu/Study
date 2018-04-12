package team.WGZ.ATM.Listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import team.WGZ.ATM.GUI.Test;

public class PasswordEnterListener implements FocusListener{

	private JLabel tip;
	private JPasswordField password;
	public PasswordEnterListener(JLabel tip,JPasswordField password){
		this.tip=tip;
		this.password=password;
	}
	public void focusGained(FocusEvent e) {
		this.tip.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(!String.valueOf(password.getPassword()).equals(Test.nowclient.getPassword())){
			this.tip.setText("密码不正确");
		}else{
			this.tip.setText("正确");
		}
	}
}
