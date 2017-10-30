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

import com.suggestion.InterfaceServiceImpliment.FileResourceInterfaceService;
import com.suggestion.InterfaceServiceImpliment.UserInterfaceService;
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
		out.print(name + " " +password);
		User user=new User();
		UserInterfaceService userservice=new UserInterfaceService();
		List<User> listuser=userservice.getUser(user);
		for(int count=0;count<listuser.size();count++)
		{
			String userid=String.valueOf(listuser.get(count).getUserid());
		String username=listuser.get(count).getUsername();
		String userpassword=listuser.get(count).getUserpassword();
		
		if(name.equals(username) && password.equals(userpassword))
		{
			  Cookie usercookie=new Cookie("userid",userid);//creating cookie object  
			    response.addCookie(usercookie);
			    
			    HttpSession usersession=request.getSession(true);
				usersession.setAttribute("name", name);
//				session.setAttribute("usercookie", usercookie);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserResource.jsp");
		    rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UserRegistration.jsp");
		    rd.forward(request, response);
		}
		}
	}

}
