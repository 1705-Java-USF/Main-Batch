package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration<String> params = request.getParameterNames();
		
		out.println("<table border='1px'><tr><th>Field Name</th><th>Value(s) Entered</th></tr>");
		
		String param;
		while(params.hasMoreElements()) {
			param = (String) params.nextElement();
			out.println("<tr><td>" + param + "</td><td>" + Arrays.toString(request.getParameterValues(param)) + "</td></tr>");
		}
		out.println("</table>");
	}
}
