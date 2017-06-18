package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("I am not alive yet! Web container has called me!");
	}


	public void destroy() {
		System.out.println("Web container considers dormant, shutting me down.");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am now executing actions.");
		
		response.setContentType("text/html");
		//Grab the writer of the response to utilize it to send back a dynamic webpage
		PrintWriter out = response.getWriter();
		
		out.println("Hello world!");
		
		
		out.println(
				"<hr>" +
				"<a href='index.html'>BACK</a>"
				);
		
	}

}
