package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import model.OutDAO;
import vo.OutVO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Choice;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseWheelListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.MouseWheelEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class OutView extends JFrame{

	private JPanel contentPane;
	private JTextField tfOutNum;
	private JTextField tfHopeD;
	private JTextField tfShareHopeP;
	private JTextField tfsaleHopeP;
	private JTextField tfshareHopeRentDate;
	private ListTableModel LTModel;
	private DefaultTableModel DTModel;
	private JTable sellTable;
	private JScrollPane scrollPane;
	private JButton bOut ,bShareApp, bSaleApp;
	private JTextField tfOutComplDate;
	private OutDAO model;
	public JTextField hideId = new JTextField();
/////////////////////////////////////////////////////////////////////////////////////////
	public OutView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1144, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52,117,171));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
/////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel = new JPanel(); panel.setBackground(new Color(52,117,171));
		panel.setBounds(0, 0, 404, 713); contentPane.add(panel);
		panel.setLayout(null);
///////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("\uBCF4\uAD00 \uBB3C\uD488 \uAD00\uB9AC");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(218,165,32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(0, 10, 412, 47);
		panel.add(lblNewLabel);
//////////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_2 = new JLabel("\uBCF4\uAD00 \uBB3C\uD488 \uBC88\uD638");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(218,165,32));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 67, 157, 47);
		panel.add(lblNewLabel_2);
/////////////////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_4 = new JLabel("\uCD9C\uACE0/\uACF5\uC720/\uD310\uB9E4 \uD76C\uB9DD\uC77C");
		lblNewLabel_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(218,165,32));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(10, 112, 157, 47);
		panel.add(lblNewLabel_4);
///////////////////////////////////////////////////////////////////////////////////////////////////	
		JLabel lblNewLabel_5 = new JLabel("\uD310\uB9E4 \uD76C\uB9DD \uAE08\uC561");
		lblNewLabel_5.setForeground(new Color(218,165,32));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 592, 157, 47);
		panel.add(lblNewLabel_5);
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_6 = new JLabel("\uACF5\uC720 \uD76C\uB9DD \uAE08\uC561");
		lblNewLabel_6.setForeground(new Color(218,165,32));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 465, 157, 47);
		panel.add(lblNewLabel_6);
/////////////보관물품 텍스트///////////////////////////////////////////////////////////////////////////////////////////		
		tfOutNum = new JTextField();
		tfOutNum.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOutNum.setEditable(false);
		tfOutNum.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		tfOutNum.setBackground(new Color(255, 255, 255));
		tfOutNum.setBounds(310, 80, 90, 21);
		panel.add(tfOutNum);
		tfOutNum.setColumns(10);
///////////희망일지정/////////////////////////////////////////////////////////////////////////////////////////////	
		tfHopeD = new JTextField();
		tfHopeD.setEditable(false);
		tfHopeD.setHorizontalAlignment(SwingConstants.RIGHT);
		tfHopeD.setForeground(new Color(0, 0, 0));
		tfHopeD.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		tfHopeD.setBackground(new Color(255, 255, 255));
		tfHopeD.setBounds(221, 125, 179, 21);
		panel.add(tfHopeD);
		tfHopeD.setColumns(10);
//////////////////////////공유금액///////////////////////////////////////////////////
		tfShareHopeP = new JTextField();
		tfShareHopeP.setHorizontalAlignment(SwingConstants.RIGHT);
		tfShareHopeP.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		tfShareHopeP.setBackground(new Color(255, 255, 255));
		tfShareHopeP.setBounds(210, 478, 157, 21);
		panel.add( tfShareHopeP);
		tfShareHopeP.setColumns(10);
///////////////////판매금액//////////////////////////////////////////////////	
		tfsaleHopeP = new JTextField();
		tfsaleHopeP.setHorizontalAlignment(SwingConstants.RIGHT);
		tfsaleHopeP.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		tfsaleHopeP.setBackground(new Color(255, 255, 255));
		tfsaleHopeP.setBounds(210, 605, 157, 21);
		panel.add(tfsaleHopeP);
		tfsaleHopeP.setColumns(10);
