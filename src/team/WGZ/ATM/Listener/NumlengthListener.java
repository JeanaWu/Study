package team.WGZ.ATM.Listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class NumlengthListener extends KeyAdapter{
       private JTextField jt;
       private int maxLength;
       public NumlengthListener(JTextField jt,int length) {
    	     this.jt=jt;
    	     this.maxLength=length;
       }
        public void keyTyped(KeyEvent e) {
            int code = e.getKeyChar();
            if (code == KeyEvent.VK_BACK_SPACE) {
                e.isActionKey();
            } else if (this.jt.getDocument().getLength() >= maxLength) {
                e.consume();
            }
        }
}
