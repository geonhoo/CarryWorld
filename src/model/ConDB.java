package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConDB {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url="jdbc:oracle:thin:@192.168.0.85:1521:java5";
	String user = "gunhos";
	String pass = "pass";
	Statement stmt;
	Connection con;
	
	void  connectDB() throws Exception {
		
		try{
			 Class.forName(driver);
	         con = DriverManager.getConnection(jdbc_url, user, pass);
	         stmt = con.createStatement();
	         //System.out.println("성공적으로 디비에 접속 되었음");
	      }catch(ClassNotFoundException e){
	         System.out.println("해당 드라이버를 찾을 수 없습니다.1");
	      }catch(SQLException se){
	         System.out.println("해당 드라이버를 찾을 수 없습니다.2");
	      }
	}
}
