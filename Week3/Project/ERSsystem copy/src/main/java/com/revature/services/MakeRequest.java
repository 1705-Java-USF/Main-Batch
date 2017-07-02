package main.java.com.revature.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_REIMBURSEMENTS;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/makeReq")
public class MakeRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (Double.parseDouble(req.getParameter("amount")) <= 0) {
			req.getSession().setAttribute("error", "Amount must be greater than 0");
			resp.setStatus(400);
		} else {
			ERS_DAO dao = new ERS_DAO();
			double amount = Double.parseDouble(req.getParameter("amount"));
			String desc = req.getParameter("desc");
			String reas = req.getParameter("reason");
			String uname = req.getParameter("ERS_USERSname");
			ERS_USERS ERS_USERS = dao.getERS_USERS(uname);
			ERS_REIMBURSEMENTS reim = new ERS_REIMBURSEMENTS(amount, desc, ERS_USERS, reas);
			dao.createRequest(reim);
		}
	}
}
