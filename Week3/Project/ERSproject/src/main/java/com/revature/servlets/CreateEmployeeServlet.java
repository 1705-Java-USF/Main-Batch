package com.revature.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.EmployDAO;
import com.revature.dao.EmployImplDAO;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class CreateEmployeeServlet
 */
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create employee object with input and insert into database
		EmployDAO dao = new EmployImplDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String title =  request.getParameter("title");
		dao.createEmployee(new Employee(0, username, password, fname.toUpperCase(), lname.toUpperCase(), email, title));
		
		// log registering employee
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		logger.info(request.getSession().getAttribute("user") + " registered " + username + " at " 
		+ sdf.format(new Date(System.currentTimeMillis())));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);		
	}

}
