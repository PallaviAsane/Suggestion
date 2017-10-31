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

/**
 * Servlet implementation class GetSuggetionController
 */
@WebServlet("/GetSuggestionController")
public class GetSuggestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Cookie usercookies[] = request.getCookies();
		int index=0;
		 for(int i=0;i<usercookies.length;i++) {
			 if(usercookies[i].getName().equals("suggestion"))
			 {
				 index=i;
				 out.print(index+ " " +usercookies[index].getValue());
			 }
//		 out.print("i is::<br>"+usercookies[i].getName()+" <br>"+usercookies[0].getValue()+" <br>");//printing
//////		 name and value of cookie
//		 out.print(usercookies[1].getValue());
		 }
		if (usercookies[index].getValue().equalsIgnoreCase("java")) {
//			 out.print("if"+usercookies[index].getValue());
			RequestDispatcher rd = request
					.getRequestDispatcher("JavaResourceController");
			rd.forward(request, response);
		} else if (usercookies[index].getValue().equalsIgnoreCase("php")) {
//			 out.print("else"+usercookies[index].getValue());
						RequestDispatcher rd = request
					.getRequestDispatcher("PhpResourceController");
			rd.forward(request, response);
		}

	}

}
