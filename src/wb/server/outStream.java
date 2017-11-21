package wb.server;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/outStream")
public class outStream extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public outStream() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Disposition", "attachment;filename=hinhanh.jpg");
		response.setContentType("image/jpg");
		FileInputStream input=new FileInputStream("E:/CNTT/LTWEB/img.jpg");
		byte[] bufer=new byte[2048];
		int byteRead;
		OutputStream out=response.getOutputStream();
		while((byteRead=input.read(bufer))>0){
			out.write(bufer,0,byteRead);
		}
		input.close();
	}

}
