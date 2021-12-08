package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	public JTextField hideId, hidePass, hideName, hidePhone, hideAddr, hideEmail, hideBank, hideAccName, hideAccNum, hideNo;
	
	public Main() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52,117,171));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//물건 맡기기
		JButton btnNewButton = new JButton("\uBB3C\uAC74 \uB9E1\uAE30\uAE30");
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setForeground(new Color(0,0,0));
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WareHouseView whvw = new WareHouseView();
				whvw.setVisible(true);
			}
		});
		btnNewButton.setBounds(123, 101, 140, 75);
		contentPane.add(btnNewButton);
		//내 정보
		JButton btnNewButton_2 = new JButton("\uB0B4 \uC815\uBCF4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = hideBank.getText();
				MemberInfoView mivw = new MemberInfoView(name);
				mivw.tfid.setText(hideId.getText());
				mivw.tfpass.setText(hidePass.getText());
				mivw.tfname.setText(hideName.getText());
				mivw.tfphone.setText(hidePhone.getText());
				mivw.tfaddr.setText(hideAddr.getText());
				mivw.tfemail.setText(hideEmail.getText());
				mivw.tfacc_name.setText(hideAccName.getText());
				mivw.tfacc_num.setText(hideAccNum.getText());
				mivw.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(218, 165, 32));
		btnNewButton_2.setForeground(new Color(0,0,0));
		btnNewButton_2.setBounds(300, 187, 140, 75);
		contentPane.add(btnNewButton_2);
		//물건 구매하기
		JButton btnNewButton_3 = new JButton("\uBB3C\uAC74 \uAD6C\uB9E4\uD558\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerchaseView pcvw = new PerchaseView();
				
				pcvw.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 13));
		btnNewButton_3.setBackground(new Color(218, 165, 32));
		btnNewButton_3.setForeground(new Color(0,0,0));
		btnNewButton_3.setBounds(487, 293, 140, 75);
		contentPane.add(btnNewButton_3);
		//물건 대여
		JButton btnNewButton_1 = new JButton("\uBB3C\uAC74 \uB300\uC5EC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 WareRentView wrvw = new WareRentView();
				 wrvw.hideUserNo.setText(hideNo.getText());
				 wrvw.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(218, 165, 32));
		btnNewButton_1.setForeground(new Color(0,0,0));
		btnNewButton_1.setBounds(487, 101, 140, 75);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Main");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(218, 165, 32));
		lblNewLabel.setBounds(315, 28, 123, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("\uCD9C\uACE0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutView ovw = new OutView();
				ovw.hideId.setText(hideId.getText());
				ovw.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(new Color(0,0,0));
		btnNewButton_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 14));
		btnNewButton_4.setBackground(new Color(218, 165, 32));
		btnNewButton_4.setBounds(123, 293, 140, 75);
		contentPane.add(btnNewButton_4);
		
		hideId = new JTextField();
		hidePass = new JTextField();
		hideName = new JTextField();
		hidePhone = new JTextField();
		hideAddr = new JTextField();
		hideEmail = new JTextField();
		hideBank = new JTextField();
		hideAccName = new JTextField();
		hideAccNum = new JTextField();
		hideNo = new JTextField();
		
	}
}
