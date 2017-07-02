package main.java.com.revature.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/login")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		ERS_DAO dao = new ERS_DAO();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		if(dao.checkERS_USERSname(uname)==0){
			req.getSession().setAttribute("error", "There is no account associated with that ERS_USERSname");
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!pass.equals(dao.getPassword(uname))){
			req.getSession().setAttribute("error", "Incorrect ERS_USERSname/password combination");
			try {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else{
			ERS_USERS ERS_USERS = dao.getERS_USERS(uname);
			req.getSession().setAttribute("ERS_USERS", ERS_USERS);
			if(ERS_USERS.getRole().equals("Manager")){
				try {
					req.getRequestDispatcher("ManReimbursement.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					req.getRequestDispatcher("EmployeeInfo.jsp").forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}