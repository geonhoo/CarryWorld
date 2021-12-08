package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import view.ManagerMain;
import view.UserManaging.ListTableModel;
import model.ManagerModel;
import vo.ManagerVO;

import javax.management.StringValueExp;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class PutProMa extends JPanel {
	private JTable table;
	private ListTableModel LTModel;
	
	ManagerModel model;
	ListTableModel ListTModel;
	private JTextField textField;
	JTable MList;
	

	/**
	 * Create the panel.
	 */
	public PutProMa() {
		
		
		
	setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 752, 418);
		add(scrollPane);
		String[] column = {"입고 신청 목록 번호","회원정보 번호","상품 소분류 번호", "입고 물품명", "입고 신청일","입고 희망일","부피 등급"};
		LTModel = new ListTableModel();
		
		table = new JTable(LTModel);		
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(Color.LIGHT_GRAY);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				MList = new JTable(ListTModel);
				int row = table.getSelectedRow();
				System.out.println(row);
				int col = 0;
				
				int vNum = (Integer)table.getValueAt(row, col);
				System.out.println(vNum);
				
				textField.setText(String.valueOf(vNum));
			}
		});
// 입고 승인	
		JButton btnNewButton = new JButton("\uC2B9\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				ManagerVO vo = new ManagerVO();
				int aaa = Integer.parseInt(textField.getText());
				vo.setCome_list_no(aaa);
				try {
					model.putOnKeep(aaa);
					JOptionPane.showMessageDialog(null, "승인완료"); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			});
		btnNewButton.setBounds(667, 102, 97, 23);
		add(btnNewButton);
// 입고 반려		
		JButton refuse = new JButton("\uBC18\uB824");
		refuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if (o == refuse) {
					
				if(textField.getText().length()>0) {
					ManagerVO vo = new ManagerVO();
					vo.setCome_list_no(Integer.valueOf(textField.getText()));
					
				try {
					model.refuse(vo);
					
				} catch (Exception e) {
					// TODO: handle exception
				}	
				}
				
//				int num = Integer.parseInt(textField.getText());
				
//				try { 
//					model = new ManagerModel();	
//					model.refuse(num);
//					System.out.println("반려 완료");
//					
//					ArrayList list = model.bnb2();	
//					ListTModel.data = list;
//					ListTModel.fireTableDataChanged();
//				 
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
			}
			}
		});
		refuse.setBounds(667, 24, 97, 23);
		add(refuse);
		
		JButton bnb2 = new JButton("\uC870\uD68C");
		bnb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
	if ( o == bnb2) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb2();
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
		bnb2.setBounds(558, 102, 97, 23);
		add(bnb2);
		
		JLabel lblNewLabel = new JLabel("\uC785\uACE0 \uC2E0\uCCAD \uBAA9\uB85D \uBC88\uD638");
		lblNewLabel.setBounds(419, 28, 120, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(551, 25, 104, 21);
		add(textField);
		textField.setColumns(10);

		// 마우스클릭 이벤트
//MList = new JTable(ListTModel);
//		
//		MList.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int row = MList.getSelectedRow();
//				int col = 0;
//				
//				String vNum = String.valueOf(MList.getValueAt(row, col));
//				System.out.println(vNum);
//				
//				textField.setText(vNum);
//			}
//		});

		
	}
//	void selectTable() {
//		
//		try {
//		ArrayList list = model.bnb2();
//		ListTModel.data = list;
//		ListTModel.fireTableDataChanged();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"입고 신청 목록 번호","회원정보 번호","상품 소분류 번호", "입고 물품명", "입고 신청일","입고 희망일","부피 등급"};

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
