package view;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import view.ComSellMa;
import view.KeepManaging;
import view.OutManaging;
import view.ProductManaging;
import view.PutProMa;
import view.RentManaging;
import view.ShareManaging;
import view.UserSellMa;
import view.UserManaging;

public class ManagerMain extends JFrame{

	UserManaging user;
	PutProMa put;
	KeepManaging keep;
	OutManaging out;
	RentManaging rent;
	ShareManaging share;
	UserSellMa usell;
	ProductManaging product;
	ComSellMa csell;
	
	public ManagerMain() {
		user = new UserManaging();
		put = new PutProMa();
		keep = new KeepManaging();
		out = new OutManaging();
		rent = new RentManaging();
		share = new ShareManaging();
		usell = new UserSellMa();
		product = new ProductManaging();
		csell = new ComSellMa();
		
		JTabbedPane  pane = new JTabbedPane();
		pane.addTab("������", user );
		pane.addTab("�԰����", put);
		pane.addTab("��������", keep);
		pane.addTab("������", out);
		pane.addTab("�뿩����", rent);
		pane.addTab("��������", share);
		pane.addTab("���Ǹ�", usell);
		pane.addTab("��ǰ����", product);
		pane.addTab("ȸ���Ǹ�", csell);
		pane.setSelectedIndex(8);
		
		getContentPane().add("Center", pane );
		setSize(800,600);
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerMain();
	}

}
