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
@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw=resp.getWriter()){
			String id=req.getParameter("id");
			if(id!=null) {
				@SuppressWarnings("unchecked")
				ArrayList<CartBean> c_L= (ArrayList<CartBean>)req.getSession().getAttribute("cart-list");
				if(c_L!=null) {
					for (CartBean c : c_L) {
						if(c.getId()==Integer.parseInt(id)) {
							c_L.remove(c_L.indexOf(c));
							break;
						}
					}
					resp.sendRedirect("cart.jsp");
				}
			}else {
				resp.sendRedirect("cart.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
