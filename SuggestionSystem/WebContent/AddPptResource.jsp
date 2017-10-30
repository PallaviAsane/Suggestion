<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HomeController"  method="post">

PptName      <input type="text" name="pptname"  placeholder="Name of ppt"><br>
<br>
PptCategory  <input type="text" name="pptcategory" placeholder="Category of ppt "><br>
<br>
<br>
PptAuthor    <input type="text" name="pptauthor" placeholder="Author of ppt "><br>
<br>
<br>
PptSize      <input type="text" name="pptsize" placeholder="Size of ppt "><br>
<br>
<br>

<input type="submit" name="submit"  value="Insert Ppt Resource">
</form>

</body>
</html>