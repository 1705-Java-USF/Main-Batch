package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;
import com.revature.pojo.RtType;
import com.revature.service.CreateAccount;
import com.revature.service.GetReinBurst;
import com.revature.service.GetType;
import com.revature.service.LogIn;
import com.revature.service.UserInteract;


public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session =null;
		RequestDispatcher rd = null;
		ErsUser currentUser;
		
		String url = request.getRequestURI();
		System.out.println("url: " + url);
		
		String[] tokens = url.split("/");
		System.out.println(Arrays.toString(tokens));
		
		String action = tokens[tokens.length - 1];
		System.out.println("Action: " + action);
		
		action = action.substring(0, action.length() - 3).toLowerCase();
		System.out.println("Action: " + action);
		
		
		switch(action)
		{
			case "login":
			{
				LogIn l1 = new LogIn();
				GetType gt;
				
				request.setAttribute("issue", null);
				String username = request.getParameter("user");
				String pass = request.getParameter("pass");
				
				currentUser = l1.validate(username, pass);
				
				if(currentUser != null)
				{
					session = request.getSession();
					session.setAttribute("user", currentUser);
					session.setAttribute("role", currentUser.getUrId());
					if(currentUser.getUrId() == 1)
					{
						session.setAttribute("position", "Morty");
						
					}
					else if(currentUser.getUrId() == 2)
					{
						session.setAttribute("position", "Rick");
					}
					session.setAttribute("username", currentUser.getUserName());
					
					gt = new GetType();
					List<RtType> types = gt.getTypes();
					session.setAttribute("types", types);
				}
				else
				{
					request.setAttribute("issue", "INVALID USERNAME OR PASSWORD");
				}
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			}
			case "update":
			{
				UserInteract u1 = new UserInteract();
				
				String username = request.getParameter("user");
				String pass = request.getParameter("pass");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
			
				currentUser = (ErsUser) request.getSession().getAttribute("user");
				
				currentUser.setUserName(username);
				currentUser.setPassWord(pass);
				currentUser.setFirstName(fname);
				currentUser.setLastName(lname);
				currentUser.setEmail(email);
				
				System.out.println("Updating: " + currentUser.toString());
				
				u1.updateUser(currentUser);
				
				request.getSession().setAttribute("user", currentUser);
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		
				break;
			}
			case "createaccount":
			{
				CreateAccount ca = new CreateAccount();
				String username = request.getParameter("user");
				String pass = request.getParameter("pass");
				
				ca.create(username, pass);
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			}
			case "logout":
			{
				request.getSession().invalidate();
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				break;
			}
			case "userpending":
			{
				GetReinBurst grb = new GetReinBurst();
				currentUser = (ErsUser) request.getSession().getAttribute("user");
				
				List<ReinBurst> list = grb.getPending(currentUser);
				request.getSession().setAttribute("list", list);
				rd = request.getRequestDispatcher("reinburst.jsp");
				rd.forward(request, response);
				break;
			}
			case "userresolved":
			{
				GetReinBurst grb = new GetReinBurst();
				currentUser = (ErsUser) request.getSession().getAttribute("user");
				
				List<ReinBurst> list = grb.getResolved(currentUser);
				request.getSession().setAttribute("list", list);
				rd = request.getRequestDispatcher("reinburst.jsp");
				rd.forward(request, response);
				break;
			}
			case "manresolved":
			{
				GetReinBurst grb = new GetReinBurst();
				
				List<ReinBurst> list = grb.getAll(2);
				request.getSession().setAttribute("list", list);
				rd = request.getRequestDispatcher("reinburst.jsp");
				rd.forward(request, response);
				break;
			}
			case "viewuser":
			{
				GetReinBurst grb = new GetReinBurst();
				String viewId = request.getParameter("viewId");
				List<ReinBurst> list = grb.getAllByAuthor(Integer.parseInt(viewId));
				request.getSession().setAttribute("list", list);
				rd = request.getRequestDispatcher("reinburst.jsp");
				rd.forward(request, response);
				break;
			}
			case "manpending":
			{
				GetReinBurst grb = new GetReinBurst();
				List<ReinBurst> list = grb.getAll(1);
				request.getSession().setAttribute("list", list);
				rd = request.getRequestDispatcher("reinburst.jsp");
				rd.forward(request, response);
				break;
			}
			case "managemorty":
			{
				UserInteract ui = new UserInteract();
				List<ErsUser> list = ui.getAllUsers();
				request.getSession().setAttribute("emplist", list);
				rd = request.getRequestDispatcher("viewemp.jsp");
				rd.forward(request, response);
				break;
			}
			case "createrein":
			{
				GetReinBurst grb = new GetReinBurst();
				currentUser = (ErsUser) request.getSession().getAttribute("user");
				String ammount = request.getParameter("ammount");
				String descrip = request.getParameter("desc");
				String type = request.getParameter("type");
				String receipt = request.getParameter("receipt");
			
				grb.createRein(currentUser, Double.parseDouble(ammount) , descrip, receipt, Integer.parseInt(type));
				
				rd = request.getRequestDispatcher("ersuser.jsp");
				rd.forward(request, response);
				break;
			}
			case "opprove":
			{
				currentUser = (ErsUser) request.getSession().getAttribute("user");
				String reinId = request.getParameter("reinId");
				GetReinBurst grb = new GetReinBurst();
				grb.updateReinBurst(currentUser.getuId(), Integer.parseInt(reinId));
				rd = request.getRequestDispatcher("ManPending.do");
				rd.forward(request, response);
				break;
			}
			case "promote":
			{
				UserInteract ui = new UserInteract();
				String promoteId = request.getParameter("promoteId");
				ui.promoteUSer(Integer.parseInt(promoteId));
				rd = request.getRequestDispatcher("ManageMorty.do");
				rd.forward(request, response);
				break;
			}
			default: response.sendError(404);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*
	 * UserInteract u1 = new UserInteract();
			
				String username = request.getParameter("user");
				String pass = request.getParameter("pass");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
				
				currentUser = new ErsUser(username, pass, fname, lname, email);
				
				System.out.println("Updating: " + currentUser.toString());
				
				u1.updateUser(currentUser);
				
				request.getSession().setAttribute("user", currentUser);
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		
				break;
	 */

}