////////////공유 버튼///////////////////////////////////////////////////////////////////////////////			
		JButton bRent = new JButton("공유하기");
		bRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();

				int k_n = Integer.parseInt(tfOutNum.getText());
				int sharehopeCash = Integer.parseInt(tfShareHopeP.getText()) ;
				String shareHopeDate = tfHopeD.getText();
				int shareHopeRentDate = Integer.parseInt(tfshareHopeRentDate.getText());
						
				OutVO vo = new OutVO(k_n, sharehopeCash, shareHopeDate, shareHopeRentDate);
					
					try {
						model = new OutDAO();	

						vo.setOutNum(k_n);
						vo.setSharehopeCash(sharehopeCash);
						vo.setShareHopeDate(shareHopeDate);
						vo.setShareHopeRentDate(shareHopeRentDate);
						int result = model.shareCheck(k_n);
						if (result == 1) {
							JOptionPane cc=new JOptionPane();
							cc.showMessageDialog(null, "이미 공유 중인 물품입니다!");
						}else {
							model.bRent(vo);				
							JOptionPane cc=new JOptionPane();
							cc.showMessageDialog(null, "공유 신청 완료");
							layoutClear();	
						}
									
					}catch (Exception ed) {
						JOptionPane cc=new JOptionPane();
						cc.showMessageDialog(null, "공유 신청 실패"+ ed.getMessage());
						ed.printStackTrace();			
					}
				}
			});
			
		bRent.setBackground(new Color(52,117,171));
		bRent.setForeground(new Color(0, 0, 0));
		bRent.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		bRent.setBounds(272, 554, 128, 36);
		panel.add(bRent);		
/////////////출고///////////////////////////////////////////////////////////////////////////		
		JButton bOut = new JButton("출고하기");
		bOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
					
			    int k_n = Integer.parseInt(tfOutNum.getText());
				String outHopeDate = tfHopeD.getText();
//				String outComplDate = tfOutComplDate.getText();
					
				OutVO vo = new OutVO(k_n, outHopeDate);
					
					try {
                       model = new OutDAO();

					   vo.setOutNum(k_n);
					   vo.setOutHopeDate(outHopeDate);
					   model.bOut(vo);		
					   JOptionPane cc=new JOptionPane();
					   cc.showMessageDialog(null, "출고 신청 완료");
					   layoutClear();
					}catch (Exception ed) {
					   System.out.println("출고 신청 실패");
					   JOptionPane cc=new JOptionPane();
					   cc.showMessageDialog(null, "출고 신청 실패"+ed.getMessage());
					   ed.printStackTrace();				
					}
			}
	});
		bOut.setBounds(272, 410, 128, 36);
		bOut.setBackground(new Color(52,117,171));
		bOut.setForeground(new Color(0, 0, 0));
		bOut.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		panel.add(bOut);
///////////////////판매/////////////////////////////////////////////////////////////////////////////
		JButton bSale = new JButton("판매하기");
		bSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
			
				int k_n = Integer.parseInt(tfOutNum.getText());
				int userSaleHopePay = Integer.parseInt(tfsaleHopeP.getText());
				String userSaleHopeDate =tfHopeD.getText();
				
				OutVO vo = new OutVO(k_n, userSaleHopePay, userSaleHopeDate);
			
				
				try {
                    model = new OutDAO();
					
					vo.setOutNum(k_n);
                    vo.setUserSaleHopeDate(userSaleHopeDate);
                    vo.setSaleHopePrice(userSaleHopePay);
                    int result = model.saleCheck(k_n);
                    if(result == 1) {
                    	JOptionPane cc=new JOptionPane();
                    	cc.showMessageDialog(null, "이미 판매 중인 물품입니다.");
                    }else {
                    	model.bSale(vo);
    					JOptionPane cc=new JOptionPane();
    					cc.showMessageDialog(null, "판매 신청 완료");
    					layoutClear();
                    }
					
				}catch (Exception ed) {
					System.out.println(" 판매 신청 실패");
					JOptionPane cc=new JOptionPane();
					cc.showMessageDialog(null, "판매 신청 실패"+ ed.getMessage());
				    ed.printStackTrace();
					}
			  }
		});
		bSale.setBackground(new Color(52,117,171));
		bSale.setForeground(new Color(0, 0, 0));
		bSale.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		bSale.setBounds(272, 653, 128, 36);
		panel.add(bSale);
/////////////////////////달력//////////////////////////////////////////////////////////////////////////////////		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		calendar.setBounds(10, 156, 390, 244);
		panel.add(calendar);	
////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_3 = new JLabel("\uACF5\uC720 \uD76C\uB9DD \uB300\uC5EC\uAE30\uAC04");
		lblNewLabel_3.setForeground(new Color(218,165,32));
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 506, 157, 47);
		panel.add(lblNewLabel_3);
////////////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_8 = new JLabel("\uC77C");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setForeground(new Color(218,165,32));
		lblNewLabel_8.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(375, 514, 17, 30);
		panel.add(lblNewLabel_8);
