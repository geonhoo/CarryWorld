package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import view.UserManaging.ListTableModel;
import model.ManagerModel;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class RentManaging extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
ManagerModel model;
	
	ListTableModel ListTModel;

	/**
	 * Create the panel.
	 */
	public RentManaging() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = { "렌탈 목록 번호","회원정보 번호","회원 이름","렌탈 시작일", "렌탈 종료일","공유 희망 비용","부피 등급"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		JButton bnb5 = new JButton("\uC870\uD68C");
		bnb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb5) {
					
					try {
						model = new ManagerModel();				
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb5();
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
		bnb5.setBounds(667, 102, 97, 23);
		add(bnb5);

	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = { "렌탈 목록 번호","회원정보 번호","회원 이름","렌탈 시작일", "렌탈 종료일","공유 희망 비용","부피 등급"};

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
