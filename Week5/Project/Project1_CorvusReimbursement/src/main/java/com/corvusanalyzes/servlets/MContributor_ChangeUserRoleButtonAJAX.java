package com.corvusanalyzes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.corvusanalyzes.dao.ReimbursementsDAO;
import com.corvusanalyzes.dao.ReimbursementsDAOInterface;
import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;
import com.corvusanalyzes.pojos.Reimbursement;
import com.corvusanalyzes.pojos.User;

/**
 * Servlet implementation class MContributor_ChangeUserRoleButtonAJAX
 */
public class MContributor_ChangeUserRoleButtonAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getRootLogger();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		UsersDAOInterface usersDAO = new UsersDAO();
		List<User> users = new ArrayList<>();
		String username = request.getParameter("username");
		String curRole = request.getParameter("curRole");
		int newRole = 0;
		
		if(curRole.equals("Manager"))
			newRole = 1;							// Change to Contributor (1)
		else if(curRole.equals("Contributor"))
			newRole = 2;							// Change to Manager (2)
		
		logger.debug("Current Role (" + curRole + ") switched to opposite (#" + newRole + ")");
		
		usersDAO.updateUserRole(username, newRole);
		
		users = usersDAO.selectAllUsers();
		
		pw.write("<contributors>");
		
		for(User u : users) {
			pw.write(
					"<contributor>"
					+ "<username>" + u.getUsername() + "</username>"
					+ "<firstname>" + u.getFirstname() + "</firstname>"
					+ "<lastname>" + u.getLastname() + "</lastname>"
					+ "<email>" + u.getEmail() + "</email>"
					+ "<role>" + u.getRole() + "</role>"
					+ "</contributor>"
					);
		}
		pw.write("</contributors>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
