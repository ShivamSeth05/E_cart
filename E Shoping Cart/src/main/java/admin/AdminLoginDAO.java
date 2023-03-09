package admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginDAO {
	AdminBean ab=null;
	public AdminBean login(HttpServletRequest rq) {
		try {
			
			Connection con=test.DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement("Select * from admin where id=? and password=?");
			ps1.setString(1, rq.getParameter("username"));
			ps1.setString(2, rq.getParameter("password"));
			ResultSet rs =ps1.executeQuery();
			while (rs.next()) {
				 ab=new AdminBean();
				ab.setId(rs.getString(1));
				ab.setPass(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
