package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try(PrintWriter pw=response.getWriter()) {
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			Date  date= new Date();
			
			UserBean admin=(UserBean) request.getSession().getAttribute("admin");
			if(admin!=null) {
				String productId=request.getParameter("id");
				int productquantity=Integer.parseInt(request.getParameter("quantity"));
				if(productquantity<=0) {
					productquantity=1;
				}
				
				OrderBean orb=new OrderBean();
				orb.setId(Integer.parseInt(productId));
				orb.setUid(admin.getId());
				orb.setQuantity(productquantity);
				orb.setDate(formatter.format(date));
				
				Boolean result= new OrderDAO().insertOrder(orb);
				if(result) {
					@SuppressWarnings("unchecked")
					ArrayList<CartBean> c_L= (ArrayList<CartBean>)request.getSession().getAttribute("cart-list");
					if(c_L!=null) {
						for (CartBean c : c_L) {
							if(c.getId()==Integer.parseInt(productId)) {
								c_L.remove(c_L.indexOf(c));
								break;
							}
						}
					}

					response.sendRedirect("orders.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
