<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type = "text/css" href = "resources/css/default.css">
<meta charset="ISO-8859-1">
<title>Account Information</title>
</head>
<body>
	<nav class = "navbar navbar-inverse">
		<div class = "container-fluid">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "#"><%= session.getAttribute("title") %>Corp</a>
			</div>
			<ul>
				<ul class = "nav navbar-nav">
					<li><a href = "index.jsp">HOME</a></li>
				</ul>
			</ul>
			<c:if test = "${username != null}">
			<ul class = "nav navbar-nav navbar-right">
				<li class = "dropdown"><a class = "dropdown-toggle" data-toggle = "dropdown" href = "#"><span class = "caret"></span><span class = "glyphicon glyphicon-user"></span><c:out value = "${username}"/></a>
					<ul class = "dropdown-menu">
						<li class = "active"><a href = "accinfo.jsp">Account Information</a></li>
						<li><a href = "reimpage.jsp">Reimbursements</a></li>
						<c:if test = "${sessionScope.role == 'Manager'}">	
							<li><a href = "viewemployees.jsp">Employees</a></li>
						</c:if>
					</ul>
				</li>
				<li><a href = "logout.do"><span class = "glyphicon glyphicon-log-in"></span>&nbsp;LOG-OUT</a></li>
			</ul>
			</c:if>
		</div>
	</nav>
	<h1>Update Account Information</h1>
	<c:if test = "${failure != null}">
		<div class = "alert alert-danger">Failed to update info, either username or email is already in use or not enough information entered!</div>
	</c:if>
	<c:if test = "${success != null}">
		<div class = "alert alert-success">Updated information successfully</div>
	</c:if>
	<div class = "container-fluid">
		<div id = "info">
			<h2>Username: <c:out value = "${username}"></c:out></h2>
			<h2>Role: <c:out value = "${role}"></c:out></h2>
			<h2>First and Last name: <c:out value = "${first}"></c:out> <c:out value = "${last}"></c:out></h2>
			<h2>Email: <c:out value = "${email}"></c:out></h2>
		</div>
		<form method = "get" action = "update.do">
			<h2>Update your information</h2>
			<ul style = "list-style-type: none;">
				<li>USERNAME</li>
				<li><input type = "text" name = "username"></li>
				<li>PASSWORD</li>
				<li><input type = "password" name = "password"></li>
				<li>FIRST NAME</li>
				<li><input type = "text" name = "first"></li>
				<li>LAST NAME</li>
				<li><input type = "text" name = "last"></li>
				<li>EMAIL</li>
				<li><input type = "text" name = "email"></li>
			</ul>
			<div class = "darkfont">
				<input type = "submit" value = "UPDATE">
			</div>
		</form>
	</div>
	<c:if test = "${sessionScope.username == null}">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>
</body>
</html>