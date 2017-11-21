package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getRequest")
public class getRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public getRequest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();//tạo một đối tượng in
		out.print("<p>Method:"+request.getMethod() +"</p>");//in ra loại phương thức sử dụng getMethod
		out.print("<p>ContextPath:"+request.getContextPath() +"</p>");//In ra Contexpath
		out.print("<p>URL:"+request.getRequestURL() +"</p>");//ỉn ra URL
		out.print("<p>URI:"+request.getRequestURI() +"</p>");//in ra URI
		out.print("<p>Remote Addr:"+request.getRemoteAddr() +"</p>");//In ra đia chỉ ip
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)//Kiểm tra web có hổ trợ G-
			out.println("<p>Gzip-suported </p>");
		else
				out.println("<p>Gzip-not-suported </p>");
			
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
