package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutServlet
 */
public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// display a html file with data from the form submitted
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
		out.println("<script>$(function(){$(\"#includedContent\").load(\"travel.html\"); });</script>");
		out.println("<div id=\"includedContent\"></div>");
		out.println("<h3 style=\"margin-left: 40px\">The following travel suggestion has been submitted:</h3>");
		Enumeration<String> params = request.getParameterNames();
		out.println("<table class=\"table table-condensed\" style=\"margin-left: 60px\"><thead><tr>"
				+ "<th>Question</th><th>Answer</th></tr></thead><tbody>"); 
		String param;
		while(params.hasMoreElements()) {
			param = params.nextElement();
			out.println("<tr><td>" + param + "</td><td>" + request.getParameter(param) + "</td></tr>");
		}
		out.println("</tbody></table>");
	}

}
