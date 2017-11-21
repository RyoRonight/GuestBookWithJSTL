package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wp.model.GuestBookEmtry;

@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public AddCommentWithSession() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 //in các thẻ html
		out.println("<html>");
		out.println("<head><tile>Add Comment with session</tile></head>");
		out.println("<body>");
		out.println("<form method='Post' action='AddCommentWithSession'>");
		//if we already have name in a cookie, then just display name
		String name = (String) request.getSession().getAttribute("Name");
		
		if(name != null)
			out.println("Name: " + name + "<br/>");
		else
		//otherwise, display the input field
			out.println("Name:<Input type=text name=Name></input><br>");
		
		out.println ("Message:<textarea name=message cols=60 rows=6>");
		out.println ("</textarea>");
		out.println("<input type=submit name=submit value=add ></input><br>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		long id=(long) getServletContext().getAttribute("id");
		id++;
		getServletContext().setAttribute("id", id);
		
		//first try to get name from cookie
		String name = (String) request.getSession().getAttribute("Name");
		if (name==null) {
		//get the user input
			name=request.getParameter("Name");
			request.getSession().setAttribute("Name", name);
		}
		String message=request.getParameter("message");
		
		//create a GuestBookEmtry
		GuestBookEmtry entry = new GuestBookEmtry(id,name,message);
		
		//add the new entry to the guestbook
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries"); 
		entries.add(entry);
		
		//send user back to guestbook
		response.sendRedirect("GuestBook");
	}

}
