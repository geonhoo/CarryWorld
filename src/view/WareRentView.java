package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

//import OutView.ListTableModel;
import model.WareRentModel;
import vo.WareRentVO;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WareRentView extends JFrame {
	public JTextField pro_num, pro_name, price,
	r_start, r_period, r_end, to_price, hideUserNo;

	WareRentModel model;
	private JTable shareTable;

	private DefaultTableModel DTModel;

	private ListTableModel LTModel;

	private JPanel contentPane;
	private JTable table;


	public WareRentView() {

		setBackground(new Color(51, 102, 255));
		getContentPane().setBackground(new Color(102, 204, 255));
		getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("물품넘버");
		lblNewLabel_1.setBounds(12, 50, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		pro_num = new JTextField();
		pro_num.setEditable(false);
		pro_num.setEnabled(false);
		pro_num.setHorizontalAlignment(SwingConstants.RIGHT);
		pro_num.setColumns(10);
		pro_num.setBounds(146, 44, 116, 21);
		getContentPane().add(pro_num);
		
		JLabel lblNewLabel_2 = new JLabel("물품명");
		lblNewLabel_2.setBounds(12, 78, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		pro_name = new JTextField();
		pro_name.setEditable(false);
		pro_name.setEnabled(false);
		pro_name.setHorizontalAlignment(SwingConstants.RIGHT);
		pro_name.setColumns(10);
		pro_name.setBounds(146, 75, 116, 21);
		getContentPane().add(pro_name);
		
		JLabel lblNewLabel_7 = new JLabel("렌탈 비용 (1일 기준)");
		lblNewLabel_7.setBounds(12, 109, 122, 15);
		getContentPane().add(lblNewLabel_7);
		
		price = new JTextField();
		price.setEditable(false);
		price.setEnabled(false);
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setColumns(10);
		price.setBounds(146, 106, 116, 21);
		getContentPane().add(price);
		
		JLabel lblNewLabel_8 = new JLabel("원");
		lblNewLabel_8.setBounds(275, 109, 41, 15);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("렌탈 시작일 선택");
		lblNewLabel_9.setBounds(12, 134, 107, 15);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("렌탈 시작일");
		lblNewLabel_10.setBounds(12, 366, 74, 15);
		getContentPane().add(lblNewLabel_10);
		
		r_start = new JTextField();
		r_start.setHorizontalAlignment(SwingConstants.RIGHT);
		r_start.setColumns(10);
		r_start.setBounds(146, 363, 116, 21);
		getContentPane().add(r_start);
		
		JLabel lblNewLabel_11 = new JLabel("렌탈 기간(ex 7)");
		lblNewLabel_11.setBounds(12, 397, 122, 15);
		getContentPane().add(lblNewLabel_11);
		
		r_period = new JTextField();
		r_period.setHorizontalAlignment(SwingConstants.RIGHT);
		r_period.setColumns(10);
		r_period.setBounds(146, 394, 116, 21);
		getContentPane().add(r_period);
		
		JLabel lblNewLabel_12 = new JLabel("일");
		lblNewLabel_12.setBounds(275, 397, 41, 15);
		getContentPane().add(lblNewLabel_12);
		////////////////////////////////////////////////////////////////////////////확정 이벤트
		/*
		 * 렌탈 시작일이 정해지고 렌탈 기간을 입력한 후 버튼 클릭 시
		 * 1. 렌탈 시작일 + 렌탈 기간 계산 후 렌탈 종료일 출력
		 * 2. 렌탈 비용 * 렌탈 기간 계산 하여 총 렌탈 비용에 값 출력
		 */
		JButton btnNewButton_1 = new JButton("확정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object o = e.getSource();
				
				String start = r_start.getText();
				int period = Integer.parseInt(r_period.getText());
				int r_price = Integer.parseInt(price.getText());
				
				WareRentVO vo = new WareRentVO(start, period);
				WareRentVO vo2 = new WareRentVO(start, period, r_price);
				
				try {
					model = new WareRentModel();
					
					System.out.println(start);
					System.out.println(period);
					
					r_end.setText(model.fixEday(vo));
					to_price.setText(Integer.toString(model.fixPrice(vo2)));
					
					System.out.println(model.fixPrice(vo2));
					
					JOptionPane.showMessageDialog(null, "확정 완료");
					System.out.println("확정 성공!!");
					
				}catch (Exception e1) {
					System.out.println("확정 실패" + e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////
		
		btnNewButton_1.setBounds(188, 453, 74, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_18 = new JLabel("렌탈 종료일");
		lblNewLabel_18.setBounds(12, 426, 87, 15);
		getContentPane().add(lblNewLabel_18);
		
		r_end = new JTextField();
		r_end.setHorizontalAlignment(SwingConstants.RIGHT);
		r_end.setBounds(146, 422, 116, 21);
		getContentPane().add(r_end);
		r_end.setColumns(10);
		///////////////////////////////////////////////////////////////////////////수정 이벤트
		/*
		 * 수정 버튼 클릭 시 렌탈 시작일, 기간, 종료일, 총 비용 텍스트 지워짐
		 */
		JButton btnNewButton_2 = new JButton("수정");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutClear();
			}
		});
		btnNewButton_2.setBounds(102, 453, 74, 23);
		getContentPane().add(btnNewButton_2);
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_13 = new JLabel("총 렌탈 비용");
		lblNewLabel_13.setBounds(12, 492, 74, 15);
		getContentPane().add(lblNewLabel_13);
		
		to_price = new JTextField();
		to_price.setHorizontalAlignment(SwingConstants.RIGHT);
		to_price.setColumns(10);
		to_price.setBounds(146, 489, 116, 21);
		getContentPane().add(to_price);
		
		JLabel lblNewLabel_14 = new JLabel("원");
		lblNewLabel_14.setBounds(275, 492, 41, 15);
		getContentPane().add(lblNewLabel_14);
		
		///////////////////////////////////////////////////////////////////////////////////달력
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
	         @Override
	         public void propertyChange(PropertyChangeEvent evt) {
	            SimpleDateFormat sdf = new SimpleDateFormat("YY/MM/dd");	            
	            r_start.setText(sdf.format(calendar.getDate()));
	         }
	      });
		calendar.setBounds(6, 165, 256, 188);
		getContentPane().add(calendar);
		
		/////////////////////////////////////////////////////////////////////////렌탈신청 이벤트
		JButton btnNewButton = new JButton("렌탈 신청");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				
				int share = Integer.parseInt(pro_num.getText());
				String start = r_start.getText();
				String end = r_end.getText();
				int period = Integer.parseInt(r_period.getText());
				
				WareRentVO vo = new WareRentVO(share, start, end, period);
				
				try {
					model = new WareRentModel();
					
					model.rentApplication(vo);
					JOptionPane.showMessageDialog(null, "렌탈 신청 완료");
					System.out.println("렌탈 성공!!");
					
				}catch (Exception e1) {
					System.out.println("렌트 신청 실패" + e1.getMessage());
					e1.printStackTrace();
				}		
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////
		
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 14));
		btnNewButton.setBounds(138, 520, 124, 23);
		getContentPane().add(btnNewButton);

		setTitle("렌트하기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		
		/////////////////////////////////////////////////////////////////////////오른쪽 테이블 시작
		
		JPanel panel = new JPanel();
		panel.setBounds(344, 63, 828, 465);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		////////////////////////////////////////////////////////////////////////테이블 컬럼
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 804, 538);
		panel.add(scrollPane);
		String[] column = {"NO", "카테고리","상세분류","물품명","렌탈금액"};
		DTModel = new DefaultTableModel(column, 0);
		LTModel = new ListTableModel();
		
		////////////////////////////////////////////////////////////////////////테이블 클릭 이벤트
		table = new JTable(LTModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int col =0;
				int col2 =3;
				int col3 = 4;
				
				int row = table.getSelectedRow();
				
				int shareNo = (int) table.getValueAt(row, col);
				String proName = (String) table.getValueAt(row, col2);
				int rentalPrice = (int)table.getValueAt(row, col3);
				
				try {
					WareRentVO vo = new WareRentVO();
					
					vo.setPro_num(shareNo);
					vo.setPro_name(proName);
					vo.setPrice(rentalPrice);
					
					pro_num.setText(Integer.toString(shareNo));
					pro_name.setText(proName);
					price.setText(Integer.toString(rentalPrice));
					
				}catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});
		
		table.setBounds(12, 99, 804, 356);
