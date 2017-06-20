package com.revature.homework3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateTable
 */
@WebServlet("/CreateTable")
public class CreateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(session.isNew()){
			out.println("Information Saved For " + request.getParameter("user"));
			session.setAttribute("user", request.getParameter("user"));
			session.setAttribute("password", request.getParameter("password"));
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("number", request.getParameter("number"));
			session.setAttribute("cbcom", request.getParameter("cbcom"));
			session.setAttribute("cbhor", request.getParameter("cbhor"));
			session.setAttribute("cbsci", request.getParameter("cbsci"));
			session.setAttribute("cbrom", request.getParameter("cbrom"));
			session.setAttribute("cbthrill", request.getParameter("cbthrill"));
			session.setAttribute("PreferredAthlete1", request.getParameter("PreferredAtlete1"));
			session.setAttribute("PreferredAthlete2", request.getParameter("PreferredAtlete2"));
			session.setAttribute("PreferredAthlete3", request.getParameter("PreferredAtlete3"));
			session.setAttribute("PreferredAthlete4", request.getParameter("PreferredAtlete4"));
			session.setAttribute("PreferredAthlete5", request.getParameter("PreferredAtlete5"));
			session.setAttribute("PreferredAthlete6", request.getParameter("PreferredAtlete6"));
			session.setAttribute("PreferredAthlete7", request.getParameter("PreferredAtlete7"));
			session.setAttribute("games", request.getParameter("games"));
		}
		else{
			out.println("UNABLE TO SAVE INFORMATION");
			out.println("CURRENTLY LOGGED IN AS:" + ((String) session.getAttribute("user")));
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

