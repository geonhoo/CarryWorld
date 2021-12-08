package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.LoginDAO;
import model.PerchaseDAO;
import vo.PerchaseVO;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PerchaseView extends JFrame {

	private JPanel contentPane;
	private JTable sellTable;
	private DefaultTableModel DTModel;
	private JTextField tfSearch;
	private JTextField tfProCode;
	private JTextField tfProPrice;
	PerchaseDAO model = null;
	private ListTableModel LTModel;

	public PerchaseView() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 922, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel.setBackground(new Color(52,117,171));
		panel.setBounds(0, 0, 452, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488 \uCF54\uB4DC");
		lblNewLabel_1.setFont(new Font("HY������M", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(218,165,32));
		lblNewLabel_1.setBounds(43, 56, 88, 33);
		panel.add(lblNewLabel_1);
		
		tfProCode = new JTextField();
		tfProCode.setEditable(false);
		tfProCode.setFont(new Font("����", Font.PLAIN, 15));
		tfProCode.setBounds(158, 57, 232, 33);
		panel.add(tfProCode);
		tfProCode.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC0C1\uD488 \uAE08\uC561");
		lblNewLabel_1_1.setFont(new Font("HY������M", Font.PLAIN, 20));
		lblNewLabel_1_1.setForeground(new Color(218,165,32));
		lblNewLabel_1_1.setBounds(43, 114, 88, 33);
		panel.add(lblNewLabel_1_1);
		
		tfProPrice = new JTextField();
		tfProPrice.setEditable(false);
		tfProPrice.setFont(new Font("����", Font.PLAIN, 15));
		tfProPrice.setColumns(10);
		tfProPrice.setBounds(158, 114, 232, 33);
		panel.add(tfProPrice);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC0C1\uC138 \uC815\uBCF4");
		lblNewLabel_1_1_1.setFont(new Font("HY������M", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setForeground(new Color(218,165,32));
		lblNewLabel_1_1_1.setBounds(43, 177, 88, 33);
		panel.add(lblNewLabel_1_1_1);
		
		JTextArea taProInfo = new JTextArea();
		taProInfo.setEditable(false);
		taProInfo.setLineWrap(true);
		taProInfo.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		taProInfo.setBounds(43, 223, 364, 221);
		panel.add(taProInfo);
		
		JButton btnPerchase = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btnPerchase.setFont(new Font("HY������M", Font.PLAIN, 20));
		btnPerchase.setForeground(new Color(0,0,0));
		btnPerchase.setBackground(new Color(218,165,32));
		btnPerchase.setBounds(146, 460, 160, 61);
		panel.add(btnPerchase);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		panel_1.setBackground(new Color(52,117,171));
		panel_1.setBounds(451, 0, 455, 151);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbSubCategory = new JComboBox();
		cbSubCategory.setFont(new Font("HY������M", Font.PLAIN, 14));
		cbSubCategory.setBounds(244, 28, 129, 21);
		panel_1.add(cbSubCategory);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setFont(new Font("HY������M", Font.PLAIN, 14));
		cbCategory.setBounds(81, 29, 129, 21);
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"����", "����", "�Ƿ�����ȭ", "������ǰ", "��Ÿ"}));
		panel_1.add(cbCategory);
		cbCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cate = (String) cbCategory.getSelectedItem();
				if (cate.equals("����")) {
					cbSubCategory.setModel(new DefaultComboBoxModel(new String[] {"�����", "��Ź��", "tv", "��ġ�����", "������","������","������","û�ұ�","��Ÿ�Ϸ�","������","�õ���","��Ÿ"}));
				}else if (cate.equals("����")) {
					cbSubCategory.setModel(new DefaultComboBoxModel(new String[] {"����", "ħ��", "��Ź", "����", "å��","����","������","����","�ſ�","����","���̺�","��Ÿ"}));
				}else if (cate.equals("�Ƿ�����ȭ")) {
					cbSubCategory.setModel(new DefaultComboBoxModel(new String[] {"�Ƿ�", "�Ź�", "����", "���", "�Ǽ��縮","���ι�ǰ","��Ÿ"}));
				}else if (cate.equals("������ǰ")) {
					cbSubCategory.setModel(new DefaultComboBoxModel(new String[] {"��ǻ��", "��Ʈ��", "��������Ŀ", "�ý�", "�����ڽ�","���ٵ�","�ڵ���","����Ʈ��ġ","�º�","���ڻ���","��Ÿ"}));
				}else {
					cbSubCategory.setModel(new DefaultComboBoxModel(new String[] {"��Ÿ"}));
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC5B4");
		lblNewLabel.setFont(new Font("HY������M", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(184, 134, 11));
		lblNewLabel.setBounds(90, 79, 66, 21);
		panel_1.add(lblNewLabel);
		
		tfSearch = new JTextField();		
		tfSearch.setBounds(168, 74, 205, 27);
		panel_1.add(tfSearch);
		tfSearch.setColumns(10);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new LineBorder(Color.black,1)));
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(450, 149, 456, 394);
		contentPane.add(scrollPane);
		String[] column = {"��ǰ �ڵ�", "��ǰ �ݾ�", "�� ����"};
		DTModel = new DefaultTableModel(column, 0);
		LTModel = new ListTableModel();
		
		sellTable = new JTable(LTModel);
		sellTable.setBorder(new LineBorder(Color.BLACK));
		sellTable.setBackground(Color.LIGHT_GRAY);
		sellTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(sellTable);
		
		tfSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cate = (String) cbCategory.getSelectedItem();
				String sub = (String) cbSubCategory.getSelectedItem();
				String search = tfSearch.getText();
				ArrayList list = new ArrayList();
				try {
					model = new PerchaseDAO();
					list = model.recentList(cate, search, sub);
					LTModel.data = list;
					sellTable.setModel(LTModel);
					LTModel.fireTableDataChanged();
				}catch (Exception e1) {
					// TODO: handle exception
					System.out.println("�˻�����"+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		sellTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = sellTable.getSelectedRow();
				int pro_sale_no = (Integer)sellTable.getValueAt(row, col);
				try {
					PerchaseVO vo = model.searchClick(pro_sale_no);
					tfProCode.setText(Integer.toString(vo.getProCode()));
					tfProPrice.setText(Integer.toString(vo.getProPrice()));
					taProInfo.setText(vo.getProInfo());
				}catch (Exception e1) {
					// TODO: handle exception
					System.out.println("�˻���� �󼼺��� ����"+e1.getMessage());
				}
			}
		});
	}
	class ListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"��ǰ �ڵ�", "��ǰ �ݾ�", "�� ����"};

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