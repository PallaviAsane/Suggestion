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
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
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
		else if(action.equals("Logout"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/UserLogoutController");
			rd.forward(request, response);
		}
		
		else if(action.equals("Admin Login"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("/AdminLoginController");
			fr.forward(request, response);
		}
		else if(action.equals("Insert File"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("AddFileResource.jsp");
			fr.forward(request, response);
		}
		else if(action.equals("Insert Ppt"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("AddPptResource.jsp");
			fr.forward(request, response);
		}
		else if(action.equals("Insert Pdf"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("AddPdfResource.jsp");
			fr.forward(request, response);
		}
		else if(action.equals("Insert File Resource"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("/AddFileResourceController");
			fr.forward(request, response);
		}

		else if(action.equals("Insert Pdf Resource"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("/AddPdfResourceController");
			fr.forward(request, response);
		}
		else if(action.equals("Insert Ppt Resource"))
		{
			RequestDispatcher fr=request.getRequestDispatcher("/AddPptResourceController");
			fr.forward(request, response);
		}
		
		
	}

}
