package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// any invalid url will redirect to custom 404 page
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<html>"
				+ "<head><title>ERROR</title><link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/default.css\"></head>"
				+ "<body>"
				+ "The Status code : " + statusCode 
				+ "<br> You have entered an invalid URL. Please select the 'LOGIN' link below to be redirected to the login page." 
				+ "<hr><a href='index.jsp'>LOGIN</a>"	
				+ "</body></html>"
				);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
