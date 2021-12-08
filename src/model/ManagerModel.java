package model;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import vo.ManagerVO;

public class ManagerModel {

	public ManagerModel() throws Exception {	 
		connectDB();
	}
		Connection	con;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@192.168.0.85:1521:java5";
		String user = "gunhos";
		String pass = "pass";
		
		void  connectDB() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(jdbc_url, user, pass);
		System.out.println("관리자 DB 연결 성공");
	}
// 고객 정보 불러오기
		public ArrayList bnb() throws Exception {
			String sql = "select *from user_info";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getNString("jumin"));
				temp.add(rs.getNString("phone"));
				temp.add(rs.getNString("addr"));
				temp.add(rs.getNString("email"));
				temp.add(rs.getNString("id"));
				temp.add(rs.getNString("pass"));
				temp.add(rs.getNString("bank"));
				temp.add(rs.getNString("acc_name"));
				temp.add(rs.getNString("acc_num"));
				list.add(temp);
			}
			
			rs.close();
			st.close();
			return list;
		}
// 입고 정보 불러오기		
		public ArrayList bnb2() throws Exception {
			String sql = "select c.come_list_no,c.user_info_no,s.pro_sub_cat_no,c.come_name,c.come_app_date,c.come_hope_date,v.v_grade_no "+
						" from come_list c,pro_sub_cat s,v_grade v"+
						" where v.v_grade_no=c.v_grade_no and s.pro_sub_cat_no=c.pro_sub_cat_no and c.keep_bool = 'N'";
					
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("come_list_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getInt("pro_sub_cat_no"));
				temp.add(rs.getNString("come_name"));
				temp.add(rs.getNString("come_app_date"));
				temp.add(rs.getNString("come_hope_date"));
				temp.add(rs.getInt("v_grade_no"));
				list.add(temp);
			}
			rs.close();
			st.close();
			return list;
		}
		
// 보관 정보 불러오기
		public ArrayList bnb3() throws Exception {
			String sql = "select k.keep_no,u.user_info_no,u.name,p.pro_sub_cat_no,c.come_name,k.k_start_date,k.k_end_date,v.v_grade_no " +
						" from user_info u,pro_sub_cat p,v_grade v,come_list c,keep k"+
						" where c.come_list_no=k.come_list_no and v.v_grade_no=c.v_grade_no and u.user_info_no = c.user_info_no "
						+ "and c.pro_sub_cat_no=p.pro_sub_cat_no and c.keep_bool = 'Y'";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("keep_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getInt("pro_sub_cat_no"));
				temp.add(rs.getNString("come_name"));
				temp.add(rs.getNString("k_start_date"));
				temp.add(rs.getNString("k_end_date"));
				temp.add(rs.getInt("v_grade_no"));
				list.add(temp);
				
				
			}
			rs.close();
			st.close();
			return list;
		}
		
// 출고 정보 불러오기
		public ArrayList bnb4() throws Exception {
			String sql = "select o.out_list_no,u.user_info_no,u.name,o.out_app_date,o.out_hope_date,o.out_compl_date,v.v_grade_no " +
						" from out_list o,user_info u,v_grade v,come_list c,keep k " +
						" where c.come_list_no = k.come_list_no and c.user_info_no=u.user_info_no and c.v_grade_no=v.v_grade_no";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("out_list_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getNString("out_app_date"));
				temp.add(rs.getNString("out_hope_date"));
				temp.add(rs.getNString("out_compl_date"));			
				temp.add(rs.getInt("v_grade_no"));				
				list.add(temp);
			}
			rs.close();
			st.close();
			return list;
		}
// 대여 정보 불러오기
		public ArrayList bnb5() throws Exception {
			String sql = "select distinct(r.rent_no),r.user_info_no,u.name,r.rent_start_date,r.rent_end_date,s.share_hope_cash,v.v_grade_no "+ 
						" from rent r,share_list s,user_info u,v_grade v,come_list c,keep k" +
						" where r.share_no=s.share_no and u.user_info_no = r.user_info_no and v.v_grade_no=c.v_grade_no and k.keep_no=s.keep_no and c.come_list_no = k.keep_no";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("rent_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getNString("rent_start_date"));
				temp.add(rs.getNString("rent_end_date"));
				temp.add(rs.getInt("share_hope_cash"));
				temp.add(rs.getInt("v_grade_no"));			
				list.add(temp);				
			}
			rs.close();
			st.close();
			return list;
		}
