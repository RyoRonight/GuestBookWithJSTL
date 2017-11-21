package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCounter")
public class DisplayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisplayCounter() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext(); //khai báo đối tượng servlet
		
		//get counter
		Integer counter = (Integer) servletContext.getAttribute("counter");// ép về kiểu int
		
		PrintWriter out = response.getWriter(); //khai báo biến để sinh ra trang HTML
		
		response.setContentType("text/html"); //xác định kiểu của trang html
		
		out.println("<html><head><title>Display Counter</title></head><body>");//cấu trúc của trang html
		out.println("<h2>You are vistor # " + counter + ".</h2>");//nội dung trong thẻ body xuất giá trị số lần load trang servlet
		out.println("</body></html>");//đóng các thẻ html
	}

}
