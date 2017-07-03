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

/**
 * Servlet implementation class ReimbursementTableAJAX
 */
public class ReimbursementTableAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getRootLogger();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter pw = response.getWriter();
		ReimbursementsDAOInterface reimbDAO = new ReimbursementsDAO();
		UsersDAOInterface users = new UsersDAO();
		List<Reimbursement> reimbursements = new ArrayList<>();
		HttpSession session = request.getSession();
		String statusFilter = request.getParameter("statusFilter");
		
		if(session.getAttribute("role").equals("Contributor")) {
			int author_id = users.selectIdByUsername(session.getAttribute("username").toString());
			if(statusFilter.equals("All")) {
				reimbursements = reimbDAO.selectAllReimbursementsByAuthorId(author_id);
			} else if(statusFilter.equals("Pending")) {
				reimbursements = reimbDAO.selectAllReimbursementsByAuthorIdAndStatus(author_id, 2);	// 2 for pending
			} else {
				reimbursements = reimbDAO.selectAllReimbursementsByAuthorIdAndStatus(author_id, 1);	// 1 for resolved (denied or approved)
			}
			logger.debug("Contributor #" + author_id + " (" + session.getAttribute("username").toString() + ") viewing table through status filter: " + statusFilter);
			
		} else {	// Manager
			if(statusFilter.equals("All")) {
				reimbursements = reimbDAO.selectAllReimbursements();
			} else if(statusFilter.equals("Pending")) {
				reimbursements = reimbDAO.selectAllReimbursementsByStatus(2);	// 2 for pending
			} else if(statusFilter.equals("Resolved")) {
				reimbursements = reimbDAO.selectAllReimbursementsByStatus(1);	// 1 for resolved (denied or approved)
			}
			logger.debug("Manager viewing table through status filter: " + statusFilter);
		}
		
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
