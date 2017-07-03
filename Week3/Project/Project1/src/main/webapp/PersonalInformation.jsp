<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/default.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information</title>
</head>
<body>
	<c:if test="${sessionScope.user == null}">
		<jsp:forward page="index.jsp" />
	</c:if>
	<nav class="navbar navbar-default navbar-fixed-top"
		style="color: #000000">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-left"><img alt="Revature"
					src="https://mv.force.com/revature/resource/1479749399000/RevatureLogo"
					height="50px"></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">
						<button style="background-color: #FF7700; color: #000000">
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
						<span class="caret"></span>
						</button>
				</a>
					<ul class="dropdown-menu">
						<li><a href="Logout.do"><span
								class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse" style="background-color: #888888">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp"><div style="color: #000000">Homepage</div></a>
				<li style="background-color: #FF7700"><a
					href="PersonalInformation.jsp"><div style="color: #000000">Personal Information</div></a></li>
				<li><a href="Reimbursements.do"><div style="color: #000000">Reimbursements</div></a></li>
				<c:if test="${sessionScope.role == 'Manager'}">
					<li><a href="ManagerOptions.do"><div style="color:#000000">Manager Options</div></a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	<div class="well row">

		<div class="col-md-6">
			<h1 style="text-align:center;text-decoration:underline">
			Currently Logged in as
			</h1>
			<h1>
				Username:
				<c:out value="${sessionScope.user.getUsername()}" />
			</h1>
			<!-- <h1>
				Password:
				<c:out value="${sessionScope.user.getPassword()}" />
			</h1> -->
			<h1>
				Name:
				<c:out
					value="${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}" />
			</h1>
			<h1>
				Email:
				<c:out value="${sessionScope.user.getEmail()}" />
			</h1>
		</div>
		<div class="col-md-6">
			<h1 style="text-align:center;text-decoration:underline">
			Update Information
			</h1>
			<form method="post" action="update.do">
				Username: <input type="text" name="username" placeholder="Username"
					value="${sessionScope.user.getUsername()}"><br><br>
				Current Password: <input type="password" name="oldpassword"
					placeholder="Password" required>
					New Password: <input type="password" name="newpassword" placeholder="Password"><br><br>
				First Name: <input type="text" name="firstName"
					placeholder="First Name"
					value="${sessionScope.user.getFirstName()}"> Last Name: <input
					type="text" name="lastName" placeholder="Last Name"
					value="${sessionScope.user.getLastName()}"><br><br>
				Email: <input type="text" name="email" placeholder="E-mail"
					value="${sessionScope.user.getEmail()}"> <br><br>
				<button type="submit">
					SUBMIT CHANGES <span class="glyphicon glyphicon-ok"></span>
				</button>
				<button type="reset">
					RESET CHANGES <span class="glyphicon glyphicon-remove"></span>
				</button>
			</form>
		</div>
	</div>
</body>
</html>