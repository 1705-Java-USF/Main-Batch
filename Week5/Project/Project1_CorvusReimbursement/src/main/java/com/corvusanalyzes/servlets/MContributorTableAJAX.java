package com.corvusanalyzes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.corvusanalyzes.pojos.User;

/**
 * Servlet implementation class MContributorTableAJAX
 */
public class MContributorTableAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getRootLogger();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		ReimbursementsDAOInterface reimbDAO = new ReimbursementsDAO();
		UsersDAOInterface usersDAO = new UsersDAO();
		List<User> users = new ArrayList<>();
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		String username = request.getParameter("userFilter");
		
		if(username != null) {
			logger.debug("Table Filtered");
			logger.debug("Switching to Reimbursement View");
			logger.debug("Showing " + username + " Table");
			
			int author_id = usersDAO.selectIdByUsername(username);
			reimbursements = reimbDAO.selectAllReimbursementsByAuthorId(author_id);
			
			pw.write("<reimbursements>");
			
			for(Reimbursement r : reimbursements) {
				pw.write(
						"<reimbursement>"
						+ "<id>" + r.getId() + "</id>"
						+ "<amount>" + r.getAmount() + "</amount>"
						+ "<author>" + r.getAuthorString() + "</author>"
						+ "<description>" + r.getDescription() + "</description>"
						+ "<submitted>" + r.getSubmitted() + "</submitted>"
						+ "<type>" + r.getTypeString() + "</type>"
						+ "<receipt>" + r.getReceipt() + "</receipt>"
						+ "<status>" + r.getStatusString() + "</status>"
						+ "<resolver>" + r.getResolverString() + "</resolver>"
						+ "<resolved>" + r.getResolved() + "</resolved>"
						+ "</reimbursement>"
						);
			}
			pw.write("</reimbursements>");
			
		} else {
			logger.debug("Table Unfiltered");
			logger.debug("Switching to User View");
			logger.debug("Showing All Users");
			
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
