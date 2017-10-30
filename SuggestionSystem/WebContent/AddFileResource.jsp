<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Resource</title>
</head>
<body>
<form action="HomeController"  method="post">

FileName      <input type="text" name="filename"  placeholder="Name of file"><br>
<br>
FileCategory  <input type="text" name="filecategory" placeholder="Category of file "><br>
<br>
<br>
FileAuthor    <input type="text" name="fileauthor" placeholder="Author of file "><br>
<br>
<br>
FileSize      <input type="text" name="filesize" placeholder="Size of file "><br>
<br>
<br>

<input type="submit" name="submit"  value="Insert File Resource">
</form>
 
</body>
</html>