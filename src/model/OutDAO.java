package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import vo.OutVO;


////////////////////////////접속/////////////////////////////////////////////////
public class OutDAO extends ConDB{

	public OutDAO() throws Exception{
	  super.connectDB();
	}
/////////////////////////////물품 조회//////////////////////////////////
public ArrayList recentList (String cate, String id) throws Exception
{
	 con = DriverManager.getConnection(jdbc_url, user, pass);
	 String sql = "select distinct(k.keep_no), c.come_name, k.k_start_date, k.k_end_date "
	 		+ "from keep k, come_list c, user_sale_app u,share_list s, pro_main_cat m, pro_sub_cat p "
	 		+ "where m.pro_main_cat_no=p.pro_main_cat_no and "
	 		+ "p.pro_sub_cat_no=c.pro_sub_cat_no and "
	 		+ "c.come_list_no=k.come_list_no and "
	 		+ "m.pro_main_cat_name='"+cate+"' and c.user_info_no = (select user_info_no from user_info where id = '"+id+"')" ;
	 Statement ps = con.createStatement(); 
	 ArrayList list = new ArrayList();
	 ResultSet rs = ps.executeQuery(sql); 
	 while (rs.next()){
	           ArrayList temp = new ArrayList();
	           temp.add(rs.getInt("keep_no"));
	           temp.add(rs.getString("come_name"));
	           temp.add(rs.getString("k_start_date"));
	           temp.add(rs.getString("k_end_date"));
	           list.add(temp);
     }
    rs.close();
    ps.close();
    return list;	
}
//////////출고 신청/////////////////////////////////////////////////////////
public 	void bOut(OutVO vo) throws Exception
{
PreparedStatement ps = null;
String sql = "insert into out_list (out_list_no, out_app_date, out_hope_date, out_compl_date, keep_no) "
	+ "values (num_seq.nextval, sysdate, ?, ?, ?) " ;
ps = con.prepareStatement(sql);
ps.setString(1, vo.getOutHopeDate());
ps.setString(2, vo.getOutComplDate());
ps.setInt(3, vo.getOutNum());
ps.executeUpdate();
ps.close();	
}
/////////////공유 신청////////////////////////////////////////////////////////////////////////
public void bRent(OutVO vo) throws Exception
{
	PreparedStatement ps = null;
	String sql = "insert into share_list (share_no, share_date, keep_no, share_bool, share_hope_cash, share_hope_date, share_hope_rent_date) "
			+ "values (num_seq.nextval, sysdate, ?, 'Y', ?, ?, ?) " ;
	ps = con.prepareStatement(sql);
	ps.setInt(1, vo.getOutNum());
	ps.setInt(2, vo.getSharehopeCash());
	ps.setString(3, vo.getShareHopeDate());
	ps.setInt(4, vo.getShareHopeRentDate());
	
	ps.executeUpdate();
	ps.close();	
}
//////////////////////////판매 신청////////////////////////////////////////////////////////////////// 
public void bSale(OutVO vo) throws Exception
{
	PreparedStatement ps =null;
	String sql = "insert into user_sale_app(user_sale_app_no, user_sale_app_date, user_sale_hope_pay, keep_no ,sale_bool, user_sale_hope_date) "
			+ " values (num_seq.nextval,sysdate, ?, ?, 'Y',?) " ;
	ps = con.prepareStatement(sql);
	ps.setInt(1, vo.getSaleHopePrice());
	ps.setInt(2, vo.getOutNum());
	ps.setString(3, vo.getUserSaleHopeDate());
	
	ps.executeUpdate();
	ps.close();	
 }

public int saleCheck(int num) throws SQLException {
	Statement ps =null;
	String sql = "select * from user_sale_app where keep_no = '"+num+"'";
	ps = con.createStatement(); 
	ResultSet rs = ps.executeQuery(sql);
	if(rs.next()) {
		return 1; 
	}return -1;
}

public int shareCheck(int num) throws SQLException {
	Statement ps =null;
	String sql = "select * from share_list where keep_no = '"+num+"'";
	ps = con.createStatement(); 
	ResultSet rs = ps.executeQuery(sql);
	if(rs.next()) {
		return 1; 
	}return -1;
}
}