///////////////////////////////////////////////////////////////////////////////////////		
		tfshareHopeRentDate = new JTextField();
		tfshareHopeRentDate.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		tfshareHopeRentDate.setHorizontalAlignment(SwingConstants.RIGHT);
		tfshareHopeRentDate.setBounds(210, 519, 157, 21);
		panel.add(tfshareHopeRentDate);
		tfshareHopeRentDate.setColumns(10);
//////////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_9 = new JLabel("\uC6D0");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(new Color(218,165,32));
		lblNewLabel_9.setBounds(375, 473, 17, 30);
		panel.add(lblNewLabel_9);
////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_10 = new JLabel("\uC6D0");
		lblNewLabel_10.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setForeground(new Color(218,165,32));
		lblNewLabel_10.setBounds(375, 600, 17, 30);
		panel.add(lblNewLabel_10);
////////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_11 = new JLabel("\uCD9C\uACE0 \uC2E0\uCCAD");
		lblNewLabel_11.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_11.setForeground(new Color(218,165,32));
		lblNewLabel_11.setBounds(9, 410, 157, 47);
		panel.add(lblNewLabel_11);
/////////////////////////////////////////////////////////////////////////////////////		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(11, 457, 160, -10);
		panel.add(separator);
///////////////////////////////////////////////////////////////////////////////////		
		JLabel lblNewLabel_12 = new JLabel("No.");
		lblNewLabel_12.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setForeground(new Color(218,165,32));
		lblNewLabel_12.setBounds(251, 80, 57, 21);
		panel.add(lblNewLabel_12);
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
	        public void propertyChange(PropertyChangeEvent evt) {
	           SimpleDateFormat sdf = new SimpleDateFormat("YY/MM/dd");
	           tfHopeD.setText(sdf.format(calendar.getDate()));
	        }
	     });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(52,117,171));
		panel_1.setBounds(406, 0, 722, 713);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		JLabel lblNewLabel_1 = new JLabel("\uBCF4\uAD00 \uBB3C\uD488 \uD604\uD669");
		lblNewLabel_1.setBackground(new Color(245, 245, 245));
		lblNewLabel_1.setForeground(new Color(218,165,32));
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 688, 46);
		panel_1.add(lblNewLabel_1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel_7 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setForeground(new Color(218,165,32));
		lblNewLabel_7.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(234, 98, 139, 21);
		panel_1.add(lblNewLabel_7);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 688, 563);
		panel_1.add(scrollPane);
		String[] column = {"NO", "물품명","보관 시작일","보관 종료일","공유 상태","판매 상태"};
		DTModel = new DefaultTableModel(column, 0);
		LTModel = new ListTableModel();
//////스크롤//////////////////////////////////////////////////////////		
		sellTable = new JTable(LTModel);
		sellTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col =0;
				int row = sellTable.getSelectedRow();
				int keepNo = (int) sellTable.getValueAt(row, col);
				
				try {
					OutVO vo = new OutVO();
					vo.setOutNum(keepNo);
					tfOutNum.setText(Integer.toString(keepNo));
				}catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});
	    sellTable.setBorder(new LineBorder(Color.BLACK));
	    sellTable.setBackground(Color.LIGHT_GRAY);
	    sellTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    scrollPane.setViewportView(sellTable);
	///////////////////////////////////////////////////////////////	
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList list = new ArrayList();
				String a = (String) comboBox.getSelectedItem();
				String id = hideId.getText();
					try {
						model = new OutDAO();
						list = model.recentList(a, id);
						LTModel.data=list;
						sellTable.setModel(LTModel);
						LTModel.fireTableDataChanged();
					}catch (Exception e1) {
						System.out.println("검색실패"+e1.getMessage());
						e1.getStackTrace();
					}	
			}
		});
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"가전", "전자","가구","의류 및 잡화","기타"}));
		comboBox.setBounds(385, 97, 315, 23);
		panel_1.add(comboBox);
/////////////////////////////////////////////////////////////////////////////////////////////////////		
	}	
/////////////////////입력 글 초기화////////////////////////////////////////////////////////
	public void layoutClear() {
		tfOutNum.setText(null);
		tfHopeD.setText(null);
		tfShareHopeP.setText(null);
		tfsaleHopeP.setText(null);
		tfshareHopeRentDate.setText(null);
	}
////////////////////화면에 테이블 붙이기/////////////////////////////////////////////
class ListTableModel extends AbstractTableModel { 

ArrayList data = new ArrayList();
String [] columnNames =  {"NO", "물품명","보관 시작일","보관 종료일"};

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