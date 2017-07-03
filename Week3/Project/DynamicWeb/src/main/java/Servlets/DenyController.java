package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReimbursementDAOImpl;

/**
 * Servlet implementation class DenyController
 */
public class DenyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String tokens[] = url.split("/");
		String action = tokens[tokens.length - 1];
		action = action.substring(0, action.length() - 3).toLowerCase();
		int reimbId = Integer.parseInt(action);
		
		RequestDispatcher rd = null;
		
		// Get user ID from session and use it to mark in the database who approved the reimbursement
		int id = (Integer)request.getSession().getAttribute("userId");
		System.out.println(id);
		ReimbursementDAOImpl approve = new ReimbursementDAOImpl();
	    approve.ApproveReimb(reimbId, 2, id);
	    
	    rd = request.getRequestDispatcher("EmpHome.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
