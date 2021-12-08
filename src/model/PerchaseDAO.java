package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.PerchaseVO;

public class PerchaseDAO extends ConDB{

	public	void PerchaseDAO() throws Exception{
		super.connectDB();
	}
	
	public ArrayList recentList(String cate, String info, String sub) throws Exception
	{
		con = DriverManager.getConnection(jdbc_url, user, pass);
		String sql = "select p.pro_sale_no, p.sale_price, p.pur_info from pro_sale p, pro_main_cat c, "
				+ "pro_sub_cat s, come_list l, keep k, user_sale_app a, product t "
				+ "where c.pro_main_cat_no=s.pro_main_cat_no and s.pro_sub_cat_no=l.pro_sub_cat_no "
				+ "and l.come_list_no=k.come_list_no and k.keep_no=a.user_sale_app_no "
				+ "and t.pro_no=p.pro_no and c.pro_main_cat_name = '"+cate+"' and s.pro_sub_cat_name = '"+sub+"' and p.pur_info like '%"+info+"%'";
		Statement ps = con.createStatement();

		
		ArrayList list = new ArrayList();
		ResultSet rs = ps.executeQuery(sql);
		
		while (rs.next()) {
			ArrayList temp = new ArrayList();
            temp.add(rs.getInt("pro_sale_no"));
            temp.add(rs.getInt("sale_price"));
            temp.add(rs.getString("pur_info"));

            list.add(temp);
		}
        rs.close();
        ps.close();
          return list;
	}
	
	public PerchaseVO searchClick(int pro_sale_no) throws Exception {
		PerchaseVO vo = new PerchaseVO();
		PreparedStatement ps = null;
		
		String sql = "select * from pro_sale where pro_sale_no=?";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, pro_sale_no);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo.setProCode(rs.getInt("PRO_SALE_NO"));
			vo.setProPrice(rs.getInt("SALE_PRICE"));
			vo.setProInfo(rs.getString("PUR_INFO"));
		}
		ps.close();
		return vo;
	}

}
