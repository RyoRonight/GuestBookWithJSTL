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
@WebServlet("/SLAddWithCookie")
public class SLAddWithCookie extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public SLAddWithCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getUserFromCookie(HttpServletRequest request){
    	Cookie[] cookies=request.getCookies();
    	if(cookies!=null){
    		for(Cookie cookie:cookies){
    			if(cookie.getName().equals("Name"));
    			return cookie.getValue();
    		}
    	}
    	return null;
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 //in các thẻ html
		out.println("<html>");
		out.println("<head><tile>AddComent</tile></head>");
		out.println("<body>"
				+ "<form method=post action=SLAddWithCookie>");
		String Name=getUserFromCookie(request);
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
		String name=getUserFromCookie(request);
		if(name==null){
			name=request.getParameter("Name");
			Cookie cookie=new Cookie("Name",name);
			response.addCookie(cookie);
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
