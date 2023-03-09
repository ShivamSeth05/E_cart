package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw=response.getWriter()){
			System.out.println(request.getParameter("name"));
//			pw.println();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			
			//retriveing all cart bean using session
			@SuppressWarnings("unchecked")
			ArrayList<CartBean> c_L =(ArrayList<CartBean>) request.getSession().getAttribute("cart-list");
			//user authentication
			UserBean admin=(UserBean)request.getSession().getAttribute("admin");
			System.out.println(c_L.size());
			//check admin and cart list
			if(c_L.size()!=0 && admin!=null) {
				for (CartBean c : c_L) {
					//prepare the Orderbean obj
					OrderBean ob=new OrderBean();
					ob.setId(c.getId());
					ob.setUid(admin.getId());
					ob.setQuantity(c.getQuantity());
					ob.setDate(formatter.format(date));
					
					 Boolean result=new OrderDAO().insertOrder(ob);
					 if(!result)break;
				}
				c_L.clear();
				response.sendRedirect("orders.jsp");
			}
			else {
				if(admin==null) response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
