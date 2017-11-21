<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sửa Tin Nhắn</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Sửa Tin Nhắn Nè HiHi!!!</h2>
		<form class="form-horizontal" action="SuaTinNhan" method="post">
		    </div>
		    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Tên:</label>
			      <div class="col-sm-10">          
			        	<p><%
			        		ServletContext context2 = getServletContext();
			       	 		out.print(context2.getAttribute("Ten"));
			        	%></p>
			      </div>
		    </div>
		  	<div class="form-group">
		      	<label class="control-label col-sm-2" for="pwd">Tin Nhắn:</label>
		      	<div class="col-sm-10">          
		        	<input type="text" class="form-control" id="pwd" name="TinNhan" placeholder="Nhập Vào Message" value="<%
		        		ServletContext context3 = getServletContext();
		       	 		out.print(context3.getAttribute("TinNhan"));
		        	%>">
		      	</div>
		    </div>
		    <div class="form-group">        
		      	<div class="col-sm-offset-2 col-sm-10">
		        	<button type="submit" class="btn btn-default">Sửa</button>
		      	</div>
		    </div>
	  	</form>
	</div>
</body>
</html>