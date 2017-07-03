package com.revature.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.ReimburseDAO;
import com.revature.dao.ReimburseImplDAO;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class SubmitReimburseServlet
 */
public class SubmitReimburseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create reimbursement with input
		ReimburseDAO dao = new ReimburseImplDAO();
		double amount = Double.parseDouble( request.getParameter("amount") );
		String report = request.getParameter("report");
		String type = request.getParameter("reimbursetype");
		int author = (int) request.getSession().getAttribute("eid"); 
		dao.createReimbursement(new Reimbursement(0, amount, report, null, null, null, author, 0, "PENDING", type));
		
		// log submit reimbursement
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		logger.info(request.getSession().getAttribute("user") + " submitted a request at " 
		+ sdf.format(new Date(System.currentTimeMillis())));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
