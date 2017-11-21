package wp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Download() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "inline;filename=Chien.jpg");
		//read the image from disk
		FileInputStream in = new FileInputStream("D:/LapTrinh/JAVA/Project02_Basicvervlet/WebContent/Chien.jpg");
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0) {
			//write the mimage to the response
			out.write(buffer, 0, bytesRead);
		}
		in.close();
	}

}
