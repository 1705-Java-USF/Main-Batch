package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
//@WebServlet(urlPatterns="/EmployeeLookup")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		String id = request.getParameter("eid");
		PrintWriter pw = response.getWriter();
		
		
		if(id.equals("1")){
			pw.write(
					"<employees>"
					+ "<employee>"
					+ "<eid>1</eid>"
					+ "<first>Bobbert</first>"
					+ "<last>Bobson</last>"
					+ "</employee>"
					+ "</employees>"
					);
		}
		if(id.equals("2")){
			pw.write(
					"<employees>"
					+ "<employee>"
					+ "<eid>2</eid>"
					+ "<first>Ryan</first>"
					+ "<last>Lessley</last>"
					+ "</employee>"
					+ "</employees>"
					);			
		}
		if(id.equals("3")){
			pw.write(
					"<employees>"
					+ "<employee>"
					+ "<eid>3</eid>"
					+ "<first>Edgar</first>"
					+ "<last>Edgarson</last>"
					+ "</employee>"
					+ "</employees>"
					);			
		}
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
