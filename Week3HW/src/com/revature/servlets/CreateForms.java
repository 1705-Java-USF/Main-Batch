package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateForms
 */
@WebServlet("/CreateForms")
public class CreateForms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table><tr><td> Username: </td><td>" + username + "</td></tr>"
				+ "<tr><td> Password: </td><td>" + password + "</td></tr>"
			
		
		+ "</table>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<ul>");
		String param;
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()){
			param = (String)params.nextElement();
			out.println("<li>" + param + ": " + request.getParameter(param) + "</li>");
		}
		
		out.println("</ul>");
	}

}
