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

import dao.QuestDao;
import dao.QuestDaoImpl;
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
		QuestDao qd = new QuestDaoImpl();
		
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
				al2 = rdi.selectPendingReimbursementsById(ud.returnIdByUsername(username));
				String e = al2.toString();
				session.setAttribute("requests", e);
				
				List<ErsReimburse> al3 = new ArrayList<ErsReimburse>();
				al3 = rdi.selectAllPendingReimbursements();
				String f = al3.toString();
				session.setAttribute("allrequests", f);
				
				List<ErsReimburse> al4 = new ArrayList<ErsReimburse>();
				al4 = rdi.selectResolvedReimbursementsById(ud.returnIdByUsername(username));
				String g = al4.toString();
				session.setAttribute("resolved", g);
				
				List<ErsReimburse> al5 = new ArrayList<ErsReimburse>();
				al5 = rdi.selectAllResolvedReimbursements();
				String h = al5.toString();
				session.setAttribute("allresolved", h);
				
			}else{
				request.setAttribute("issue", "INVALID CRENDENTIALS!");
			}
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "submit":
			request.setAttribute("issue", null);
			int rt_type = Integer.parseInt(request.getParameter("RT_TYPE"));
			String un = (String) request.getSession().getAttribute("user");
			session = request.getSession();
			ErsReimburse er = new ErsReimburse(ud.returnIdByUsername(un), rt_type);
			rdi.createReimbursementMinReq(er);
			if(rt_type == 10){qd.quest10();}
			if(rt_type == 11){qd.quest11();}
			if(rt_type == 12){qd.quest12();}
			if(rt_type == 20){qd.quest20();}
			if(rt_type == 21){qd.quest21();}
			if(rt_type == 22){qd.quest22();}
			if(rt_type == 30){qd.quest30();}
			if(rt_type == 31){qd.quest31();}
			if(rt_type == 32){qd.quest32();}
			if(rt_type == 40){qd.quest40();}
			if(rt_type == 41){qd.quest41();}
			if(rt_type == 42){qd.quest42();}
			if(rt_type == 50){qd.quest50();}
			if(rt_type == 51){qd.quest51();}
			if(rt_type == 52){qd.quest52();}
			if(rt_type == 60){qd.quest60();}
			if(rt_type == 61){qd.quest61();}
			if(rt_type == 62){qd.quest62();}
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("indexJSTL.jsp");
			rd.forward(request, response);
			break;	
		case "resolve":
			request.setAttribute("issue", null);
			String usern = (String) request.getSession().getAttribute("user");
			int r_id = Integer.parseInt(request.getParameter("R_ID"));
			session = request.getSession();
			rdi.resolveReimbursement(r_id, ud.returnIdByUsername(usern));
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("indexJSTL.jsp");
			rd.forward(request, response);
			break;	
		case "upload":
			request.setAttribute("issue", null);
			session = request.getSession();

			request.getSession().invalidate();
			rd = request.getRequestDispatcher("indexJSTL.jsp");
			rd.forward(request, response);
			break;	
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("indexJSTL.jsp");
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
