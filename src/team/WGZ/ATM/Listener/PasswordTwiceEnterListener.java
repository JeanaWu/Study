package team.WGZ.ATM.Listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordTwiceEnterListener implements KeyListener{

	private JLabel tip;
	private JPasswordField oncePassword,twicePassword;
	public PasswordTwiceEnterListener(JLabel tip, JPasswordField oncePassword, JPasswordField twicePassword) {
		this.tip = tip;
		this.oncePassword = oncePassword;
		this.twicePassword = twicePassword;
	}
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(twicePassword.getPassword().length==5){
			if(!String.valueOf(oncePassword.getPassword()).equals(String.valueOf(twicePassword.getPassword()))){
				this.tip.setText("密码不一致");
			}else{
				this.tip.setText("一致");
			}
		}else{
			this.tip.setText("");
		}*/
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(twicePassword.getPassword().length==5){
			if(!String.valueOf(oncePassword.getPassword()).equals(String.valueOf(twicePassword.getPassword()))){
				this.tip.setText("密码不一致");
			}else{
				this.tip.setText("一致");
			}
		}else{
			this.tip.setText("");
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(twicePassword.getPassword().length==6){
			if(!String.valueOf(oncePassword.getPassword()).equals(String.valueOf(twicePassword.getPassword()))){
				this.tip.setText("密码不一致");
			}else{
				this.tip.setText("一致");
			}
		}else{
			this.tip.setText("");
		}
	}

}
