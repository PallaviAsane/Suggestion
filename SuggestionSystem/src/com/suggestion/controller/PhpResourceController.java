package com.suggestion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suggestion.InterfaceServiceImpliment.FileResourceInterfaceService;
import com.suggestion.InterfaceServiceImpliment.PptResourceInterfaceService;
import com.suggestion.model.FileResource;
import com.suggestion.model.PptResource;

/**
 * Servlet implementation class PhpResourceController
 */
@WebServlet("/PhpResourceController")
public class PhpResourceController extends HttpServlet {
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
//		String resourcename=(String) request.getSession(true).getAttribute("resourcename");
		FileResourceInterfaceService fileservice=new FileResourceInterfaceService();
		ArrayList<FileResource> filelist=fileservice.getFileResourcebyCategory("php");
		PptResourceInterfaceService pptservice=new PptResourceInterfaceService();
		ArrayList<PptResource> pptlist=pptservice.getPptResourcebyCategory("php");
		ServletContext resources=getServletContext();
		resources.setAttribute("filelist",filelist);
		resources.setAttribute("pptlist",pptlist);
		RequestDispatcher rd=request.getRequestDispatcher("UserResource.jsp");
		rd.forward(request, response);
	}

}
