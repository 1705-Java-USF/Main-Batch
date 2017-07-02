package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.DaoReimbursementImpl;
import com.revature.dao.DaoUser;
import com.revature.dao.DaoUserImp;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class FrontController
 */
@MultipartConfig
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		System.out.println("url: " + url);
		
		String[] tokens = url.split("/");
		System.out.println(Arrays.toString(tokens));
		
		String action = tokens[tokens.length - 1];
		System.out.println("Action: " + action);
		
		action = action.substring(0, action.length() - 3).toLowerCase();
		System.out.println("Action: " + action);
		
		RequestDispatcher rd = null;
		HttpSession session = null;
		
		switch(action) {
			case "login":
				request.setAttribute("issue", null);
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String company = request.getParameter("insTitle");
				if(validateLogin(username, password)) {
					DaoUser u = new DaoUserImp();
					Users usr = u.selectUserByUsername(username);
					session = request.getSession();
					System.out.println(company);
					session.setAttribute("title", company);
					session.setAttribute("id", usr.getId());
					session.setAttribute("username", username);
					session.setAttribute("role", u.getRole(usr.getUr_id()));
					session.setAttribute("first", usr.getFname());
					session.setAttribute("last", usr.getLname());
					session.setAttribute("email", usr.getEmail());
				}
				else {
					request.setAttribute("issue", "INVALID CREDENTIALS!");
				}
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,  response);
				break;
			case "update":
				session = request.getSession();
				String oldUser = session.getAttribute("username").toString();
				DaoUserImp u = new DaoUserImp();
				Users user = u.selectUserByUsername(oldUser);
				request.setAttribute("success", null);
				request.setAttribute("failure", null);
				
				String newUsername = request.getParameter("username");
				String newPass = request.getParameter("password");
				String newFirst = request.getParameter("first");
				String newLast = request.getParameter("last");
				String newEmail = request.getParameter("email");
				
				if(newUsername != "") {
					user.setUsername(newUsername);
				}
				if(newPass != "") {
					user.setPassword(newPass);
				}
				if(newFirst != "") {
					user.setFname(newFirst);
				}
				if(newLast != "") {
					user.setLname(newLast);
				}
				if(newEmail != "") {
					user.setEmail(newEmail);
				}
				
				if(u.updateUser(user)) {
					//code for green success message to top of page
					request.setAttribute("success", "Updated your user info");
					session.setAttribute("username", user.getUsername());
					session.setAttribute("password", user.getPassword());
					session.setAttribute("first", user.getFname());
					session.setAttribute("last", user.getLname());
					session.setAttribute("email", user.getEmail());
				}
				else {
					//code for red fail message to top of page
					request.setAttribute("failure", "Failed to update info");
				}
				
				rd = request.getRequestDispatcher("accinfo.jsp");
				rd.forward(request,  response);
				break;
			case "createreim":
				session = request.getSession();
				Double amount = Double.parseDouble(request.getParameter("amount"));
				String descrip = request.getParameter("descrip");
				Blob receipt = getBlob(request.getPart("receipt"));
				String type = request.getParameter("type");
				DaoUserImp u2 = new DaoUserImp();
				DaoReimbursementImpl r = new DaoReimbursementImpl();
				Reimbursement reim = new Reimbursement(amount, descrip, receipt, r.getTypeByString(type));
				int id = u2.selectUserByUsername(session.getAttribute("username").toString()).getId();				
				
				reim.setSubmitted(new Timestamp(System.currentTimeMillis()));
				reim.setId_author((int)session.getAttribute("id"));
				reim.setRs_id(1);
				r.createReim(reim);
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,  response);
				break;
			case "approve":
				session = request.getSession();
				DaoReimbursementImpl r2 = new DaoReimbursementImpl();
				DaoUser u5 = new DaoUserImp();
				int reimId = Integer.parseInt(request.getParameter("id"));
				Reimbursement reimb = r2.getReimbursementById(reimId);
				Users u3 = u5.getUserById(reimb.getId_author());
				Timestamp newT = new Timestamp(System.currentTimeMillis());
				int resId = (int)session.getAttribute("id");
				reimb.setId_resolver(resId);
				reimb.setResolved(newT);
				reimb.setRs_id(3);
				r2.updateReim(reimb);
				rd = request.getRequestDispatcher("viewemployees.jsp?username="+ u3.getUsername());
				rd.forward(request,  response);
				break;
			case "deny":
				session = request.getSession();
				DaoReimbursementImpl r3 = new DaoReimbursementImpl();
				DaoUser u6 = new DaoUserImp();
				int reimbId = Integer.parseInt(request.getParameter("id"));
				Reimbursement reimb2 = r3.getReimbursementById(reimbId);
				Users u4 = u6.getUserById(reimb2.getId_author());
				Timestamp newTs = new Timestamp(System.currentTimeMillis());
				int resolvId = (int)session.getAttribute("id");
				reimb2.setId_resolver(resolvId);
				reimb2.setResolved(newTs);
				reimb2.setRs_id(2);
				r3.updateReim(reimb2);
				rd = request.getRequestDispatcher("viewemployees.jsp?username="+ u4.getUsername());
				rd.forward(request,  response);
				break;
			case "logout":
				request.getSession().invalidate();
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			default:
				rd = request.getRequestDispatcher("userhome.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean validateLogin(String username, String pass) {
		
		DaoUserImp u = new DaoUserImp();
		Users user = u.selectUserByUsername(username);
		return (pass.equals(user.getPassword()));
	}
	
	public Blob getBlob(Part p) {
		
		try {
			
			Connection connection = ConnectionUtil.getConnectionUtil().getConnection();
			InputStream is = p.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] byteArray = new byte[10240];
			
			for(int i = 0; (i = is.read(byteArray)) > 0;) {
				os.write(byteArray, 0, i);
			}
			Blob b = connection.createBlob();
			b.setBytes(1, os.toByteArray());
			
			return b;
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
}
