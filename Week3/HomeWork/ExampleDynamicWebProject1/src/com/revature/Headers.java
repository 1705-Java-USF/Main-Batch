package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Headers extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String Money = request.getParameter("Money");
		String Henny = request.getParameter("Henny");
		String Other = request.getParameter("Other");
		String No_Tip = request.getParameter("No_Tip");
		String Gender = request.getParameter("Gender");
		String select = request.getParameter("select");
		
		out.println("<table border='1px'><tr><th>Question</th><th>Your Answer</th></tr>");
		
		String answer;
		
		
			out.println("<tr><td> Username </td><td>" + username + "</td>");
			out.println("<tr><td> Password </td><td>" + password + "</td>");
			out.println("<tr><td> Username </td><td>" + email + "</td>");
			out.println("<tr><td> Password </td><td>" + age + "</td>");
			out.println("<tr><td> Tip </td><td>" + Money + " " + Henny+ " " + Other + " "+ No_Tip + "</td>");
			out.println("<tr><td> Gender </td><td>" + Gender + "</td>");
			out.println("<tr><td> Montage Music </td><td>" + select + "</td>");
			
		
		out.println("</table>");
		out.println("<hr>" +
		             "<a href= 'index.html'>BACK</a>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
