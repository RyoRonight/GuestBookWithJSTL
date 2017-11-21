package wb.server;

import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/GuestBook",loadOnStartup=1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		long id=2;
		List<Entry> entries=new ArrayList<Entry>();
		entries.add(new Entry(1,"Joe","hello"));
		entries.add(new Entry(2,"Emmy","nice to meet you"));
		getServletContext().setAttribute("entries", entries);
		getServletContext().setAttribute("id", id);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Entry> entries=(ArrayList<Entry>) getServletContext().getAttribute("entries"); 
		 PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><tile>Guest Book</tile></head>");
		out.println("<body>");
		out.println("<table border="+"'1'"+">");
		out.println("<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "<th>Message</th> "
				+ "</tr>");
		for(int i=0;i<entries.size();i++){
		out.println("<tr>"
				+ "<td>"+entries.get(i).getId()+"</td>"
				+ "<td>"+entries.get(i).getName()+"</td>"
				+ "<td>"+entries.get(i).getMessage()+"</td> "
				+ "<td><a href=SLEdit?id="+entries.get(i).getId()+">Edit</a></td>"
				+ "<td><a href=SLDel?id="+entries.get(i).getId()+">Delete</a></td>"
				+ "</tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("<a href=SLAdd>Leave your message</a></br>");
		out.println("<a href=SLAddWithCookie>Leave your message with cookie</a></br>");
		out.println("<a href=SLAddSessionTracking>Leave your message(SessionTracking)</a></br>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
