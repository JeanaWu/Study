package team.WGZ.ATM.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OnlyNumListener implements KeyListener {
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 ) {
			
		} else {
			e.consume();  
		}
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
