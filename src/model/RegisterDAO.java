package model;

import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import vo.RegisterVO;
import view.RegisterView;
public class RegisterDAO extends ConDB{
	
	public RegisterDAO() throws Exception{
		super.connectDB();
	}

	public void regist(RegisterVO vo) throws Exception{
		String name = vo.getName();
		String jumin = vo.getJumin();
		String phone = vo.getPhone();
		String addr = vo.getAddr();
		String email = vo.getEmail();
		String id = vo.getId();
		String upass =vo.getPass();
		String bank = vo.getBank();
		String acc_name =vo.getAcc_name();
		String acc_num  = vo.getAcc_num();
		PreparedStatement ps=null;
		System.out.println(upass);
		String sql = "insert into user_info(User_info_no,name,jumin,phone,addr,email,id,pass,bank, acc_name,acc_num) "
				+ "values (num_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
	
		ps = con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, jumin);
		ps.setString(3, phone);
		ps.setString(4, addr);
		ps.setString(5, email);
		ps.setString(6, id);
		ps.setString(7, upass);
		ps.setString(8, bank);
		ps.setString(9, acc_name);
		ps.setString(10, acc_num);
	
	
		ps.executeUpdate();
		ps.close();
	}
				
	public boolean idcheck(String id) throws Exception
	{
		String sql = "SELECT id from user_info where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,id);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			stmt.close();
			return true;
		}else {
			return false;
		
		}
		
	}	
		
	public RegisterVO find(String name,String num) throws Exception{
			
			String sql = "SELECT id,pass from user_info where name = ? and phone =?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, num);
			ResultSet rs = ps.executeQuery();
			RegisterVO vo = new RegisterVO();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
			}else {
				vo.setId("id¾øÀ½");
			}
			rs.close();
			ps.close();
			
			return vo;
	}
}


