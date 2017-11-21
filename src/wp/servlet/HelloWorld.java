package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;// Thêm thư viện chứa PrintWriter

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/HelloWorld","/a","/b","/member/*"}) //thay đổi URL
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //khai báo biến để sinh ra trang HTML
		
		response.setContentType("text/html"); //xác định kiểu của trang html
		
		out.println("<html><head><title>Hello</title></head><body>");//cấu trúc của trang html
		out.println("<h2>Hello World</h2>");//nội dung trong thẻ body
		out.println("</body></html>");//đóng các thẻ html
	}

}
