package team.WGZ.ATM.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mylabel extends JLabel {

   private ImageIcon ic;
   private String name;
   public Mylabel(String name){
	   this.name=name;
	   ic=new ImageIcon(name);
	   this.setIcon(ic);
   }

   public void paintComponent(Graphics g) {
	   int x = 0, y = 0;
	   g.drawImage(ic.getImage(), x, y, getSize().width,getSize().height, this);
	   this.repaint();
  }
      
}
