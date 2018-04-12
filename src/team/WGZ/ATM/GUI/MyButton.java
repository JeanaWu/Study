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
			this.setBorderPainted(false);  //�����Ƿ���Ʊ߿�
			this.setBorder(null);//���ñ߿�
			this.setIcon(icon);
			this.setOpaque(false);			
			this.setContentAreaFilled(false);//����ͼƬ������ť���ڵ�����
			this.setFont(new Font("��Բ", Font.BOLD, 30));
			this.setForeground(Color.RED);//������ϵ�����������ɫ    new Color(54,54,54)
			this.setText(string);//д��
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
