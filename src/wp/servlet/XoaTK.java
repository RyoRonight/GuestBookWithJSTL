package wp.servlet;

import java.sql.ResultSet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.servlet.MyConnection;

@WebServlet("/XoaTK")
public class XoaTK extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	
    public XoaTK() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID");
		try {
			new MyConnection().thucThiCauLenhSQL("delete from Message where ID='"+ID+"'");
			response.sendRedirect("GuestBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
