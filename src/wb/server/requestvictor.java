package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/requestvictor",loadOnStartup=1)
public class requestvictor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public requestvictor() {
        super();
    }	
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int counter=0;
		//set đối tượng counter có giá trị là counter vào application scope
		getServletContext().setAttribute("counter", counter);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lấy giá trị counter
		Integer counter=(Integer)(getServletContext().getAttribute("counter")); 
		//tăng giá trị counter va lưu lại vào application scope
		counter++;
		getServletContext().setAttribute("counter", counter);
		//in sô biến đếm counter
		 PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><tile></tile></head>");
		out.println("<body><h2>The counter is increased</h2></body>");
		out.println("</html>");
	}

}
