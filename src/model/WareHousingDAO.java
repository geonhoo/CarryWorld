package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import vo.WareHouseingVO;


public class WareHousingDAO extends ConDB{
	
	public WareHousingDAO() throws Exception{
		super.connectDB();
	}
	
	/////////////////입고신청 클릭 시
	public void wareApplication(WareHouseingVO vo) throws Exception {
		int w = vo.getWidth();
		int v = vo.getVertical();
		int h = vo.getHeight();
		String hday = vo.getStartDate();
		String oday = vo.getEndDate();
		
		////////////////////////////부피 계산 후 해당 등급번호 추출
		int volume = w*v*h;
		String sql1 = "select v_grade_no from v_grade where "+volume+" > min_g and "+volume +"< max_g";
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(sql1);
		if(rs1.next()) {
			
		}
		///////////////////////////서브 카테고리 해당 번호 추출
		String sql2 = "select pro_sub_cat_no from pro_sub_cat where pro_sub_cat_name = ?";
		
		PreparedStatement stmt2 = con.prepareStatement(sql2);
		stmt2.setString(1, vo.getS_c_name());
		ResultSet rs2 = stmt2.executeQuery();
		
		if(rs2.next()) {
			
		}
		/////////////////////////입력된 전화번호를 이용하여 회원 번호 가져오기
		String sql3 = "select user_info_no from user_info where phone = ?";
		PreparedStatement stmt3 = con.prepareStatement(sql3);
		stmt3.setString(1, vo.getPhone());
		ResultSet rs3 = stmt3.executeQuery();
		
		if(rs3.next()) {
			
		}
		
		int rs11 = Integer.parseInt(rs1.getNString("V_GRADE_NO"));
		int rs22 = Integer.parseInt(rs2.getNString("PRO_SUB_CAT_NO"));
		int rs33 = Integer.parseInt(rs3.getNString("USER_INFO_NO"));
		
		////////////////////입고 신청 클릭 시 come_list 테이블 insert
		String sql4 = "insert into come_list (come_list_no, come_app_date, come_hope_date, user_info_no, "
				+ "v_grade_no, pro_sub_cat_no, come_name, out_hope_date) "
				+ "values (num_seq.nextval, sysdate, to_date('"+hday+"', 'YYYY-MM-DD'),"+rs33+", "+rs11+", "+rs22+", ?, to_date('"+hday+"', 'YYYY-MM-DD'))";
		
		PreparedStatement ps = con.prepareStatement(sql4);
		ps.setString(1, vo.getpName());
		
		ps.executeUpdate();
		ps.close();
		

	}
	/////////////////////////////////////////////////////////////////////////////////
	
	public int fix(WareHouseingVO vo) throws Exception{
		int w = vo.getWidth();
		int v = vo.getVertical();
		int h = vo.getHeight();
		
		int volume = w*v*h;
		int result;
		
		String sql1 = "select v_grade_no from v_grade where "+volume+" > min_g and "+volume +"< max_g";
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(sql1);
		if(rs1.next()) {
			
			result = rs1.getInt("V_GRADE_NO");
			return result;
		}else {
			return 0;
		}
		
	}
	
	public int fixprice(WareHouseingVO vo) throws Exception{
		String hday = vo.getStartDate();
		String oday = vo.getEndDate();
		
		DateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date H = format.parse(hday);
        Date O = format.parse(oday);
        
        long caldate = O.getTime() - H.getTime();
        long period  = caldate / (24 * 60 * 60 * 1000);
        period = Math.abs(period);
        int peri = Long.valueOf(period).intValue();

        /////////////////////////////////////////////////////////////////////////////
        int w = vo.getWidth();
		int v = vo.getVertical();
		int h = vo.getHeight();
		int volume = w*v*h;

		String sql = "select v_price from v_grade where "+volume+" > min_g and "+volume +"< max_g";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
	
			int result = rs.getInt("V_PRICE");
			int re = peri*result;
			return re;
		}else {
			return 0;
		}
	}
	
}

	
	
//	////////////////////////승인 버튼 클릭 시
//	String sql2 = "insert into keep (keep_no, come_compl_date, k_start_date, warehouse_no, come_list_no, k_end_date)"
//			+"values (num_seq.nextval, sysdate, ?, 1, ?, ?)";

