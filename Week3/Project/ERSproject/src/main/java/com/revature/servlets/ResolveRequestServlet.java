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
 * Servlet implementation class ResolveRequestServlet
 */
public class ResolveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(FrontController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select reimbursement with reimbursement_id and resolve with new status and manager_id
		int m_id = (int) request.getSession().getAttribute("eid");
		ReimburseDAO dao = new ReimburseImplDAO();
		int r_id = Integer.parseInt( request.getParameter("rid") );
		Reimbursement r = dao.selectReimbursement(r_id);
		r.setStatus( request.getParameter("status") );
		dao.resolveReimbursement( r, m_id);
		
		// log resolved request
		SimpleDateFormat sdf = new SimpleDateFormat("HH24:mm:ss"); 
		logger.info(request.getSession().getAttribute("user") + " resolved " + r_id + " at " 
		+ sdf.format(new Date(System.currentTimeMillis())));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
