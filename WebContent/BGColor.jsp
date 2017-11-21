<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="bg" class="model.BGBean" scope="session"/> 
    <jsp:setProperty name="bg" property="r" param="red"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:rgb(<jsp:getProperty name="bg" property="r"/>,
							<jsp:getProperty name="bg" property="g"/>,
							<jsp:getProperty name="bg" property="b"/>);">

</body>
</html>