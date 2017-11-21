package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEmtry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries");
		PrintWriter out=response.getWriter();
		long id=Long.parseLong(request.getParameter("id"));
		for(GuestBookEmtry entry:entries){
			if(entry.getId()==id){
				out.println("<html>");
				out.println("<head><tile>EditComent</tile></head>");
				out.println("<body>");
				out.println("<form method='post' action='EditEntry'>");
				out.println("Name:<Input type=text name=Name value="+entry.getName() +"></input><br>");
				out.println("Message:<textarea name=message cols=60 rows=6 >"+entry.getMessage()+"</textarea>");
				out.println("<input type=submit name=submit value=Update></input><br>");
				out.println("<input type='hidden' name='id' value="+entry.getId()+"></input>");
				out.println("</form>");
				out.println("</body></html>");
				break;
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries");  
		String name=request.getParameter("Name");
		String message=request.getParameter("message");
		///
		long id=Long.parseLong(request.getParameter("id"));
		for(GuestBookEmtry entry:entries){
			if(entry.getId()==id){
			entry.setName(name);
			entry.setMessage(message);
			break;
			}
			
		}
		
		response.sendRedirect("GuestBook");
		
	}

}
