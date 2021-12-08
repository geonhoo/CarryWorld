package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.LoginDAO;
import vo.LoginVO;
import vo.MemberInfoVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;

public class LoginView extends JFrame{

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfPass;
	private JButton btnLogin, btnJoin, btnFind;
	LoginDAO dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginView() {
		addLayout();
	}

	/**
	 * Create the frame.
	 */
	void addLayout() {
		try {
			dao = new LoginDAO();
			System.out.println("고객DB 연결 성공");
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "고객DB 연결 실패"+e.getMessage());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52,117,171));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Font font = new Font("",Font.BOLD,30);
		
		JLabel labelid = new JLabel("\uC544\uC774\uB514");
		labelid.setForeground(new Color(218,165,32));
		labelid.setBackground(Color.WHITE);
		labelid.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		labelid.setBounds(178, 183, 80, 30);
		contentPane.add(labelid);
		
		JLabel labelPass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		labelPass.setForeground(new Color(218,165,32));
		labelPass.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		labelPass.setBounds(178, 261, 95, 26);
		contentPane.add(labelPass);
		
		tfID = new JTextField();
		tfID.setBounds(285, 181, 245, 38);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(285, 257, 245, 38);
		contentPane.add(tfPass);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("HY엽서M", Font.BOLD, 24));
		btnLogin.setBackground(new Color(52,117,175));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userID = tfID.getText();
				String userPass = tfPass.getText();
				try {
					if (userID.equals("gunho") && userPass.equals("team2")) {
						//관리자 창 띄움
						System.out.println("관리자 로그인");
						ManagerMain ma = new ManagerMain();
						ma.setVisible(true);
						setVisible(false);
					}else {
						LoginVO vo = new LoginVO();
						vo.setUserID(userID);
						vo.setUserPass(userPass);
						try {
							int rs = dao.login(vo.getUserID(),vo.getUserPass());
							if(rs == 1) {
								//회원정보 화면으로 정보 넘기기
								MemberInfoVO mivo = new MemberInfoVO();
								
								
								mivo = dao.ReturnInfo(userID, userPass);
								Main ma = new Main();
								ma.hideId.setText(userID);
								ma.hidePass.setText(userPass);
								ma.hideNo.setText(Integer.toString(mivo.getuserNo()));
								ma.hideName.setText(mivo.getName());
								ma.hidePhone.setText(mivo.getPhone());
								ma.hideAddr.setText(mivo.getAddr());
								ma.hideEmail.setText(mivo.getEmail());
								ma.hideBank.setText(mivo.getBank());
								ma.hideAccName.setText(mivo.getAccname());
								ma.hideAccNum.setText(mivo.getAccnum());

								//로그인 완료 메세지 출력
								JOptionPane.showMessageDialog(null, "로그인 되었습니다!");
								
								ma.setVisible(true);
								
								setVisible(false);
							}else{
								//로그인 실패 메세지 출력
								JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 다시 확인해주세요");
								tfID.setText("");
								tfPass.setText("");
							}
							
						}catch (Exception e1) {
							// TODO: handle exception
							System.out.println("로그인 에러"+e1.getMessage());
							e1.printStackTrace();
						}
					}
				}catch (Exception e1) {
					// TODO: handle exception
				}
				
			}
		});
		btnLogin.setBounds(583, 181, 108, 114);
		contentPane.add(btnLogin);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		btnJoin.setForeground(new Color(0, 0, 0));
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterView regivw = new RegisterView();
				regivw.setVisible(true);
			}
		});
		btnJoin.setBackground(new Color(52,117,175));
		btnJoin.setBounds(207, 341, 129, 46);
		contentPane.add(btnJoin);
		
		JButton btnFind = new JButton("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnFind.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		btnFind.setForeground(new Color(0, 0, 0));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindView fdvw = new FindView();
				fdvw.setVisible(true);
			}
		});
		btnFind.setBackground(new Color(52,117,175));
		btnFind.setBounds(370, 341, 245, 46);
		contentPane.add(btnFind);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/logo.png").getImage());
		panel.setBounds(206, 10, 448, 152);
		contentPane.add(panel);
		panel.setLayout(null);

	}

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
}
