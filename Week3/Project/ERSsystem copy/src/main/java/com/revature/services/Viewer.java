package main.java.com.revature.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_REIMBURSEMENTS;

@WebServlet("/viewRec")
public class Viewer extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERS_DAO dao = new ERS_DAO();
		ERS_REIMBURSEMENTS reim = dao.getRequest(Integer.parseInt(req.getParameter("recId")));
		req.getSession().setAttribute("receipt", reim.getReceipt());
		try {
			req.getRequestDispatcher("View.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
}