<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ page import="wp.servlet.MyConnection" %>
    <%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GuestBook SQL</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		MyConnection con = new MyConnection();
		ResultSet rs = con.chonDuLieuTuDTB("select * from Message");		
	%>
	<table class="table table-hover" id="dev-table"> 
		<thead> 
			<tr> 
				<th>ID</th> 
				<th>Tên</th> 
				<th>Tin Nhắn</th>
				<th>Xóa</th>
				<th>Sửa</th>
			</tr> 
		</thead> 
		<tbody>
			<%
				while(rs.next()){
			%>
						
			<tr> 
				<td><%=rs.getString(1) %></td> 
				<td><%=rs.getString(2) %></td> 
				<td><%=rs.getString(3) %></td>
				<td><a href="XoaTK?ID=<%=rs.getString(1)%>"><button class="btn btn-warning">Xóa</button></a></td>
				<td><a href="SuaTinNhan?ID=<%=rs.getString(1)%>"><button class="btn btn-primary">Sửa</button></a></td> 
			</tr> 
			<%
				}
			%>
						
		</tbody>
	</table>
	<a href="ThemTaiKhoan.jsp"><button class="btn btn-primary">Thêm</button></a> 
</body>
</html>