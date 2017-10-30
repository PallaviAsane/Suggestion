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

import com.suggestion.InterfaceServiceImpliment.SuggestionServiceImplement;
import com.suggestion.model.Suggestion;

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
		String userid=(String) request.getSession().getAttribute("userid");
		
		Cookie usercookie=new Cookie("suggestion" , resourcename);//creating cookie object  
	    response.addCookie(usercookie);
	    RequestDispatcher rd=request.getRequestDispatcher("GetSuggestionController");
		rd.forward(request, response);

//	    out.print(usercookie);
//		Cookie usercookies[]=request.getCookies();
//		int cookieid=Integer.parseInt(usercookies[1].getValue());
//		for(int i=0;i<usercookies.length;i++) 
//			 out.print("i is::"+i+"<br>"+usercookies[i].getName()+" "+usercookies[i].getValue());//printing name and value of cookie
//			 out.print(usercookies[1].getValue());
//		if(usercookies[1].getValue().contains("java"))
//			 {
////				out.print(true); 
//			 RequestDispatcher rd=request.getRequestDispatcher("JavaResourceController");
//			rd.forward(request, response);
//			 }
//			 else if(usercookies[1].getValue().contains("php"))
//			 {
//			 RequestDispatcher rd=request.getRequestDispatcher("PhpResourceController");
//			rd.forward(request, response);
//			 }
//			}  
//		out.print(usercookies);
//		CookiesServiceImplement cookieservice=new CookiesServiceImplement();
//		Cookies getcookie=cookieservice.getCookies(cookieid);
//		
//		HttpSession resourcesession=request.getSession(true);
//		if(cookieid==getcookie.getCookieid())
//		{
//			
//			String resource=getcookie.getCookiename();
//			resourcesession.setAttribute("resourcename", resource);
////			RequestDispatcher rd=request.getRequestDispatcher("/JavaResourceController");
////			rd.forward(request, response);
//		}
//		else{
//			Cookies cookie=new Cookies(cookieid, resourcename,cookieid);
//			boolean addcookie=cookieservice.addCookies(cookie);
//		resourcesession.setAttribute("resourcename", resourcename);
////		RequestDispatcher rd=request.getRequestDispatcher("/JavaResourceController");
////		rd.forward(request, response);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
