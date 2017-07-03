package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.services.Login;
import com.revature.services.ManageProfiles;
import com.revature.services.ManageRequests;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/upload")
@MultipartConfig
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// FrontController obtains URI for url-pattern's indicated in deployment
		// descriptor
		String url = request.getRequestURI();
		System.out.println("url: " + url);

		// Obtain the name of the case by removing common url extension
		String[] tokens = url.split("/");
		for (String token : tokens) {
			System.out.print(token + ',');
		}

		String action = tokens[tokens.length - 1];
		System.out.println("Action: " + action);

		// The actual action obtained for the switch statement
		action = action.substring(0, action.length() - 3).toLowerCase();
		System.out.println("Action substring: " + action);

		// Objects to handle views within the application
		RequestDispatcher rd = null;
		HttpSession session = null;

		String username;
		String password;
		String fname;
		String lname;
		String email;
		int roleid;

		switch (action) {
		case "login":
			request.setAttribute("issue", null);
			username = request.getParameter("user");
			password = request.getParameter("password");

			// Attempt login
			Login v1 = new Login();
			if (v1.validateLogin(username, password)) {
				session = request.getSession();
				String[] attributes = v1.getAttributes(username);
				// Set session object variables
				session.setAttribute("user", username);
				session.setAttribute("fname", attributes[0]);
				session.setAttribute("lname", attributes[1]);
				session.setAttribute("email", attributes[2]);
				session.setAttribute("role", attributes[3]);
				session.setAttribute("id", attributes[4]);
				session.setAttribute("page", "loggedin");
			} else {
				request.setAttribute("issue", "invalid..");
			}
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "logout":
			// "Destroy" session object
			request.getSession().invalidate();
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;

		// Default
		case "loggedin":
			// Reset session page to default 'loggedin' main page
			session = request.getSession();
			session.setAttribute("page", "loggedin");
			session.setAttribute("viewSingle", null);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "updateprofile":
			session = request.getSession();
			username = session.getAttribute("user").toString();

			// Check that a change is being made to the profile
			if (request.getParameter("fname").length() != 0)
				fname = request.getParameter("fname");
			else
				fname = session.getAttribute("fname").toString();

			if (request.getParameter("lname").length() != 0)
				lname = request.getParameter("lname");
			else
				lname = session.getAttribute("lname").toString();

			if (request.getParameter("email").length() != 0)
				email = request.getParameter("email");
			else
				email = session.getAttribute("email").toString();

			// Session Object has no access to password
			if (request.getParameter("password").length() != 0)
				password = request.getParameter("password");
			else
				password = "";

			if (session.getAttribute("role").toString().equals("Counter-Terrorist"))
				roleid = 2;
			else
				roleid = 1;

			// Update every value of user with any new updated values as well
			ManageProfiles v2 = new ManageProfiles();
			v2.updatePersonnelInfo(username, password, fname, lname, email, roleid);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			session.setAttribute("email", email);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewpic":
			ManageRequests img = new ManageRequests();
			System.out.println(request.getParameter("thegid"));
			
			byte[] retrievedimg = img.getImageByGid(Integer.parseInt(((String)request.getParameter("thegid"))));
			
			String contentType = this.getServletContext().getMimeType("type.jpg");
			System.out.println("Content Type: " + contentType);

			response.setHeader("Content-Type", contentType);

			response.setHeader("Content-Length", String.valueOf(retrievedimg.length));

			response.setHeader("Content-Disposition", "inline; filename=\"" + "req_form" + (String)request.getParameter("thegid") + "\"");

			// Write image data to Response.
			response.getOutputStream().write(retrievedimg);
			break;
			// Counter-Terrorist
		case "gunrequest":
			session = request.getSession();
			session.setAttribute("page", "gunrequest");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewprofile":
			session = request.getSession();
			session.setAttribute("page", "viewprofile");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "upload":
			session = request.getSession();
			// Using Servlet 3.0 to upload a file
			// String description = request.getParameter("fileUpload"); //
			// Retrieves <input type="text" name="description">
			Part filePart = request.getPart("fileUpload"); // Retrieves <input
															// type="file"
															// name="file">
			// String fileName =
			// Paths.get(getSubmittedFileName(filePart)).getFileName().toString();
			// // MSIE fix.

			// System.out.println(fileName); //80's+City.jpg

			InputStream fileContent = filePart.getInputStream();

			// Convert image to byte array for a Request object
			// ByteArrayOutputStream output = new ByteArrayOutputStream();
			// byte[] buffer = new byte[10240];
			// for (int length = 0; (length = fileContent.read(buffer)) > 0;)
			// output.write(buffer, 0, length);
			// pojo setter: someEntity.setImage(output.toByteArray());

			ManageRequests mr = new ManageRequests();
			mr.sendPedReqFormToDB(fileContent, request.getParameter("description"), request.getParameter("guntype"),
					Integer.parseInt(request.getParameter("cost")), session.getAttribute("user").toString(), 1);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		// FBI Manager
		case "viewreqs":
			session = request.getSession();
			session.setAttribute("page", "viewreqs");

			ManageRequests mr2 = new ManageRequests();
			String[][] reqs = mr2.getAllRequests();

			Integer rlen = reqs.length - 1;
			String reqlength = rlen.toString();

			session.setAttribute("pendingreqs", reqs);
			session.setAttribute("preqslength", reqlength);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewoldreqs":
			session = request.getSession();
			session.setAttribute("page", "viewoldreqs");

			ManageRequests mr2b = new ManageRequests();
			String[][] reqsb = mr2b.getAllRequests();

			Integer rlenb = reqsb.length - 1;
			String reqlengthb = rlenb.toString();

			session.setAttribute("pendingreqs", reqsb);
			session.setAttribute("preqslength", reqlengthb);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "approve": // 2
			session = request.getSession();
			String[][] apreqs = (String[][]) session.getAttribute("pendingreqs");
			String reqIdUpd = request.getParameter("approve");
			int j1 = Integer.parseInt(request.getParameter("thej"));

			ManageRequests mr3 = new ManageRequests();
			mr3.updateRequestStatusById("approve", (String) session.getAttribute("id"), reqIdUpd);

			apreqs[j1][10] = "2";
			session.setAttribute("pendingreqs", apreqs);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "deny": // 3
			session = request.getSession();
			String[][] apreqs2 = (String[][]) session.getAttribute("pendingreqs");
			String reqIdUpd2 = request.getParameter("deny");
			int j2 = Integer.parseInt(request.getParameter("thej"));

			ManageRequests mr4 = new ManageRequests();
			mr4.updateRequestStatusById("deny", (String) session.getAttribute("id"), reqIdUpd2);

			apreqs2[j2][10] = "3";
			session.setAttribute("pendingreqs", apreqs2);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "promote":
			session = request.getSession();
			String[][] approf = (String[][]) session.getAttribute("people");
			String reqIdUpd3 = request.getParameter("promote");
			int j3 = Integer.parseInt(request.getParameter("thej"));

			ManageProfiles v4 = new ManageProfiles();
			v4.promoteById(reqIdUpd3);

			approf[j3][4] = "FBI Manager";
			session.setAttribute("people", approf);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewcts":
			session = request.getSession();
			session.setAttribute("page", "viewcts");

			ManageProfiles v3 = new ManageProfiles();
			String[][] people = v3.getProfiles();

			Integer plen = people.length - 1;
			String peoplelength = plen.toString();

			session.setAttribute("people", people);
			session.setAttribute("peoplelength", peoplelength);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		case "viewsingle":
			session = request.getSession();
			session.setAttribute("viewSingle", request.getParameter("ct"));

			System.out.println(request.getParameter("ct"));

			ManageRequests s = new ManageRequests();
			String[][] sreqs = s.getAllRequests();

			Integer srlen = sreqs.length - 1;
			String sreqlength = srlen.toString();

			session.setAttribute("pendingreqs", sreqs);
			session.setAttribute("preqslength", sreqlength);

			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		default:
			response.sendError(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
