package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomForm
 */
public class RandomForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RandomForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		Enumeration params = request.getParameterNames();
		
		out.println("<table border='1px'>");
		String param;
		while(params.hasMoreElements()){
			param = (String)params.nextElement();
			out.println("<tr><td>"+param+"<td>"+request.getParameter(param));
		}
		
		out.println(
				"</table><hr>" + 
				"<hr>" +
				"<a href='forms.html'>back</a>"
				);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		Enumeration params = request.getParameterNames();
		
		out.println("<table border='1px'>");
		String param;
		while(params.hasMoreElements()){
			param = (String)params.nextElement();
			out.println("<tr><td>"+param+"<td>"+request.getParameter(param));
		}
		
		out.println(
				"</table><hr>" + 
				"<hr>" +
				"<a href='forms.html'>back</a>"
				);
	}

}
