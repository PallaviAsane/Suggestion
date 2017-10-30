<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Resources</title>
<style>
.vertical-menu {
    width: 200px;
}

.vertical-menu a {
    background-color: #eee;
    color: black;
    display: block;
    padding: 12px;
    text-decoration: none;
}

.vertical-menu a:hover {
    background-color: #ccc;
}

.vertical-menu a.active {
    background-color: #4CAF50;
    color: white;
}
.searchinputbox {

    background: url("/site/css/images/fld.gif") no-repeat scroll 0 0 transparent;

    border: 0 none;

    color: #666666;

    height: 22px;

    padding: 0;

    text-align: center;

    vertical-align: middle;

    width: 228px;

}
</style>
</head>
<body>
<form action="HomeController" method="post">
<h3 align="right">
Welcome
<%
String username = (String) request.getSession().getAttribute("name");
out.print(username);
%>
</h3>
<h3 slign="right">Logout
<%HttpSession logout=request.getSession();  
logout.invalidate();  

out.print("You are successfully logged out!");   %>
</h3>
<div align="center">
<input type="text" name="resourcename" placeholder="Search">
<input type="submit" name="submit" value="Search">
</div>
<p align="right">
kjgjgjgjg</p>
</form>
<form action="#" method="post">

<div class="vertical-menu">
  <a href="#" class="active">Resource</a>
  <a href="#">File Resource</a>
  <a href="#">PPT Resource</a>
<!--   <a href="#">Link 3</a>
  <a href="#">Link 4</a> -->
</div>
<div align="center">
<%@ page import="java.util.ArrayList"
import="java.util.Iterator" 
import="com.suggestion.model.FileResource"%>
<table border='2'>
<%
try{
	ServletContext fileresource=getServletContext();
	if (fileresource.getAttribute("filelist") != null) {
		

	ArrayList<FileResource> filelist=(ArrayList<FileResource>)fileresource.getAttribute("filelist");
	
Iterator<FileResource> it=filelist.iterator();

while(it.hasNext())
{
%>
<tr><td>  &nbsp;&nbsp;&nbsp;  <%= it.next().getFilename() %>  </td>
</tr>
<%}}else{ %><tr><td>no data in array</td></tr>
<%}}catch(Exception e){out.print(e);} %>

</table>
</div>
</form>
</body>
</html>