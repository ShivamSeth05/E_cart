package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.LoginDAO;
import test.UserBean;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		    PrintWriter pw=res.getWriter();
		    res.setContentType("text/html");
		   
		    AdminBean ab=new AdminLoginDAO().login(req);
		    if(ab==null) {
		    	pw.println(" <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>"
		    			+ "  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
		    	pw.println("<div class='alert alert-danger alert-dismissible fade show'>");
				pw.println("<button type='button' class='btn-close' data-bs-dismiss='alert'></button>");				
				pw.println("Invalid login Credentials");
				pw.println("</div>");
		    	RequestDispatcher rd=req.getRequestDispatcher("adminLogin.jsp");
		    	rd.include(req, res);
		    }
		    else {
		    	pw.println(" <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>"
		    			+ "  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
		    	pw.println("<div class='alert alert-success alert-dismissible'>");
				pw.println("<button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
				pw.println("Welcome "+ab.getId());
				pw.println("</div>");
		    	RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
		    	rd.include(req, res);
				Cookie ck= new Cookie("uname", ab.getId());
				res.addCookie(ck);
				
			}
		    
	}
}
