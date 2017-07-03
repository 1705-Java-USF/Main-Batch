package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//import org.jsoup.Jsoup;
//import org.jsoup.safety.Whitelist;

import DAO.EmployeeDAOImpl;
import DAO.ReimbursementDAOImpl;
import Database.EmployeePOJO;
import Database.ReimbursementPOJO;

/**
 * Servlet implementation class LoginControl
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * The next lines of code will retrieve the URL and create the "action" string
		 * that will be used to determine what action will occur.
		 */
		String url = request.getRequestURI();
		String tokens[] = url.split("/");
		String action = tokens[tokens.length - 1];
		action = action.substring(0, action.length() - 3).toLowerCase();
		
		RequestDispatcher rd = null;
		HttpSession session = null;
		
		Logger logger = Logger.getLogger(FrontController.class);
		
		switch(action) {
		case "login":
			// Store username into a string			
			String username = request.getParameter("username");
			
			// Get the correct password from the database
			EmployeeDAOImpl log = new EmployeeDAOImpl();
			String pwd = log.selectPassByLogin(username);
			
			/*
			 * If the username is not found, then the DAOImpl will
			 * return "password" as the password.  If the person
			 * logging in uses "password" as the password, then this
			 * will change their input so they can't log in using
			 * their phony username.
			 */
			if (username.equals("password")) {
				username = "";
			}
			
			// Check that the password in the form matches the password
			// retrieved from the database
			if (request.getParameter("password").equals(pwd)) {
				/*
				 * If the user is authenticated, then the user info is retrieved
				 * from the database.  I chose to have two different queries
				 * as a security measure since the query used to gather employee
				 * information does not retrieve the password.
				 */
				EmployeePOJO pojo = new EmployeePOJO();
				pojo = log.selectEmpByUser(username);
				
				if (pojo.getRole() != 3) {
				
					session = request.getSession();
					session.setAttribute("user", username);
					session.setAttribute("userId", pojo.getId());
					session.setAttribute("firstName", pojo.getFn());
					session.setAttribute("lastName", pojo.getLn());
					session.setAttribute("address", pojo.getAddr());
					session.setAttribute("city", pojo.getCity());
					session.setAttribute("state", pojo.getSt());
					session.setAttribute("zip", pojo.getZip());
					session.setAttribute("phone", pojo.getPhone());
					session.setAttribute("email", pojo.getEmail());
					session.setAttribute("role", pojo.getRole());
					
					if (pwd.equals("initech")) {
						request.setAttribute("issue", "Please change your password");
						
						rd = request.getRequestDispatcher("changePass.jsp");
						rd.forward(request, response);
					} else {
						rd = request.getRequestDispatcher("EmpHome.jsp");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("issue", "Account Deactivated");
				}
				
			} else {
				request.setAttribute("issue", "Invalid Credentials");
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
			break;
		case "logout":
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "changepass":	// Redirect to the page where the employee can change
							// the password
			rd = request.getRequestDispatcher("changePass.jsp");
			rd.forward(request, response);
			break;
		case "passcheck":	// Check if password is correct, then update
			String user = (String)request.getSession().getAttribute("user");
			String oldpwd = request.getParameter("old");
			
			// Retrieve the user's password from the database
			log = new EmployeeDAOImpl();
			pwd = log.selectPassByLogin(user);
			
			/*
			 * The following if statement checks if the password matches the
			 * password in the database.
			 */
			if (oldpwd.equals(pwd)) {
				String new1 = request.getParameter("new1");
				String new2 = request.getParameter("new2");
				
				/*
				 * The following makes sure that the new password was entered
				 * the same both times.  If so, then it will change the password
				 * in the database.
				 */
				if (new1.equals(new2) && new1 != "" && !new1.equals("password")) {
					
					log.ChangePassword(user, new1);
					
					request.setAttribute("issue", "Password Successfully Changed");
					
					rd = request.getRequestDispatcher("EmpHome.jsp");
					rd.forward(request, response);
				} else {
					/*
					 * If the user entered an invalid password or the passwords do
					 * not match, this code will be triggered.
					 */
					request.setAttribute("issue", "Please enter new password again.");
					
					rd = request.getRequestDispatcher("changePass.jsp");
					rd.forward(request, response);
				}
					
			} else {
				/*
				 * If the old password is incorrect, then this code will be triggered.
				 */
				request.setAttribute("issue", "Current password typed incorrectly.");
				
				rd = request.getRequestDispatcher("changePass.jsp");
				rd.forward(request, response);
			}
			
			
			break;
		case "updateinfo":
			/*
			 * This section will forward the user to the update info page
			 */
			rd = request.getRequestDispatcher("UpdateInfo.jsp");
			rd.forward(request, response);
			
			break;
		case "update":
			/*
			 * This section will run the SQL that will update the user's info
			 */
			EmployeeDAOImpl upd = new EmployeeDAOImpl();
			
			upd.UpdateEmpInfo((String)request.getSession().getAttribute("user"),
							   request.getParameter("address"),
							   request.getParameter("city"),
							   request.getParameter("state"),
							   request.getParameter("zip"),
							   request.getParameter("phone"),
							   request.getParameter("email"));
			
			request.setAttribute("issue", "Information Updated");
			
			rd = request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request, response);
			
			break;
		/*
		 * This will forward the person to the page for adding a new employee
		 */
		case "addemployee":
			rd = request.getRequestDispatcher("addnew.jsp");
			rd.forward(request, response);
			
			break;
		/*
		 * This will add a new employee to the database
		 */
		case "addnew":
			EmployeeDAOImpl addEmp = new EmployeeDAOImpl();
			EmployeePOJO emp = new EmployeePOJO();
			int maxId = addEmp.GetMaxId();		// Find the max ID number to create
												// a new unique ID
			
			// Use the constructor to build the new employee
			emp.setId(maxId + 1);
			emp.setFn(request.getParameter("fname"));
			emp.setLn(request.getParameter("lname"));
			emp.setAddr(request.getParameter("addr"));
			emp.setCity(request.getParameter("city"));
			emp.setSt(request.getParameter("st"));
			emp.setZip(request.getParameter("zip"));
			emp.setPhone(request.getParameter("phone"));
			emp.setEmail(request.getParameter("email"));
			emp.setRole(1);
			emp.setUserid(request.getParameter("username"));
			emp.setPwd("initech");		// Sets default password that must be changed
			
			addEmp.AddEmployee(emp);
			
			request.setAttribute("issue", "Employee Added");
			
			rd = request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request, response);
			
			break;
		/*
		 * This will create a table of all employees
		 */
		case "seeemp":
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		    // Call the database and get an array list of all employees
		    List<EmployeePOJO> empList = new ArrayList<EmployeePOJO>();
		    EmployeeDAOImpl getEmps = new EmployeeDAOImpl();
		    empList = getEmps.getAllEmps();
			
		    // Create the web page
		    out.println("<!-- DOCTYPE HTML -->");
		    out.println("<html lang = 'en'>");
		    out.println("<head>");
		    out.println("<!-- Required meta tags always come first -->");
		    out.println("<meta charset='utf-8'>");
		    out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
		    out.println("<meta http-equiv='x-ua-compatible' content='ie=edge'>");
		    out.println("<link rel='icon' type='image/png' href='resources/img/icon.png'>");
		    out.println("<link rel='stylesheet' type='text/css' href='resources/css/style.css'>");
		    out.println("<!-- Include Bootstrap -->");
		    out.println("<link rel='stylesheet'" +
		    		"href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'" +
		    		"integrity='sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ' crossorigin='anonymous'>");
		    out.println("<script src='https://code.jquery.com/jquery-3.1.1.slim.min.js'" +
		    		"integrity='sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js'" +
		    		"integrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'" +
		    		"integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<!-- Additional JavaScript -->");
		    out.println("<script src='http://www.w3schools.com/lib/w3data.js'></script>");
		    out.println("</head>");
		    
		    // Body of the HTML, beginning with including the nav bar
		    out.println("<body>");
		    out.println("<!-- INCLUDE NAVBAR FILE -->");
		    out.println("<div w3-include-html='navbar.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    
		    // Begin the main body of the page
		    out.println("<div class='container'>");
		    out.println("<div class='row'>");
		    
		    // This code creates the left box with the Initech logo
		    out.println("<div class='hidden-md-down col-md-4 leftbox-login'> <!-- left box -->");
		    out.println("<!-- INCLUDE LEFT BOX -->");
		    out.println("<div w3-include-html='initech.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    out.println("</div>");
		    
		    // This code creates the right box with the table
		    out.println("<div class='rightbox-login col-lg-8'> <!-- right box, where login screen is located -->");
		    out.println("<div class='outerbox'>  <!-- Used for centering the login box -->");
		    out.println("<div class='middlebox'>");
	  	    out.println("<div class='innerbox-wide'>");
		    
		    // This code will create the table of all of the employees and their info
	  	    out.println("<p>View Employees and Reimbursements</p>");
		    out.println("<table style='width:100%'>");
		    out.println("<tr><th>Name</th><th>e-Mail</th><th>Reimb.</th></tr>");
		    
		    for (EmployeePOJO x : empList) {
		    	out.println("<tr>");
			    
		    	out.println("<td>" + x.getFn() + " " + x.getLn() + "</td>");
		    	out.println("<td>" + x.getEmail() + "</td>");
		    	out.println("<td><form action='" + x.getId() + ".re'>" +
		    			"<input type='submit' value='See List'></form></td>");
		    	
		    	out.println("</tr>");
		    }
		    
		    out.println("</table>");
		    
		    // This code closes the page by closing all divs
		    out.println("</div></div></div></div></div></div></body></html>");
		    
			break;
		case "approvereimb":
			// Call the database and get an array list of all pending reimbursements
		    List<ReimbursementPOJO> reimbList = new ArrayList<ReimbursementPOJO>();
		    ReimbursementDAOImpl getReimbs = new ReimbursementDAOImpl();
		    reimbList = getReimbs.getPendReimbs();
		    
		    String resolved = null;
		    String approval = null;
		    response.setContentType("text/html");
		    out = response.getWriter();
		    
		 // Create the web page
		    out.println("<!-- DOCTYPE HTML -->");
		    out.println("<html lang = 'en'>");
		    out.println("<head>");
		    out.println("<!-- Required meta tags always come first -->");
		    out.println("<meta charset='utf-8'>");
		    out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
		    out.println("<meta http-equiv='x-ua-compatible' content='ie=edge'>");
		    out.println("<link rel='icon' type='image/png' href='resources/img/icon.png'>");
		    out.println("<link rel='stylesheet' type='text/css' href='resources/css/style.css'>");
		    out.println("<link rel='stylesheet' type='text/css' href='resources/css/font-awesome.min.css'>");
		    out.println("<!-- Include Bootstrap -->");
		    out.println("<link rel='stylesheet'" +
		    		"href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'" +
		    		"integrity='sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ' crossorigin='anonymous'>");
		    out.println("<script src='https://code.jquery.com/jquery-3.1.1.slim.min.js'" +
		    		"integrity='sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js'" +
		    		"integrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'" +
		    		"integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<!-- Additional JavaScript -->");
		    out.println("<script src='http://www.w3schools.com/lib/w3data.js'></script>");
		    out.println("<style>table td {border:1px solid #333;}</style>");
		    out.println("</head>");
		    
		    // Body of the HTML, beginning with including the nav bar
		    out.println("<body>");
		    out.println("<!-- INCLUDE NAVBAR FILE -->");
		    out.println("<div w3-include-html='navbar.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    
		    // Begin the main body of the page
		    out.println("<div class='container'>");
		    out.println("<div class='row'>");
		    
		    // This code creates the left box with the Initech logo
		    out.println("<div class='hidden-md-down col-md-4 leftbox-login'> <!-- left box -->");
		    out.println("<!-- INCLUDE LEFT BOX -->");
		    out.println("<div w3-include-html='initech.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    out.println("</div>");
		    
		    // This code creates the right box with the table
		    out.println("<div class='rightbox-login col-lg-8'> <!-- right box, where login screen is located -->");
		    out.println("<div class='outerbox'>  <!-- Used for centering the login box -->");
		    out.println("<div class='middlebox'>");
	  	    out.println("<div class='innerbox-wide2'>");
		    
		    out.println("<table style='width:100%' class='reimbursements-table'>");
		    out.println("<tr><th>Description</th><th>Amount</th><th>Image</th>" +
		    		"<th align='center'>Created On</th><th align='center'>Resolved</th>" +
		    		"<th align='center'>Approve</th></tr>");
		    
		    for (ReimbursementPOJO x : reimbList) {
		    	out.println("<tr>");
			    
		    	out.println("<td>" + x.getDescr() + "</td>");
		    	out.println("<td align='right'>$" + x.getAmt() + "</td>");
		    	out.println("<td align='center'><a href='resources/img/" + x.getRcpt() + "' target='_blank'>" +
		    			"<i class='fa fa-file-image-o'></i></a></td>");
		    	out.println("<td align='center'>" + x.getDateCr().substring(0, 10) + "</td>");
		    	
		    	// Display icon depending on whether reimbursement has been resolved
		    	if (x.getStat() == 3) {
		    		resolved = "<span style='color:red;'><i class='fa fa-times'></i></span>";
		    	} else if(x.getStat() == 2) {
		    		resolved = "<span style='color:green;'><i class='fa fa-check'></i></span>";
		    	} else {
		    		resolved = "<span style='color:blue;'><i class='fa fa-ellipsis-h'></i></span>";
		    	}
		    	out.println("<td align='center'>" + resolved + "</td>");
		    	
		    	/*
		    	 * *******************************************************************
		    	 * Need to change this section to turn the href into forms and buttons
		    	 * *******************************************************************
		    	 */
		    	if (x.getDateRe() == null) {
		    		approval = "<form action='" + x.getId() + ".ap' method='post'><button type='submit' class='fa-green-button'" +
		    				"><i class='fa fa-check'></i></button></form>" +
		    				"<form action='" + x.getId() + ".dn' method='post'><button type='submit' class='fa-red-button'" +
		    	    		"><i class='fa fa-times'></i></button></form>";
		    	} else {
		    		approval = "";
		    	}
		    	out.println("<td align='center'>" + approval + "</td>");
		    	
		    	out.println("</tr>");
		    }
		    
		    out.println("</table>");
		    
		    // This code closes the page by closing all divs
		    out.println("</div></div></div></div></div></div></body></html>");
			
			break;
		case "viewreimb":
			// Call the database and get an array list of all reimbursements
		    reimbList = new ArrayList<ReimbursementPOJO>();
		    getReimbs = new ReimbursementDAOImpl();
		    reimbList = getReimbs.getAllReimbs();
		    
		    resolved = null;
		    response.setContentType("text/html");
		    out = response.getWriter();
		    
		 // Create the web page
		    out.println("<!-- DOCTYPE HTML -->");
		    out.println("<html lang = 'en'>");
		    out.println("<head>");
		    out.println("<!-- Required meta tags always come first -->");
		    out.println("<meta charset='utf-8'>");
		    out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
		    out.println("<meta http-equiv='x-ua-compatible' content='ie=edge'>");
		    out.println("<link rel='icon' type='image/png' href='resources/img/icon.png'>");
		    out.println("<link rel='stylesheet' type='text/css' href='resources/css/style.css'>");
		    out.println("<link rel='stylesheet' type='text/css' href='resources/css/font-awesome.min.css'>");
		    out.println("<!-- Include Bootstrap -->");
		    out.println("<link rel='stylesheet'" +
		    		"href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'" +
		    		"integrity='sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ' crossorigin='anonymous'>");
		    out.println("<script src='https://code.jquery.com/jquery-3.1.1.slim.min.js'" +
		    		"integrity='sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js'" +
		    		"integrity='sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'" +
		    		"integrity='sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn'" +
		    		"crossorigin='anonymous'></script>");
		    out.println("<!-- Additional JavaScript -->");
		    out.println("<script src='http://www.w3schools.com/lib/w3data.js'></script>");
		    out.println("<style>table td {border:1px solid #333;}</style>");
		    out.println("</head>");
		    
		    // Body of the HTML, beginning with including the nav bar
		    out.println("<body>");
		    out.println("<!-- INCLUDE NAVBAR FILE -->");
		    out.println("<div w3-include-html='navbar.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    
		    // Begin the main body of the page
		    out.println("<div class='container'>");
		    out.println("<div class='row'>");
		    
		    // This code creates the left box with the Initech logo
		    out.println("<div class='hidden-md-down col-md-4 leftbox-login'> <!-- left box -->");
		    out.println("<!-- INCLUDE LEFT BOX -->");
		    out.println("<div w3-include-html='initech.html'></div>");
		    out.println("<script>w3IncludeHTML();</script>");
		    out.println("</div>");
		    
		    // This code creates the right box with the table
		    out.println("<div class='rightbox-login col-lg-8'> <!-- right box, where login screen is located -->");
		    out.println("<div class='outerbox'>  <!-- Used for centering the login box -->");
		    out.println("<div class='middlebox'>");
	  	    out.println("<div class='innerbox-wide2'>");
		    
		    // This code will create the table of all of the employees and their info
	  	    out.println("<table style='width:100%' class='reimbursements-table'>");
		    out.println("<tr><th>Description</th><th align='right'>Amount</th><th>Image</th>" +
		    		"<th align='center'>Created On</th><th align='center'>Resolved</th>");
		    
		    for (ReimbursementPOJO x : reimbList) {
		    	out.println("<tr>");
			    
		    	out.println("<td>" + x.getDescr() + "</td>");
		    	out.println("<td align='right'>$" + x.getAmt() + "</td>");
		    	out.println("<td align='center'><a href='" + x.getRcpt() + "'>" +
		    			"<i class='fa fa-file-image-o'></i></a></td>");
		    	out.println("<td align='center'>" + x.getDateCr().substring(0, 10) + "</td>");
		    	
		    	// Display icon depending on whether reimbursement has been resolved
		    	if (x.getStat() == 3) {
		    		resolved = "<span style='color:red;'><i class='fa fa-times'></i></span>";
		    	} else if(x.getStat() == 2) {
		    		resolved = "<span style='color:green;'><i class='fa fa-check'></i></span>";
		    	} else {
		    		resolved = "<span style='color:blue;'><i class='fa fa-ellipsis-h'></i></span>";
		    	}
		    	out.println("<td align='center'>" + resolved + "</td>");
		    	
		    	out.println("</tr>");
		    }
		    
		    out.println("</table>");
		    
		    // This code closes the page by closing all divs
		    out.println("</div></div></div></div></div></div></body></html>");
		    
		    break;
		case "createreimb":	// Used to redirect to the create reimbursements page when the user
							// clicks on creating a reimbursement
			rd = request.getRequestDispatcher("createReimb.jsp");
			rd.forward(request, response);
			break;
		case "createnewreimb":
			ReimbursementDAOImpl addReimb = new ReimbursementDAOImpl();
			ReimbursementPOJO reimb = new ReimbursementPOJO();
			int maxReimb = addReimb.GetMaxId();		// Find the max ID number to create
													// a new unique ID
			
			// Create a timestamp out of the current time
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curTime = date.format(new java.sql.Timestamp(cal.getTime().getTime()));
			
			SimpleDateFormat fileDate = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = fileDate.format(new java.sql.Timestamp(cal.getTime().getTime()));
			
			// Use the constructor to build the new employee
			reimb.setId(maxReimb + 1);
			
				// Jsoup will clean up potential SQL injections
			/*String unsafeDescr = request.getParameter("descr");
			String Descr = Jsoup.clean(unsafeDescr, Whitelist.basic());
			*/
			String Descr = request.getParameter("descr");
			reimb.setDescr(Descr);
			
			reimb.setAmt(Double.parseDouble(request.getParameter("amt")));
			int id = (Integer)request.getSession().getAttribute("userId");
			reimb.setEmpCr(id);
			reimb.setDateCr(curTime);
			reimb.setType(Integer.parseInt(request.getParameter("type")));
			reimb.setRcpt(fileName + ".jpg");
			
			System.out.println(reimb);
			
			addReimb.AddReimbursement(reimb);
			
			request.setAttribute("issue", "Reimbursement Added");
			
			rd = request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request, response);
			break;
		default:
			response.sendError(404);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
