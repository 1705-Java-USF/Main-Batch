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

/**
 * Servlet implementation class PromoteServlet
 */
public class PromoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// promote employee title with given employee_id
		int e_id = Integer.parseInt(request.getParameter("eid"));
		EmployDAO dao = new EmployImplDAO();
		dao.promoteEmployee(e_id);
		
		// log promote employee
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		logger.info(request.getSession().getAttribute("user") + " promoted " + e_id + " at " 
		+ sdf.format(new Date(System.currentTimeMillis())));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
