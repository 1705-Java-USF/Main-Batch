package com.revature.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.dao.EmployDAO;
import com.revature.dao.EmployImplDAO;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// control log in and log out page 
		// create session for employees once logged in
		String url = request.getRequestURI();		
		String[] tokens = url.split("/");		
		String action = tokens[tokens.length-1];		
		action = action.substring(0, action.length()-3).toLowerCase();
		RequestDispatcher rd = null;
		HttpSession session = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		switch(action){
			case "login":
				request.setAttribute("issue", null);
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				EmployDAO dao = new EmployImplDAO();
				int id = dao.loginEmployee(username, password);
				if (id != 0) {
					session = request.getSession();
					Employee e = dao.selectEmployee(id);
					session.setAttribute("user", e.getUsername());
					session.setAttribute("f_name", e.getFirstname().toUpperCase());
					session.setAttribute("l_name", e.getLastname().toUpperCase());
					session.setAttribute("eid", id);
					session.setAttribute("isManager", ( e.getTitle().equalsIgnoreCase("manager") ));
					session.setMaxInactiveInterval(1800); // set timeout to 30 mins
					logger.info("Logged in " + e.toString() + " at " + sdf.format(new Date(System.currentTimeMillis())));
				} else {
					request.setAttribute("issue", "INVALID CRENDENTIALS");
				}
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			case "logout":
				logger.info("Logged out " + request.getSession().getAttribute("user") + " at " 
						+ sdf.format(new Date(System.currentTimeMillis())));
				request.getSession().invalidate();
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			default:
				logger.info("Incorrect Login Information at" + sdf.format(new Date(System.currentTimeMillis())));
				response.sendError(404);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
