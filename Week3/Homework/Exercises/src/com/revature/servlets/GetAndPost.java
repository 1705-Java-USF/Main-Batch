package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAndPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * service() will call doGet in the event of the GET HTTP Protocol
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("first");
		String lastname = request.getParameter("last");
		
		response.setContentType("text/html");
		
		out.println(
				"<ul>" +
						"<li>First Name: " + firstname + "</li>" +
						"<li>Last Name: " + lastname + "</li>" +
				"</ul>"
				);
		
		out.println(
				"<hr>" + 
				"<hr>" +
				"<a href='index.html'>back</a>"
				);
	}

	/*
	 * service() will call doPost ------------------ POST HTTP Protocol
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("first");
		String lastname = request.getParameter("last");
		
		response.setContentType("text/html");
		
		Enumeration params = request.getParameterNames();
		
		out.println("<ul>");
		String param;
		while(params.hasMoreElements()){
			param = (String)params.nextElement();
			out.println("<li>"+param+": "+request.getParameter(param)+"</li>");
		}
		
		out.println(
				"<hr>" + 
				"<hr>" +
				"<a href='index.html'>back</a>"
				);
	}

}
