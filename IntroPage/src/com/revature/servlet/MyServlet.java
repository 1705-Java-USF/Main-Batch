package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public MyServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<ul>" );
	
		
		Enumeration headers = request.getParameterNames();
		
		out.println("<table border='1px'><tr><th>Input Name<th>Input Value" );
		
		String header;
		while(headers.hasMoreElements())
		{
			header = (String)headers.nextElement();
			//out.println(header + " " + request.getParameter(header) + "\n");
			out.println("<tr><td>"+ header +"<td>"+ request.getParameter(header));
		}
		
		
		
		out.println(
				"</table><hr>" + 
				"<hr>" +
				"<a href='form.html'>back</a>"
				);
	}

}
