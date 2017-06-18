package com.htmlhmwk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<table border='1'>"
				+ "<tr> <th> Name Attribute </th> <th> Values </th> </tr>");
		String param;
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
			param = (String)params.nextElement();
			out.println("<tr> <td> " + param + " </td> <td> " + request.getParameter(param) + "</td> </tr>");
		}
		
		out.println("</table>");
		
		out.println(
				"<hr />" +
				"<a href='index.html'> BACK </a>");
	}

}
