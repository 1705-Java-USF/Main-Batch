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
 * Servlet implementation class UpdateAccountServlet
 */
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update employee with input
		EmployDAO dao = new EmployImplDAO();
		int e_id = (int) request.getSession().getAttribute("eid");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		request.getSession().setAttribute("f_name", fname);		
		String lname = request.getParameter("lname");
		request.getSession().setAttribute("l_name", lname);
		String email = request.getParameter("email");
		dao.updateEmployee(new Employee(e_id, username, password, fname.toUpperCase(), lname.toUpperCase(), email, null));
		
		// log update employee
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		logger.info(request.getSession().getAttribute("user") + " updated account at " 
		+ sdf.format(new Date(System.currentTimeMillis())));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
