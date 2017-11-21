package wp.servlet;

import java.sql.ResultSet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.servlet.MyConnection;

@WebServlet("/ThemTK")
public class ThemTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemTK() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String Ten =request.getParameter("Ten");
		String TinNhan =request.getParameter("TinNhan");
		int ID = 0;
		try {
			ResultSet rs = new MyConnection().chonDuLieuTuDTB("select * from Message");
			while(rs.next()){
				ID = (int) rs.getInt(1);
			}
			ID++;
			new MyConnection().thucThiCauLenhSQL("insert into Message values('"+ID+"','"+Ten+"','"+TinNhan+"')");
			response.sendRedirect("GuestBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
