package wp.servlet;

import java.sql.ResultSet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.servlet.MyConnection;

@WebServlet("/SuaTinNhan")
public class SuaTinNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String Ten;
	String tn; 
	
    public SuaTinNhan() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID=request.getParameter("ID");
		ResultSet rs;
		try {
			rs = new MyConnection().chonDuLieuTuDTB("select * from Message where ID='"+ID+"'");
			while(rs.next()){
				Ten=rs.getString(2);
				tn=rs.getString(3);
			}
			response.setContentType("text/html");
			ServletContext context = getServletContext();
			context.setAttribute("ID", ID);
			context.setAttribute("Ten", Ten);
			context.setAttribute("TinNhan", tn);
			
			
			response.sendRedirect("SuaTaiKhoan.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ten = request.getParameter("Ten");
		String tn = request.getParameter("TinNhan");
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		String ID=(String) context.getAttribute("ID");
		
		
		try {
			new MyConnection().thucThiCauLenhSQL("Update Message Set TinNhan='"+tn+"' Where ID='"+ID+"'");
			response.sendRedirect("GuestBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
