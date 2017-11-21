package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//thêm url patternes
@WebServlet({"/helloworild","/a","/b","/member/*"})
public class helloworild extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public helloworild() {
    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//khởi tạo đối tượng prinwriter
		 PrintWriter out=response.getWriter();
		 //in các thẻ html
		out.println("<html>");
		out.println("<head><tile></tile></head>");
		out.println("<body><h2>hello world</h2></body>");
		out.println("</html>");
	}
} 
