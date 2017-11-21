package wb.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entry;

/**
 * Servlet implementation class SLEdit
 */
@WebServlet("/SLEdit")
public class SLEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Entry> entries=(ArrayList<Entry>) getServletContext().getAttribute("entries");
		PrintWriter out=response.getWriter();
		long id=Long.parseLong(request.getParameter("id"));
		for(Entry entry:entries){
			if(entry.getId()==id){
				out.println("<html>");
				out.println("<head><tile>AddComent</tile></head>");
				out.println("<body>"
						+ "<form method=post action=SLEdit>"
						+ "Name:<Input type=text name=Name value="+entry.getName() +"></input><br>"
						+ "Message:<textarea name=message cols=50 rows=4 >"+entry.getMessage()+"</textarea> </br>"
						+ "<input type=submit name=submit value=Update></input><br>"
						+ "<input type='hidden' name='id' value="+entry.getId()+"></input>"
						+ "</form>"
						+ "</body>");
				out.println("</html>");
				break;
			}
			
		}
		 //in các thẻ html
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Entry> entries=(ArrayList<Entry>) getServletContext().getAttribute("entries");  
		String name=request.getParameter("Name");
		String message=request.getParameter("message");
		///
		long id=Long.parseLong(request.getParameter("id"));
		for(Entry entry:entries){
			if(entry.getId()==id){
			entry.setName(name);
			entry.setMessage(message);
			break;
			}
			
		}
		
		response.sendRedirect("GuestBook");
	}

}
