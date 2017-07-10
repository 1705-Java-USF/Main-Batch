<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Portal</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- This will ensure that mobile will work with site by allowing proper formatting when zooming in -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="">Dynasty</a><img
				src="http://icons.iconarchive.com/icons/tatice/operating-systems/128/Globe-icon.png"
				align="middle" width="25" heigth="25">
		</div>
		<ul class="nav navbar-nav">
			<li><a href="Homepage.jsp">HOME</a></li>
			<li><a href="About.jsp">About Us</a></li>
			<c:if test="${ur==1}">
				<li class="active"><a href="MPortal.jsp">Manager Portal</a></li>
			</c:if>
			<c:if test="${user!=null}">
				<li><a href="Reim.jsp">Reimbursements</a></li>
			</c:if>
		</ul>
		<c:if test="${user!=null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <span class="caret"></span> <span
						class="glyphicon glyphicon-user"></span> <c:out value="${user}" /></a>
					<ul class="dropdown-menu">
						<li><a href="AccInfo.jsp">Account Information</a></li>
					</ul></li>
				<li><a href="Logout.do"><span
						class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
			</ul>
		</c:if>
	</div>
	</nav>

	<div class="jumbotron">
		<h2>List All Current Employees</h2>
		<form method="POST" action="selectAllE.do">
			<input type="submit" value="LIST">

		</form>
	</div>

	<c:if test="${newR!=null}">
		<div class="alert alert-info">Reimbursement has been Approved</div>

	</c:if>
	<div class="jumbotron">
		<h2>View Pending Requests</h2>
		<form method="POST" action="viewpendingr.do">
			<input type="submit" value="VIEW">
		</form>
	</div>
	<div class="jumbotron">
		<h2>View Resolved Requests</h2>
		<form method="POST" action="resolvedreim.do">
			<input type="submit" value="VIEW">
		</form>
	</div>
	<div class="jumbotron">
		<h2>View Denied Requests</h2>
		<form method="POST" action="deniedreim.do">
			<input type="submit" value="VIEW">
		</form>
	</div>
	<div class="jumbotron">
		<h2>Retrieve Reimbursements For:</h2>
		<form method="POST" action="reime.do">
			<input name="authorid" type="number" value="authorid" placeholder="EMPLOYEE ID">
			<input type="submit" value="VIEW">
		</form>
	</div>





</body>