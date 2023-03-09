package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private Connection conn;
	UserBean user=null;
	public boolean insertOrder(OrderBean orb) {
		
		boolean result=false;
		try {
			conn=DBConnenction.getConnection();
			PreparedStatement ps1=conn.prepareStatement
					("insert into orders (p_id,u_id,o_quantuty,o_date)values(?,?,?,?)");
			ps1.setInt(1, orb.getId());
			ps1.setInt(2, orb.getUid());
			ps1.setInt(3, orb.getQuantity());
			ps1.setString(4, orb.getDate());
			int k=ps1.executeUpdate();
			if(k>0) {
				result=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		 
	}
	
public List<OrderBean> userOrders(int id) {
		List<OrderBean> olist=new ArrayList<OrderBean>();
		try {
			conn=DBConnenction.getConnection();
			PreparedStatement ps1=conn.prepareStatement
					("select * from orders where u_id=? order by orders.o_id desc");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				OrderBean orderB=new OrderBean();
				ProductDAO productDAO=new ProductDAO();
				int pId=rs.getInt("p_id");
				
				ProductBean productBean=productDAO.getSingleProduct(pId);
				orderB.setOrderId(rs.getInt("o_id"));
				orderB.setId(pId);
				orderB.setName(productBean.getName());
				orderB.setCategory(productBean.getCategory());
				orderB.setPrice(productBean.getPrice()*rs.getInt("o_quantuty"));
				orderB.setQuantity(rs.getInt("o_quantuty"));
				orderB.setDate(rs.getString("o_date"));
				olist.add(orderB);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return olist;
		 
	}
	
}

