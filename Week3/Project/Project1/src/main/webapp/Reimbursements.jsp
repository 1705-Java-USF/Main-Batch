<%@page import="com.revature.dao.ReimbursementDaoImpl"%>
<%@page import="com.revature.dao.ReimbursementDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/default.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements</title>
</head>
<body>
	<c:if test="${sessionScope.user == null}">
		<jsp:forward page="index.jsp"/>
	</c:if>
	<nav class="navbar navbar-default navbar-fixed-top" style="color:#000000">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-left"><img alt="Revature" src="https://mv.force.com/revature/resource/1479749399000/RevatureLogo" height="50px"></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<button style="background-color:#FF7700;color:#000000">
						<c:choose>
							<c:when test="${user.getFirstName() != '' && user.getLastName() != ''}">
								${user.getFirstName()} ${user.getLastName()}
							</c:when>
							<c:when test="${user.getFirstName() != ''}">
								${user.getFirstName()}
							</c:when>
							<c:when test="${user.getLastName() != ''}">
								${user.getLastName()}
							</c:when>
							<c:otherwise>
								${user.getUsername()}
							</c:otherwise>
						</c:choose>
					<span class="caret"></span></button></a>
					<ul class="dropdown-menu">
						<li><a href="Logout.do"><span class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<br><br><br>
	<nav class="navbar navbar-inverse" style="background-color:#888888">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp"><div style="color:#000000">Homepage</div></a>
				<li><a href="PersonalInformation.jsp"><div style="color:#000000">Personal Information</div></a></li>
				<li style="background-color:#FF7700"><a href="Reimbursements.do"><div style="color:#000000">Reimbursements</div></a></li>
				<c:if test="${sessionScope.role == 'Manager'}">
					<li><a href="ManagerOptions.do"><div style="color:#000000">Manager Options</div></a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	<div class="well row">
		<h2>Your Reimbursements:</h2>
		<form method="post" action="Reimbursements.do">
		<p>view <select name="status">
			<option>All</option>
			<option>Pending</option>
			<option>Resolved</option>
			<option>Approved</option>
			<option>Denied</option>
		</select> Reimbursements
		<input type="submit" value="Update List">
		</p></form>
		<br>
		<table border="1">
			<col width="50px"/>
			<col width="150px"/>
			<col width="300px"/>
			<col width="200px"/>
			<col width="150px"/>
			<col width="150px"/>
			<tr><th>Id</th><th>Type</th><th>Description</th><th>Time Submitted</th><th>Status</th><th>Amount</th></tr>
			<c:forEach var="reim" items="${sessionScope.reimbursements}">
				<tr>
					<td><c:out value="${reim.getId()}"/></td>
					<td><c:out value="${reimDao.getTypeById(reim.getTypeId())}"/></td>
					<td><c:out value="${reim.getDescription()}"/></td>
					<td><c:out value="${reim.getSubmitted()}"/></td>
					<td><c:out value="${reimDao.getStatusById(reim.getStatusId())}"/></td>
					<td>USD $<c:out value="${reim.getAmount()}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div class="well row">
		<h1>Create a Reimbursement Request</h1><br>
		<form method="post" action="NewReimbursement.do" enctype="multipart/form-data">
			$<input type="text" name="amount" placeholder="Amount">
			<input type="text" name="description" placeholder="Description">
			<select name="type">
				<option>Travel</option>
				<option>Equipment</option>
				<option>Training</option>
				<option>Parking</option>
				<option>Enthuware</option>
				<option>Other</option>
			</select>
			<!-- <input type="file" name="receipt"> -->
			<input type="submit" value="Create Reimbursement">
		
		</form>
	</div>
</body>
</html>