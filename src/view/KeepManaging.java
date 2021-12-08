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



public class KeepManaging extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
	ManagerModel model;
	
	ListTableModel ListTModel;

	/**
	 * Create the panel.
	 */
	public KeepManaging() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = {"보관 물품 목록 번호","회원정보 번호","회원 이름","상품 소분류 번호", "보관 시작일","보관 종료일","부피 등급"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		JButton bnb3 = new JButton("\uC870\uD68C");
		bnb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb3) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb3();
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
		bnb3.setBounds(667, 103, 97, 23);
		add(bnb3);

	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"보관 물품 목록 번호","회원정보 번호","회원 이름","상품 소분류 번호", "보관 시작일","보관 종료일","부피 등급"};

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
