package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try(PrintWriter pw= resp.getWriter()){
			String id=req.getParameter("id");
			if(id!=null) {
			 	new ProductDAO().cancelOrder(Integer.parseInt(id));
			}
			resp.sendRedirect("orders.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
