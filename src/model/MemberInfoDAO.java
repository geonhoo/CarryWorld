package model;

import java.sql.*;
import java.util.ArrayList;

import vo.MemberInfoVO;

public class MemberInfoDAO extends ConDB {
	
	public MemberInfoDAO() throws Exception{	 
		super.connectDB();
	}

// 회원 정보 수정 메소드
	public void btnNewButton(MemberInfoVO vo) throws Exception {
		String sql ="update user_info set pass=?,phone=?,addr=?,email=?,bank=?,acc_name=?,acc_num=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,vo.getPass());
		ps.setString(2,vo.getPhone());
		ps.setString(3,vo.getAddr());
		ps.setString(4,vo.getEmail());
		ps.setString(5,vo.getBank());
		ps.setString(6,vo.getAccname());
		ps.setString(7,vo.getAccnum());
		ps.setString(8,vo.getId());
		
		ps.executeQuery();
		ps.close();
	}
	
// 회원 정보 삭제 메소드
	public void btnNewButton_1(MemberInfoVO vo) throws Exception {
		String sql = "delete user_info where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,vo.getId());
		
		ps.executeQuery();
		ps.close();
		
	}
// 공유 신청 목록 검색 메소드 	
	
	public ArrayList selectCategory(String sel,String text) throws Exception {
		String sql = "select s.share_no, s.share_date, s.share_hope_cash, m.pro_main_cat_name "
				+ "from share_list s, keep k, come_list c, user_info u, pro_sub_cat p, pro_main_cat m "
				+ "where m.pro_main_cat_no=p.pro_main_cat_no and p.pro_sub_cat_no = c.pro_sub_cat_no "
				+ "and u.user_info_no=c.user_info_no and c.come_list_no = k.come_list_no "
				+ "and k.keep_no = s.keep_no and m.pro_main_cat_name = '"+sel+"' and u.id='"+text+"'" ;
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		ArrayList list = new ArrayList();

		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getNString("pro_main_cat_name"));
			temp.add(rs.getNString("share_no"));
			temp.add(rs.getNString("share_date"));
			temp.add(rs.getNString("share_hope_cash"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}
// 보관 물건 목록 검색 메소드 		
	public ArrayList selectCategory1(String sel,String text) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select k.keep_no, k.k_start_date, k.k_end_date, m.pro_main_cat_name "
				+ "from keep k, come_list c, user_info u, pro_sub_cat s, pro_main_cat m "
				+ "where m.pro_main_cat_no=s.pro_main_cat_no and s.pro_sub_cat_no=c.pro_sub_cat_no "
				+ "and u.user_info_no = c.user_info_no and c.come_list_no=k.come_list_no "
				+ "and m.pro_main_cat_name = '"+sel+"' and u.id='"+text+"'";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		ArrayList list = new ArrayList();

		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("keep_no"));
			temp.add(rs.getString("k_start_date"));
			temp.add(rs.getString("k_end_date"));
			temp.add(rs.getString("pro_main_cat_name"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}
	
// 판매 신청 물건 목록 검색 메소드 		
	public ArrayList selectCategory2(String sel,String text) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select u.user_sale_app_no,u.user_sale_app_date,u.user_sale_hope_pay,p.pro_main_cat_name "
				+ "from user_sale_app u, keep k, come_list c, user_info i, pro_sub_cat s, pro_main_cat p "
				+ "where p.pro_main_cat_no=s.pro_main_cat_no and s.pro_sub_cat_no = c.pro_sub_cat_no "
				+ "and i.user_info_no=c.user_info_no and c.come_list_no = k.come_list_no "
				+ "and k.keep_no = u.keep_no and p.pro_main_cat_name = '"+sel+"' and i.id='"+text+"'" ;
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		ArrayList list = new ArrayList();

		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("user_sale_app_no"));
			temp.add(rs.getNString("user_sale_app_date"));
			temp.add(rs.getNString("user_sale_hope_pay"));
			temp.add(rs.getNString("pro_main_cat_name"));
			list.add(temp);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public int setBank(String accNum, String accName) {
		String sql = "select bank from user_info where acc_name = '"+accName+"' and acc_num = '"+accNum+"'";
		String bank = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				bank = rs.getNString("BANK");
			}
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bank.equals("국민")) {
			return 0;
		}else if (bank.equals("신한")) {
			return 1;
		}else if (bank.equals("농협")) {
			return 2;
		}else if (bank.equals("외환")) {
			return 3;
		}else if (bank.equals("하나")) {
			return 4;
		}
		return -1;
	}			
}
