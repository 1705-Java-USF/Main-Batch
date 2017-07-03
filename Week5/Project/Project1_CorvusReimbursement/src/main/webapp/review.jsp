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
	<script src="resources/js/table-ajax.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Reimbursements</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Corvus Analyzes</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="manager.jsp">HOME</a></li>
				<li class="active"><a href="review.jsp">REVIEW REIMBURSEMENTS</a></li>
				<li><a href="view-c.jsp">VIEW ALL USERS</a>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.username != null}">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<span class="caret"></span>
							<span class="glyphicon glyphicon-user"></span>
							&nbsp;<c:out value="${sessionScope.username}"></c:out></a>
							<ul class="dropdown-menu">
								<li><a href="account.jsp">Account Information</a></li>
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
			<c:if test="${ sessionScope.role == 'Contributor' }">
				<c:redirect url="contributor.jsp"></c:redirect>
			</c:if>
		</div>
	</nav>
	<div class="container-fluid portal-background">
	
		<select id="statusFilter" class="form-control">
		    <option value="All">All</option>
		    <option value="Pending">Pending</option>
		    <option value="Resolved">Resolved</option>
		</select>
	
		<table id="reviewTable" class="table table-striped">
		    <thead>
		    	<tr>
		    		<th>ID</th>
		        	<th>Amount</th>
		        	<th>Author</th>
		        	<th>Description</th>
		        	<th>Date Submitted</th>
		        	<th>Type</th>
		        	<th>Receipt</th>
		        	<th>Status</th>
		        	<th>Resolver</th>
		        	<th>Date Resolved</th>
		        	<th>Approve/Deny</th>
		    	</tr>
		    </thead>
	    </table>
	</div>
	
</body>
</html>