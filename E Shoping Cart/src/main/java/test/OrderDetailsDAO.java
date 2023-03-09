package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class OrderDetailsDAO {
	private int k=0;
	public int insertOrdDet(HttpServletRequest rq) {
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("insert into cust_orders values(?,?,?,?,?)");
			ps1.setInt(1,Integer.parseInt(rq.getParameter("p")));
			ps1.setString(2,rq.getParameter("name"));
			ps1.setString(3,rq.getParameter("email"));
			ps1.setString(4,rq.getParameter("cpayment"));
			ps1.setString(5,rq.getParameter("caddress"));
			k= ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}