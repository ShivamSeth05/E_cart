package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/user-login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw=resp.getWriter()){

		UserBean ub= new LoginDAO().userLogin(req);
		
		if(ub!=null) {
			pw.println("user Login");
			req.getSession().setAttribute("admin", ub);
			resp.sendRedirect("index.jsp");
		}
		else {
			pw.println("user Login Failed");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	
	
	

}
