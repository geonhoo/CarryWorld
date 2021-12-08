package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.MemberInfoDAO;
import vo.MemberInfoVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class MemberInfoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel DTModel;
	   
	   
	public JTextField tfid;
	public JTextField tfpass;
	public JTextField tfname;
	public JTextField tfphone;
	public JTextField tfaddr;
	public JTextField tfemail;
	public JTextField tfacc_name;
	public JTextField tfacc_num;
	public ShareTableModel LTModel;
	
	public JTextField	tfshare,tfkeep,tfusersaleapp;
	
	MemberInfoDAO model;
	JTable		tableCategory;
	JTextField comboBox;
	JComboBox comboBox_1, comboBox_2;
	
	public String accname;
	
	public MemberInfoView() {

	}
	public MemberInfoView(String name) {	
		this.accname = name;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1011, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52,117,171));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 99, 551, 475);
		contentPane.add(scrollPane);
		
		String[] column = {"", "", "",""};
	      DTModel = new DefaultTableModel(column, 0);
	      LTModel = new ShareTableModel();
	      ShareTableModel HTModel = new ShareTableModel();
	      KeepTableModel KTModel = new KeepTableModel();
	      SaleTableModel STModel = new SaleTableModel();
	      
	      table = new JTable(new DefaultTableModel(
	      	new Object[][] {
	      	},
	      	new String[] {
	      		"", "", "", ""
	      	}
	      ));
	      table = new JTable(LTModel);
	      table.setBorder(new LineBorder(Color.BLACK));
	      table.setBackground(Color.LIGHT_GRAY);
	      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	      scrollPane.setViewportView(table);
	      
		JComboBox comboBox =    new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aa = (String) comboBox.getSelectedItem();				
				
				if( aa == "공유 신청한 물건") {
					DTModel.setColumnIdentifiers(new String[] {"공유 신청 코드", "공유 신청일", "배송 희망일","카테고리 이름"});
				}else if ( aa == "보관된 물건") {
					DTModel.setColumnIdentifiers(new String[] {"상품 보관 코드", "보관 시작일", "보관 종료일","카테고리 이름"});
				}else {
					DTModel.setColumnIdentifiers(new String[] {"판매 신청 코드", "판매 신청일", "가격","카테고리 이름"});
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uACF5\uC720 \uC2E0\uCCAD\uD55C \uBB3C\uAC74", "\uBCF4\uAD00\uB41C \uBB3C\uAC74", "\uD310\uB9E4 \uC2E0\uCCAD\uD55C \uBB3C\uAC74"}));
		comboBox.setBounds(504, 48, 139, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC", "\uC2E0\uD55C", "\uB18D\uD611", "\uC678\uD55C", "\uD558\uB098"}));
		comboBox_2.setBounds(117, 312, 225, 23);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String bb = (String) comboBox_1.getSelectedItem();
				String aa = (String) comboBox.getSelectedItem();	
	// 공유 신청 테이블 만들기				
				if ( aa.equals("공유 신청한 물건")) {
					
					try {
						model = new MemberInfoDAO();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String sel = (String)comboBox_1.getSelectedItem();
					String text = tfid.getText();

					try {
						ArrayList list = model.selectCategory(sel,text);
						HTModel.data = list;
						table.setModel(HTModel);		
						HTModel.fireTableDataChanged();
					}catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "물품 내역 가져오기 실패" + e3.getMessage());
					}
			//		보관된 물품 테이블 만들기			
				}else if (aa.equals("보관된 물건")) {
					
					try {
						model = new MemberInfoDAO();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String sel = (String)comboBox_1.getSelectedItem();
					String text = tfid.getText();
					try {
						ArrayList list = model.selectCategory1(sel,text);
						KTModel.data = list;
						table.setModel(KTModel);		
						KTModel.fireTableDataChanged();
					}catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "물품 내역 가져오기 실패" + e3.getMessage());
					}
//					판매 신청한 물품 테이블 만들기			
				}else if (aa.equals("판매 신청한 물건")) { 
					
					try {
						model = new MemberInfoDAO();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String sel = (String)comboBox_1.getSelectedItem();
					String text = tfid.getText();
					try {					
						ArrayList list = model.selectCategory2(sel,text);
						STModel.data = list;
						table.setModel(STModel);	
						STModel.fireTableDataChanged();
					}catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "물품 내역 가져오기 실패" + e3.getMessage());
					}
				}						
			}			
		});
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uAC00\uC804", "\uAC00\uAD6C", "\uC758\uB958 \uBC0F \uC7A1\uD654", "\uC804\uC790", "\uAE30\uD0C0"}));
		comboBox_1.setBounds(683, 48, 116, 23);
		contentPane.add(comboBox_1);
// 회원정보 수정 메소드		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(52,117,171));
		btnNewButton.setForeground(new Color(0,0,0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				try {
					model = new MemberInfoDAO();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if ( o == btnNewButton) {
					String id = tfid.getText();
					String pass = tfpass.getText();
					String name = tfname.getText();
					String phone = tfphone.getText();
					String addr = tfaddr.getText();
					String email = tfemail.getText();
					String bank = (String)(comboBox_2.getSelectedItem());
					String accname = tfacc_name.getText();
					String accnum = tfacc_num.getText();
					
					MemberInfoVO vo = new MemberInfoVO();
					vo.setId(id);
					vo.setPass(pass);
					vo.setName(name);
					vo.setPhone(phone);
					vo.setAddr(addr);
					vo.setEmail(email);
					vo.setBank(bank);
					vo.setAccname(accname);
					vo.setAccnum(accnum);
					try {
						model.btnNewButton(vo);
						System.out.println("수정완료 !");
					}catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "정보 수정 실패" + e.getMessage());
					}	 
				}
			}
		});
		btnNewButton.setBounds(33, 493, 116, 44);
		contentPane.add(btnNewButton);
		
		
