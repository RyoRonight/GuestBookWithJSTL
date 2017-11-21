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

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 //in các th? html
		out.println("<html>");
		out.println("<head><tile>AddComent</tile></head>");
		out.println("<body>");
		out.println("<form method='Post' action='AddComment'>");
		out.println("Name:<Input type=text name=Name></input><br>");
		out.println ("Message:<textarea name=message cols=60 rows=6>");
		out.println ("</textarea>");
		out.println("<input type=submit name=submit value=add ></input><br>");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries");   
		long id=(long) getServletContext().getAttribute("id");
		id++;
		getServletContext().setAttribute("id", id);
		String name=request.getParameter("Name");
		String message=request.getParameter("message");
		entries.add(new GuestBookEmtry(id,name,message));
		response.sendRedirect("GuestBook");
	}

}
