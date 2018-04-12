package team.WGZ.ATM.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyButton extends JButton{

		
		
	private static final long serialVersionUID = 1L;
		
		protected ImageIcon icon = new ImageIcon("btn.png");
		public MyButton(String string){
			super();
			
			this.setOpaque(false);
			
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setBorderPainted(false);  //设置是否绘制边框
			this.setBorder(null);//设置边框
			this.setIcon(icon);
			this.setOpaque(false);			
			this.setContentAreaFilled(false);//设置图片填满按钮所在的区域
			this.setFont(new Font("幼圆", Font.BOLD, 30));
			this.setForeground(Color.RED);//给组件上的文字设置颜色    new Color(54,54,54)
			this.setText(string);//写字
			this.setSize(this.icon.getIconWidth(),this.icon.getIconHeight());
			this.setVisible(true);
			addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent argo){
					setIcon(new ImageIcon("btn.png"));
				}
				public void mousePressed(MouseEvent argo){
					setIcon(new ImageIcon("btn1.png")); 
				}
				public void mouseExited(MouseEvent argo){
					setIcon(new ImageIcon("btn.png"));
				}
				public void mouseEntered(MouseEvent argo){
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
		}
	}
