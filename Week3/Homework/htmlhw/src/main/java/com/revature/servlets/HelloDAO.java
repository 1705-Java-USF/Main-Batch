package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.PersonnelDAO;
import com.revature.dao.PersonnelDAOImpl;

/**
 * Servlet implementation class HelloDAO
 */
public class HelloDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public void init() throws ServletException {
		//System.out.println(this.getServletConfig().getInitParameter(""));
		System.out.println(this.getServletConfig().getServletName());
		
		Enumeration params = this.getServletConfig().getInitParameterNames();
		

		while(params.hasMoreElements()){
			String param = (String)params.nextElement();
			System.out.println(param + ": " + this.getServletConfig().getInitParameter(param));
		}
		
		Enumeration gparams = this.getServletContext().getInitParameterNames();
		
		while(gparams.hasMoreElements()){
			String param = (String)gparams.nextElement();
			System.out.println(param + ": " + this.getServletContext().getInitParameter(param));
		}
	}


	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonnelDAO pdao = new PersonnelDAOImpl();
		
		System.out.println("I am now executing actions.");
		
		response.setContentType("text/html");
		//Grab the writer of the response to utilize it to send back a dynamic webpage
		PrintWriter out = response.getWriter();
		
		//out.println("Hello "+ pdao.selectPersonnelById(1).toString());
		System.out.println(pdao.selectPersonnels().toString());
		out.println(pdao.selectPersonnels().toString());
		
		out.println(
				"<hr>" +
				"<a href='index.html'>BACK</a>");
	}

}
