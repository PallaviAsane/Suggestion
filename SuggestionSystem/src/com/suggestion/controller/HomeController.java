package com.suggestion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("submit");
		
		if(action.equals("Login as Admin"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/AdminLoginController");
			rd.forward(request, response);
		}
		
		else if(action.equals("Login as User"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("User Login"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/UserLoginController");
			rd.forward(request, response);
		}
		else if(action.equals("Register New User"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/UserRegistrationController");
			rd.forward(request, response);
		}
		else if(action.equals("Search"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/UserSetCookiesController");
			rd.forward(request, response);
		}
		
		
	}

}
