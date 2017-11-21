package wp.servlet;

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
    
	int counter = 10;
	
    public Countdown() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter(); //khai báo biến để sinh ra trang HTML
		
		response.setContentType("text/html"); //xác định kiểu của trang html
		
		out.println("<html><head><title>Countdown</title></head><body>");//cấu trúc của trang html
		
		// if the counter is already 0, just display a message
		if (counter==0)
		{
			out.println("<p>Rocket launched!</p>");
		}
		//if the counter hasn't reached zero, set a refresh header, and then decrement the counter
		else {
			out.println("<h3>"+ counter + "</h3>");
			response.setHeader("Refresh", "1");
			--counter;
		}
	}

}
