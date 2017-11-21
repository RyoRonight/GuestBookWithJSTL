package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/RequestCounter", loadOnStartup = 1)
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RequestCounter() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //gọi phương thức init trong lớp cha
		int counter = 0; //Tạo và khởi tạo giá trị ban đầu của biến counter
		getServletContext().setAttribute("counter", counter); //truyền dữ liệu counter cho servlet khác
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext(); //khai báo đối tượng servlet
		
		//get counter
		Integer counter = (Integer) servletContext.getAttribute("counter");// ép về kiểu int
		
		//increment counter
		counter++; //tăng counter
		
		//set counter application scope
		servletContext.setAttribute("counter", counter);
		
		PrintWriter out = response.getWriter(); //khai báo biến để sinh ra trang HTML
		
		response.setContentType("text/html"); //xác định kiểu của trang html
		
		out.println("<html><head><title>Request Counter</title></head><body>");//cấu trúc của trang html
		out.println("<h2>The Counter is increment</h2>");//nội dung trong thẻ body xuất giá trị số lần load trang servlet
		out.println("</body></html>");//đóng các thẻ html
	}

}
