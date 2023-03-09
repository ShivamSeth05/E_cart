package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class SignInDAO {
	private int k=0;
	public int userSignIN(HttpServletRequest rq) {
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("insert into users(name,email,password)values(?,?,?)");
			ps1.setString(1,rq.getParameter("uname"));
			ps1.setString(2,rq.getParameter("ulogin-email"));
			ps1.setString(3,rq.getParameter("ulogin-pass"));
			 k= ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	
}
}
