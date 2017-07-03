<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<script src="resources/js/default.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement Hub</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Reimbursement Hub</a>
			</div>
			<c:if test="${user!=null}">
				<ul class="nav navbar-nav">
					<c:choose>
						<c:when test = "${sessionScope.isManager==true}">
							<li id="home" class="active"><a onclick="includeHomeM()">Home Page</a></li>
							<li id="p_view"><a onclick="includeViewPM()">View Pending Requests</a></li>
							<li id="r_view"><a onclick="includeViewRM()">View Resolved Requests</a></li>
							<li id="e_view"><a onclick="includeViewEmploys()">View Employees</a></li>
							<li id="register"><a onclick="includeRegisterEmploys()">Register Employees</a></li>
						</c:when>
						<c:otherwise>
							<li id="home" class="active"><a onclick="includeHomeE()">Home Page</a></li>
							<li id="p_view"><a onclick="includeViewPE()">View Pending Requests</a></li>
							<li id="r_view"><a onclick="includeViewRE()">View Resolved Requests</a></li>
							<li id="submit"><a onclick="includeSubmitR()">Submit Reimbursements</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">
						<span class="caret"></span><span class="glyphicon glyphicon-user"></span> <c:out value="${user}"/></a>
						<ul class="dropdown-menu">
							<li><a onclick="includeAccount()">Account Information</a></li>
						</ul>
					</li>
					<li><a href="logout.do"><span class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
				</ul>
			</c:if>
		</div>
	</nav>
	<div class="container-fluid">		
		<c:choose>
			<c:when test="${sessionScope.user==null}">
				<div class="jumbotron">
					<h2>PLEASE LOGIN!</h2>
					<c:if test="${issue!=null}">
						<div class="alert alert-danger">INVALID CREDENTIALS</div>
					</c:if>
					<form method="post" action="login.do">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" name="username" class="form-control" placeholder="USERNAME" required>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input type="password" name="password" class="form-control" placeholder="PASSWORD" required>
						</div>
						<br>
						<div>
							<input type="submit" value="LOGIN">
						</div>
					</form>
				</div>
			</c:when>
			<c:otherwise>
					<div class="space"></div>
					<c:choose>
						<c:when test = "${sessionScope.isManager==true}">
							<script>includeHomeM()</script>
			         	</c:when>
			         	<c:otherwise>
							<script>includeHomeE()</script>
						</c:otherwise>
					</c:choose>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>