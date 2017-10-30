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

PdfName      <input type="text" name="pdfname"  placeholder="Name of pdf"><br>
<br>
PdfCategory  <input type="text" name="pdfcategory" placeholder="Category of pdf "><br>
<br>
<br>
PdfAuthor    <input type="text" name="pdfauthor" placeholder="Author of pdf "><br>
<br>
<br>
PdfSize      <input type="text" name="pdfsize" placeholder="Size of pdf "><br>
<br>
<br>

<input type="submit" name="submit"  value="Insert Pdf Resource">
</form>
</body>
</html>