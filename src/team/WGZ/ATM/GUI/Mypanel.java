package team.WGZ.ATM.GUI;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")

public class Mypanel extends JPanel{
	public Mypanel(){
		this.setLayout(null);
		this.setSize(1280,800);
		this.setOpaque(false);
	    
	}
	public Mypanel(GridLayout g){
		super(g);
	}
    private String picname="background.jpg";
    public void setPicname(String picname){
  	  this.picname = picname;
    }
	  public void paintComponent(Graphics g) {
		   int x = 0, y = 0;
		   ImageIcon icon = new ImageIcon(picname);
		   g.drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);
	  }
		public void setNextPanel(JPanel nextPanel) {
			//this.setVisible(false);
			Test.q.getContentPane().add(nextPanel);
			Test.q.remove(this);
			nextPanel.setVisible(true);
			nextPanel.updateUI();
			nextPanel.repaint();
		}
}


