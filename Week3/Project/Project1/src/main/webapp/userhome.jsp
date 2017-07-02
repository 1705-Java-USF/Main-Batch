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
<title>EmployeeHomepage</title>
</head>
<body>
	<nav class = "navbar navbar-inverse">
		<div class = "container-fluid">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "#"><%= session.getAttribute("title") %>Corp</a>
			</div>
			<ul>
				<ul class = "nav navbar-nav">
					<li class = "active"><a href = "index.jsp">HOME</a></li>
				</ul>
			</ul>
			<c:if test = "${username != null}">
			<ul class = "nav navbar-nav navbar-right">
				<li class = "dropdown"><a class = "dropdown-toggle" data-toggle = "dropdown" href = "#"><span class = "caret"></span><span class = "glyphicon glyphicon-user"></span><c:out value = "${username}"/></a>
					<ul class = "dropdown-menu">
						<li><a href = "accinfo.jsp">Account Information</a></li>
						<li><a href = "reimpage.jsp">Reimbursements</a></li>
					</ul>
				</li>
				<li><a href = "logout.do"><span class = "glyphicon glyphicon-log-in"></span>&nbsp;LOG-OUT</a></li>
			</ul>
			</c:if>
		</div>
	</nav>
	<c:if test = "${sessionScope.username == null}">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>
	<div class = "row">
		<div class = "col-md-3"></div><div class = "col-md-6">
			<h1>Welcome to InsTitleHereCorp, <c:out value = "${username}"></c:out>!</h1>
			
			<p>
				As an employee you have the ability to change update your account information, as well as view your reimbursements. In addition you can request reimbursements as well, enjoy your stay!
			</p>
			<!--<p>
				Donec semper massa nisi, id lacinia dui eleifend a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque gravida accumsan massa rutrum aliquam. In gravida ipsum ut elit facilisis, eget condimentum diam mattis. Donec sit amet dui sodales, gravida ipsum sed, pharetra tellus. In fermentum sed enim at finibus.
			</p>-->
		</div>
		<div class = "col-md-3"></div>
	</div>

</body>
</html>