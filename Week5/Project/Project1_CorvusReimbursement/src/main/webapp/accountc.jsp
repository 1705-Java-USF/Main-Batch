<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/default.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Corvus Analyzes</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="contributor.jsp">HOME</a></li>
				<li><a href="my_reimbursements.jsp">VIEW MY REIMBURSEMENTS</a></li>
				<li><a href="request_reimbursement.jsp">REQUEST REIMBURSEMENT</a></li>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.username != null}">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<span class="caret"></span>
							<span class="glyphicon glyphicon-user"></span>
							&nbsp;<c:out value="${sessionScope.username}"></c:out></a>
							<ul class="dropdown-menu">
								<li class="active"><a href="accountc.jsp">Account Information</a></li>
								<li><a href="new-user.jsp">Add New Contributor</a></li>
							</ul>
						</li>
						<li><a href="logout.corvus"><span class="glyphicon glyphicon-log-in"></span>&nbsp;LOGOUT</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<c:redirect url="login.jsp"></c:redirect>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="jumbotron center-on-screen">
			<c:if test="${ requestScope.issueUsername != null }">
				<div class="alert alert-danger"><c:out value="${ requestScope.issueUsername }"></c:out></div>
			</c:if>
			<c:if test="${ requestScope.issuePassword != null }">
				<div class="alert alert-danger"><c:out value="${ requestScope.issuePassword }"></c:out></div>
			</c:if>
			<c:if test="${ requestScope.issue != null }">
				<div class="alert alert-success"><c:out value="${ requestScope.issue }"></c:out></div>
			</c:if>
			<form method="post" action="update-account.corvus">
				<strong>Username</strong><br /><input type="text" name="username" class="form-control" placeholder="<c:out value="${ sessionScope.username }"></c:out>"> <br />
				<strong>First Name</strong><br /><input type="text" name="firstname" class="form-control" placeholder="<c:out value="${ sessionScope.firstname }"></c:out>"> <br />
				<strong>Last Name</strong><br /><input type="text" name="lastname" class="form-control" placeholder="<c:out value="${ sessionScope.lastname }"></c:out>"> <br />
				<strong>Email</strong><br /><input type="text" name="email" class="form-control" placeholder="<c:out value="${ sessionScope.email }"></c:out>"> <br />
				<strong>Old Password</strong><br /><input type="password" name="oldpassword" class="form-control" placeholder="*******"> <br />
				<strong>New Password</strong><br /><input type="password" name="newpassword" class="form-control" placeholder="*******"><br />
	
				<input type="submit" class="btn btn-success" value="Submit Changes">
				<a class="btn btn-danger" href="contributor.jsp">Return Home</a>
			</form>
		</div>
	</div>
</body>
</html>