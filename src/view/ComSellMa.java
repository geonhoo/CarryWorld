package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.ManagerModel;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ComSellMa extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
	ManagerModel model;
	
	ListTableModel ListTModel;

	/**
	 * Create the panel.
	 */
	public ComSellMa() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = { "사내 판매 목록 번호","판매일","구입 금액","회원 정보 번호","부피 등급"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		JButton btnCom = new JButton("\uC870\uD68C");
		btnCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if(o == btnCom)
				try {
					model = new ManagerModel();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
		
				try {
					ArrayList list = model.pro_sal();
					ListTModel.data=list;
					table.setModel(ListTModel);		
					ListTModel.fireTableDataChanged();
					System.out.println(list);
				}catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "물품 내역 가져오기 실패" + e3.getMessage());
					e3.printStackTrace();
				}
				
			}
		});
		btnCom.setBounds(667, 102, 97, 23);
		add(btnCom);

	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = { "사내 판매 목록 번호","판매일","구입 금액","회원 정보 번호","부피 등급"};

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
