package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.suggestion.InterfaceServiceImpliment.UserInterfaceService;
import com.suggestion.model.User;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	Logger logger=Logger.getLogger(UserRegistrationController.class);
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		if(password.equals(confirmpassword))
		{
		UserInterfaceService userservice=new UserInterfaceService();
		
				User user=new User(username,password);
				boolean adduser=userservice.addUser(user);	
		
		
		if(adduser==true)
		{
//			out.print(adduser);
		RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
			rd.include(request, response);
		}

		}
		else{
//			out.print("Password and confirm password not match");
			RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
			rd.include(request, response);
			

		}
	}

}
