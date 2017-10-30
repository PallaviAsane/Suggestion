package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.suggestion.InterfaceServiceImpliment.SuggestionServiceImplement;
import com.suggestion.InterfaceServiceImpliment.FileResourceInterfaceService;
import com.suggestion.InterfaceServiceImpliment.UserInterfaceService;
import com.suggestion.daointerface.SuggestionInterface;
import com.suggestion.model.Suggestion;
import com.suggestion.model.FileResource;
import com.suggestion.model.User;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	Logger logger=Logger.getLogger(UserLoginController.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
//		out.print(name + " " +password);
	
		UserInterfaceService userservice=new UserInterfaceService();
		int getuser=userservice.getUser(name, password);
		if(getuser>0)
		{
			HttpSession usersession=request.getSession(true);
			usersession.setAttribute("name", name);
			usersession.setAttribute("userid",String.valueOf(getuser));//creating cookie object  
//		    response.addCookie(usercookie);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserResource.jsp");
	    rd.forward(request, response);
		}
		else
			{
//				out.print("in else");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserRegistration.jsp");
			    rd.forward(request, response);
			}
//		ArrayList<User> listuser=userservice.getUser(user);
////		int usercount=0;
//		out.print(listuser);
//		for(int count=0;count<listuser.size();count++)
//		{
//			out.print(count);
//			String userid=String.valueOf(listuser.get(count).getUserid());
//		String username=listuser.get(count).getUsername();
//		String userpassword=listuser.get(count).getUserpassword();
////		out.print(" in for" + username + userpassword);
//		if(name.equals(username) && password.equals(userpassword))
//		{
//			
//		
//			Cookies cookie=new Cookies();
//			CookiesServiceImplement cookies=new CookiesServiceImplement();
//			  ArrayList<Cookies> cookielist=cookies.getsCookies(cookie);
//			  int counter=0;
//			  for(int cookiecheck=0;cookiecheck<cookielist.size();cookiecheck++)
//			  {
//				  
//				  if(cookielist.get(cookiecheck).getUserid()==Integer.parseInt(userid))
//				  {
//					  counter++;
//				  }
//			  }
//			  if(counter>0)
//			  {
////				  out.print("in if");
////				  out.print(name + " "+username + " "+ password+" "+userpassword);
//			  }
//			  else{
//			Cookie usercookie=new Cookie("userid",userid);//creating cookie object  
//			    response.addCookie(usercookie);
//			  }
//			    
//			    HttpSession usersession=request.getSession(true);
//				usersession.setAttribute("name", name);
//			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserResource.jsp");
//		    rd.forward(request, response);
//		}
//		else
//		{
//			out.print("in else");
//			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserRegistration.jsp");
//		    rd.forward(request, response);
//		}
//		}
		
	}

}
