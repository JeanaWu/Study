package team.WGZ.ATM.MGUI;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import team.WGZ.ATM.GUI.Test;

@SuppressWarnings("serial")
public class Mpanel extends JPanel{
	public Mpanel(){
		super();
		this.setOpaque(false);
	}
	public Mpanel(GridLayout g){
		super(g);
	}
    private String picname="adbc.jpg";
    public void setPicname(String picname){
  	  this.picname = picname;
    }
	  public void paintComponent(Graphics g) {
		   int x = 0, y = 0;
		   ImageIcon icon = new ImageIcon(picname);
		   g.drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);
	  }
		public void setNextPanel(JPanel nextPanel) {
			this.setVisible(false);
			Test.mf.add(nextPanel);
			nextPanel.setVisible(true);
			nextPanel.updateUI();
			nextPanel.repaint();
		}
}
