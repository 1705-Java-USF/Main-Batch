package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReimDao;
import dao.ReimDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import pojo.ErsReimburse;
import pojo.ErsUser;
import services.login;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		ReimDao rdi = new ReimDaoImpl();
		
		String url = request.getRequestURI(); //save url as a string
		System.out.println("url: " + url); //debugging, print the url
		
		String[] tokens = url.split("/"); //split the url by /
		System.out.println(Arrays.toString(tokens)); //debugging
		
		//Take the last piece of the url /DynamicWebMavenLucasV/Login.do
		//Save it to the String action
		String action = tokens[tokens.length-1]; 
		System.out.println("Action: " + action);
		
		//makes action go from "Login.do" to "login"
		//Actually could have just saved another new string called "login"
		action = action.substring(0, action.length()-3).toLowerCase(); 
		System.out.println("action: " + action);
		
		RequestDispatcher rd = null;
		HttpSession session = null;
	
		switch(action){
		case "login":
			request.setAttribute("issue", null);
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			login vl = new login();
			if(vl.validateLogin(username, password)){
				session = request.getSession();
				session.setAttribute("user", username);
				session.setAttribute("fname", ud.selectUserByUserName(username).getU_FIRSTNAME());
				session.setAttribute("lname", ud.selectUserByUserName(username).getU_LASTNAME());
				session.setAttribute("role", ud.selectUserByUserName(username).getUR_ID());
				session.setAttribute("role_name", ud.returnRoleByRoleId(ud.selectUserByUserName(username).getUR_ID()));
				
				List<ErsUser> al1 = new ArrayList<ErsUser>();
				al1 = ud.selectErsUsers();
				String c = al1.toString();				
				session.setAttribute("hunters", c);
				String d = ud.selectUserByUserName(username).toString();
				session.setAttribute("hunter", d);
				List<ErsReimburse> al2 = new ArrayList<ErsReimburse>();
				al2 = rdi.selectReimbursementsById(ud.returnIdByUsername(username));
				String e = al2.toString();
				session.setAttribute("requests", e);
				List<ErsReimburse> al3 = new ArrayList<ErsReimburse>();
				al3 = rdi.selectAllReimbursements();
				String f = al3.toString();
				session.setAttribute("allrequests", f);
			}else{
				request.setAttribute("issue", "INVALID CRENDENTIALS!");
			}
			rd = request.getRequestDispatcher("indexJSTL2.jsp");
			rd.forward(request, response);
			break;
		case "submit":
			request.setAttribute("issue", null);
			int r_id = Integer.parseInt(request.getParameter("R_ID"));
			int rt_type = Integer.parseInt(request.getParameter("RT_TYPE"));
			String un = request.getParameter("username");	
			session = request.getSession();
			ErsReimburse er = new ErsReimburse(r_id, ud.returnIdByUsername(un), rt_type);
			rdi.createReimbursementMinReq(er);
			
			rd = request.getRequestDispatcher("submitRequest.jsp");
			rd.forward(request, response);
			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("indexJSTL2.jsp");
			rd.forward(request, response);
			break;
		default:
			response.sendError(404);
		}
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
