<!-- JSTL tags -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%-- importing pojo and dao packages --%>
<%@ page import="com.revature.pojo.*, com.revature.dao.*"%>

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

<!-- This will ensure that mobile will work with site by allowing proper formatting when zooming in -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Select character encoding support -->
<link rel="stylesheet" type="text/css" href="/Project1/CSS/default.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project 1</title>
<!-- tab title  -->

</head>

<body>

	<%-- make sure there's a connected user. If not, then forward them to the login page --%>
	<c:if test="${sessionScope.username==null}">

		<jsp:forward page="/WEB-INF/login.jsp" />
	</c:if>


	<c:choose>
		<%-- login 1 for manager, 2 for employee --%>
		<c:when test="${role_id==1}">
			<!-- using JSTL tags to check the user role_id (manager or employee)-->

			<nav class="navbar navbar-inverse"> <!-- navbar at the top -->

			<div class="container-fluid">

				<div class="navbar-header">
					<a class="navbar-brand">Company Name</a>
					<!-- main navbar link -->
				</div>

				<ul class="nav navbar-nav">
					<!-- navbar links -->
					<li class="active"><a href="${pageContext.request.contextPath}/index/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/myinfo/">My Information</a></li>
					<li><a href="${pageContext.request.contextPath}/reimbursements/">Reimbursements</a></li>
					<li><a href="${pageContext.request.contextPath}/employees/">Employees</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<!-- creating a navbar to the right side -->
					<!-- creating dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <span class="caret"></span> <span
							class="glyphicon glyphicon-user"></span> <c:out
								value="${username}" /></a>
						<ul class="dropdown-menu">
							<li><a href="#">Manager Information</a></li>
							<li><a href="#">Site Preferences</a></li>
							<li><a href="#">Stuff</a></li>
						</ul></li>
					<!-- Logout button -->

					<li><a href="${pageContext.request.contextPath}/logout/"><span
							class="glyphicon glyphicon-log-in"></span>&nbsp;LOGOUT</a></li>
				</ul>
			</div>

			<div class="well"> <%-- this is opening a welcome page if the user logs in --%>
				<h1> 
					Manager Login: 
					
					Welcome,
					<%-- I can use this to display an object attribute with JSP :
					<%= emp.getUser_first_name() --%>
					
					<%--Capitalizing first letter of fname: --%>
					<c:out value="${fn:toUpperCase(fn:substring(fname, 0, 1))}${fn:toLowerCase(fn:substring(fname, 1, fn:length(fname)))}"></c:out>
				</h1>			
			</div>
			
			</nav>
		</c:when>

		<c:when test="${role_id==2}">
			<!-- using JSTL tags to check the user role_id (manager or employee)-->

			<nav class="navbar navbar-inverse"> <!-- navbar at the top -->

			<div class="container-fluid">

				<div class="navbar-header">
					<a class="navbar-brand">Company Name</a>
					<!-- main navbar link -->
				</div>

				<ul class="nav navbar-nav">
					<!-- navbar links -->
					<li class="active"><a href="${pageContext.request.contextPath}/index/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/myinfo/">My Information</a></li>
					<li><a href="${pageContext.request.contextPath}/reimbursements/">Reimbursements</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<!-- creating a navbar to the right side -->
					<!-- creating dropdown -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <span class="caret"></span> <span
							class="glyphicon glyphicon-user"></span> <c:out
								value="${username}" /></a>
						<ul class="dropdown-menu">
							<li><a href="#">Employee Information</a></li>
							<li><a href="#">Site Preferences</a></li>
							<li><a href="#">Stuff</a></li>
						</ul></li>
					<!-- Logout button -->
					<li><a href="${pageContext.request.contextPath}/logout/"><span
							class="glyphicon glyphicon-log-in"></span>&nbsp;LOGOUT</a></li>
				</ul>
			</div>
			
			
			<div class="well"> <%-- this is opening a welcome page if the user logs in --%>
				<h1> 
					Employee Login: 
					
					Welcome,
					<%-- I can use this to display an object attribute with JSP :
					<%= emp.getUser_first_name() --%>
					
					<%--Capitalizing first letter of fname: --%>
					<c:out value="${fn:toUpperCase(fn:substring(fname, 0, 1))}${fn:toLowerCase(fn:substring(fname, 1, fn:length(fname)))}"></c:out>
				</h1>			
			</div>


			</nav>
		</c:when>

	</c:choose>




</body>
</html>