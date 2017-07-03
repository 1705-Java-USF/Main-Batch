package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReimbursementDAOImpl;
import DAO.EmployeeDAOImpl;
import Database.EmployeePOJO;
import Database.ReimbursementPOJO;

/**
 * Servlet implementation class ReimbController
 */
public class ReimbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * This controller will generare a query of all of the reimbursements made by
		 * a specific employee.
		 */
		String url = request.getRequestURI();
		String tokens[] = url.split("/");
		String action = tokens[tokens.length - 1];
		action = action.substring(0, action.length() - 3).toLowerCase();
		int userId = Integer.parseInt(action);
		
		String resolved = null;
		String approval = null;
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    // Call the database and get an array list of all employees
	    List<ReimbursementPOJO> reimbList = new ArrayList<ReimbursementPOJO>();
	    ReimbursementDAOImpl getReimbs = new ReimbursementDAOImpl();
	    reimbList = getReimbs.selectReimbByID(userId);
	    
	    EmployeeDAOImpl emp = new EmployeeDAOImpl();
	    String empName = emp.selectEmpByID(userId).getFn() + " " + emp.selectEmpByID(userId).getLn();
	    
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
	    
  	    // This code will create the table headers
  	    out.println("<p>View Reimbursements for " + empName + "</p>");
  	    out.println("<table style='width:100%' class='reimbursements-table'>");
	    out.println("<tr><th>Description</th><th>Amount</th><th>Image</th>" +
	    		"<th align='center'>Created On</th><th align='center'>Resolved</th>");
	    
	    		if(request.getSession().getAttribute("role").equals(2)) {
	    			out.println("<th align='center'>Approve</th>");
	    		}
	    
	    out.println("</tr>");
	    
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
	    	
	    	if(request.getSession().getAttribute("role").equals(2)) {
	    		if (x.getDateRe() == null) {
	    			approval = "<form action='" + x.getId() + ".ap' method='post'><button type='submit' class='fa-green-button'" +
	    					"><i class='fa fa-check'></i></button></form>" +
	    					"<form action='" + x.getId() + ".dn' method='post'><button type='submit' class='fa-red-button'" +
	    					"><i class='fa fa-times'></i></button></form>";
	    		} else {
	    			approval = "";
	    		}
	    		out.println("<td align='center'>" + approval + "</td>");
	    	}
	    	
	    	out.println("</tr>");
	    }
	    
	    out.println("</table>");
	    
	    // This code closes the page by closing all divs
	    out.println("</div></div></div></div></div></div></body></html>");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
