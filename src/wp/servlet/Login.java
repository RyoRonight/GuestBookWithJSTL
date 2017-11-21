package wp.servlet;

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
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><tile>Login</tile></head>");
		out.println("<body>");
		out.println("<form method='Post' action='Login'>");
		out.println("Username:<input type='text' name='username'></input><br>");
		out.println("Password:<input type='text' name='password'></input><br>");
		out.println("<input type=submit name='submit' value='Submit'></input><br>");
		out.println("</form>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//check username & password, if correct, redirect the user to Members page
		if (username.equals("chien") && password.equals("1234"))
		{
			request.getSession().setAttribute("user", username);
			response.sendRedirect("Members");
		}
		else
		{
			//otherwise, redirect the user back to Login page
			response.sendRedirect("Login");
		}
	}

}
