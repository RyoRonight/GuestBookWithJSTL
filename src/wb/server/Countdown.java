package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=10;
    public Countdown() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 out.println("<html>");
		out.println("<head><tile></tile></head>");
		 if(count==0)
		 {
				out.println("<body><h2>Dem het roi</h2></body>");
				
		 }else{
		 //in các thẻ html
		out.println("<body><h2>"+count+"</h2></body>");
		count--;
		response.setHeader("Refresh", "1");
		 }
		 out.println("</html>");
	}

}
