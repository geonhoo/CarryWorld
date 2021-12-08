package model;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.WareRentVO;

public class WareRentModel extends ConDB{
	
	public WareRentModel() throws Exception{
		super.connectDB();
	}
	
	public void rentApplication(WareRentVO vo) throws Exception{
		
		int share = vo.getPro_num();
		String sday = vo.getR_start();
		String eday = vo.getR_end();
		int pday = vo.getR_period();
		
		System.out.println(sday);
		System.out.println(eday);
		
		String sql = "insert into rent (rent_no, rent_start_date, user_info_no, share_no, rent_end_date, rent_period) "
				+ "values (num_seq.nextval, to_date('"+sday+"', 'YYYY-MM-DD'), 42, "+share+", "
						+ "to_date('"+eday+"', 'YYYY-MM-DD'),"+pday+")";

		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();	
	}
	
	public String fixEday(WareRentVO vo) throws ParseException {
		
		String sday = vo.getR_start();
		int pday = vo.getR_period();
		
		DateFormat fm = new SimpleDateFormat("yy/MM/dd");
		Date date = fm.parse(sday);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,  pday);
		
		System.out.println(fm.format(cal.getTime()));
		return fm.format(cal.getTime());
	}
	
	public int fixPrice(WareRentVO vo) throws Exception{
		int price = vo.getPrice();
		int pday = vo.getR_period();
		
		int result = price*pday;
		
		return result;
	}
	
	public ArrayList sharetList (String cate) throws Exception{
		
		String sql = "select h.share_no, m.pro_main_cat_name, s.pro_sub_cat_name, c.come_name, h.share_hope_cash "
				+ "from share_list h, keep k, come_list c, pro_sub_cat s, pro_main_cat m "
				+ "where h.keep_no = k.keep_no and "
				+ "k.come_list_no = c.come_list_no and "
				+ "c.pro_sub_cat_no = s.pro_sub_cat_no and "
				+ "s.pro_main_cat_no = m.pro_main_cat_no and "
				+ "m.pro_main_cat_name = '"+cate+"' and h.share_bool = 'Y'";
		
		 Statement ps = con.createStatement(); 
		 ArrayList list = new ArrayList();
		 ResultSet rs = ps.executeQuery(sql); 
		 
		 while (rs.next()) {
	           ArrayList temp = new ArrayList();
	           temp.add(rs.getInt("share_no"));
	           temp.add(rs.getString("pro_main_cat_name"));
	           temp.add(rs.getString("pro_sub_cat_name"));
	           temp.add(rs.getString("come_name"));
	           temp.add(rs.getInt("share_hope_cash"));
	           list.add(temp);
		 }
		 rs.close();
		 ps.close();
		 return list;
	}
	
}
