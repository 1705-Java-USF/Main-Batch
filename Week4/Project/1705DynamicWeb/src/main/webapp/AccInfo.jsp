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
<title>Account Info</title>
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
				<li><a href="MPortal.jsp">Manager Portal</a></li>
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
	<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

	<div class="jumbotron">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Lame</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${user}"></c:out></td>
					<td><c:out value="${fname}"></c:out></td>
					<td><c:out value="${lname}"></c:out></td>
					<td><c:out value="${email}"></c:out></td>
				</tr>
			</tbody>
		</table>

	</div>
	<div class="well">
		<form method="post" action="update.do">
			<c:if test="${issue!=null}">
				<div class="alert alert-danger">Username is Taken</div>

			</c:if>
			<c:if test="${newUp!=null}">
				<div class="alert alert-success">Account Updated</div>

			</c:if>
			<h3>Update Credentials</h3>
			<div class="input-group">
				Username: <input type="text" name="userNew" class="form-control"
					placeholder="USERNAME" size="4" />
			</div>
			<br>
			<div class="input-group">
				Password: <input type="password" name="pass" class="form-control"
					placeholder="PASSWORD" size="4" />
			</div>
			<br>
			<div class="input-group">
				First Name: <input type="text" name="fname" class="form-control"
					placeholder="FIRST NAME" size="4" />
			</div>
			<br>
			<div class="input-group">
				Last Name: <input type="text" name="lname" class="form-control"
					placeholder="LAST NAME" size="4" />
			</div>
			<br>
			<div class="input-group">
				Email: <input type="email" name="email" class="form-control"
					placeholder="EMAIL" size="5" />
			</div>
			<br>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>

</body>
</html>