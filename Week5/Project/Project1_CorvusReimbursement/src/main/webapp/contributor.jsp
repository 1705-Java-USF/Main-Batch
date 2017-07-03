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
	<script src="resources/js/redirect.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contributor</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Corvus Analyzes</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="contributor.jsp">HOME</a></li>
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
								<li><a href="accountc.jsp">Account Information</a></li>
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
	
	<div class="container text-center">
		<div class="well"><h1><c:out value="${ sessionScope.role }"></c:out>&nbsp;<c:out value="${ sessionScope.firstname }"></c:out>&nbsp;<c:out value="${ sessionScope.lastname }"></c:out></h1></div>
			<button type="button" class="btn btn-block viewMyReimb">View My Reimbursements</button>
			<button type="button" class="btn btn-block requestReimb">Request Reimbursement</button>
	</div>

</body>
</html>