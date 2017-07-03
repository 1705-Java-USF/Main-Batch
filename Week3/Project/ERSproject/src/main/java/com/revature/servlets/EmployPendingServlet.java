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
 * Servlet implementation class EmployPendingServlet
 */
public class EmployPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select all 'PENDING' reimbursements with session employee_id and send as a json object
		int e_id = (int) request.getSession().getAttribute("eid");
		ReimburseDAO dao = new ReimburseImplDAO();
		Collection<Reimbursement> c = dao.selectEmployPendingReimbursements(e_id);
		String json = new Gson().toJson(c);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
