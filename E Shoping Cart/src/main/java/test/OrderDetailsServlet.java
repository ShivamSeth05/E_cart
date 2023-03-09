package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/order-details")
public class OrderDetailsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		int k=new OrderDetailsDAO().insertOrdDet(req);
		if(k>0) {
			pw.println("<div class='alert alert-success alert-dismissible'>");
			pw.println(" <button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
			pw.println("<strong>Success!</strong> Data Submited .");
			pw.println("</div>");
			
			RequestDispatcher rd=req.getRequestDispatcher("Payment.jsp");
			rd.include(req, resp);
		}
	}

}
