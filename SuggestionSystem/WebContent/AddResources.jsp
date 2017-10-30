<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="HomeController" method="post">

<input type="submit" value="Insert File" name="submit">

<input type="submit" value="Insert Pdf" name="submit">

<input type="submit" value="Insert Ppt" name="submit">

<input type="submit" value="Logout" name="submit"/>
<h3 align="right">
Welcome
<%
String username = (String) request.getSession().getAttribute("name");
out.print(username);
%>
</h3>

</form>
</body>
</html>