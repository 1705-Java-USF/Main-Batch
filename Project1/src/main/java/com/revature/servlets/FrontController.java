package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojo.EmployeeObject;
import com.revature.services.ValidateLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		//HttpSession session = null;

		String url = request.getRequestURI(); // url requested
		System.out.println("FC 1- url: " + url); // printing it out

		// regular expressions to check what the url is ==
		String regex = "\\/\\w*\\/(\\w*)\\/(.*)";  
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);  // setting url = matcher

		if (matcher.find()) // returns true if it finds an url
		{
			String firstUrl = matcher.group(1); //"main route"
			String secondUrl = matcher.group(2);  // second url thing after main route
			
			System.out.println("FC 2 - firstUrl: " + firstUrl);
			
			switch(firstUrl)
			{
			case "login":
				
				System.out.println("FC 3 - forwarding to login.jsp");
								
				rd = request.getRequestDispatcher("/WEB-INF/login.jsp"); 
				rd.forward(request, response); // forward request and response?
				break;
				
			case "index":
				
				System.out.println("FC 3.1 - forwarding to index.jsp");
					
				rd = request.getRequestDispatcher("/WEB-INF/index.jsp"); 
				rd.forward(request, response); // forward request and response?
				break;
				
			
			case "logout":
				
				System.out.println("FC 3.2 - (LOGOUT)forwarding to login.jsp");
				
				request.getSession().invalidate();  // invalidate session
				
				response.sendRedirect("/Project1/login/"); // forwarding to login page again
				
				break;
				
			case "myinfo":
				
				System.out.println("FC 3.3 - forwarding to myinfo.jsp");
					
				rd = request.getRequestDispatcher("/WEB-INF/myinfo.jsp"); 
				rd.forward(request, response); // forward request and response?
				break;
				
			case "reimbursements":
				
				System.out.println("FC 3.4 - forwarding to reimbursements.jsp");
					
				rd = request.getRequestDispatcher("/WEB-INF/reimbursements.jsp"); 
				rd.forward(request, response); // forward request and response?
				break;
				
			case "employees":
				
				if (secondUrl.equals("new"))
				{
					System.out.println("FC 3.6 secondUrl: " + secondUrl);
					System.out.println("FC 3.6 - forwarding to createemployee.jsp");
					
					rd = request.getRequestDispatcher("/WEB-INF/createemployee.jsp"); 
					rd.forward(request, response); // forward request and response?
				}
				else if (secondUrl.equals("modify"))
				{
					System.out.println("FC 3.6.5 secondUrl: " + secondUrl);
					System.out.println("FC 3.6.5 - forwarding to modify.jsp");
					
					String username = request.getParameter("username");
					UserDAOImpl dao = new UserDAOImpl();
					EmployeeObject updateUser = new EmployeeObject();
					
					updateUser = dao.selectEmployeeByUsername(username);
					
					System.out.println("Object username: " + updateUser.getUser_username());
					request.setAttribute("user", updateUser);  // this is setting the array of employees, putting the attribute to users (used by employees.jsp)
					
					rd = request.getRequestDispatcher("/WEB-INF/modify.jsp"); 
					rd.forward(request, response); // forward request and response?
				}
				else
				{
				System.out.println("FC 3.5 - forwarding to employees.jsp");
				
				ArrayList<EmployeeObject> arr = new ArrayList<>();
				UserDAO dao2 = new UserDAOImpl();
				System.out.println("FC 4 - Getting array of employees, setting it to arr");
				
				arr = dao2.selectEmployee();
				System.out.println("Select first user, name: " + arr.get(0).getUser_first_name());
				request.setAttribute("users", arr);  // this is setting the array of employees, putting the attribute to users (used by employees.jsp)
					
				rd = request.getRequestDispatcher("/WEB-INF/employees.jsp"); // prints out the login.jsp file
				rd.forward(request, response); // forward request and response?
				}	
				break;
				
			default:
				
				response.sendRedirect("/Project1/index/"); // forwarding to index page again
				break;
			}						
		} 
		else
		{
			rd = request.getRequestDispatcher("/WEB-INF/index.jsp"); // prints out the login.jsp file
			rd.forward(request, response); // forward request and response?
		}
		
	}
	
	/*	This is a way of splitting  url by "/", gets last part of URL
	 * 
	 * String[] tokens = url.split("/"); // gets the URL requested, splits it
											// by '/'
		// http:/locahost500/myproj/employees/new
		System.out.println(Arrays.toString(tokens)); // printing them out. Ex:
														// Project/Login.do

		String action = tokens[tokens.length - 1]; // gets the last token var.
													// Ex: Login.do
		System.out.println("Action: " + action); // prints it out

		// removing last 3 chars
		action = action.substring(0, action.length() - 3).toLowerCase(); 
		System.out.println("Action: " + action); // printing that out
	 * 
	 * 
	 * 
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		HttpSession session = null;

		String url = request.getRequestURI(); // url requested
		System.out.println("FC 4 doPost - url: " + url); // printing it out

		// regular expressions to check what the url is ==
		String regex = "\\/\\w*\\/(\\w*)\\/(.*)";  
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher2 = pattern.matcher(url);  // setting url = matcher
		
		if (matcher2.find()) // returns true if it finds an url
		{
			String firstUrl = matcher2.group(1); //"main route"
			String secondUrl = matcher2.group(2);  // second url thing after main route
			
			System.out.println("FC 5 doPost - first url is: " + firstUrl);
						
			switch(firstUrl)
			{
			case "login":
				
				System.out.println("FC 6 doPost - inside login");
				
				if (secondUrl.equals(""))  // starting here, we will validate the username and passsword given
				{	
					System.out.println("FC 7 doPost - got 'login'");
					
					request.setAttribute("issue", null);  // setting null to issue will allow it to continue and not give an "invalid credentials" page
					String username = request.getParameter("username"); // setting name (id) "user" to username
					String password = request.getParameter("pass"); // setting name (id) "pass" to password
					
					ValidateLogin vl = new ValidateLogin();  // creates an object v1 of type Login
					EmployeeObject emp = new EmployeeObject();
					
					System.out.println("FC 8 doPost - Sending username and pass for validation: " + username);
					// calling method .validateLogin in Login.java, 
					// which returns the employee person, then sets it = to emp
					emp = vl.validateLogin(username, password);
					System.out.println("FC 9 doPost - Received employee back: " + emp);
					
					if (emp != null) // if employee is not null (given back by Login)
					{ 
						System.out.println("FC 10 - Succesfully logged in user: " + emp.getUser_username());
						//once logged in, then set the following attributes:
						session = request.getSession(); // grabs the session from request
						session.setAttribute("employee", emp);
						session.setAttribute("role_id", emp.getUser_role_id());
						session.setAttribute("username", emp.getUser_username());
						session.setAttribute("fname", emp.getUser_first_name());
						session.setAttribute("lname", emp.getUser_last_name());
						
						response.sendRedirect("/Project1/index/"); // redirecting to "index" which is look at by doGet as case "index"
						
					} 
					else 
					{
						// if login isn't correct, give them an "issue" message
						request.setAttribute("issue", "INVALID CRENDENTIALS!");
					}
						
					break;
				}
				
			case "employees":
				
				System.out.println("FC - creating new employee");
				
				if (secondUrl.equals("thanks"))  // adding new employee to DB
				{
					int uid = Integer.parseInt(request.getParameter("user_id")); // must case string to int
					int uroleid = Integer.parseInt(request.getParameter("user_role_id"));  // must cast string to int
					String uname = request.getParameter("username"); // setting name (id) "user" to username
					String pass = request.getParameter("password"); // setting name (id) "pass" to password
					String fname = request.getParameter("first_name");
					String lname = request.getParameter("last_name");
					String email = request.getParameter("email");
														
					EmployeeObject newEmp = new EmployeeObject(uid, uroleid, uname, pass, fname, lname, email);
					UserDAO dao = new UserDAOImpl();  // creating dao object
					
					dao.createEmployee(newEmp);  // sending newEmp object to UserDAOImpl for creating
	
					session = request.getSession(); // grabs the session from request
					session.setAttribute("newEmp", newEmp);
					session.setAttribute("newRoleId", newEmp.getUser_role_id());
					session.setAttribute("newUsername", newEmp.getUser_username());
					session.setAttribute("newFname", newEmp.getUser_first_name());
					session.setAttribute("newLname", newEmp.getUser_last_name());
					session.setAttribute("newEmail", newEmp.getUser_email());
					
					
					
					rd = request.getRequestDispatcher("/WEB-INF/thanks.jsp");  // requestDispatch to login.jsp
					rd.forward(request, response);   // forward request and response?
				}
				else if (secondUrl.equals("updated"))
				{
					rd = request.getRequestDispatcher("/WEB-INF/updated.jsp");  
					rd.forward(request, response);   // forward request and response?
				}
				break;
				
			default:
				response.sendError(404); // if something else is click, send to custom made error page
			}	
			return;
		}
		
	}

}