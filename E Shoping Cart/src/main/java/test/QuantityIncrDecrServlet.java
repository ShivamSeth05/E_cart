package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/quantity-Incr-Decr")
public class QuantityIncrDecrServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw=response.getWriter()){
			response.setContentType("text/html");
			String action=request.getParameter("action");
			int id=Integer.parseInt(request.getParameter("id"));
			@SuppressWarnings("unchecked")
			ArrayList<CartBean> c_L=(ArrayList<CartBean>) request.getSession().getAttribute("cart-list");
			
			if(action!=null && id>=1) {
				if(action.equals("inc")) {
					for (CartBean c : c_L) {
						if(c.getId()==id) {
							int qty=c.getQuantity();
							qty++;
							c.setQuantity(qty);
							response.sendRedirect("cart.jsp");
						}
					}
				}
				if(action.equals("dec")) {
					for (CartBean c : c_L) {
						if(c.getId()==id &&c.getQuantity()>1) {
							int qty=c.getQuantity();
							qty--;
							c.setQuantity(qty);
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
			}else {
				response.sendRedirect("cart.jsp");
			}
		
		}
		
	}

}
