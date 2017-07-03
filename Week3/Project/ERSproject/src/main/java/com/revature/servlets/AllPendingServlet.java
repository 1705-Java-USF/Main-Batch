package com.revature.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.dao.ReimburseDAO;
import com.revature.dao.ReimburseImplDAO;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class AllPendingServlet
 */
public class AllPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select all reimbursements with 'PENDING' status and send as a json object
		ReimburseDAO dao = new ReimburseImplDAO();
		Collection<Reimbursement> reimbursements = dao.selectPendingReimbursements();
		String json = new Gson().toJson(reimbursements);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
