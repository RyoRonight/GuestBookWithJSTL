package wp.servlet;

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
import wp.model.GuestBookEmtry;

@WebServlet(urlPatterns="/GuestBook", loadOnStartup=1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBook() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);//gọi lớp cha init
		long id=2;
		List<GuestBookEmtry> entries = new ArrayList<GuestBookEmtry>();
		entries.add(new GuestBookEmtry(1,"john","hello")); //tạo giá trị cho entries
		entries.add(new GuestBookEmtry(2,"joe","nice site"));
		getServletContext().setAttribute("entries", entries); //lưu và chia sẽ
		getServletContext().setAttribute("id", id);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries"); 
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
		out.println("<tr>"+ "<td>"+entries.get(i).getId()+"</td>"
				+ "<td>"+entries.get(i).getName()+" say: </td>"
				+ "<td>"+entries.get(i).getMessage()+"</td> "
				+ "<td><a href=EditEntry?id="+entries.get(i).getId()+">Edit</a>|<a href=DeleteEntry?id="+entries.get(i).getId()+">Delete</a></td></td>"
				+ "</tr>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("<a href=AddComment>Leave your message</a><br/>");
		out.println("<a href=AddCommentWithCookie>Leave your message (with cookie)</a><br/>");
		out.println("<a href=AddCommentWithSession>Leave your message (with session)</a><br/>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
