package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
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
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String userId=request.getParameter("adminname");
		
		String password=request.getParameter("password");
		
		if( userId.equals("Admin") && password.equals("123") )
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("name", userId);
			RequestDispatcher fr=request.getRequestDispatcher("AddResources.jsp");
			fr.forward(request, response);
		
		}
		else{
			RequestDispatcher fr=request.getRequestDispatcher("AdminLogin.jsp");
			fr.include(request, response);

		}
	}
    public void init()
    {
    	
    }	
}


