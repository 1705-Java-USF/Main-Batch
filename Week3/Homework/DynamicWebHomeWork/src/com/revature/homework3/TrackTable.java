package com.revature.homework3;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TrackTable
 */
@WebServlet("/TrackTable")
public class TrackTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		if(session.isNew()){
			out.println("Please input information first!");
			session.invalidate(); //Purges session object
			
		}else{
			String user = (String)session.getAttribute("user");
			String password = (String)session.getAttribute("password");
			int age = (Integer)session.getAttribute("age");
			String email = (String)session.getAttribute("email");
			String cbcom = (String)session.getAttribute("cbcom");
			String cbhor = (String)session.getAttribute("cbhor");
			String cbsci = (String)session.getAttribute("cbsci");
			String cbrom = (String)session.getAttribute("cbrom");
			String cbthrill = (String)session.getAttribute("cbthrill");
			String PreferredAthlete1 = (String)session.getAttribute("PreferredAthlet1");
			String PreferredAthlete2 = (String)session.getAttribute("PreferredAthlet2");
			String PreferredAthlete3 = (String)session.getAttribute("PreferredAthlet3");
			String PreferredAthlete4 = (String)session.getAttribute("PreferredAthlet4");
			String PreferredAthlete5 = (String)session.getAttribute("PreferredAthlet5");
			String PreferredAthlete6 = (String)session.getAttribute("PreferredAthlet6");
			String PreferredAthlete7 = (String)session.getAttribute("PreferredAthlet7");
			String games = (String)session.getAttribute("games");
			out.println("<h2>Welcome , " + user + "</h2><br>");
			out.println("Below is your information: <br><table border = '1px'><tr><th>Field Name</th><th>Field Value</th></tr>");
			out.print("<tr><td>User Name</td><td>" + user + "/<td></tr>");
			out.print("<tr><td>Password</td><td>" + password + "/<td></tr>");
			out.print("<tr><td>Age</td><td>" + age + "/<td></tr>");
			out.print("<tr><td>Email</td><td>" + email + "/<td></tr>");
			out.print("<tr><td>Favorite Genres of Movies</td><td>" + cbcom + "/<td></tr>");
			out.print("<tr><td>Favorite Genres of Movies</td><td>" + cbhor + "/<td></tr>");
			out.print("<tr><td>Favorite Genres of Movies</td><td>" + cbsci + "/<td></tr>");
			out.print("<tr><td>Favorite Genres of Movies</td><td>" + cbrom + "/<td></tr>");
			out.print("<tr><td>Favorite Genres of Movies</td><td>" + cbthrill + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete1 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete2 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete3 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete4 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete5 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete6 + "/<td></tr>");
			out.print("<tr><td>MVP Chosen</td><td>" + PreferredAthlete7 + "/<td></tr>");
			out.print("<tr><td>NBA Games Seen</td><td>" + games + "/<td></tr>");
			out.println("</table>");
			
		}
		out.println(
				"<hr>" + 
				"<a href = 'index.html'> BACK</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
