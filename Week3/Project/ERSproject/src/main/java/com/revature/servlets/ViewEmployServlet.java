package com.revature.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.dao.EmployDAO;
import com.revature.dao.EmployImplDAO;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class ViewEmployServlet
 */
public class ViewEmployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select all employees and send as a json object
		EmployDAO dao = new EmployImplDAO();
		Collection<Employee> e = dao.selectAllEmployees();
		String json = new Gson().toJson(e);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
