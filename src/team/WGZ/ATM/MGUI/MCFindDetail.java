package team.WGZ.ATM.MGUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import team.WGZ.ATM.GUI.Coperation;
import team.WGZ.ATM.GUI.FindChoose;
import team.WGZ.ATM.GUI.FindDetail;
import team.WGZ.ATM.GUI.MyButton;
import team.WGZ.ATM.GUI.Test;
import team.WGZ.ATM.Operation.Find;
import team.WGZ.ATM.Person.Client;

public class MCFindDetail extends Mpanel{
	private JTable table;
	private ResultSet result;
	private DefaultTableModel model_3month,model_1year,model_3year;
	private Vector <Vector>data1,data2,data3;
	private Vector <String>name;
	private SimpleDateFormat year,month;
	private Client client;
	private  void init(){
		model_3month = new DefaultTableModel();
		model_1year = new DefaultTableModel();
		model_3year = new DefaultTableModel();
		data1 = new Vector<Vector>();
		data2 = new Vector<Vector>();
		data3 = new Vector<Vector>();
		name = new Vector<String>();
		year = new SimpleDateFormat("yyyy");
		month= new SimpleDateFormat("MM");
		name.add("����");
		name.add("���׽��");
		name.add("����ʱ��");
		name.add("������");
		name.add("Ŀ���˺�");
	}
	public MCFindDetail(String account) {
		init();
		this.setLayout(null);
		this.setSize(1280,800);
		//��Ҫ������
		Find find = new Find();
		client=Test.databaseconnection.validateID(account);
		find.setClient(client);
		Test.nowclient=Test.databaseconnection.correspondingOperation(find);
		result=Test.nowclient.getRecord();
		
		reorganize();//��������
		
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MCFindDetail.this.setNextPanel(new MFind2(account));
			}
		});
		button.setFont(new Font("��Բ", Font.BOLD, 25));
		button.setBounds(14, 632, 178, 53);
		add(button);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 194, 800, 491);
		scrollPane.setOpaque(false);
		add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setOpaque(false);
		//table.setFont(new Font("����", Font.BOLD, 30));
		scrollPane.setViewportView(table);
		table.setOpaque(false);//����͸��
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		table.setModel(this.model_3month);
		table.setBackground(null);
		
		table.setDefaultRenderer(Object.class,   new TableCellTextAreaRenderer());
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem( "��������");
		comboBox_1.addItem( "һ����");
		comboBox_1.addItem("������");
		
		comboBox_1.setBounds(216, 109, 178, 35);
		add(comboBox_1);
		
		
		//comboBox.addActionListener();
		//comboBox.setBounds(0, 200, 232, 80);
		
		//model.setDataVector(data, name);
		//name.add
		
	}
	private void reorganize(){
		Date date = new Date();
		String y=year.format(date);//��õ�ǰ���
		String m =month.format(date);//��õ�ǰ�·�
		int n=0;
		try {
			this.result.last();
			n= this.result.getRow();
			this.result.first();
	
		for(int i=1;i<=n;i++){
			Vector<String> v = new Vector<String>();//�༭ĳ��
			v.add(this.result.getString("Operation_type"));
			if(this.result.getString("Operation_type").trim().equals("�޸�����")){
				v.add("");
				v.add(this.result.getString("Trade_time").split(" ")[0]);
				v.add("");
			}else{
				v.add(this.result.getString("Trade_money"));
				v.add(this.result.getString("Trade_time").split(" ")[0]);
				v.add(this.result.getString("Poundage"));
			}
			if(this.result.getString("Operation_type").trim().equals("ת��")){
				v.add(this.result.getString("Target_account").substring(0,4)+"*****"+this.result.getString("Target_account").substring(this.result.getString("Target_account").length()-4,this.result.getString("Target_account").length()));
			}else{
				if(this.result.getString("Operation_type").trim().equals("�յ����")){
					v.add(this.result.getString("Target_account").substring(0,4)+"*****"+this.result.getString("Target_account").substring(this.result.getString("Target_account").length()-4,this.result.getString("Target_account").length()));
				}
				v.add("");
			}
			
			if(Integer.parseInt((this.result.getString("Trade_time").trim().split("/")[0]))==Integer.parseInt(y.trim())){//�ж��Ƿ�Ϊ����
				//�ж��Ƿ���������
				if(Integer.parseInt((this.result.getString("Trade_time").trim().split("/")[1]))>=(Integer.parseInt(m.trim())-3)&&Integer.parseInt((this.result.getString("Trade_time").trim().split("/")[1]))<=Integer.parseInt(m.trim())){
					this.data1.add(v);
					this.data2.add(v);
					this.data3.add(v);
				}else{
					this.data2.add(v);
					this.data3.add(v);
				}
			}else{
				//�ж��Ƿ�������
				if(Integer.parseInt((this.result.getString("Trade_time").trim().split("/")[0]))>=(Integer.parseInt(y.trim())-3)&&Integer.parseInt((this.result.getString("Trade_time").trim().split("/")[0]))<=Integer.parseInt(y.trim())){
					data3.add(v);
				}
			}
			if(i<=n-1) this.result.next();
		}
		this.model_3month.setDataVector(data1, this.name);
		this.model_1year.setDataVector(data2, this.name);
		this.model_3year.setDataVector(data3, this.name);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	private class ComboBoxListener implements ActionListener{

		private JComboBox jb;
		public ComboBoxListener(JComboBox jb){
			this.jb=jb;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(this.jb.getSelectedItem().equals("��������"))  table.setModel(MCFindDetail.this.model_3month);
			if(this.jb.getSelectedItem().equals("һ����"))    table.setModel(MCFindDetail.this.model_1year);
		    if(this.jb.getSelectedItem().equals("������"))    table.setModel(MCFindDetail.this.model_3year);
		    MCFindDetail.this.repaint();
		}
		
	}
	private class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer {
		   public TableCellTextAreaRenderer() {
		       setLineWrap(true);
		       setWrapStyleWord(true);
		   }
		   public Component getTableCellRendererComponent(JTable table, Object value,
		           boolean isSelected, boolean hasFocus, int row, int column) {
		       // ���㵱���е���Ѹ߶�
		       int maxPreferredHeight = 0;
		       for (int i = 0; i < table.getColumnCount(); i++) {
		           setText("" + table.getValueAt(row, i));
		           setSize(table.getColumnModel().getColumn(column).getWidth(), 0);//
		           maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
		       }
		       if (table.getRowHeight(row) != maxPreferredHeight)  // ��������������Ϲæ
		           table.setRowHeight(row, maxPreferredHeight);
		       setText(value == null ? "" : value.toString());
		       return this;
		   }
		}
}

