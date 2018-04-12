package team.WGZ.ATM.Listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import team.WGZ.ATM.DataConnection.DatabaseConnection;
import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Person.Client;

public class TargetAccountExistListener implements FocusListener{

	private JTextField targetText;
	private Client Targetclient;
	private JLabel jb;
	public TargetAccountExistListener(Client Targetclient,JTextField targetText,JLabel jb){
		this.targetText=targetText;
		this.Targetclient=Targetclient;
		this.jb=jb;
	}
	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		DatabaseConnection d = new DatabaseConnection();
		this.Targetclient=d.validateID(this.targetText.getText());
		d.closeConnection();
		if(Targetclient==null){
			this.jb.setText("��Ŀ���û������ڣ�����������");
			this.jb.repaint();
		}else{
			if(this.Targetclient.getUser_ID().equals(Test.nowclient.getUser_ID())){
				this.jb.setText("��������ȷ���˺ţ�");
				this.jb.repaint();
			}else{
			String state=this.Targetclient.getState();
			if(state.equals("��ʧ")||state.equals("����")){
				this.jb.setText("��Ŀ���û�����"+state+"״̬���޷�ת��");
				this.jb.repaint();
			}else{
				String str="Ŀ���˺�:"+Targetclient.getUser_ID()+"    ״̬��"+Targetclient.getState()+"    ��ݣ�"+Targetclient.getName().substring(0,1);
				if(this.Targetclient.getSex().substring(0,1).equals("��")){
					this.jb.setText(str+"����");
				}else{
					this.jb.setText(str+"Ůʿ");
				}

				this.jb.repaint();
			}
			}
		}
	}

}
