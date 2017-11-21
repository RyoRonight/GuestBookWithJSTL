package wb.server;

import model.*;
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

/**
 * Servlet implementation class SLAdd
 */
@WebServlet("/SLAddSessionTracking")
public class SLAddWithSessionTracking extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public SLAddWithSessionTracking() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 //in các thẻ html
		out.println("<html>");
		out.println("<head><tile>AddComent</tile></head>");
		out.println("<body>"
				+ "<form method=post action=SLAddSessionTracking>");
		String Name=(String) request.getSession().getAttribute("name");
		if(Name!=null)
		{
			out.println("Name:"+Name+"</br>");
		}else
			out.println( "Name:<Input type=text name=Name></input><br>");
		out.println("Message:<textarea name=message cols=50 rows=4>"
				+ "</textarea> </br>"
				+ "<input type=submit name=submit value=add ></input><br>"
				+ "</form>"
				+ "</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(String) request.getSession().getAttribute("name");
		if(name==null){
			name=request.getParameter("Name");
			request.getSession().setAttribute("name",name);
		}
		List<Entry> entries=(ArrayList<Entry>) getServletContext().getAttribute("entries");  
		long id=(long) getServletContext().getAttribute("id");
		id++;
		getServletContext().setAttribute("id", id);
		
		String message=request.getParameter("message");
		entries.add(new Entry(id,name,message));
		response.sendRedirect("GuestBook");
	}

}
