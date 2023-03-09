package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/user-sign")
@SuppressWarnings("serial")
public class SignInServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.sendRedirect("login.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw=resp.getWriter()){

		int k= new SignInDAO().userSignIN(req);
		
		if(k>0) {
			pw.println("<div class='alert alert-success alert-dismissible'>");
			pw.println(" <button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
			pw.println("<strong>Success!</strong> Account Created.");
			pw.println("</div>");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
			
		}
		else {
			pw.println("<div class='alert alert-danger alert-dismissible fade show'>");
			pw.println(" <button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
			pw.println("<strong>Success!</strong> Sorry Please Try Again!!!");
			pw.println("</div>");
			RequestDispatcher rd=req.getRequestDispatcher("signUp.jsp");
			rd.include(req, resp);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
