package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.WareHouseingVO;

public class WareHousingDa extends ConDB {
	
	public WareHousingDa() throws Exception{
		super.connectDB();
	}
	
	/////////////////�԰��û Ŭ�� ��
	public void wareApplication(WareHouseingVO vo) throws Exception {
		int w = vo.getWidth();
		int v = vo.getVertical();
		int h = vo.getHeight();
		String hday = vo.getStartDate();
		String oday = vo.getEndDate();
		
		////////////////////////////���� ��� �� �ش� ��޹�ȣ ����
		int volume = (w*v*h)/100;
		String sql1 = "select v_grade_no from v_grade where "+volume+" > min_g and "+volume +"< max_g";
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(sql1);
		if(rs1.next()) {
			
		}
		///////////////////////////���� ī�װ� �ش� ��ȣ ����
		String sql2 = "select pro_sub_cat_no from pro_sub_cat where pro_sub_cat_name = ?";
		
		PreparedStatement stmt2 = con.prepareStatement(sql2);
		stmt2.setString(1, vo.getS_c_name());
		ResultSet rs2 = stmt2.executeQuery();
		
		if(rs2.next()) {
			
		}
		/////////////////////////�Էµ� ��ȭ��ȣ�� �̿��Ͽ� ȸ�� ��ȣ ��������
		String sql3 = "select user_info_no from user_info where phone = ?";
		PreparedStatement stmt3 = con.prepareStatement(sql3);
		stmt3.setString(1, vo.getPhone());
		ResultSet rs3 = stmt3.executeQuery();
		
		if(rs3.next()) {
			
		}
		
		int rs11 = Integer.parseInt(rs1.getNString("V_GRADE_NO"));
		int rs22 = Integer.parseInt(rs2.getNString("PRO_SUB_CAT_NO"));
		int rs33 = Integer.parseInt(rs3.getNString("USER_INFO_NO"));
		
		////////////////////�԰� ��û Ŭ�� �� come_list ���̺� insert
		String sql4 = "insert into come_list (come_list_no, come_app_date, come_hope_date, user_info_no, "
				+ "v_grade_no, pro_sub_cat_no, come_name, out_hope_date) "
				+ "values (num_seq.nextval, sysdate, to_date('"+hday+"', 'YYYY-MM-DD'),"+rs33+", "+rs11+", "+rs22+", ?, to_date('"+oday+"', 'YYYY-MM-DD'))";
		
		PreparedStatement ps = con.prepareStatement(sql4);
		ps.setString(1, vo.getpName());
		
		ps.executeUpdate();
		ps.close();
	}
}
