package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 

@WebServlet("/LoadGuestBook")
public class LoadGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadGuestBook() {
        super();
      
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0");
		out.println("Transitonal//EN\">\n");
		out.println("<html><head><title>GuestBook JDBC</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"></head>\n<body>");
		
		// Create a variable for the connection string.  
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=GuestBook;user=sa;password=sa";  

	      // Declare the JDBC objects.  
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  

	      try {  
	         // Establish the connection.  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(connectionUrl);  

	         // Create and execute an SQL statement that returns some data.  
	         String SQL = "SELECT * FROM Message";  
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  

	         // Iterate through the data in the result set and display it.
	         out.println("<table border="+"'1'"+">");
	         out.println("<tr>"
	 				+ "<th>ID</th>"
	 				+ "<th>Name</th>"
	 				+ "<th>Message</th> "
	 				+ "</tr>");
	         while (rs.next()) {  
	        	 out.println("<tr>" + "<td>" + rs.getString(1)+ "</td>"
	            		+ "<td>" + rs.getString(2) + "</td>"
	            		+ "<td>" + rs.getString(3) + "</td>"
	            		+ "</tr>");
	         }  
	      }  

	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }  
	      finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	         if (con != null) try { con.close(); } catch(Exception e) {}  
	      }  
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
