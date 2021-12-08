package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.RegisterVO;
import model.RegisterDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindView extends JFrame {

	private JPanel contentPane;
	private JTextField tfinname;
	private JTextField tfinnum;
	private JTextField tffindid;
	private JTextField tffindpass;
	RegisterDAO model;

	public FindView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(52,117,171));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(218,165,32));
		lblNewLabel.setBounds(142, 31, 220, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(218,165,32));
		lblNewLabel_1.setBounds(51, 103, 71, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(218,165,32));
		lblNewLabel_2.setBounds(51, 134, 89, 32);
		contentPane.add(lblNewLabel_2);
		
		tfinname = new JTextField();
		tfinname.setBounds(172, 98, 136, 26);
		contentPane.add(tfinname);
		tfinname.setColumns(10);
		
		tfinnum = new JTextField();
		tfinnum.setBounds(172, 138, 136, 26);
		contentPane.add(tfinnum);
		tfinnum.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(218,165,32));
		lblNewLabel_3.setBounds(51, 191, 71, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(218,165,32));
		lblNewLabel_4.setBounds(51, 238, 71, 18);
		contentPane.add(lblNewLabel_4);
		
		tffindid = new JTextField();
		tffindid.setEditable(false);
		tffindid.setBounds(172, 190, 136, 26);
		contentPane.add(tffindid);
		tffindid.setColumns(10);
		
		tffindpass = new JTextField();
		tffindpass.setEditable(false);
		tffindpass.setBounds(172, 233, 136, 26);
		contentPane.add(tffindpass);
		tffindpass.setColumns(10);
		
		JButton btnfind = new JButton("\uCC3E\uAE30");
		btnfind.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		btnfind.setForeground(new Color(0, 0, 0));
		btnfind.setBackground(new Color(52,117,175));
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					model=new RegisterDAO();
					String name = tfinname.getText();
					String num = tfinnum.getText();
					RegisterVO vo= model.find(name, num);
					
					tffindid.setText(vo.getId());
					tffindpass.setText(vo.getPass());
				}catch (Exception e4) {
				
					// TODO: handle exception
				}
					
					
				}
			}
		);
		btnfind.setBounds(331, 116, 102, 50);
		contentPane.add(btnfind);
	}

}
