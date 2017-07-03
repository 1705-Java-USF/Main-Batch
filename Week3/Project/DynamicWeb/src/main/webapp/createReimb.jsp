<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- DOCTYPE HTML -->
<html lang = "en">

	<head>
		<!-- Required meta tags always come first -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<link rel="icon" type="image/png" href="resources/img/icon.png">
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
	
		<!-- jQuery first, then Bootstrap JS. -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js" integrity="sha384-vZ2WRJMwsjRMW/8U7i6PWi6AlO1L79snBrmgiDpgIWJ82z8eA5lenwvxbMV1PAh7" crossorigin="anonymous"></script>
	
		<!-- Additional JavaScript -->
		<script src="http://www.w3schools.com/lib/w3data.js"></script>
	
	</head>
	
	<body>
	
		<!-- INCLUDE NAVBAR FILE -->
		<div w3-include-html="navbar.html" class="hidden-sm-down"></div> 
		<script>w3IncludeHTML();</script>
		
			<ul class="nav navbar-nav navbar-right hidden-md-up">
				
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						
						<span class="caret"></span>
						<span class="glyphicon glyphicon-user"></span>
							
						<c:out value="${sessionScope.user}"></c:out>
						
					</a>
						
					<ul class="dropdown-menu">
						<li><a href="EmpHome.jsp">Home</a></li>
						<li><a href="tps.html">TPS Reports</a></li>
						<li><a href="Logout.do">Logout</a></li>
					</ul>
						
				</li>
				
			</ul>
		
		<div class="container">
		
			<div class="row">
			
				<div class="hidden-md-down col-lg-4 leftbox-login"> <!-- left box -->
					<!-- INCLUDE LEFT BOX -->
					<div w3-include-html="initech.html"></div> 
					<script>w3IncludeHTML();</script>
				</div>
				
				<div class="rightbox-login col-lg-8"> <!-- Right box -->
					
					<div class="outerbox">  <!-- Used for centering the page -->
						<div class="middlebox">
							<div class="innerbox emp-screen">
							
								<!-- Display page only if there is a session -->
								<% if (session.getAttribute("user") != null) { %>
								
								<!-- If the page has an issue, display it here. -->
								<% if (request.getAttribute("issue") != null) { %>
									<p class="login-issue"><%= request.getAttribute("issue") %></p>
								<% } 
								request.setAttribute("issue", null);%>
								
								<p>Use the form below to upload a new reimbursement.</p>
								
								<!-- This form will be used to create a new reimbursement -->
								<form class="update-info" action="createNewReimb.do" method="post">
									<p>Description: <input type="text" name="descr" style="width:350px;"></p>
									<p>Amount: <input type="number" name="amt" step="any" required></p>
									<p>Type: <select name="type">
										<option value="1">Travel</option>
										<option value="2">Training</option>
										<option value="3">TPS Reports</option>
										<option value="4">Materials</option>
									</select>
									<p>Upload receipt: <input type="file" name="rcpt" id="rcpt">
									<p><input type="submit" value="Create" style="margin:auto;display:block;"></p>
								</form>
							
								<% } else { %>
								<!-- This else function runs when the person is not logged in -->
								
								<p>Oops, it looks like something went wrong! You're not logged in.</p>
								<p>Click on "Home" above to return to the login screen.</p>
					
								<% } %>
							
							</div>
						</div>
					</div>
					
				</div> <!-- Close right box -->
			
			</div>
	
		</div>

	</body>
</html>