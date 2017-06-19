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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<script>document.getElementById(\"TravelForm\").style.visibility = \"hidden\";</script>");
		out.println("<h3>The following form has been submitted:</h3>");
		Enumeration<String> headers = request.getHeaderNames();
		out.println("<table border='1px'><tr><th>Question</th><th>Answer</th></tr>"); 
		String header;
		while(headers.hasMoreElements()) {
			header = headers.nextElement();
			out.println("<tr><td>" + header + "</td><td>" + request.getHeader(header) + "</td></tr>");
		}
		out.println("</table>");
	}

}
