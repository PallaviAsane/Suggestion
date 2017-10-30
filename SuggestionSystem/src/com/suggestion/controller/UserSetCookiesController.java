package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suggestion.InterfaceServiceImpliment.CookiesServiceImplement;
import com.suggestion.model.Cookies;

/**
 * Servlet implementation class UserSetCookiesController
 */
@WebServlet("/UserSetCookiesController")
public class UserSetCookiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String resourcename=request.getParameter("resourcename");
//		String usercookie=(String) request.getSession().getAttribute("usercookie");
		
		Cookie usercookie[]=request.getCookies();
		int cookieid=Integer.parseInt(usercookie[1].getValue());
		CookiesServiceImplement cookieservice=new CookiesServiceImplement();
		Cookies cookie=new Cookies(cookieid, resourcename,cookieid);
		boolean addcookie=cookieservice.addCookies(cookie);
		HttpSession resourcesession=request.getSession(true);
		resourcesession.setAttribute("resourcename", resourcename);
		RequestDispatcher rd=request.getRequestDispatcher("/JavaResourceController");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	    Cookie passwordcookie[]=request.getCookies();
//	    out.print(" password "+passwordcookie[1].getValue());
	    
//	    <%-- <h4>
//		Welcome
//		<%
//		String uid = (String) request.getSession().getAttribute("name");
//		out.print(uid);
//	%>
//	</h4> --%>
//
//	<h3>Welcome to home page</h3>
//	<%
//		Cookie ck[] = request.getCookies();
//		for (Cookie c : ck) {
//			out.print("  name :: " + c.getName() + "  Value is : " + c.getValue());
//		}
//	%>
	    
		
	}

}
