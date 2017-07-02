package main.java.com.revature.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.revature.DAO.ERS_DAO;
import main.java.com.revature.pojo.ERS_USERS;

@WebServlet("/getEmp")
public class GetEmployees extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ERS_DAO dao = new ERS_DAO();
		List<ERS_USERS> ERS_USERSs = new ArrayList<>();
		ERS_USERSs = dao.getEmployees();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ERS_USERSs);
		resp.getWriter().write(json);
	}
}
