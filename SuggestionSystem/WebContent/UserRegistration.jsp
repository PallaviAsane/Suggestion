<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action="HomeController" method="post">
UserName *<input type="text" name="username" required>
<br><br>
Password *<input type="password" name="password" required>
<br><br>
Confirm Password *<input type="password" name="confirmpassword" required>
<br><br>
<input type="submit" name="submit" value="Register New User">
</form>
</body>
</html>