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
<title>Employee Management</title>
</head>
<body>
	<c:if test="${sessionScope.user == null}">
		<jsp:forward page="index.jsp"/>
	</c:if>
	<c:if test="${sessionScope.role != 'Manager'}">
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
				<li><a href="Reimbursements.do"><div style="color:#000000">Reimbursements</div></a></li>
				<li style="background-color:#FF7700"><a href="ManagerOptions.do"><div style="color:#000000">Manager Options</div></a></li>
			</ul>
		</div>
	</nav>
	
	<div class="well">
		<h1>Employees</h1>
		
		<table border="1">
		<col width="200px"/>
		<col width="200px"/>
		<col width="200px"/>
		<col width="200px"/>
			<tr>
				<th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th>
			</tr>
			<c:forEach var="employee" items="${sessionScope.employees}">
				<tr>
					<td><c:out value="${employee.getUsername()}"/></td>
					<td><c:out value="${employee.getFirstName()}"/></td>
					<td><c:out value="${employee.getLastName()}"/></td>
					<td><c:out value="${employee.getEmail()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>Create a New Employee</h3>
		<form method="post" action="NewEmployee.do">
		<input type="text" name="user" placeholder="Username" required>
		<input type="password" name="password" placeholder="Password" required>
		<input type="text" name="email" placeholder="Email">
		<input type="text" name="firstName" placeholder="First Name">
		<input type="text" name="lastName" placeholder="Last Name">
		<input type="submit" value="Create New Employee">
		</form>
	</div>
	<hr>
	<div class="well">
		<h1>Reimbursements</h1>
		<br>
		<form method="post" action="ManagerOptions.do">
		Show reimbursements submitted by: 
		<input type="text" name="username" placeholder="Username"><br>
		view <select name="status">
			<option>All</option>
			<option>Pending</option>
			<option>Resolved</option>
			<option>Approved</option>
			<option>Denied</option>
		</select> Reimbursements
		<input type="submit" value="Update List">
		</form>
		<br>
		<table border="1">
			<col width="50px"/>
			<col width="150px"/>
			<col width="300px"/>
			<col width="200px"/>
			<col width="100px"/>
			<col width="80px"/>
			<col width="150px"/>
			<col width="200px"/>
			<tr><th>Id</th><th>Type</th><th>Description</th><th>Time Submitted</th><th>Author</th>
			<th>Status</th><th>Resolved By</th><th>Time Resolved<th>Amount</th><th></th></tr>
			<c:forEach var="reim" items="${sessionScope.reimbursements}">
				<c:if test="${userDao.getRoleById(userDao.selectUserById(reim.getAuthorId()).getRoleId()).equals('Employee')}">
					<tr>
						<td><c:out value="${reim.getId()}"/></td>
						<td><c:out value="${reimDao.getTypeById(reim.getTypeId())}"/></td>
						<td><c:out value="${reim.getDescription()}"/></td>
						<td><c:out value="${reim.getSubmitted()}"/></td>
						<td><c:out value="${userDao.selectUserById(reim.getAuthorId()).getUsername()}"/></td>
						<td><c:out value="${reimDao.getStatusById(reim.getStatusId())}"/></td>
						<td><c:out value="${userDao.selectUserById(reim.getResolverId()).getUsername()}"/></td>
						<td><c:out value="${reim.getResolved()}"/></td>
						<td><c:out value="${reim.getAmount()}"/></td>
						<td><c:if test="${reimDao.getStatusById(reim.getStatusId()).equals('Pending') }">
							<form method="post" action="UpdateReimbursement.do">
								<input type="hidden" name="ReimSelected" value="${reim.getId()}">
								<input type="hidden" name="newStatus" value="Approved">
								<button type="submit">
									Approve <span class="glyphicon glyphicon-ok"></span>
								</button>
							</form>
							<form method="post" action="UpdateReimbursement.do">
								<input type="hidden" name="ReimSelected" value="${reim.getId()}">
								<input type="hidden" name="newStatus" value="Denied">
								<button type="submit">
									Deny <span class="glyphicon glyphicon-remove"></span>
								</button>
							</form>
						</c:if>
						
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
</body>
</html>