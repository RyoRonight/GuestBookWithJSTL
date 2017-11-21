package wp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEmtry;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public DeleteEntry() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEmtry> entries=(ArrayList<GuestBookEmtry>) getServletContext().getAttribute("entries");  
		long id=Long.parseLong(request.getParameter("id"));
		for(GuestBookEmtry entry:entries){
			if(entry.getId()==id){
				entries.remove(entry);
				break;
			}
			
		}
		response.sendRedirect("GuestBook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<GuestBookEmtry> entries = (List<GuestBookEmtry>)getServletContext().getAttribute("entries");
		//lấy dữ liệu từ form
		//String name = request.getParameter("name");
		//String message = request.getParameter("message");
		//int index = Integer.parseInt(request.getParameter("index"));//cập nhật lại
		//entries.get(index).setName(name);
		//entries.get(index).setMessage(message);
		//response.sendRedirect("GuestBook");//gữi giá trị entries đến trang GuestBook
		/*for(int i=0; i<entries.size(); i++) //duyệt từng entries và ghi vào từng dòng
		{
			GuestBookEmtry entry = entries.get(i);
			int id = i + 1;
			entry.setId(id);
			response.sendRedirect("GuestBook");
		}*/
	}

}
