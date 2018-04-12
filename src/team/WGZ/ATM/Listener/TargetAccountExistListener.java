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
			this.jb.setText("该目标用户不存在，请重新输入");
			this.jb.repaint();
		}else{
			if(this.Targetclient.getUser_ID().equals(Test.nowclient.getUser_ID())){
				this.jb.setText("请输入正确的账号！");
				this.jb.repaint();
			}else{
			String state=this.Targetclient.getState();
			if(state.equals("挂失")||state.equals("销户")){
				this.jb.setText("该目标用户处于"+state+"状态，无法转账");
				this.jb.repaint();
			}else{
				String str="目标账号:"+Targetclient.getUser_ID()+"    状态："+Targetclient.getState()+"    身份："+Targetclient.getName().substring(0,1);
				if(this.Targetclient.getSex().substring(0,1).equals("男")){
					this.jb.setText(str+"先生");
				}else{
					this.jb.setText(str+"女士");
				}

				this.jb.repaint();
			}
			}
		}
	}

}
