package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public  class AddProductServlet extends GenericServlet{
	public void service(ServletRequest rq ,ServletResponse rs)throws ServletException,IOException {
		PrintWriter pw=rs.getWriter();
		rs.setContentType("text/html");
		ProductBean pb = new ProductBean();//BeanClassObj
		pb.setName(rq.getParameter("pname"));
		pb.setCategory(rq.getParameter("pcat"));
		pb.setPrice(Float.parseFloat(rq.getParameter("prate")));
		pb.setImage(rq.getParameter("pimg"));
		
		int k=new Insert_deleteProductDAO().insert(pb);
		RequestDispatcher rd = rq.getRequestDispatcher("admin.jsp");
		rd.include(rq, rs);
		if(k>0) {
			pw.println("Product Added Successfully...<br>");
		}
		pw.close();
	}

}
