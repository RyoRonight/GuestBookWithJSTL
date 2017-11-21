package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaycounter")
public class displaycounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public displaycounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lấy giá trị counter
		Integer counter=(Integer)(getServletContext().getAttribute("counter")); 
			
				//in sô biến đếm counter
				 PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<head><tile></tile></head>");
				out.println("<body><h2>you are victor:</h2>"+counter+"</body>");
				out.println("</html>");
	}

}
