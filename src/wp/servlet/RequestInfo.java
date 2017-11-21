package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //khai báo biến để sinh ra trang HTML
		
		response.setContentType("text/html"); //xác định kiểu của trang html
		
		out.println("<html><head><title>RequestInfo</title></head><body>");//cấu trúc của trang html
		//lấy thông tin request gửi tới
		out.println("<p> Method: " + request.getMethod()+ " </p>");
		out.println("<p> ContextPath: " + request.getContextPath()+ " </p>");
		out.println("<p> URL: " + request.getRequestURL()+ " </p>");
		out.println("<p> URI: " + request.getRequestURI()+ " </p>");
		out.println("<p> RremoteAddr: " + request.getRemoteAddr()+ " </p>");
		if (request.getHeader("Accept-Encoding").indexOf("gzip") >= 0)
			out.println("<p>Gzip supported.</p>");
		else
			out.println("<p>Gzip not supported.</p>");
		out.println("</body></html>");//đóng các thẻ html
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
