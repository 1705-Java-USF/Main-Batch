package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetAndPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String exercising = request.getParameter("exercising");
		String sleeping = request.getParameter("sleeping");
		String eating = request.getParameter("eating");
		String programming = request.getParameter("programming");
		String dog = request.getParameter("dog");
		String cat = request.getParameter("cat");
		String other = request.getParameter("other");
		String gender = request.getParameter("gender");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table border='1px'><tr><th>Categories</th><th>Inputs</th></tr>");
		out.println(
					" <tr><td>Username: </td><td>" + username + "</td></tr>" +
					"<tr><td>Password: </td><td>" + password + "</td></tr>" +
					"<tr><td>exercising: </td><td>" + exercising + "</td></tr>" +
					"<tr><td>sleeping: </td><td>" + sleeping + "</td></tr>" +
					"<tr><td>eating: </td><td>" + eating + "</td></tr>" +
					"<tr><td>programming: </td><td>" + programming + "</td></tr>" +
					"<tr><td>dog: </td><td>" + dog + "</td></tr>" +
					"<tr><td>cat: </td><td>" + cat + "</td></tr>" +
					"<tr><td>other: </td><td>" + other + "</td></tr>" +
					"<tr><td>gender: </td><td>" + gender + "</td></tr>"
				);
		out.println("</table>");
		out.println(
				"<hr>" +
				"<a href='forms.html'>BACK</a>"
				);
	}	

}
