<!-- JSTL tags -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%-- importing pojo and dao packages --%>
<%@ page import="com.revature.pojo.*, com.revature.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/default.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project 1</title><!-- tab title  -->

	</head>

	<body>
		
		<%@ include file="nav_bar.jsp" %>  <%-- Bringing in nav bar  --%>
	
		<div class="well">  <!-- beginning of actual website display -->
			<h2>My info</h2>
			<br>
			
			<h3>First name: <c:out value="${fname}"></c:out></h3>
			<h3>Last name: <c:out value="${lname}"></c:out></h3>
			<h3>Username: <c:out value="${username}"></c:out></h3>
			<h3>Role: <c:if test="${role_id==1}">Manager</c:if>
				<c:if test="${role_id==2}">Employee</c:if></h3>
			<h3>Email: <c:out value="${email}"></c:out></h3>
			<br>
			
			<form class="form-horizontal" action="/Project1/employees/modify">
				<input type="hidden" name="username" value="${username}" />
				<input type="submit" value="Edit" />
			</form>
		
		</div>
	
	</body>
</html>