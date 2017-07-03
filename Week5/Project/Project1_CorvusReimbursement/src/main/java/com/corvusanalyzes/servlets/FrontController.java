package com.corvusanalyzes.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.corvusanalyzes.dao.ReimbursementsDAO;
import com.corvusanalyzes.dao.ReimbursementsDAOInterface;
import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;
import com.corvusanalyzes.pojos.Reimbursement;
import com.corvusanalyzes.services.Action;
import com.corvusanalyzes.services.Login;
import com.corvusanalyzes.services.NewUser;
import com.corvusanalyzes.services.UpdateUser;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getRootLogger();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = new Action();
		RequestDispatcher rd = null;
		HttpSession session = null;
		Login login;
		
		switch(action.getAction(request)) {
			case "login": 
				request.setAttribute("issue", null);
				login = new Login();
				String username = request.getParameter("username");
				String pageToRedirectTo = null;
				
				if(login.validateLogin(username, request.getParameter("password"))) {
					login.setupSession(username, session = request.getSession());
					pageToRedirectTo = session.getAttribute("role").equals("Contributor") ? "contributor.jsp" : "manager.jsp";
					logger.debug("Valid Login Credentials.");
				} else {
					logger.debug("Invalid Login Credentials.");
					request.setAttribute("issue", "INVALID CREDENTIALS");
					pageToRedirectTo = "login.jsp";
				}
				logger.debug("Forwarding to: " + pageToRedirectTo);
				rd = request.getRequestDispatcher(pageToRedirectTo);
				rd.forward(request, response);
				break;
				
			case "logout":
				request.getSession().invalidate();
				logger.debug("Logout: Session Invalidated.");
				logger.debug("Forwarding to: login.jsp");
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				break;
				
			case "update-account":
				request.setAttribute("issuePassword", null);
				request.setAttribute("issueUsername", null);
				request.setAttribute("issue", null);
				UpdateUser update = new UpdateUser();
				login = new Login();
				session = request.getSession();
				String status = update.updateUserCredentials(
						session,
						request.getParameter("username"),
						request.getParameter("firstname"),
						request.getParameter("lastname"),
						request.getParameter("email"),
						request.getParameter("oldpassword"),
						request.getParameter("newpassword"));
				if(status.equals("Username Taken")) {
					request.setAttribute("issueUsername", "USERNAME TAKEN");
					logger.debug("Username Taken.");
				}
				if(status.equals("Old Password Is Incorrect")) {
					request.setAttribute("issuePassword", "OLD PASSWORD IS INCORRECT");
					logger.debug("Old Password Is Incorrect.");
				}
				if(status.equals("OK")) {
					request.setAttribute("issue", "Success: Changes Made");
					logger.debug("Success: Changes Made To User " + session.getAttribute("username"));
				}
				login.setupSession(session.getAttribute("username").toString(), request.getSession());
				
				pageToRedirectTo = session.getAttribute("role").equals("Contributor") ? "accountc.jsp" : "account.jsp";
				logger.debug("Forwarding to: " + pageToRedirectTo);
				rd = request.getRequestDispatcher(pageToRedirectTo);
				rd.forward(request, response);
				break;
			
			case "new-user":
				request.setAttribute("issueUsername", null);
				request.setAttribute("issue", null);
				UpdateUser usernameUnique = new UpdateUser();
				if(!usernameUnique.isUsernameUnique(request.getParameter("username"))) {
					request.setAttribute("issueUsername", "USERNAME TAKEN");
					logger.debug("Username Taken.");
				} else {
					request.setAttribute("issue", "Success: New User Added");
					NewUser newUser = new NewUser();
					newUser.insertNewUser(
							request.getParameter("username"),
							request.getParameter("password"),
							request.getParameter("firstname"),
							request.getParameter("lastname"),
							request.getParameter("email"),
							request.getParameter("role"));
				}
				
				logger.debug("Success: New User " + request.getParameter("username") + " Added.");
				logger.debug("Forwarding to: new-user.jsp");
				rd = request.getRequestDispatcher("new-user.jsp");
				rd.forward(request, response);
				break;
				
			case "request-reimb":
				request.setAttribute("issueUsername", null);
				request.setAttribute("issue", null);
				request.setAttribute("issue", "Success: Reimbursement Requested");
				Reimbursement reimb = new Reimbursement();
				ReimbursementsDAOInterface reimbDAO = new ReimbursementsDAO();
				UsersDAOInterface users = new UsersDAO();
				
				int author_id = users.selectIdByUsername(request.getSession().getAttribute("username").toString());
				
				int type;
				if(request.getParameter("type").equals("Game"))
					type = 1;
				else
					type = 2;
				
				reimb.setAmount(Float.parseFloat(request.getParameter("amount")));
				reimb.setDescription(request.getParameter("description"));
				reimb.setAuthor(author_id);
				reimb.setType(type);
				reimb.setReceipt(null);
				
				reimbDAO.createReimbursement(reimb);
				
				logger.debug("Success: Reimbursement requested by " + request.getSession().getAttribute("username").toString());
				logger.debug("Forwarding to: request_reimbursement.jsp");
				rd = request.getRequestDispatcher("request_reimbursement.jsp");
				rd.forward(request, response);
				break;
				
			default:
				response.sendError(404);
				break;
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
