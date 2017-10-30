<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
<form action="HomeController" method="post">
User name <input type="text" name="username" placeholder="Name of User">
<br>
<br>
Password <input type="password" name="password" placeholder="Password">
<br>
<br>
<input type="submit" name="submit" value="User Login">
</form>
</body>
</html>