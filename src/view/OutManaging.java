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
import vo.ManagerVO;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class OutManaging extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
	ManagerModel model;
	ListTableModel ListTModel;
	private JTextField textField;
	JTable MList;
	

	/**
	 * Create the panel.
	 */
	public OutManaging() {
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 417);
		add(scrollPane);
		String[] column = { "출고 신청 목록 번호","회원정보 번호","회원 이름","출고 신청일", "배송 희망일","출고 완료일","부피 등급"};
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
		
		JButton outReturn = new JButton("\uC2B9\uC778");
		outReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if ( o == outReturn) {
					if(textField.getText().length()>0) {
						ManagerVO vo = new ManagerVO();
						vo.setOut_list_no(Integer.valueOf(textField.getText()));
						try {
							model.outReturn(vo);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
				
			}
		});
		outReturn.setBounds(667, 43, 97, 23);
		add(outReturn);
		
		JButton bnb4 = new JButton("\uC870\uD68C");
		bnb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb4) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb4();
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
		bnb4.setBounds(667, 102, 97, 23);
		add(bnb4);
		
		textField = new JTextField();
		textField.setBounds(539, 44, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uCD9C\uACE0 \uC2E0\uCCAD \uBAA9\uB85D \uBC88\uD638");
		lblNewLabel.setBounds(411, 47, 116, 15);
		add(lblNewLabel);

	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = { "출고 신청 목록 번호","회원정보 번호","회원 이름","출고 신청일", "배송 희망일","출고 완료일","부피 등급"};

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
