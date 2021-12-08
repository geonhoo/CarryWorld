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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class UserSellMa extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	ManagerModel model;
	
	ListTableModel ListTModel;
	private JTextField textField;
	JTable MList;

	/**
	 * Create the panel.
	 */
	public UserSellMa() {
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = { "고객 판매 신청 목록 번호","회원정보 번호","회원 이름","판매 신청일","판매 희망 비용","판매 승인 여부","부피 등급"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				System.out.println(row);
				int col = 0;
				
				int vNum = (Integer)table.getValueAt(row, col);
				System.out.println(vNum);
				
				textField.setText(String.valueOf(vNum));
			}
		});
		
		JButton button = new JButton("\uC2B9\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(667, 102, 97, 23);
		add(button);
// 고객 판매 승인 		
		JButton userout = new JButton("\uBC18\uB824");
		userout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if ( o == userout ) {
					int num = Integer.parseInt(textField.getText());
					
					try {
						model.sale_bool(num);
					}catch (Exception e1) {
						
						// TODO: handle exception
					}
					
					
				}
				
			}
		});
		userout.setBounds(667, 26, 97, 23);
		add(userout);
		
		JButton bnb7 = new JButton("\uC870\uD68C");
		bnb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb7) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb7();
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
		bnb7.setBounds(556, 102, 97, 23);
		add(bnb7);
		
		textField = new JTextField();
		textField.setBounds(539, 27, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uACE0\uAC1D \uD310\uB9E4 \uC2E0\uCCAD \uBC88\uD638");
		lblNewLabel.setBounds(411, 30, 116, 15);
		add(lblNewLabel);

	}
	
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = { "고객 판매 신청 목록 번호","회원정보 번호","회원 이름","판매 신청일","판매 희망 비용","판매 승인 여부","부피 등급"};

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
