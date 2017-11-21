package wb.server;

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
		String User=(String)request.getSession().getAttribute("user");
		if(User!=null){
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><tile>Members</tile></head>");
		out.println("<body>"
				+ "<h2>Page Only Member</h2>"
				+ "<h2>Welcome:"+User+"</h2>"
				+ "<a href=Logout>Logout</a>"
				+ "</body>");
		out.println("</html>");
		}else{
			response.sendRedirect("Login");
		}

}
	}
