package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	public List<ProductBean> getproduct() {
		List <ProductBean> ls =new ArrayList<ProductBean>();
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("select * from products");
			ResultSet rs= ps1.executeQuery();
			while(rs.next()) {
				ProductBean pb=new ProductBean();
				pb.setId(rs.getInt(1));
				pb.setName(rs.getString(2));
				pb.setCategory(rs.getString(3));
				pb.setPrice(rs.getString(4));
				pb.setImage(rs.getString(5));
				
				ls.add(pb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
		
	}
}
