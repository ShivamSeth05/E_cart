package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/remove-from-pro")
public class RemoveProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try(PrintWriter pw= resp.getWriter()){
			String id=req.getParameter("id");
			if(id!=null) {
				new Insert_deleteProductDAO().deleteOrder(Integer.parseInt(id));
			}
			resp.sendRedirect("admin.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
