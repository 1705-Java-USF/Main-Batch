package com.revature.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.Login;
import com.revature.services.MyLogger;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] tokens = request.getRequestURI().split("/");
		MyLogger.logger.trace("tokens: " + Arrays.toString(tokens));
		
		String action = tokens[tokens.length-1];
		MyLogger.logger.trace("Action: " + action);
		action = action.substring(0, action.length()-3).toLowerCase();
		MyLogger.logger.trace("action: " + action);
		
		RequestDispatcher rd = null;
		HttpSession session = null;
		
		String username = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		User user = null;
		Reimbursement reim = null;
		List<Reimbursement> reimbursements = null;
		List<User> employees = null;
		
		
		UserDao userDao = new UserDaoImpl();
		ReimbursementDao reimDao = new ReimbursementDaoImpl();
		switch(action) {
		case "login":
			username = request.getParameter("username");
			password = request.getParameter("password");
			request.setAttribute("issue", null);
			Login vl = new Login();
			if(vl.validateLogin(username, password)) {
				session = request.getSession();
				user = userDao.selectUserByUsername(username);
				session.setAttribute("email", user.getEmail());
				session.setAttribute("user", user);
				session.setAttribute("role", userDao.getRoleById(((User)session.getAttribute("user")).getRoleId()));
			} else {
				request.setAttribute("issue", "INVALID CREDENTIALS!");
			}
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "update":
			session = request.getSession();
			request.setAttribute("issue", null);
			user = (User)session.getAttribute("user");
			System.out.println("Old password: " + request.getParameter("oldpassword"));
			System.out.println("User password: " + user.getPassword());
			if(request.getParameter("oldpassword").equals(user.getPassword())) {
				username = request.getParameter("username");
				password = request.getParameter("newpassword");
				firstName = request.getParameter("firstName");
				lastName = request.getParameter("lastName");
				email = request.getParameter("email");
				
				if(password != null && !password.equals(""))
					user.setPassword(password);
				if(firstName != null)
					user.setFirstName(firstName);
				if(lastName != null)
					user.setLastName(lastName);
				if(email != null) {
					if(userDao.selectUserByEmail(email) == null)
						user.setEmail(email);
					else
						request.setAttribute("issue", "Email is already taken!");
				}
				if(username != null && !username.equals("")) {
					if(userDao.selectUserByUsername(username) == null) {
						user.setUsername(username);
					}
					else {
						request.setAttribute("issue", "Username is already taken!");
					}
				}
				if(userDao.updateUser(user)) {
					session.setAttribute("user", user);
				}
			} else {
				request.setAttribute("issue", "Incorrect Password!");
			}
			rd = request.getRequestDispatcher("PersonalInformation.jsp");
			rd.forward(request, response);
			break;
		case "reimbursements":
			session = request.getSession();
			reimbursements = new ArrayList<Reimbursement>();
			if(request.getParameter("status") != null) {
				if(request.getParameter("status").equals("All"))
					reimbursements = reimDao.selectReimbursementsByAuthorId(((User)session.getAttribute("user")).getId());
				else if(request.getParameter("status").equals("Resolved")) {
					reimbursements = reimDao.selectReimbursementsByAuthorIdAndStatus
							(((User)session.getAttribute("user")).getId(), "Approved");
					reimbursements.addAll(reimDao.selectReimbursementsByAuthorIdAndStatus
							(((User)session.getAttribute("user")).getId(), "Denied"));
				} else {
					int status = reimDao.getStatusId(request.getParameter("status"));
					reimbursements = reimDao.selectReimbursementsByAuthorIdAndStatus
							(((User)session.getAttribute("user")).getId(), request.getParameter("status"));
				}
			} else {
				reimbursements = reimDao.selectReimbursementsByAuthorId(((User)session.getAttribute("user")).getId());
			}
			session.setAttribute("reimbursements", reimbursements);
			session.setAttribute("reimDao", reimDao);
			rd = request.getRequestDispatcher("Reimbursements.jsp");
			rd.forward(request, response);
			break;
		case "newreimbursement":
			session = request.getSession();
			reim = new Reimbursement();
			reim.setAmount(Double.parseDouble(request.getParameter("amount")));
			reim.setDescription(request.getParameter("description"));
			reim.setReceipt(null);
			reim.setTypeId(reimDao.getTypeId(request.getParameter("type")));
			
			reim.setAuthorId(((User)session.getAttribute("user")).getId());
			reim.setStatusId(1);
			reim.setSubmitted(new Timestamp(System.currentTimeMillis()));
			
			reimDao.createReimbursement(reim);
			
			rd = request.getRequestDispatcher("Reimbursements.do");
			rd.forward(request, response);
			break;
		case "manageroptions":
			session = request.getSession();
			employees = new ArrayList<User>();
			reimbursements = new ArrayList<Reimbursement>();
			employees = userDao.selectEmployees();
			if(request.getParameter("username") == null || userDao.selectUserByUsername(request.getParameter("username")).getUsername() == null) {
				if(request.getParameter("status") != null) {
					if(request.getParameter("status").equals("All"))
						reimbursements = reimDao.selectReimbursements();
					else if(request.getParameter("status").equals("Resolved")) {
						reimbursements = reimDao.selectReimbursementsByStatus("Approved");
						reimbursements.addAll(reimDao.selectReimbursementsByStatus("Denied"));
					} else {
						reimbursements = reimDao.selectReimbursementsByStatus(request.getParameter("status"));
					}
				} else {
					reimbursements = reimDao.selectReimbursements();
				}
			} else{ //User exists
				user = userDao.selectUserByUsername(request.getParameter("username"));
				if(request.getParameter("status") != null) {
					if(request.getParameter("status").equals("All"))
						reimbursements = reimDao.selectReimbursementsByAuthorId(user.getId());
					else if(request.getParameter("status").equals("Resolved")) {
						reimbursements = reimDao.selectReimbursementsByAuthorIdAndStatus(user.getId(), "Approved");
						reimbursements.addAll(reimDao.selectReimbursementsByAuthorIdAndStatus(user.getId(), "Denied"));
					} else {
						reimbursements = reimDao.selectReimbursementsByAuthorIdAndStatus(user.getId(), request.getParameter("status"));
					}
				} else {
					reimbursements = reimDao.selectReimbursementsByAuthorId(user.getId());
				}
			}
			session.setAttribute("employees", employees);
			session.setAttribute("reimbursements", reimbursements);
			session.setAttribute("userDao", userDao);
			session.setAttribute("reimDao", reimDao);
			rd = request.getRequestDispatcher("ManagerOptions.jsp");
			rd.forward(request, response);
			break;
		case "newemployee":
			session = request.getSession();
			user = new User();
			user.setUsername(request.getParameter("user"));
			user.setPassword(request.getParameter("password"));
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setEmail(request.getParameter("email"));
			user.setRoleId(userDao.getRoleId("Employee"));

			userDao.createUser(user);
			
			rd = request.getRequestDispatcher("ManagerOptions.do");
			rd.forward(request, response);
			break;
		case "updatereimbursement":
			session = request.getSession();
			reim = reimDao.selectReimbursementById(Integer.parseInt(request.getParameter("ReimSelected")));
			reim.setStatusId(reimDao.getStatusId(request.getParameter("newStatus")));
			reim.setResolved(new Timestamp(System.currentTimeMillis()));
			reim.setResolverId(((User)session.getAttribute("user")).getId());
			reimDao.updateReimbursement(reim);
			
			rd = request.getRequestDispatcher("ManagerOptions.do");
			rd.forward(request, response);
		default:
			response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
