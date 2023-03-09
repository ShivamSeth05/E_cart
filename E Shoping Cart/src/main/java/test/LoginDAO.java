package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;

public class LoginDAO {
	private Connection conn;
	UserBean user=null;
	public UserBean userLogin(ServletRequest req) {
		try {
			conn=DBConnenction.getConnection();
			PreparedStatement ps1=conn.prepareStatement
					("select * from users where email=? and password=?");
			ps1.setString(1, req.getParameter("login-email"));
			ps1.setString(2, req.getParameter("login-pass"));
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				user=new UserBean();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		 
	}
}
