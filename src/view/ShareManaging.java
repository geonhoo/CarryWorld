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



public class ShareManaging extends JPanel {
	private JTable table;
	private ListTableModel LTModel;

	ManagerModel model;
	
	ListTableModel ListTModel;
	private JTextField textField;
	JTable MList;
	

	/**
	 * Create the panel.
	 */
	public ShareManaging() {

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 752, 418);
		add(scrollPane);
		String[] column = { "공유 신청 목록 번호","회원정보 번호","회원 이름","공유 신청일","공유 희망 비용", "공유 가능 여부","부피 등급"};
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
		setLayout(null);

		
		JButton share = new JButton("\uC2B9\uC778");
		share.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if ( o == share) {
				int num = Integer.parseInt(textField.getText());
				
				try {
					model.share_bool(num);
				}catch (Exception ev) {
					
					// TODO: handle exception
				}
				}
			}
		});
		share.setBounds(669, 109, 97, 23);
		add(share);
		
		JButton btnNewButton_1 = new JButton("\uBC18\uB824");
		btnNewButton_1.setBounds(667, 39, 97, 23);
		add(btnNewButton_1);
		
		JButton bnb6 = new JButton("\uC870\uD68C");
		bnb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				ListTableModel ListTModel = new ListTableModel();
				if ( o == bnb6) {
					
					try {
						model = new ManagerModel();
					
					}catch (Exception e) {
						e.printStackTrace();
					}try {
						ArrayList list = model.bnb6();
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
		bnb6.setBounds(560, 109, 97, 23);
		add(bnb6);
		
		textField = new JTextField();
		textField.setBounds(539, 40, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uACF5\uC720 \uBC88\uD638 \uC870\uD68C");
		lblNewLabel.setBounds(432, 43, 95, 15);
		add(lblNewLabel);

	}
	
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = { "공유 신청 목록 번호","회원정보 번호","회원 이름","공유 신청일","공유 희망 비용", "공유 가능 여부","부피 등급"};

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
