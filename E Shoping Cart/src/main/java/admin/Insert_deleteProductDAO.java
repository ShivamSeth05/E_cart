package admin;

import java.sql.*;

import test.DBConnenction;

public class Insert_deleteProductDAO {
	public int k=0;
	public int insert(ProductBean pb) {

		try {
			Connection con =test.DBConnenction.getConnection(); //Accessing DB Connection
			PreparedStatement ps=con.prepareStatement("insert into Products(name,category,price,image) values(?,?,?,?)");
			
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getCategory());
			ps.setLong(3, (long) pb.getPrice());
			ps.setString(4, pb.getImage());
			k = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public void deleteOrder(int id) {
		try {
			Connection con=test.DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("delete from products where id=?");
			ps1.setInt(1,id);
			ps1.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
