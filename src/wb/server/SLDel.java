package wb.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entry;

/**
 * Servlet implementation class SLDel
 */
@WebServlet("/SLDel")
public class SLDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SLDel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Entry> entries=(ArrayList<Entry>) getServletContext().getAttribute("entries");  
		long id=Long.parseLong(request.getParameter("id"));
		for(Entry entry:entries){
			if(entry.getId()==id){
				entries.remove(entry);
				break;
			}
			
		}
		response.sendRedirect("GuestBook");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
