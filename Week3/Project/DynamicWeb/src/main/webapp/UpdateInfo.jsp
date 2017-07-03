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
								
								<p>Use the form below to update your information.</p>
								
								<!-- This form will be used to update the user's information -->
								<form class="update-info" action="update.do" method="post">
									<p>First Name: <%= session.getAttribute("firstName") %></p>
									<p>Last Name: <%= session.getAttribute("lastName") %></p>
									<p>Address:
										<input type="text" name="address" value="<%= session.getAttribute("address") %>"
											style="width:350px;"></p>
									<p>City:
										<input type="text" name="city" value="<%= session.getAttribute("city") %>"
											style="width:150px;">
										State: <input type="text" name="state" value="<%= session.getAttribute("state") %>"
											style="width:50px;">
										Zip: <input type="text" name="zip" value="<%= session.getAttribute("zip") %>"
											style="width:100px;"></p>
									<p>Phone Number:
										<input type="text" name="phone" value="<%= session.getAttribute("phone") %>"
											style="width:150px;" pattern="(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}"></p>
									<p>e-Mail:
										<input type="text" name="email" value="<%= session.getAttribute("email") %>"
											style="width:350px;" pattern="[a-z0-9A-Z._%+-]+@[a-z0-9A-Z.-]+\.[a-zA-Z]{2,3}$"></p>
									<p><input type="submit" value="Update Info" style="margin:auto;display:block;"></p>
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