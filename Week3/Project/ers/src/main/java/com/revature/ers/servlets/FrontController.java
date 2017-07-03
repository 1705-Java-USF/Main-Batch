package com.revature.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.Dao;
import com.revature.ers.dao.ReimbursementDaoImpl;
import com.revature.ers.services.Authenticator;
import com.revature.ers.services.CreateReimbursementService;
import com.revature.ers.services.CreateUserService;
import com.revature.ers.services.GetReceiptService;
import com.revature.ers.services.GetRequestsService;
import com.revature.ers.services.PromoteUserService;
import com.revature.ers.services.UpdateProfileService;
import com.revature.util.ColumnNameUtil;

/**
 * Servlet implementation class FrontController
 */
@MultipartConfig
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_FAILURE_MSG = "CREDENTIALS INVALID";
	private static Logger logger = Logger.getLogger(FrontController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		String action = tokens[tokens.length-1];
		action = action.substring(0, action.length() -3).toLowerCase();
		RequestDispatcher rd = null;
		HttpSession session = null;
		PrintWriter out;
		switch(action)
		{
		case "login":
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			request.setAttribute("pass", null);
			logger.debug(username + " " + password);
			User u = Authenticator.authenticate(username, password);
			if(u != null)
			{
				session = request.getSession();
				session.setAttribute("uid", u.getUserId());
				session.setAttribute("username", u.getUsername());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("firstname", u.getFirstname());
				session.setAttribute("lastname", u.getLastname());
				session.setAttribute("userRole", u.getUserRole());
				
				rd = request.getRequestDispatcher("ERS-Home.jsp");
				rd.forward(request, response);
				
			}else
			{
				session = request.getSession();
				session.invalidate();
				request.setAttribute("message", LOGIN_FAILURE_MSG);
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "createreq":
			CreateReimbursementService crs = new CreateReimbursementService();
			if(crs.createReimbursement(request) == 1)
			{
				request.setAttribute("message", "Request Created Succesfully");
			}else
			{
				request.setAttribute("message", "Error Creating Request" );
			}
			
			rd = request.getRequestDispatcher("CreateReimbursement.jsp");
			rd.forward(request, response);
			break;
		case "getreceipt":
			
			int rid = Integer.parseInt(request.getParameter("rid"));
			Reimbursement r = GetRequestsService.getRequestById(rid);
			String fileUrl =  GetReceiptService.getReceiptUrl(request, r);
			response.setContentType("text/xml");
			out = response.getWriter();
			out.write("<filenames><filename>"+ fileUrl +"</filename></filenames>");
			break;
		case "profile":
			if(UpdateProfileService.updateProfileService(request) == 1)
			{
				request.setAttribute("message", "Profile Updated Succesfully");
			}else
			{
				request.setAttribute("message", "Error updating profile");
			}
			rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			break;
		case "managerequests":
			 session = request.getSession();
			 String status = request.getParameter("type");
			 List<Reimbursement> reimbursements = GetRequestsService.getAllRequestsByStatus(status);
			 response.setContentType("text/xml");
			 out = response.getWriter();
			 out.write("<reimbursements>");
			 logger.debug("ManageRequests reimbursements: " + reimbursements.size());
			 for(Reimbursement rem : reimbursements)
			 {
				 out.write("<reimbursement>");
				 out.write("<id>" + rem.getId() + "</id>");
				 out.write("<amount>" + rem.getAmount() + "</amount>");
				 out.write("<description>" + rem.getDescription() + "</description>");
				 out.write("<author>" + rem.getAuthor().getFirstname() + " " + rem.getAuthor().getLastname() + "</author>");
				 out.write("<subtime>" + rem.getSubmittedTime() + "</subtime>");
				 out.write("<restime>" + rem.getResolvedTime() + "</restime>");
				 if(rem.getResolver() != null)
				 {
					 out.write("<resolver>" + rem.getResolver().getFirstname() + " " + rem.getResolver().getLastname() + "</resolver>");
				 }else
				 {
					 out.write("<resolver>null</resolver>");
				 }
				 
				 out.write("<status>" + rem.getReimbursementStatus() + "</status>");
				 out.write("<type>" + rem.getReimbursementType() + "</type>");
				 out.write("</reimbursement>");
			 }
			 out.write("</reimbursements>");
			 break;
		case "updaterequest":
			Dao<Reimbursement> rdi = new ReimbursementDaoImpl();
			Map<String, String> optionMap = new HashMap<String, String>();
			Map<String, String> conditionMap = new HashMap<String, String>();
			String rStat = request.getParameter("status");
			if(rStat.equals("approve"))
			{
				rStat = "approved";
			}else if(rStat.equals("reject"))
			{
				rStat = "denied";
			}
			logger.debug(request.getParameter("rid"));
			logger.debug(rStat);
			conditionMap.put(ColumnNameUtil.ID, request.getParameter("rid"));
			optionMap.put(ColumnNameUtil.STATUS, rStat);
			int rows = rdi.updateBy(optionMap, conditionMap);
			response.setContentType("text/xml");
			if(rows == 1)
			{
				response.getWriter().write("<message>Success</message>");
			}else if(rows < 1)
			{
				response.getWriter().write("<message>Error: No update occured</message>");
			}else
			{
				response.getWriter().write("<message>Error:More than 1 request updated</message>");
			}
			break;
		case "promoteuser":
			int id = Integer.valueOf(request.getParameter("uid"));
			response.setContentType("text/xml");
			out = response.getWriter();
			
			if(PromoteUserService.promoteUser(id) == 1)
			{
				out.write("<message>User Promoted</message>");
			}else
			{
				out.write("<message>Error: User not promoted</message>");
			}
			break;
		case "createuser":
			if(CreateUserService.createUser(request) == 1)
			{
				request.setAttribute("message", "User Created");
				request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "Error Creating User");
				request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
			};
			
			break;
		default:
			response.sendError(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void finalize(){
		GetReceiptService.clearImages();
	}
}
