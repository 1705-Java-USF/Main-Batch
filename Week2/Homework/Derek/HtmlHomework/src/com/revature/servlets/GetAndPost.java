package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAndPost
 */
public class GetAndPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<ul>" +
						"<li>Name: " + name + "</li>" +
				"</ul>"						
				);
		
		out.println(
				"<hr>" +
				"<a href='index.html'>BACK</a>"
				);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<table border = '1'>");		
		String param;
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
			param = (String)params.nextElement();
			out.println("<tr><td>" + param + "</td><td>" + request.getParameter(param) + "</td></tr>");
		}
		out.println("</table>");
		
		out.println(
				"<hr>" +
				"<a href='index.html'>BACK</a>"
				);
	}

}
