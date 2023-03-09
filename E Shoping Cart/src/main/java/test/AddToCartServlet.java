package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw = resp.getWriter()) {
			ArrayList<CartBean> cL = new ArrayList<CartBean>();

			int id = Integer.parseInt(req.getParameter("id"));
			CartBean cb = new CartBean();
			cb.setId(id);
			cb.setQuantity(1);
			HttpSession session = req.getSession();// created Session
			@SuppressWarnings("unchecked")
			ArrayList<CartBean> c_L = (ArrayList<CartBean>) session.getAttribute("cart-list");
			if (c_L == null) {
				cL.add(cb);// 
				session.setAttribute("cart-list", cL);
				resp.sendRedirect("index.jsp");
				
			} else {
				cL = c_L;			
				boolean exist = false;
				for (CartBean c : c_L) {
					if (c.getId() == id) {
						exist = true;
//						RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
//						rd.include(req, resp);
				
						pw.println(" <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>"
				    			+ "  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
						pw.println("<div class='alert alert-danger alert-dismissible'>");
						pw.println(" <button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
						pw.println("<strong>Item Already Exist in Cart</strong><a href='cart.jsp'>Go to Cart Page</a>");
						pw.println("</div>");
//						pw.println("<h3 style='color:crimson; text-align:center' >Item Already Exist in Cart.<a href='cart.jsp'>Go to Cart Page</a></h3>");
					}
				}
				if (!exist) {
					cL.add(cb);
					resp.sendRedirect("index.jsp");
				}
			}

		}
	}
}
