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

import com.suggestion.InterfaceServiceImpliment.FileResourceInterfaceService;
import com.suggestion.model.FileResource;



/**
 * Servlet implementation class FileResourceController
 */
@WebServlet("/AddFileResourceController")
public class AddFileResourceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AddFileResourceController.class);
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
		
		String FileName=request.getParameter("filename");
		
		String FileCategory=request.getParameter("filecategory");
		
        String FileAuthor=request.getParameter("fileauthor");
		
		String FileSize=request.getParameter("filesize");
		//writer.print("in file controller" + FileName + " " +FileSize);
		
		FileResource fr=new FileResource(FileName,FileCategory,FileAuthor,FileSize);
		FileResourceInterfaceService fr1=new FileResourceInterfaceService();
		boolean result=fr1.addFileResource(fr);
		logger.info(result);
		if(result==true)
		{
		writer.append("<html><body>sucessfully Inserted File</body></html>");
		RequestDispatcher rs=request.getRequestDispatcher("AddFileResource.jsp");
		rs.include(request, response);
		}
		else
		{
			writer.append("Resource not inserted");
			RequestDispatcher rs=request.getRequestDispatcher("AddFileResource.jsp");
			rs.include(request, response);
		}
	}

}
