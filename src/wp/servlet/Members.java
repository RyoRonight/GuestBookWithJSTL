package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Members() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = (String) request.getSession().getAttribute("user");
		//check, if there's a session attribute "user", if yes, display
		if (user != null) {
			PrintWriter out = response.getWriter(); 
			response.setContentType("text/html"); 
			
			out.println("<html><head><title>Members</title></head><body>");
			out.println("<h2>This is members-only area!</h2>");
			out.println("<p> Wellcome," + user + "</p>");
			out.println("<p><a href='Logout'>Logout</p>");
			out.println("</body></html>");
		}
		else
		{
			//if not, redirect the user to the login
			response.sendRedirect("Login");
		}
	}

}