// 공유 관리 정보 불러오기
		public ArrayList bnb6() throws Exception {
			String sql = "select s.share_no,u.user_info_no,u.name,s.share_date,s.share_hope_cash,s.share_bool,v.v_grade_no" + 
						" from v_grade v,user_info u,share_list s,come_list c,keep k" +
						" where u.user_info_no = c.user_info_no and v.v_grade_no = c.v_grade_no and c.come_list_no = k.come_list_no and k.keep_no =s.keep_no";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("share_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getNString("share_date"));
				temp.add(rs.getInt("share_hope_cash"));
				temp.add(rs.getNString("share_bool"));
				temp.add(rs.getInt("v_grade_no"));
				list.add(temp);
			}
			rs.close();
			st.close();
			return list;
		}
 // 고객판매 관리 정보 불러오기
		public ArrayList bnb7() throws Exception {
			String sql = "select s.user_sale_app_no,u.user_info_no,u.name,s.user_sale_app_date,s.user_sale_hope_pay,s.sale_bool,v.v_grade_no" +
						" from user_sale_app s,user_info u,v_grade v,keep k,come_list c" +
						" where u.user_info_no=c.user_info_no and v.v_grade_no=c.v_grade_no and c.come_list_no = k.come_list_no and k.keep_no = s.keep_no";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList list = new ArrayList();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("user_sale_app_no"));
				temp.add(rs.getInt("user_info_no"));
				temp.add(rs.getNString("name"));
				temp.add(rs.getNString("user_sale_app_date"));
				temp.add(rs.getInt("user_sale_hope_pay"));
				temp.add(rs.getNString("sale_bool"));
				temp.add(rs.getInt("v_grade_no"));	
				list.add(temp);				
			}
			rs.close();
			st.close();
			return list;
		}
		
// 사내 물품 정보 불러오기
		 public ArrayList btnpro() throws Exception{
		      String sql ="select p.pro_no,p.pur_date,p.pur_price,c.user_info_no,c.v_grade_no from come_list c, keep k, user_sale_app u , product p  where "
		            + " c.come_list_no = k.come_list_no and k.keep_no =u.keep_no and u.user_sale_app_no="
		            + " p.user_sale_app_no";
		            
		      Statement ps = con.createStatement();
		      ResultSet rs = ps.executeQuery(sql);
		      ArrayList list = new ArrayList();
		      
		      while(rs.next()) {
		         ArrayList temp = new ArrayList();
		         temp.add(rs.getInt("pro_no"));
		         temp.add(rs.getNString("pur_date"));
		         temp.add(rs.getNString("pur_price"));
		         temp.add(rs.getInt("user_info_no"));
		         temp.add(rs.getInt("v_grade_no"));
		         list.add(temp);
		         }
		      
		      rs.close();
		      ps.close();
		      
		      return list;
		   }
		 
// 회사 판매 정보 불러오기
	      public ArrayList pro_sal() throws Exception {
	          
	          String sql = "select s.pro_sale_no ,s.sale_date, p.pur_price, c.user_info_no, c.v_grade_no "
	                +"from come_list c, keep k, user_sale_app u , product p , pro_sale s where "
	                +"c.come_list_no = k.come_list_no and k.keep_no =u.keep_no and u.user_sale_app_no="
	                +" p.user_sale_app_no and p.pro_no = s.pro_no" ;
	          
	          Statement ps = con.createStatement();
	          ResultSet rs = ps.executeQuery(sql);
	          ArrayList list = new ArrayList();
	          
	          while(rs.next()) {
	             ArrayList temp = new ArrayList();
	             temp.add(rs.getInt("pro_sale_no"));
	             temp.add(rs.getNString("sale_date"));
	             temp.add(rs.getNString("pur_price"));
	             temp.add(rs.getInt("user_info_no"));
	             temp.add(rs.getInt("v_grade_no"));
	             list.add(temp);
	             }
	          
	          rs.close();
	          ps.close();
	          
	          return list;
	       }

		
		
		
		
// 입고 반려시 데이터 삭제 
		public void refuse(ManagerVO vo) throws Exception {
			String sql = "delete come_list where come_list_no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, vo.getCome_list_no());	
			ps.executeUpdate();
			ps.close();		
		}
// 입고승인 
		
		public void putOnKeep(int num) throws Exception {
			String sql = "insert into keep(keep_no,come_compl_date,k_start_date,k_end_date,warehouse_no,come_list_no)"+ 
					"values(num_seq.nextval,sysdate, sysdate, sysdate, 1, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, num);
			ps.executeUpdate();
			ps.close();
			
			String sql2 = "update come_list set keep_bool='Y' where come_list_no = ?";
			PreparedStatement ps1 = con.prepareStatement(sql2);
			
			ps1.setInt(1, num);
			ps1.executeUpdate();
			ps1.close();
		}
		
// 출고 승인 가능 여부 변경
		public void outReturn (ManagerVO vo) throws Exception {
			String sql = "delete out_list where out_list_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getOut_list_no());
			ps.executeUpdate();
			ps.close();
		}
// 공유 승인 여부 변경	
		public void share_bool(int num) throws Exception {
			String sql = "update share_list set sale_bool = 'Y' where share_no=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, num);
			ps.executeUpdate();
			ps.close();
		}
	
// 고객 판매 승인 여부 변경
		
		
		public void sale_bool(int num) throws Exception {
			String sql = "update user_sale_app set sale_bool ='Y' where user_sale_app_no=? ";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
			ps.close();
		}

		
}

