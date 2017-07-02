package main.java.com.revature.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/resolve")
public class ResolveReim extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERS_DAO dao = new ERS_DAO();
		int id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		ERS_USERS resolver = dao.getERS_USERS(req.getParameter("reso"));
		dao.updateRequest(id, type, resolver.getId());
		resp.getWriter().print("");
	}

}