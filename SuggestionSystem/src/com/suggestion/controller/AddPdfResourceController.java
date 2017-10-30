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

import com.suggestion.InterfaceServiceImpliment.PdfResourceInterfaceService;
import com.suggestion.model.PdfResource;

/**
 * Servlet implementation class PdfResourceController
 */
@WebServlet("/AddPdfResourceController")
public class AddPdfResourceController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(AddPdfResourceController.class);
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
		
		String PdfName=request.getParameter("pdfname");
		
		String PdfCategory=request.getParameter("pdfcategory");
		
        String PdfAuthor=request.getParameter("pdfauthor");
		
		String PdfSize=request.getParameter("pdfsize");
		
//		writer.print("in pdf controller" + PdfName + " " +PdfSize);
		
		PdfResource pr=new PdfResource(PdfName,PdfCategory,PdfAuthor,PdfSize);
		PdfResourceInterfaceService pr1=new PdfResourceInterfaceService();
		
		boolean result=pr1.addPdfResource(pr);
		logger.info(result);
		if(result==true)
		{
		writer.append("<html><body>sucessfully Inserted pdf</body></html>");
		RequestDispatcher rs=request.getRequestDispatcher("AddPdfResource.jsp");
		rs.include(request, response);
		}
		else
		{
			writer.append("Resource not inserted");
			RequestDispatcher rs=request.getRequestDispatcher("AddPdfResource.jsp");
			rs.include(request, response);
		}
	}

}
