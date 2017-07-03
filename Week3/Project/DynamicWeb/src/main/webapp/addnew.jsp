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
		
		<!-- Include Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
		
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
			
				<div class="hidden-md-down col-md-4 leftbox-login"> <!-- left box -->
					<!-- INCLUDE LEFT BOX -->
					<div w3-include-html="initech.html"></div> 
					<script>w3IncludeHTML();</script>
				</div>
				
				<div class="rightbox-login col-lg-8"> <!-- right box, where login screen is located -->
				
					<div class="outerbox">  <!-- Used for centering the login box -->
						<div class="middlebox">
							<div class="innerbox">
							
								<% if (request.getAttribute("issue") != null) { %>
									<p class="login-issue"><%= request.getAttribute("issue") %></p>
								<% } 
								request.setAttribute("issue", null);%>
							
								<p>Enter the information for the new employee:</p>
								<form class="login" action="addnew.do" method="post">
									<p>First Name: <input type="text" name="fname"></p>
									<p>Last Name: <input type="text" name="lname"></p>
									<p>Address: <input type="text" name="addr" style="width:350px;"></p>
									<p>City: <input type="text" name="city" style="width:150px;">
									State: <input type="text" name="st" style="width:50px;">
									Zip: <input type="text" name="zip" style="width:100px;"></p>
									<p>e-Mail: <input type="text" name="email"></p>
									<p>Phone: <input type="text" name="phone"
										 pattern="(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}"></p>
									<p>Login ID: <input type="text" name="username"></p>
									<p><input type="submit" value="Create Employee"></p>
								</form>
							
							</div>
						</div>
					</div>
				
				</div> <!-- Close right box -->
			
			</div> <!-- Close the row div -->
		
		</div> <!-- Close the container div -->
	
	</body>

</html>