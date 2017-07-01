package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.Action;
import com.revature.services.Login;
import com.revature.services.Select;
import com.revature.services.Update;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action a = new Action();

		String action = a.getAction(request.getRequestURI());

		HttpSession session = null;
		RequestDispatcher rd = null;

		response.setContentType("text/html");

		UserDAO uDao = new UserDAOImp();
		ReimbursementDAO rDao = new ReimbursementDAOImp();
		Update updater = new Update();
		Select selector = new Select();

		switch (action) {
		case "login":
			request.setAttribute("issue", null);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Login vl = new Login();
			User u = vl.validateLogin(username, password);
			if (u != null) {
				session = request.getSession();
				session.setAttribute("user", u);
				if (u.getPassword().equals("generic")) {
					rd = request.getRequestDispatcher("changePass.jsp");
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("issue", "Username and password combination was wrong.");
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "edituser":
			session = request.getSession();
			request.setAttribute("issue", null);

			String newPass = request.getParameter("newpass");
			String oldPass = request.getParameter("oldpass");
			User us = (User) session.getAttribute("user");
			if (!oldPass.equals(us.getPassword()) && !newPass.equals("")) {
				request.setAttribute("issue", "You need to input the correct password you have currently");
				rd = request.getRequestDispatcher("editUser.jsp");
				rd.forward(request, response);
			} else {
				us.setEmail(request.getParameter("email"));
				us.setFirstname(request.getParameter("fname"));
				us.setLastname(request.getParameter("lname"));
				us.setUsername(request.getParameter("uname"));
				if (!newPass.equals(""))
					us.setPassword(request.getParameter("newpass"));
				uDao.updateUser(us);
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			break;
		case "newreimbursement":
			session = request.getSession();
			request.setAttribute("issue", null);
			Reimbursement r = null;
			System.out.println(request.getParameter("receipt"));
			r = new Reimbursement(0, Double.parseDouble(request.getParameter("amount")),
					request.getParameter("description"), request.getParameter("receipt"), null, null,
					((User) session.getAttribute("user")).getId(), 0, Integer.parseInt(request.getParameter("rtype")),
					1);
			rDao.createReimbursement(r);
			rd = request.getRequestDispatcher("reimbursements.jsp");
			rd.forward(request, response);
			break;
		case "managecreateaccount":
			session = request.getSession();
			request.setAttribute("issue", null);

			updater.createUser(request.getParameter("firstname"), request.getParameter("lastname"),
					request.getParameter("username"), "generic", request.getParameter("email"));

			rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
			break;
		case "usercreateaccount":
			session = request.getSession();
			request.setAttribute("issue", null);

			updater.createUser(request.getParameter("firstname"), request.getParameter("lastname"),
					request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));

			rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
			break;
		case "changepass":
			session = request.getSession();
			request.setAttribute("issue", null);

			updater.updatePassword((User) session.getAttribute("user"), request.getParameter("password"));

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewreimb":
			session = request.getSession();
			if (session.getAttribute("user") != null) {
				request.setAttribute("viewed", selector.getReimbursement(Integer.parseInt(request.getParameter("id"))));
				rd = request.getRequestDispatcher("viewReimb.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			break;
		case "viewuser":
			session = request.getSession();
			if (session.getAttribute("user") != null) {
				request.setAttribute("viewed", selector.getUser(Integer.parseInt(request.getParameter("id"))));
				rd = request.getRequestDispatcher("viewUser.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			break;
		case "approvereimb":
			session = request.getSession();
			System.out.println(request.getAttribute("id"));
			updater.updateReimbursement(Integer.parseInt(request.getParameter("id")),
					((User) session.getAttribute("user")).getId(), 2);

			rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
			break;
		case "denyreimb":
			session = request.getSession();

			updater.updateReimbursement(Integer.parseInt(request.getParameter("id")),
					((User) session.getAttribute("user")).getId(), 3);

			rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
			break;
		case "promote":
			session = request.getSession();
			
			updater.promote(Integer.parseInt(request.getParameter("id")));

			rd = request.getRequestDispatcher("management.jsp");
			rd.forward(request, response);
			break;
		default:
			response.sendError(404);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
