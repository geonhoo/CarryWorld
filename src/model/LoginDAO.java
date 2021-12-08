package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo.LoginVO;
import vo.MemberInfoVO;

public class LoginDAO extends ConDB {
	
	//DAO 생성자
	public	LoginDAO() throws Exception{
		super.connectDB();
	}
	//DB연결
	
	//로그인 메소드
	public int login(String uID, String uPass)  throws Exception{
		
		stmt = con.createStatement();
		String sql = "select id, pass from user_info where id = '"+uID+"' and pass = '"+uPass+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			return 1;
		}else {
			return -1; // 아이디가 없음
		}
		
	}
	
	public MemberInfoVO ReturnInfo(String uID, String uPass) {
		MemberInfoVO miv = new MemberInfoVO();
		try {
			stmt = con.createStatement();
			String sql = "select user_info_no, name, phone, addr, email, bank, acc_name, acc_num "
					+ "from user_info where id = '"+uID+"' and pass = '"+uPass+"'";
			ResultSet rs = stmt.executeQuery(sql);	
			
			if(rs.next()) {
				miv.setuserNo(rs.getInt("USER_INFO_NO"));
				miv.setName(rs.getString("NAME"));
				miv.setPhone(rs.getString("PHONE"));
				miv.setAddr(rs.getString("ADDR"));
				miv.setEmail(rs.getString("EMAIL"));
				miv.setBank(rs.getString("BANK"));
				miv.setAccname(rs.getString("ACC_NAME"));
				miv.setAccnum(rs.getString("ACC_NUM"));
			}
		}catch (Exception e) {
			System.out.println("전송오류"+e.getMessage());
			e.getStackTrace();
		}return miv;
		
	}
	
}
