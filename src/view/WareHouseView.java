package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import com.toedter.calendar.JCalendar;

import model.WareHousingDAO;
import vo.WareHouseingVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Stack;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WareHouseView extends JFrame{

	private JPanel contentPane;

	private JLabel lblNewLabel, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,  lblNewLabel_5,
	lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, lblNewLabel_11, lblNewLabel_12;
	
	private JTextField tfTel, tfName, tfHope, tfOut, tfWidth, tfVertical, tfHeight, to_price, grade;

	 JComboBox com_m_c, com_s_c;

	JButton btnNewButton;

	WareHousingDAO model;
	
	private JLabel lblNewLabel_1;

	private JLabel lblNewLabel_13;

	private JButton btnNewButton_1, btnNewButton_2;

	/**
	 * Launch the application.
	 */
	////////////////////////////////////////////////////////////////////////////메인메서드 테스트용
	/////////////////////////////////////////////////////////////////////////////////////멤버필드 생성
	public WareHouseView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 923, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
        ///////////////////////////////////////////////////////////////////////////////////////////////////////전화번호
		lblNewLabel = new JLabel("전화번호");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 171, 112, 31);
		contentPane.add(lblNewLabel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(168, 171, 227, 31);
		contentPane.add(tfTel);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////상품명
		lblNewLabel_2 = new JLabel("상품명");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(28, 212, 112, 31);
		contentPane.add(lblNewLabel_2);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(168, 212, 227, 31);
		contentPane.add(tfName);

        //////////////////////////////////////////////////////////////////////////////////////////////////수거희망일
		lblNewLabel_3 = new JLabel("수거희망일");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(28, 254, 112, 31);
		contentPane.add(lblNewLabel_3);
		
		tfHope = new JTextField();
		tfHope.setColumns(10);
		tfHope.setBounds(168, 254, 227, 31);
		contentPane.add(tfHope);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////출고희망일
		lblNewLabel_4 = new JLabel("출고예정일");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(28, 295, 112, 31);
		contentPane.add(lblNewLabel_4);
		
		tfOut = new JTextField();
		tfOut.setColumns(10);
		tfOut.setBounds(168, 295, 227, 31);
		contentPane.add(tfOut);
		
        ////////////////////////////////////////////////////////////////////////////////////////////////////////가로
		lblNewLabel_5 = new JLabel("가로(CM)");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(28, 336, 112, 31);
		contentPane.add(lblNewLabel_5);
		
		tfWidth = new JTextField();
		tfWidth.setColumns(10);
		tfWidth.setBounds(28, 362, 94, 31);
		contentPane.add(tfWidth);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////세로
		lblNewLabel_6 = new JLabel("세로(CM)");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(134, 336, 112, 31);
		contentPane.add(lblNewLabel_6);
		
		tfVertical = new JTextField();
		tfVertical.setColumns(10);
		tfVertical.setBounds(134, 362, 94, 31);
		contentPane.add(tfVertical);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////높이
		lblNewLabel_7 = new JLabel("높이(CM)");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(240, 336, 112, 31);
		contentPane.add(lblNewLabel_7);
		
		tfHeight = new JTextField();
		tfHeight.setColumns(10);
		tfHeight.setBounds(240, 362, 94, 31);
		contentPane.add(tfHeight);
		
		//////////////////////////////////////////////////////////////////////////////메인카테고리 라벨(메인카테고리)
		lblNewLabel_8 = new JLabel("카테고리");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(28, 92, 112, 31);
		contentPane.add(lblNewLabel_8);

		////////////////////////////////////////////////////////////////////////////////////상세분류 라벨(서브카테고리)
		lblNewLabel_9 = new JLabel("상세분류");
		lblNewLabel_9.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(28, 133, 140, 31);
		contentPane.add(lblNewLabel_9);
		
		////////////////////////////////////////////////////////////////////////////////////////////카테고리 셀렉트박스
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBox.getSelectedItem();
				if (a.equals("가전")) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"냉장고","세탁기","TV","김치냉장고",
							"건조기","에어컨","제습기","청소기","스타일러","정수기","냉동고","기타"}));
				}else if (a.equals("가구")) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"테이블","소파","침대","식탁","의자",
							"책상","옷장","서랍장","선반","거울","조명","기타"}));
				}else if (a.equals("의류및잡화")) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"의류","신발","가방","쥬얼리","악세사리",
							"개인물품","기타"}));
				}else if (a.equals("전자제품")) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"컴퓨터","노트북","무선스피커","플스",
							"엑스박스","닌텐도","핸드폰","스마트워치","태블릿","전자사전","기타"}));
				}else	{
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"기타"}));
				}
			}
			
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택하세요","가전", "가구", "의류및잡화", "전자제품", "기타"}));
		
		comboBox.setBounds(168, 96, 135, 23);
		contentPane.add(comboBox);
		
		comboBox_1.setBounds(168, 137, 164, 23);
		contentPane.add(comboBox_1);
		
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////달력
		/////////////////////////////////////선택한 날짜 수거 희망일로 넘어가기
		JCalendar calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
	         @Override
	         public void propertyChange(PropertyChangeEvent evt) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");	            
	            tfHope.setText(sdf.format(calendar.getDate()));
	         }
	      });		
		calendar.setBounds(490, 71, 405, 180);
		contentPane.add(calendar);
		
		/////////////////////////////////////선택한 날짜 출고 예정일로 넘어가기
		JCalendar calendar2 = new JCalendar();
		calendar2.addPropertyChangeListener(new PropertyChangeListener() {			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				SimpleDateFormat sdf2 = new SimpleDateFormat("yy/MM/dd");
	            tfOut.setText(sdf2.format(calendar2.getDate()));
			}
		});		
		calendar2.setBounds(490, 310, 405, 180);
		contentPane.add(calendar2);
		
		//////////////////////////////////////////////////////////////////////////////////////////////입고신청서작성 제목
		lblNewLabel_10 = new JLabel("입고신청서 작성");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_10.setBounds(82, 10, 220, 31);
		contentPane.add(lblNewLabel_10);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////날짜선택 제목
		lblNewLabel_11 = new JLabel("입고 날짜선택");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_11.setBounds(544, 10, 220, 31);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("출고 날짜 선택");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_12.setBounds(544, 262, 220, 31);
		contentPane.add(lblNewLabel_12);
		
		////////////////////////////////////////////////////////////////////////////////////입고신청 버튼
		
		btnNewButton = new JButton("입고신청");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				
				String main = (String) comboBox.getSelectedItem();
				String sub = (String)comboBox_1.getSelectedItem();
				String phone = tfTel.getText();
				String pname = tfName.getText();
				String hDay = tfHope.getText();
				String oDay = tfOut.getText();
				int width = Integer.parseInt(tfWidth.getText());
				int vertical = Integer.parseInt(tfVertical.getText());
				int height = Integer.parseInt(tfHeight.getText());
				
				WareHouseingVO vo = new WareHouseingVO(main, sub, phone, pname,
						hDay, oDay, width, vertical, height);
				
				try {
					model = new WareHousingDAO();
					
					System.out.println(main);
					System.out.println(sub);
					System.out.println(phone);

					System.out.println(pname);
					System.out.println(hDay);
					System.out.println(oDay);
					System.out.println(width);
					System.out.println(vertical);
					System.out.println(height);
					
					model.wareApplication(vo);
					JOptionPane.showMessageDialog(null, "입고신청이 완료되었습니다.");
					System.out.println("입고 신청 성공");
					
				}catch (Exception e1) {
					System.out.println("입고 신청 실패"+e1.getMessage());
					e1.printStackTrace();
				}
				
			}
			});
		
		btnNewButton.setBounds(122, 475, 140, 31);
		contentPane.add(btnNewButton);
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		lblNewLabel_1 = new JLabel("등급");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(28, 407, 80, 27);
		contentPane.add(lblNewLabel_1);
		
		grade = new JTextField();
		grade.setBounds(28, 434, 116, 31);
		contentPane.add(grade);
		grade.setColumns(10);
		
		lblNewLabel_13 = new JLabel("총금액");
		lblNewLabel_13.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(171, 403, 75, 31);
		contentPane.add(lblNewLabel_13);
		
		to_price = new JTextField();
		to_price.setBounds(168, 434, 116, 31);
		contentPane.add(to_price);
		to_price.setColumns(10);
		
		btnNewButton_1 = new JButton("확정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object o = e.getSource();
				
				int width = Integer.parseInt(tfWidth.getText());
				int vertical = Integer.parseInt(tfVertical.getText());
				int height = Integer.parseInt(tfHeight.getText());
				
				String hope = tfHope.getText();
				String out = tfOut.getText();
				
				WareHouseingVO vo = new WareHouseingVO();
				vo.setWidth(width);
				vo.setVertical(vertical);
				vo.setHeight(height);
				vo.setStartDate(hope);
				vo.setEndDate(out);
//				WareHouseingVO vo2 = new WareHouseingVO(hope, out);
				
				try {
					model = new WareHousingDAO();
					grade.setText(Integer.toString(model.fix(vo)));
					to_price.setText(Integer.toString(model.fixprice(vo)));
//					WareHouseingVO wvo = new WareHouseingVO();
//					model.fixprice(vo);
//					String aaa = Integer.toString(vo.getTo_price());
//					to_price.setText(aaa);
					
				}catch(Exception e1) {
					System.out.println("확정 실패" + e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(346, 366, 97, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("결제신청");
		btnNewButton_2.setBounds(346, 438, 97, 23);
		contentPane.add(btnNewButton_2);
	}
}
