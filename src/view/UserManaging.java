package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.ManagerModel;
import vo.ManagerVO;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class UserManaging extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
	ManagerModel model;
	
	ListTableModel ListTModel;
	

	/**
	 * Create the panel.
	 */
	public UserManaging() {

		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = {"회원 정보 번호","이름","주민번호", "핸드폰번호", "주소","이메일","아이디","비밀번호","은행 명","예금주","계좌번호"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		JButton bnb = new JButton("\uC870\uD68C");
		bnb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb();
						ListTModel.data = list;
						table.setModel(ListTModel);
						ListTModel.fireTableDataChanged();
						System.out.println(list);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "회원정보 불러오기 실패" + e1.getMessage());
						// TODO: handle exception
					}
				}
			}
		});
		bnb.setBounds(664, 102, 97, 23);
		add(bnb);
	}
	
//	void selectTable() {
//		try {
//			ArrayList list = model.bnb();
//			ListTModel.data = list;
//			ListTModel.fireTableDataChanged();
//			
//		}catch (Exception e) {
//			
//			// TODO: handle exception
//		}
//	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"회원 정보 번호","이름","주민번호", "핸드폰번호", "주소","이메일","아이디","비밀번호","은행 명","예금주","계좌번호"};

		    public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }

			 public String getColumnName(int col) { 
		        return columnNames[col]; 
		    } 
		}
}
