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
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("��ǰ�ѹ�");
		lblNewLabel_1.setBounds(12, 50, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		pro_num = new JTextField();
		pro_num.setEditable(false);
		pro_num.setEnabled(false);
		pro_num.setHorizontalAlignment(SwingConstants.RIGHT);
		pro_num.setColumns(10);
		pro_num.setBounds(146, 44, 116, 21);
		getContentPane().add(pro_num);
		
		JLabel lblNewLabel_2 = new JLabel("��ǰ��");
		lblNewLabel_2.setBounds(12, 78, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		pro_name = new JTextField();
		pro_name.setEditable(false);
		pro_name.setEnabled(false);
		pro_name.setHorizontalAlignment(SwingConstants.RIGHT);
		pro_name.setColumns(10);
		pro_name.setBounds(146, 75, 116, 21);
		getContentPane().add(pro_name);
		
		JLabel lblNewLabel_7 = new JLabel("��Ż ��� (1�� ����)");
		lblNewLabel_7.setBounds(12, 109, 122, 15);
		getContentPane().add(lblNewLabel_7);
		
		price = new JTextField();
		price.setEditable(false);
		price.setEnabled(false);
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setColumns(10);
		price.setBounds(146, 106, 116, 21);
		getContentPane().add(price);
		
		JLabel lblNewLabel_8 = new JLabel("��");
		lblNewLabel_8.setBounds(275, 109, 41, 15);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("��Ż ������ ����");
		lblNewLabel_9.setBounds(12, 134, 107, 15);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("��Ż ������");
		lblNewLabel_10.setBounds(12, 366, 74, 15);
		getContentPane().add(lblNewLabel_10);
		
		r_start = new JTextField();
		r_start.setHorizontalAlignment(SwingConstants.RIGHT);
		r_start.setColumns(10);
		r_start.setBounds(146, 363, 116, 21);
		getContentPane().add(r_start);
		
		JLabel lblNewLabel_11 = new JLabel("��Ż �Ⱓ(ex 7)");
		lblNewLabel_11.setBounds(12, 397, 122, 15);
		getContentPane().add(lblNewLabel_11);
		
		r_period = new JTextField();
		r_period.setHorizontalAlignment(SwingConstants.RIGHT);
		r_period.setColumns(10);
		r_period.setBounds(146, 394, 116, 21);
		getContentPane().add(r_period);
		
		JLabel lblNewLabel_12 = new JLabel("��");
		lblNewLabel_12.setBounds(275, 397, 41, 15);
		getContentPane().add(lblNewLabel_12);
		////////////////////////////////////////////////////////////////////////////Ȯ�� �̺�Ʈ
		/*
		 * ��Ż �������� �������� ��Ż �Ⱓ�� �Է��� �� ��ư Ŭ�� ��
		 * 1. ��Ż ������ + ��Ż �Ⱓ ��� �� ��Ż ������ ���
		 * 2. ��Ż ��� * ��Ż �Ⱓ ��� �Ͽ� �� ��Ż ��뿡 �� ���
		 */
		JButton btnNewButton_1 = new JButton("Ȯ��");
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
					
					JOptionPane.showMessageDialog(null, "Ȯ�� �Ϸ�");
					System.out.println("Ȯ�� ����!!");
					
				}catch (Exception e1) {
					System.out.println("Ȯ�� ����" + e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////
		
		btnNewButton_1.setBounds(188, 453, 74, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_18 = new JLabel("��Ż ������");
		lblNewLabel_18.setBounds(12, 426, 87, 15);
		getContentPane().add(lblNewLabel_18);
		
		r_end = new JTextField();
		r_end.setHorizontalAlignment(SwingConstants.RIGHT);
		r_end.setBounds(146, 422, 116, 21);
		getContentPane().add(r_end);
		r_end.setColumns(10);
		///////////////////////////////////////////////////////////////////////////���� �̺�Ʈ
		/*
		 * ���� ��ư Ŭ�� �� ��Ż ������, �Ⱓ, ������, �� ��� �ؽ�Ʈ ������
		 */
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutClear();
			}
		});
		btnNewButton_2.setBounds(102, 453, 74, 23);
		getContentPane().add(btnNewButton_2);
		//////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_13 = new JLabel("�� ��Ż ���");
		lblNewLabel_13.setBounds(12, 492, 74, 15);
		getContentPane().add(lblNewLabel_13);
		
		to_price = new JTextField();
		to_price.setHorizontalAlignment(SwingConstants.RIGHT);
		to_price.setColumns(10);
		to_price.setBounds(146, 489, 116, 21);
		getContentPane().add(to_price);
		
		JLabel lblNewLabel_14 = new JLabel("��");
		lblNewLabel_14.setBounds(275, 492, 41, 15);
		getContentPane().add(lblNewLabel_14);
		
		///////////////////////////////////////////////////////////////////////////////////�޷�
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
		
		/////////////////////////////////////////////////////////////////////////��Ż��û �̺�Ʈ
		JButton btnNewButton = new JButton("��Ż ��û");
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
					JOptionPane.showMessageDialog(null, "��Ż ��û �Ϸ�");
					System.out.println("��Ż ����!!");
					
				}catch (Exception e1) {
					System.out.println("��Ʈ ��û ����" + e1.getMessage());
					e1.printStackTrace();
				}		
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////
		
		btnNewButton.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton.setBounds(138, 520, 124, 23);
		getContentPane().add(btnNewButton);

		setTitle("��Ʈ�ϱ�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		
		/////////////////////////////////////////////////////////////////////////������ ���̺� ����
		
		JPanel panel = new JPanel();
		panel.setBounds(344, 63, 828, 465);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		////////////////////////////////////////////////////////////////////////���̺� �÷�
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 804, 538);
		panel.add(scrollPane);
		String[] column = {"NO", "ī�װ�","�󼼺з�","��ǰ��","��Ż�ݾ�"};
		DTModel = new DefaultTableModel(column, 0);
		LTModel = new ListTableModel();
		
		////////////////////////////////////////////////////////////////////////���̺� Ŭ�� �̺�Ʈ
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
		
		////////////////////////////////////////////////////////////////////////ī�װ� �ڽ�
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
						System.out.println("�˻��Ϸ�");
						System.out.println(list);
					}catch (Exception e1) {
						System.out.println("�˻�����"+e1.getMessage());
						e1.getStackTrace();
					}	
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"�����ϼ���","����", "����", "�Ƿ�����ȭ", "������ǰ", "��Ÿ"}));
		panel.add(comboBox);
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel = new JLabel("ī�װ� ����");
		lblNewLabel.setBounds(12, 18, 150, 29);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
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
		String [] columnNames =  {"NO", "ī�װ�","�󼼺з�","��ǰ��","��Ż�ݾ�"};
		//=============================================================
		//1. �⺻���� TabelModel  �����
		//�Ʒ� �� �Լ��� TabelModel �������̽��� �߻��Լ��ε�
		//AbstractTabelModel���� �������� �ʾұ⿡...
		//�ݵ�� ����� ���� �ʼ�!!!!
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
		//2. ������ �÷������� ��ȯ�ϱ�
		//
//				�⺻������ A, B, C, D ��� �̸����� �÷����� �����ȴ�
			 public String getColumnName(int col) { 
		      return columnNames[col]; 
		  } 
		 }
}
