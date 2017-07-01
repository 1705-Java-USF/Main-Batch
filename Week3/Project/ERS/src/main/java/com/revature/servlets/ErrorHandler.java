package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler
 */
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		
		Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(""
				+ "<head> <meta charset='ISO-8859-1'>"
				+ "<title>Expense Reimbursement System</title>"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
				+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
				+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
				+ "<link rel='stylesheet' type='text/css' href='resources/css/default.css'>"
				+ "<script>"
				+ "$(document).ready(function() {$('#my_audio').get(0).play();});"
				+ "</script>"
				+ "</head>"
				+ "<body>"
				+ "<audio id='my_audio' src='resources/audio/error.mp3'>"
				+ "</audio>"
				+ "<div class='window' id='reimb' style='height:100px;'>"
				+ "<div class='window_header col-md-12'>"
				+ "Error"
				+ "</div>"
				+ "<br><br>"
				+ "<div class='col-md-1'>"
				+ "<img src='resources/img/error.png'></img>"
				+ "</div>"
				+ "<div class='col-md-11' style='text-align:center;'>"
				+ "Error " + statusCode + " has occured. Please try what you are doing again until it works."
				+ "</div>"
				+ "</div>"
				+ "</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