//		panel.add(table);
		scrollPane.setViewportView(table);
		
		////////////////////////////////////////////////////////////////////////카테고리 박스
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(174, 24, 225, 23);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = new ArrayList();
				String a = (String) comboBox.getSelectedItem();
				
					try {
						model = new WareRentModel();
						list = model.sharetList(a);
						LTModel.data=list;
						table.setModel(LTModel);
						LTModel.fireTableDataChanged();
						System.out.println(a);
						System.out.println("검색완료");
						System.out.println(list);
					}catch (Exception e1) {
						System.out.println("검색실패"+e1.getMessage());
						e1.getStackTrace();
					}	
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택하세요","가전", "가구", "의류및잡화", "전자제품", "기타"}));
		panel.add(comboBox);
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel = new JLabel("카테고리 선택");
		lblNewLabel.setBounds(12, 18, 150, 29);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		hideUserNo = new JTextField();
		
	}

	public void layoutClear() {
		r_start.setText("");
		r_period.setText("");
		r_end.setText("");
		to_price.setText("");
	}
	
	class ListTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames =  {"NO", "카테고리","상세분류","물품명","렌탈금액"};
		//=============================================================
		//1. 기본적인 TabelModel  만들기
		//아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		//AbstractTabelModel에서 구현되지 않았기에...
		//반드시 사용자 구현 필수!!!!
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
		//===============================================================
		//2. 지정된 컬럼명으로 변환하기
		//
//				기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
			 public String getColumnName(int col) { 
		      return columnNames[col]; 
		  } 
		 }
}
