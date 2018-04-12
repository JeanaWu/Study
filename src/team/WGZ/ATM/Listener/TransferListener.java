package team.WGZ.ATM.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TransferListener implements KeyListener{
	
	private JTextField jt;
	public TransferListener(JTextField jt) {
		this.jt=jt;
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 ) {
			if(this.jt.getText().contains(".")) {
				int count =0;
				for(int i=this.jt.getText().length()-1;i>=0;i--) {
					if(this.jt.getText().charAt(i)=='.') {
						if(count==2) {
							e.consume();
							break;
						}
					}else {
						count++;
					}
				}
			}
		} else {
			if(keyChar==KeyEvent.VK_PERIOD) {
				if(this.jt.getText().equals("")) {
					e.consume();
				}
				else {
					if(this.jt.getText().contains(".")) {
						e.consume();
					}else {
						
					}
				}
			}else {
				e.consume(); 
			}
			 
		}
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
