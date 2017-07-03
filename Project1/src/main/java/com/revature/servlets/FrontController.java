package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.RebsDAO;
import com.revature.dao.RebsDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojo.EmployeeObject;
import com.revature.pojo.RebsObj;
import com.revature.services.ValidateLogin;
import com.revature.util.ConnectionUtil;

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
			System.out.println("!!!! secondUrl: " + secondUrl);
			
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
				
				if (secondUrl.equals(""))
				{	
					System.out.println("FC 3.4 - forwarding to reimbursements.jsp");
						
					rd = request.getRequestDispatcher("/WEB-INF/reimbursements.jsp"); 
					rd.forward(request, response); // forward request and response?
				}
				else if (secondUrl.equals("new"))
				{
					System.out.println("FC 3.4.5 secondUrl: " + secondUrl);
					System.out.println("FC 3.4.5 - forwarding to new_reimbursement.jsp");
					
					rd = request.getRequestDispatcher("/WEB-INF/new_reimbursement.jsp"); 
					rd.forward(request, response); // forward request and response?
				}
				break;
				
			case "employees":
				
				if (secondUrl.equals("") || secondUrl.equals("delete"))
				{
				System.out.println("FC 3.5 - forwarding to employees.jsp");
				
				ArrayList<EmployeeObject> arr = new ArrayList<>();
				UserDAO dao2 = new UserDAOImpl();
				System.out.println("FC 4 - Getting array of employees, setting it to arr");
				
				arr = dao2.selectEmployee();
				System.out.println("Select first user, name: " + arr.get(0).getUser_first_name());
				request.setAttribute("users", arr);  // this is setting the array of employees, putting the attribute to users (used by employees.jsp)
					
				rd = request.getRequestDispatcher("/WEB-INF/employees.jsp"); 
				rd.forward(request, response); // forward request and response?
				}
				else if (secondUrl.equals("new"))
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
					
					String username = request.getParameter("username"); // getting user that was clicked to "edit"
					UserDAOImpl dao = new UserDAOImpl();
					EmployeeObject updateUser = new EmployeeObject();
					
					updateUser = dao.selectEmployeeByUsername(username); // get that employee info from Bean
					
					System.out.println("FC - Object username to be edited: " + updateUser.getUser_username());
					request.setAttribute("user", updateUser);  // this is setting the array of employees, putting the attribute to users (used by employees.jsp)
					
					rd = request.getRequestDispatcher("/WEB-INF/modify.jsp"); 
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
						session.setAttribute("user_id", emp.getUser_id());
						session.setAttribute("role_id", emp.getUser_role_id());
						session.setAttribute("username", emp.getUser_username());
						session.setAttribute("fname", emp.getUser_first_name());
						session.setAttribute("lname", emp.getUser_last_name());
						session.setAttribute("email", emp.getUser_email());
						session.setAttribute("status", emp.getUser_status());
						
						response.sendRedirect("/Project1/index/"); // redirecting to "index" which is look at by doGet as case "index"
						
					} 
					else 
					{
						System.out.println("AM I IN HERE");
						// if login isn't correct, give them an "issue" message
						request.setAttribute("issue", "INVALID CRENDENTIALS!");
						rd = request.getRequestDispatcher("/WEB-INF/login.jsp");  
						rd.forward(request, response);   // forward request and response?
					}
						
					break;
				}
				
			case "employees":
				
				if (secondUrl.equals("thanks"))  // adding new employee to DB
				{
					System.out.println("FC - secondUrl: " + secondUrl);
					System.out.println("FC - creating new employee, redirecting to thanks.jsp");
					
					//int uid = Integer.parseInt(request.getParameter("user_id")); // must case string to int // USER_ID IS AUTO INCREMENTING
					int uroleid = Integer.parseInt(request.getParameter("role_type"));  // must cast string to int
					String uname = request.getParameter("username"); // setting name (id) "user" to username
					String pass = request.getParameter("password"); // setting name (id) "pass" to password
					String fname = request.getParameter("first_name");
					String lname = request.getParameter("last_name");
					String email = request.getParameter("email");
					int status = 2;  // default status will be 2 = "inactive"
					if(request.getParameter("onoffswitch") != null) // if switch is not null (meaning its checked)
					{
						if(request.getParameter("onoffswitch").equals("on")) // this is double checkin it - a bit pointless
							{
							status = 1;  //set status to 1
							}	
					}
					
					EmployeeObject newEmp = new EmployeeObject(uroleid, uname, pass, fname, lname, email, status);
					UserDAO dao = new UserDAOImpl();  // creating dao object
					
					dao.createEmployee(newEmp);  // sending newEmp object to UserDAOImpl for creating
	
					session = request.getSession(); // grabs the session from request
					session.setAttribute("newEmp", newEmp);
					session.setAttribute("newRoleId", newEmp.getUser_role_id());
					session.setAttribute("newUsername", newEmp.getUser_username());
					session.setAttribute("newFname", newEmp.getUser_first_name());
					session.setAttribute("newLname", newEmp.getUser_last_name());
					session.setAttribute("newEmail", newEmp.getUser_email());
					session.setAttribute("newStatus", newEmp.getUser_status());
					
					rd = request.getRequestDispatcher("/WEB-INF/thanks.jsp");  
					rd.forward(request, response);   // forward request and response?
				}
				else if (secondUrl.equals("updated") || secondUrl.equals("myinfo"))
				{
					System.out.println("FC - secondUrl: " + secondUrl);
					System.out.println("FC - updating employee, redirecting to updated.jsp");
					
					int uid = Integer.parseInt(request.getParameter("user_id")); // must case string to int // also, this one is getting a hidden field from the modify.jsp
					int uroleid = Integer.parseInt(request.getParameter("role_type"));  // must cast string to int
					String uname = request.getParameter("username"); // setting name (id) "user" to username
					String pass = request.getParameter("password"); // setting name (id) "pass" to password
					String fname = request.getParameter("first_name");
					String lname = request.getParameter("last_name");
					String email = request.getParameter("email");
					int status = 2;
					if(request.getParameter("onoffswitch") != null)
					{
						if(request.getParameter("onoffswitch").equals("on"))
							{
							status = 1;
							}	
					}
					
					
					EmployeeObject updateEmp = new EmployeeObject(uid, uroleid, uname, pass, fname, lname, email, status);
					UserDAO dao = new UserDAOImpl();  // creating dao object
					
					updateEmp = dao.updateEmployee(updateEmp);  // sending newEmp object to UserDAOImpl for creating
					
					session = request.getSession(); // grabs the session from request
					session.setAttribute("updEmp", updateEmp);
					session.setAttribute("updRoleId", updateEmp.getUser_role_id());
					session.setAttribute("updUsername", updateEmp.getUser_username());
					session.setAttribute("updFname", updateEmp.getUser_first_name());
					session.setAttribute("updLname", updateEmp.getUser_last_name());
					session.setAttribute("updEmail", updateEmp.getUser_email());
					session.setAttribute("updStatus", updateEmp.getUser_status());
					
					System.out.println("FC- updated user: " + session.getAttribute("updUsername"));
					
					if (updateEmp.getUser_username().equals(session.getAttribute("username")))
					{
						System.out.println("FC - user currently signed in has updated their own info");
						session.setAttribute("employee", updateEmp);
						session.setAttribute("role_id", updateEmp.getUser_role_id());
						session.setAttribute("username", updateEmp.getUser_username());
						session.setAttribute("fname", updateEmp.getUser_first_name());
						session.setAttribute("lname", updateEmp.getUser_last_name());
						session.setAttribute("email", updateEmp.getUser_email());
						session.setAttribute("status", updateEmp.getUser_status());
					}
					
					rd = request.getRequestDispatcher("/WEB-INF/updated.jsp"); 
					rd.forward(request, response);   // forward request and response?
				}
				else if (secondUrl.equals("delete"))
				{
					System.out.println("FC - secondUrl: " + secondUrl);
					System.out.println("FC - deleting employee, redirecting to employees.jsp");
					
					String username = request.getParameter("username");		
					
					UserDAO dao = new UserDAOImpl();  // creating dao object
					EmployeeObject deleteEmp = new EmployeeObject();
					
					deleteEmp = dao.selectEmployeeByUsername(username); // select user by username, return it to deleteEmp
					dao.deleteEmployeeById(deleteEmp.getUser_id());  // delete that employee (make them inactive)
					
					System.out.println("FC- deleted user: " + deleteEmp.getUser_first_name());
					
					rd = request.getRequestDispatcher("/WEB-INF/employees.jsp"); 
					rd.forward(request, response);   // forward request and response?
				}
				break;
			
			case "reimbursements":
				
				if (secondUrl.equals("request_sent"))
				{
					System.out.println("FC doPost- secondUrl: " + secondUrl);
					System.out.println("FC doPost- creating new rebs request");
								
					// rebs_id IS AUTO INCREMENTING
					int user_id = Integer.parseInt(request.getParameter("author_id"));  // must cast string to int
					//int man_id
					int rebs_type = Integer.parseInt(request.getParameter("type"));
					int rebs_status = Integer.parseInt(request.getParameter("status"));
					double rebs_amount = Double.parseDouble(request.getParameter("amount"));
					String rebs_description = request.getParameter("description");
					//Blob rebs_attachments = getBlob(request.getPart("attachments"));
					//Timestamp time_submitted = new Timestamp(System.currentTimeMillis());
					// Timestamp time_resolved
					
					RebsObj newReb = new RebsObj(user_id, rebs_type, rebs_status, rebs_amount, rebs_description);
					RebsDAO dao4 = new RebsDAOImpl();
					
					dao4.createReimbursement(newReb);  // sending newEmp object to UserDAOImpl for creating
	
					session = request.getSession(); // grabs the session from request
					session.setAttribute("rebs_id", newReb.getRebsId());
					session.setAttribute("rebs_user_id", newReb.getUserId());
					session.setAttribute("rebs_type", newReb.getRebsType());
					session.setAttribute("rebs_status", newReb.getRebsStatus());
					session.setAttribute("rebs_amount", newReb.getRebsAmount());
					session.setAttribute("rebs_description", newReb.getRebsDescription());
					session.setAttribute("time_submitted", newReb.getTimeSubmitted());
					
					rd = request.getRequestDispatcher("/WEB-INF/request_sent.jsp");  
					rd.forward(request, response);   // forward request and response?
				}
				
				
			/*default:
				response.sendError(404); // if something else is click, send to custom made error page
*/			}	
			return;
		}
		
	}
	
	public Blob getBlob(Part p) {
			
			try {
				
				Connection connection = ConnectionUtil.getConnection();
				InputStream is = p.getInputStream();
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				byte[] byteArray = new byte[10240];
				
				for(int i = 0; (i = is.read(byteArray)) > 0;) {
					os.write(byteArray, 0, i);
				}
				Blob b = connection.createBlob();
				b.setBytes(1, os.toByteArray());
				
				return b;
			}
			catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

}