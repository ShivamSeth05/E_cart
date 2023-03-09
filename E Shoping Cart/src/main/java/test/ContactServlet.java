package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // TODO: Implement your own code to handle the form submission here

        // Send a response to the user
        response.setContentType("text/html");
        response.getWriter().println("<h1>Thank you for contacting us!</h1>");
        response.getWriter().println("<p>We will get back to you as soon as possible.</p>");
        response.getWriter().println("<a class='btn btn-sm' href='index.jsp'>Go To home.</a>");
        
    }
}
