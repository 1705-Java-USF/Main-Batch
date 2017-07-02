package main.java.com.revature.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/update")
public class UpdateInfo extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERS_DAO dao = new ERS_DAO();
		String email = req.getParameter("email");
		String lname = req.getParameter("lname");
		String fname = req.getParameter("fname");
		String uname = req.getParameter("ERS_USERSname");
		ERS_USERS ERS_USERS = dao.getERS_USERS(uname);
		ERS_USERS.setEmail(email);
		ERS_USERS.setFname(fname);
		ERS_USERS.setLname(lname);
		req.getSession().setAttribute("ERS_USERS", dao.updateInfo(ERS_USERS));
		resp.sendRedirect("EmployeeInfo.jsp");
	}
}
