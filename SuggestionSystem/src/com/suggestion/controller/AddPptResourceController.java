package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.suggestion.InterfaceServiceImpliment.PptResourceInterfaceService;
import com.suggestion.model.PptResource;

/**
 * Servlet implementation class PptResourceController
 */
@WebServlet("/AddPptResourceController")
public class AddPptResourceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AddPptResourceController.class);
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
		
		String PptName=request.getParameter("pptename");
		
		String PptCategory=request.getParameter("pptcategory");
		
        String PptAuthor=request.getParameter("pptauthor");
		
		String PptSize=request.getParameter("pptsize");
		
		//writer.print("in file controller" + PptName + " " +PptSize);
		
		PptResource pr=new PptResource(PptName,PptCategory,PptAuthor,PptSize);
		PptResourceInterfaceService pr1=new PptResourceInterfaceService();
		
		boolean result=pr1.addPptResource(pr);
		logger.info(result);
		if(result==true)
		{
		writer.append("<html><body>sucessfully Inserted ppt</body></html>");
		RequestDispatcher rs=request.getRequestDispatcher("AddPptResource.jsp");
		rs.include(request, response);
		}
		else
		{
			writer.append("Resource not inserted");
			RequestDispatcher rs=request.getRequestDispatcher("AddPptResource.jsp");
			rs.include(request, response);
		}
	}

}

