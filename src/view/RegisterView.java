package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.RegisterDAO;
import vo.RegisterVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;


public class RegisterView extends JFrame{

	private JPanel tfuser;
	private JTextField tfid;
	private JTextField tfpass;
	private JTextField tfpass2;
	private JTextField tfjumin;
	private JTextField tfaddr;
	private JTextField tfemail;
	private JTextField tfacc_num;
	private JTextField tfacc_name;
	private JTextField tfname;
	private JTextField tfphone;
	private JComboBox<?> cbBank;
	RegisterDAO model;
	private JTextField checkMss;

	public RegisterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 777, 666);
		tfuser = new JPanel();
		tfuser.setForeground(new Color(255, 0, 0));
		tfuser.setBackground(new Color(52,117,171));
		tfuser.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tfuser);
		tfuser.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(218,165,32));
		lblNewLabel.setBounds(305, 32, 131, 47);
		tfuser.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(218,165,32));
		lblNewLabel_1.setBounds(118, 119, 63, 18);
		tfuser.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_1_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_1.setForeground(new Color(218,165,32));
		lblNewLabel_1_1.setBounds(118, 185, 131, 18);
		tfuser.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_1_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_2.setForeground(new Color(218,165,32));
		lblNewLabel_1_2.setBounds(118, 285, 57, 22);
		tfuser.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_3.setForeground(new Color(218,165,32));
		lblNewLabel_1_3.setBounds(118, 317, 63, 22);
		tfuser.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_4.setForeground(new Color(218,165,32));
		lblNewLabel_1_4.setBounds(118, 353, 57, 18);
		tfuser.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("\uC740\uD589\uBA85");
		lblNewLabel_1_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_5.setForeground(new Color(218,165,32));
		lblNewLabel_1_5.setBounds(118, 389, 63, 22);
		tfuser.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("\uC608\uAE08\uC8FC");
		lblNewLabel_1_6.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_6.setForeground(new Color(218,165,32));
		lblNewLabel_1_6.setBounds(118, 421, 63, 18);
		tfuser.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("\uAC8C\uC88C\uBC88\uD638");
		lblNewLabel_1_7.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_7.setForeground(new Color(218,165,32));
		lblNewLabel_1_7.setBounds(118, 465, 84, 18);
		tfuser.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_8.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1_8.setForeground(new Color(218,165,32));
		lblNewLabel_1_8.setBounds(118, 157, 84, 18);
		tfuser.add(lblNewLabel_1_8);
		
		tfid = new JTextField();
		tfid.setBounds(267, 117, 217, 24);
		tfuser.add(tfid);
		tfid.setColumns(10);
		
		tfpass = new JTextField();
		tfpass.setColumns(10);
		tfpass.setBounds(267, 149, 217, 24);
		tfuser.add(tfpass);
		
		tfpass2 = new JTextField();
		tfpass2.setColumns(10);
		tfpass2.setBounds(267, 183, 217, 24);
		tfuser.add(tfpass2);
		
		tfjumin = new JTextField();
		tfjumin.setColumns(10);
		tfjumin.setBounds(267, 251, 217, 24);
		tfuser.add(tfjumin);
		
		tfaddr = new JTextField();
		tfaddr.setColumns(10);
		tfaddr.setBounds(267, 317, 217, 24);
		tfuser.add(tfaddr);
		
		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(267, 351, 217, 24);
		tfuser.add(tfemail);
		
		tfacc_num = new JTextField();
		tfacc_num.setColumns(10);
		tfacc_num.setBounds(267, 459, 217, 24);
		tfuser.add(tfacc_num);
		
		tfacc_name = new JTextField();
		tfacc_name.setColumns(10);
		tfacc_name.setBounds(267, 419, 217, 24);
		tfuser.add(tfacc_name);
		
		checkMss = new JTextField();
		checkMss.setEditable(false);
		checkMss.setForeground(new Color(255, 0, 0));
		checkMss.setBackground(new Color(52,117,175));
		checkMss.setText("\uC544\uC774\uB514 \uC911\uBCF5 \uD655\uC778\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694!");
		checkMss.setBounds(283, 584, 183, 21);
		tfuser.add(checkMss);
		checkMss.setColumns(10);
		
		JButton btnIdc = new JButton("\uC911\uBCF5\uD655\uC778");
		btnIdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterVO vo= new RegisterVO();
				try {
					model=new RegisterDAO() ;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vo.setId(tfid.getText());
				String id = tfid.getText();
				try {
					if(model.idcheck(id) == true) {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
						tfid.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
						checkMss.setVisible(false);
						JButton btnUserJoin = new JButton("\uD68C\uC6D0\uAC00\uC5C5");
						btnUserJoin.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));
						btnUserJoin.setForeground(new Color(0, 0, 0));
						btnUserJoin.setBackground(new Color(52,117,175));
						btnUserJoin.setBounds(293, 505, 169, 69);
						btnUserJoin.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String name = tfname.getText();
								String jumin = tfjumin.getText();
								String phone = tfphone.getText();
								String addr = tfaddr.getText();
								String email = tfemail.getText();
								String id = tfid.getText();
								String pass = tfpass.getText();
								String pass2 = tfpass2.getText();
								String bank = (String) cbBank.getSelectedItem();
								String acc_name = tfacc_name.getText();
								String acc_num = tfacc_num.getText();
								if(pass.equals(pass2)){
									try {
									
										model = new RegisterDAO();
										RegisterVO vo = new RegisterVO(name,jumin,phone,addr,email,id,pass, bank, acc_name,acc_num);
										model.regist(vo);
										JOptionPane.showMessageDialog(null,"회원가입 성공!");
										dispose();
									}catch (Exception e2) {
										JOptionPane.showMessageDialog(null,"가입 실패"+e2.getMessage());
										// TODO: handle exception
										e2.printStackTrace();
									}
								}
								else {
									JOptionPane.showMessageDialog(null,"비밀번호를 다시 설정해주세요.");
									Clear();
								}
									}
						});
						
						btnUserJoin.setBounds(305, 495, 123, 51);
						tfuser.add(btnUserJoin);
					}
				}
					catch(Exception e4) {
						JOptionPane.showMessageDialog(null, "실패 하였습니다"+e4.getMessage());
						e4.printStackTrace();
				}
			}
		});
		btnIdc.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		btnIdc.setForeground(new Color(0, 0, 0));
		btnIdc.setBackground(new Color(52,117,175));
		btnIdc.setBounds(512, 117, 120, 44);
		tfuser.add(btnIdc);

		
		cbBank = new JComboBox();
		cbBank.setModel(new DefaultComboBoxModel(new String[] {"\uC2E0\uD55C", "\uAE30\uC5C5", "\uB18D\uD611", "\uC6B0\uB9AC", "\uAD6D\uBBFC"}));
     	cbBank.setSelectedIndex(4);
		cbBank.setBounds(267, 385, 217, 24);
		tfuser.add(cbBank);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(218,165,32));
		lblNewLabel_2.setBounds(118, 215, 63, 26);
		tfuser.add(lblNewLabel_2);
		
		tfname = new JTextField();
		tfname.setBounds(267, 217, 217, 24);
		tfuser.add(tfname);
		tfname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(218,165,32));
		lblNewLabel_3.setBounds(118, 251, 63, 24);
		tfuser.add(lblNewLabel_3);
		
		tfphone = new JTextField();
		tfphone.setBounds(267, 285, 217, 24);
		tfuser.add(tfphone);
		tfphone.setColumns(10);
	}
	
	public void Clear() {
		tfpass.setText(null);
		tfpass2.setText(null);
	}
	
	public void Clearf() {
		tfid.setText(null);
	}
}