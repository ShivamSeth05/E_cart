package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public List<ProductBean> getproduct() {
		List<ProductBean> ls = new ArrayList<ProductBean>();
		try {
			Connection con = DBConnenction.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from products");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getInt(1));
				pb.setName(rs.getString(2));
				pb.setCategory(rs.getString(3));
				pb.setPrice(rs.getDouble(4));
				pb.setImage(rs.getString(5));

				ls.add(pb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;

	}

	public List<CartBean> getCartProducts(ArrayList<CartBean> cl) {
		List<CartBean> plist = new ArrayList<CartBean>();
		try {
			Connection con = DBConnenction.getConnection();
			System.out.println(con);
			if (cl.size() > 0) {
				for (CartBean item : cl) {
					PreparedStatement ps1 = con.prepareStatement("select * from products where id=?");
					ps1.setInt(1, item.getId());
					ResultSet rs = ps1.executeQuery();
					while (rs.next()) {
						CartBean cb = new CartBean();
						cb.setId(rs.getInt(1));
						cb.setName(rs.getString(2));
						cb.setCategory(rs.getString(3));
						cb.setPrice(rs.getDouble(4) * item.getQuantity());// price*item
						cb.setQuantity(item.getQuantity());
						plist.add(cb);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return plist;
	}
	
	public double getTotalCartPrice(ArrayList<CartBean> cL) {
		double sum=0;
		try {
			Connection con=DBConnenction.getConnection();
			if(cL.size()>0) {
				for (CartBean item : cL) {
					PreparedStatement ps1=con.prepareStatement
							("select price from products where id=?");
					ps1.setInt(1, item.getId());
					ResultSet rs=ps1.executeQuery();
					while(rs.next()) {
						sum+=rs.getDouble("price")*item.getQuantity();
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#.##");
		double p = Double.parseDouble(df.format(sum));
//		System.out.println(p);
		return p;
	}

	public ProductBean getSingleProduct(int pId) {
		ProductBean pb=null;
		
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("select * from products where id=?");
			ps1.setInt(1, pId);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				pb=new ProductBean();
				pb.setId(rs.getInt(1));
				pb.setName(rs.getString(2));
				pb.setCategory(rs.getString(3));
				pb.setPrice(rs.getDouble(4));
				pb.setImage(rs.getString(5));
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return pb;
	}

	public void cancelOrder(int id) {
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps1=con.prepareStatement
					("delete from orders where o_id=?");
			ps1.setInt(1,id);
			ps1.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
