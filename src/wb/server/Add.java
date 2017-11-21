package wb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String a=request.getParameter("a");
		String b=request.getParameter("b");
		if(a==null||b==null||a.trim().length()==0||b.trim().length()==0)
		{
			response.sendRedirect("AddForm.html");
			return;
		}
		int sum=Integer.parseInt(a)+Integer.parseInt(b);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><tile>Add</tile></head>");
		out.println("<body><p>"+a+"+"+b+"="+sum+"</p></body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
