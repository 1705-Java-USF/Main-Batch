package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbusementDaoImp;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;
import com.revature.services.CreateAcc;
import com.revature.services.CreateReim;
import com.revature.services.Login;
import com.revature.services.UpdateUser;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class FrontController
 */
@MultipartConfig 

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		System.out.println("url: " + url);

		String[] tokens = url.split("/");
		System.out.println((Arrays.toString(tokens)));

		String action = tokens[tokens.length - 1];
		System.out.println("Action: " + action);

		action = action.substring(0, (action.length() - 3)).toLowerCase();
		System.out.println("action: " + action);
		RequestDispatcher rd = null;
		HttpSession session = null;

		switch (action) {
		case "login":
			request.setAttribute("issue", null);
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			Login vl = new Login();
			if (vl.validateLogin(username, password)) {

				UserDao dao = new UserDaoImp();
				Users r = dao.selectUsersByUsername(username);
				
				int uid = r.getU_ID();
				String sfname = r.getU_FIRSTNAME();
				String slname = r.getU_LASTNAME();
				String s_email = r.getU_EMAIL();
				int ur = r.getUR_ID();

				session = request.getSession();
				session.setAttribute("user", username);
				session.setAttribute("fname", sfname);
				session.setAttribute("lname", slname);
				session.setAttribute("email", s_email);
				session.setAttribute("uid", uid);
				session.setAttribute("ur", ur);
				
				System.out.println(ur);
				rd = request.getRequestDispatcher("Homepage.jsp");
				rd.forward(request, response);
			} else {

				request.setAttribute("issue", "INVALID CREDENTIALS");
				rd = request.getRequestDispatcher("Homepage.jsp");
				rd.forward(request, response);
			}

			break;

		case "createacc":
			request.setAttribute("issue", null);
			request.setAttribute("newU", null);

			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");

			CreateAcc ca = new CreateAcc();
			if (ca.storeNewUser(user, pass, fname, lname, email)) {
				;
				request.setAttribute("newU", "new");
				rd = request.getRequestDispatcher("Homepage.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("issue", "User taken");
				rd = request.getRequestDispatcher("createacc.jsp");
				rd.forward(request, response);
			}

			break;
		case "update":
			request.setAttribute("newUp", null);
			session = request.getSession();
			
			String userUp = session.getAttribute("user").toString();
			String userNewUp = request.getParameter("userNew");
			String passUp = request.getParameter("pass");
			String fnameUp = request.getParameter("fname");
			String lnameUp = request.getParameter("lname");
			String emailUp = request.getParameter("email");

				if(!(userNewUp.isEmpty())){
					session.setAttribute("user", userNewUp);
				}
			
			
			
			UpdateUser up = new UpdateUser();
			if (up.Updater(userUp, userNewUp, passUp, fnameUp, lnameUp, emailUp)) {
				
				UserDao dao = new UserDaoImp();
				Users r = dao.selectUsersByUsername((String)session.getAttribute("user"));
				//String NewUser = r.getU_USERNAME();
				String NewFname = r.getU_FIRSTNAME();
				String NewLname = r.getU_LASTNAME();
				String NewEmail = r.getU_EMAIL();
				
				
				
				session.setAttribute("fname", NewFname);
				session.setAttribute("lname", NewLname);
				session.setAttribute("email", NewEmail);
				request.setAttribute("newUp", "new");
				
				rd = request.getRequestDispatcher("AccInfo.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("issue", "User taken");
				rd = request.getRequestDispatcher("AccInfo.jsp");
				rd.forward(request, response);
			}

			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("Homepage.jsp");
			rd.forward(request, response);

			request.setAttribute("new", "new");
			rd = request.getRequestDispatcher("Homepage.jsp");
			rd.forward(request, response);
			break;
			
		case "selectalle":
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			UserDao dao = new UserDaoImp();
			List<Users> listU = dao.selectUsers();
			out.println("<table border='1px'><tr><th>ID</th><th>USERNAME</th><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th></tr>");
			
			
			for (Users u : listU ) {
				
				out.println("<tr><td>" + u.getU_ID() + "</td><td>" + u.getU_USERNAME() + "</td><td>" + u.getU_FIRSTNAME() + "</td><td>" + u.getU_LASTNAME() + "</td><td>" + u.getU_EMAIL() + "</td></tr>");
			}
			out.println("</table>");
			
			out.println(
					"<hr>" +
					"<a href='MPortal.jsp'>BACK</a>"
					);
		case "createreim":
			request.setAttribute("newR", null);
			session = request.getSession();

			Double amount = Double.parseDouble(request.getParameter("ramount"));
			String description = request.getParameter("rdescription");
			Part receipt = request.getPart("receipt");
			int rtype = Integer.parseInt(request.getParameter("rtype"));
			int ruid = (int) session.getAttribute("uid");

			CreateReim cr = new CreateReim();
			
			cr.storeNewReim(amount, description, ruid, rtype, receipt);
				
				request.setAttribute("newR", "new");
				rd = request.getRequestDispatcher("Reim.jsp");
				rd.forward(request, response);
		break;
		
		case "elistreim":
		response.setContentType("text/html");
		session = request.getSession();
		
		PrintWriter pout = response.getWriter();
		int luid = (int) session.getAttribute("uid");
		ReimbursementDao daor = new ReimbusementDaoImp();
		List<Reimbursement> listR = daor.listAllReimsE(luid);
		
		pout.println("<table border='1px'><tr><th>ID</th><th>Description</th><th>Date Submitted</th><th>Submitted By</th><th>Date Resolved</th><th>Resolved By</th><th>Type</th><th>Status</th></tr>");
		
		
		for (Reimbursement r : listR) {
			String status = null;
			String type = null;
			if (r.getRS_ID() == 1){
				status = "Approved";
			}else if(r.getRS_ID() == 2){
				status = "Rejected";
			}else{
				status = "pending";
			}
			
			if (r.getRT_ID() == 1){
				type = "Gas";
			}else if(r.getRT_ID() == 2){
				type = "Lodging";
			}else if(r.getRT_ID() == 3){
				type = "Food";
			}else{
				type = "Misc";
			}
			
			String resolver = " ";
			UserDao rdao = new UserDaoImp();
			Users ra = rdao.selectUserById(r.getU_ID_AUTHOR());
			
			if(r.getU_ID_RESOLVER() != 0){
				Users rr = rdao.selectUserById(r.getU_ID_RESOLVER());
				resolver = rr.getU_USERNAME();
			}
			
					
			pout.println("<tr><td>" + r.getR_ID() + "</td><td>" + r.getDescription() + "</td><td>" + r.getR_Submitted() + "</td><td>" + ra.getU_USERNAME() + "</td><td>" + r.getR_resolved() + "</td><td>" + resolver + "</td><td>" + type + "</td><td>" + status + "</td></tr>");
		}
		pout.println("</table>");
		
		pout.println(
				"<hr>" +
				"<a href='Reim.jsp'>BACK</a>"
				);
		break;
		
		case "viewpendingr":
			response.setContentType("text/html");
			session = request.getSession();
			
			PrintWriter outp = response.getWriter();
			int muid = (int) session.getAttribute("uid");
			ReimbursementDao daorm = new ReimbusementDaoImp();
			List<Reimbursement> rlist = daorm.listAllReimsM(muid);
			
			outp.println("<table border='1px'><tr><th>ID</th><th>Description</th><th>Date Submitted</th><th>Submitted By</th><th>Type</th><th>Approve</th><th>Deny</th><th>Reciept</th></tr>");
			
			
			for (Reimbursement r : rlist) {
				String type = null;
				if (r.getRT_ID() == 1){
					type = "Gas";
				}else if(r.getRT_ID() == 2){
					type = "Lodging";
				}else if(r.getRT_ID() == 3){
					type = "Food";
				}else{
					type = "Misc";
				}
				
				UserDao rdao = new UserDaoImp();
				Users ra = rdao.selectUserById(r.getU_ID_AUTHOR());
				
						
				outp.println("<tr><form name='frm"+r.getR_ID()+"' method=" +"POST" +" action=" +"approve.do" +"><td>" + r.getR_ID() + "</td><td>" + r.getDescription() + "</td><td>" + r.getR_Submitted() + "</td><td>" + ra.getU_USERNAME() + "</td><td>" + type + "</td><input type='hidden' name='hd' value='"+r.getR_ID()+"'/><td><input type='button'" +" name ='approve'"+" value='Approve R. #"+ r.getR_ID()+"' onclick='{document.frm"+r.getR_ID()+".hd.value=this.value;document.frm"+r.getR_ID()+".submit();}'/></td><td><input type='submit'" + " name='deny'" +" value='Deny R. #"+ r.getR_ID()+"'" + " formaction='deny.do'/></td><td><input type='submit' value='VIEW' formaction='viewr.do'/></td></form></tr>");
			}
			outp.println("</table>");
			
			outp.println(
					"<hr>" +
					"<a href='MPortal.jsp'>BACK</a>"
					);
			
			break;
			
		case "approve":
			
			session = request.getSession();
			int rid = Integer.parseInt(request.getParameter("hd").substring(12));
			
			
			int uidr = (int) session.getAttribute("uid");

			ReimbursementDao daora = new ReimbusementDaoImp();
			
			daora.approveRequest(uidr, rid);
				
				
				rd = request.getRequestDispatcher("viewpendingr.do");
				rd.forward(request, response);
				
			break;
			
		case "deny":
			session = request.getSession();
			int did = Integer.parseInt(request.getParameter("hd"));
			
			
			int uidd = (int) session.getAttribute("uid");

			ReimbursementDao daord = new ReimbusementDaoImp();
			
			daord.denyRequest(uidd, did);
				
				
				rd = request.getRequestDispatcher("viewpendingr.do");
				rd.forward(request, response);
			break;
			
		case "resolvedreim":
			response.setContentType("text/html");
			session = request.getSession();
			
			PrintWriter aout = response.getWriter();
			ReimbursementDao adaor = new ReimbusementDaoImp();
			List<Reimbursement> listRa = adaor.listAllRReimsM();
			
			aout.println("<table border='1px'><tr><th>ID</th><th>Description</th><th>Date Submitted</th><th>Submitted By</th><th>Date Resolved</th><th>Resolved By</th><th>Type</th><th>Status</th><th>Receipt</th></tr>");
			
			
			for (Reimbursement r : listRa) {
				String status = null;
				String type = null;
				if (r.getRS_ID() == 1){
					status = "Approved";
				}else if(r.getRS_ID() == 2){
					status = "Rejected";
				}else{
					status = "pending";
				}
				
				if (r.getRT_ID() == 1){
					type = "Gas";
				}else if(r.getRT_ID() == 2){
					type = "Lodging";
				}else if(r.getRT_ID() == 3){
					type = "Food";
				}else{
					type = "Misc";
				}
				
				String resolver = " ";
				UserDao rdao = new UserDaoImp();
				Users ra = rdao.selectUserById(r.getU_ID_AUTHOR());
				
				if(r.getU_ID_RESOLVER() != 0){
					Users rr = rdao.selectUserById(r.getU_ID_RESOLVER());
					resolver = rr.getU_USERNAME();
				}
				
						
				aout.println("<tr><form><td>" + r.getR_ID() + "</td><td>" + r.getDescription() + "</td><input type='hidden' name='hd' value='"+r.getR_ID()+"'/><td>" + r.getR_Submitted() + "</td><td>" + ra.getU_USERNAME() + "</td><td>" + r.getR_resolved() + "</td><td>" + resolver + "</td><td>" + type + "</td><td>" + status + "</td><td><input type='submit' value='VIEW' formaction='viewr.do'/></td></form></tr>");
			}
			aout.println("</table>");
			
			aout.println(
					"<hr>" +
					"<a href='MPortal.jsp'>BACK</a>"
					);
			break;
			
		case "deniedreim":
			response.setContentType("text/html");
			session = request.getSession();
			
			PrintWriter dout = response.getWriter();
			ReimbursementDao ddaor = new ReimbusementDaoImp();
			List<Reimbursement> listRd = ddaor.listAllDeimsM();
			
			dout.println("<table border='1px'><tr><th>ID</th><th>Description</th><th>Date Submitted</th><th>Submitted By</th><th>Date Resolved</th><th>Resolved By</th><th>Type</th><th>Status</th><th>Receipt</th></tr>");
			
			
			for (Reimbursement r : listRd) {
				String status = null;
				String type = null;
				if (r.getRS_ID() == 1){
					status = "Approved";
				}else if(r.getRS_ID() == 2){
					status = "Rejected";
				}else{
					status = "pending";
				}
				
				if (r.getRT_ID() == 1){
					type = "Gas";
				}else if(r.getRT_ID() == 2){
					type = "Lodging";
				}else if(r.getRT_ID() == 3){
					type = "Food";
				}else{
					type = "Misc";
				}
				
				String resolver = " ";
				UserDao rdao = new UserDaoImp();
				Users ra = rdao.selectUserById(r.getU_ID_AUTHOR());
				
				if(r.getU_ID_RESOLVER() != 0){
					Users rr = rdao.selectUserById(r.getU_ID_RESOLVER());
					resolver = rr.getU_USERNAME();
				}
				
						
				dout.println("<tr><form><td>" + r.getR_ID() + "</td><input type='hidden' name='hd' value='"+r.getR_ID()+"'/><td>" + r.getDescription() + "</td><td>" + r.getR_Submitted() + "</td><td>" + ra.getU_USERNAME() + "</td><td>" + r.getR_resolved() + "</td><td>" + resolver + "</td><td>" + type + "</td><td>" + status + "</td><td><input type='submit' value='VIEW' formaction='viewr.do'/></td></form></tr>");
			}
			dout.println("</table>");
			
			dout.println(
					"<hr>" +
					"<a href='MPortal.jsp'>BACK</a>"
					);
			break;
			
		case "viewr":
			int r_id = Integer.parseInt(request.getParameter("hd"));
            response.setContentType("image/jpeg");
            PreparedStatement ps = null;
    		ResultSet rs = null;
    		Reimbursement r = null;
            try (Connection conn = ConnectionUtil.getConnection()) {
    			String sql = "SELECT R_RECEIPT FROM Reim Where R_ID = ?";

    			ps = conn.prepareStatement(sql);
    			ps.setInt(1, r_id);
    			rs = ps.executeQuery();
           
            rs.next();
            Blob b = rs.getBlob("R_RECEIPT");
            byte buf[] = b.getBytes(1, (int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            
            is.read(buf);
            os.write(buf);
            os.flush();
            
            }catch(Exception e){
            	e.printStackTrace();
            }finally{
            	
            }
			break;
		case "reime":
			response.setContentType("text/html");
			session = request.getSession();
			int aid = Integer.parseInt(request.getParameter("authorid"));
			PrintWriter aouf = response.getWriter();
			ReimbursementDao adaof = new ReimbusementDaoImp();
			List<Reimbursement> listRf = adaof.listAllReimsById(aid);
			
			aouf.println("<table border='1px'><tr><th>ID</th><th>Description</th><th>Date Submitted</th><th>Submitted By</th><th>Date Resolved</th><th>Resolved By</th><th>Type</th><th>Status</th><th>Receipt</th></tr>");
			
			
			for (Reimbursement f : listRf) {
				String status = null;
				String type = null;
				if (f.getRS_ID() == 1){
					status = "Approved";
				}else if(f.getRS_ID() == 2){
					status = "Rejected";
				}else{
					status = "pending";
				}
				
				if (f.getRT_ID() == 1){
					type = "Gas";
				}else if(f.getRT_ID() == 2){
					type = "Lodging";
				}else if(f.getRT_ID() == 3){
					type = "Food";
				}else{
					type = "Misc";
				}
				
				String resolver = " ";
				UserDao rdao = new UserDaoImp();
				Users ra = rdao.selectUserById(f.getU_ID_AUTHOR());
				
				if(f.getU_ID_RESOLVER() != 0){
					Users rr = rdao.selectUserById(f.getU_ID_RESOLVER());
					resolver = rr.getU_USERNAME();
				}
				
						
				aouf.println("<tr><form><td>" + f.getR_ID() + "</td><td>" + f.getDescription() + "</td><input type='hidden' name='hd' value='"+f.getR_ID()+"'/><td>" + f.getR_Submitted() + "</td><td>" + ra.getU_USERNAME() + "</td><td>" + f.getR_resolved() + "</td><td>" + resolver + "</td><td>" + type + "</td><td>" + status + "</td><td><input type='submit' value='VIEW' formaction='viewr.do'/></td></form></tr>");
			}
			aouf.println("</table>");
			
			aouf.println(
					"<hr>" +
					"<a href='MPortal.jsp'>BACK</a>"
					);
			break;
		default:
			response.sendError(404);
	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
