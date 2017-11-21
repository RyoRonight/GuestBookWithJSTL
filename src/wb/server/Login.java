package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 //in các thẻ html
		out.println("<html>");
		out.println("<head><tile>AddComent</tile></head>");
		out.println("<body>"
				+ "<form method=post action=Login>"
				+ "Username:<Input type=text name=Name></input><br>"
				+ "Password:<Input type=text name=pass></input>"
				+ " </br>"
				+ "<input type=submit name=submit value=submit ></input><br>"
				+ "</form>"
				+ "</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("Name");
		String pass=request.getParameter("pass");
		if(user.equals("minh") && pass.equals("1234"))
		{
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Members");
		}else{
			response.sendRedirect("Login");
			
		}
		
	}

}
