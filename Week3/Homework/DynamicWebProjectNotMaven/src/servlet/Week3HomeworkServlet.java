package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Week3HomeworkServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = new PrintWriter(response.getWriter());
		pw.println("<body><table>");
		pw.println("<th>Variable Name</th><th>Value</th>");
		
		Enumeration<String> params = request.getParameterNames();
		for(String param = params.nextElement(); params.hasMoreElements(); param = params.nextElement())
			pw.println("<tr><td>" + param + "</td><td>" + request.getParameter(param) + "</td></tr>");
		
		pw.println("</table></body>");
	}
}