// 회원정보 삭제 메소드	
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnNewButton_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(52,117,171));
		btnNewButton_1.setForeground(new Color(0,0,0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			
				Object o = ev.getSource();
				if ( o == btnNewButton_1 ) {
					
					String id = tfid.getText();
					
					MemberInfoVO vo = new MemberInfoVO();			
					vo.setId(id);
			
					try {
						model = new MemberInfoDAO();
						int result = JOptionPane.showConfirmDialog(btnNewButton_1,"정말 삭제하시겠습니까?","Are you sure?",JOptionPane.YES_NO_OPTION);		
						//	사용자가 예를 선택한경우	리턴값 0
						if(result == JOptionPane.YES_OPTION) {
							model.btnNewButton_1(vo);
							layOutClear();
							// 사용자가 아니오를 선택한경우	 리턴값 1
						}else if (result == JOptionPane.NO_OPTION) {
							// 사용자가 x로 창을 닫은경우 리턴값 -1
						}else {
							
						}
					}catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "삭제 실패" + e.getMessage());
					}	
				}
			}
		});
		btnNewButton_1.setBounds(218, 493, 124, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(218,165,32));
		lblNewLabel.setBounds(33, 51, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(218,165,32));
		lblNewLabel_1.setBounds(33, 99, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(218,165,32));
		lblNewLabel_2.setBounds(33, 142, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(218,165,32));
		lblNewLabel_3.setBounds(33, 186, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(new Color(218,165,32));
		lblNewLabel_4.setBounds(33, 227, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(new Color(218,165,32));
		lblNewLabel_5.setBounds(33, 270, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC740\uD589\uBA85");
		lblNewLabel_6.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(218,165,32));
		lblNewLabel_6.setBounds(33, 315, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC608\uAE08\uC8FC");
		lblNewLabel_7.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(new Color(218,165,32));
		lblNewLabel_7.setBounds(33, 358, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("\uACC4\uC88C \uBC88\uD638");
		lblNewLabel_7_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		lblNewLabel_7_1.setForeground(new Color(218,165,32));
		lblNewLabel_7_1.setBounds(33, 403, 74, 15);
		contentPane.add(lblNewLabel_7_1);
		
		tfid = new JTextField();
		tfid.setBounds(117, 48, 225, 21);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		tfpass = new JTextField();
		tfpass.setColumns(10);
		tfpass.setBounds(117, 97, 225, 21);
		contentPane.add(tfpass);
		
		tfname = new JTextField();
		tfname.setColumns(10);
		tfname.setBounds(117, 140, 225, 21);
		contentPane.add(tfname);
		
		tfphone = new JTextField();
		tfphone.setColumns(10);
		tfphone.setBounds(117, 184, 225, 21);
		contentPane.add(tfphone);
		
		tfaddr = new JTextField();
		tfaddr.setColumns(10);
		tfaddr.setBounds(117, 225, 225, 21);
		contentPane.add(tfaddr);
		
		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(117, 268, 225, 21);
		contentPane.add(tfemail);
		
		tfacc_name = new JTextField();
		tfacc_name.setColumns(10);
		tfacc_name.setBounds(117, 356, 225, 21);
		contentPane.add(tfacc_name);
		
		tfacc_num = new JTextField();
		tfacc_num.setColumns(10);
		tfacc_num.setBounds(117, 401, 225, 21);
		contentPane.add(tfacc_num);
		
		JLabel lblNewLabel_8 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4");
		lblNewLabel_8.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_8.setForeground(new Color(218,165,32));
		lblNewLabel_8.setBounds(159, 10, 79, 28);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("\uC0C1\uD488 \uC815\uBCF4 \uAC80\uC0C9");
		lblNewLabel_8_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_8_1.setForeground(new Color(218,165,32));
		lblNewLabel_8_1.setBounds(515, 13, 116, 28);
		contentPane.add(lblNewLabel_8_1);	

		comboBox_2.setSelectedItem(accname);	
		
// 		
	}
	public void layOutClear() {
		tfid.setText("");
		tfpass.setText("");
		tfname.setText("");
		tfphone.setText("");
		tfaddr.setText("");
		tfemail.setText("");
		tfacc_name.setText("");
		tfacc_num.setText("");
	}
	// 공유물품
		void selectTable() {
			comboBox_1 = new JComboBox();																	
		}
	//보관 물품	
		void selectTable1() {
			comboBox_1 = new JComboBox();														
		}
	// 구매 물품 
		void selectTable2() {
			comboBox_1 = new JComboBox();														
		}
	}
	// 물품 목록 보여주는 리스트 		
	class ShareTableModel extends AbstractTableModel {
		
		ArrayList data = new ArrayList();
		String [] columnNames = {"공유 신청 코드", "공유 신청일", "공유 희망 금액","카테고리 이름"};

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

	class KeepTableModel extends AbstractTableModel {
		
		ArrayList data = new ArrayList();
		String [] columnNames = {"상품 보관 코드", "보관 시작일", "보관 종료일","카테고리 이름"};

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

	class SaleTableModel extends AbstractTableModel {
		
		ArrayList data = new ArrayList();
		String [] columnNames = {"판매 신청 코드", "판매 신청일", "가격","카테고리 이름"};

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