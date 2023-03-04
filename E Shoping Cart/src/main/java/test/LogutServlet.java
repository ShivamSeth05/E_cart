package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
@SuppressWarnings("serial")
public class LogutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin")!=null) {
			 req.getSession().removeAttribute("admin");
			 resp.sendRedirect("login.jsp");
		}
		else {
			resp.sendRedirect("index.jsp");
		}
	}
}
