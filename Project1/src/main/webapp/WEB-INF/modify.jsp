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

<script type="text/javascript" src="JS/default.js"></script>
<!-- Select character encoding support -->
<link rel="stylesheet" type="text/css" href="CSS/default.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project 1</title><!-- tab title  -->

</head>

	<body>
	
	<%@ include file="nav_bar.jsp" %>  <%-- Bringing in nav bar  --%>
	
	<c:if test="${sessionScope.role_id!=1 }">  <%-- User can only access this page with manager credentials --%>
			<jsp:forward page="/WEB-INF/index.jsp"/>
		</c:if>
	
	<div class="well">
		<%--action will be read by web container, and go to method doPost in the servlet chosen --%>
		<form method="post" action="updated">
			
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input type="number"
					name="user_id" class="form-control" value="${user.user_id}" required>	
			</div>
			
			
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input type="number"
					name="user_role_id" class="form-control" value="${user.user_role_id}" required>
			</div>
			
			<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-user"></i></span> <input type="text"
				name="username" class="form-control" value="${user.user_username}" required>
			</div>
		
			<%-- input session with glyphicon for PASSWORD. "pass" is the id --%>
			<div class="input-group">
				<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input type="password"
				name="password" class="form-control" value="${user.user_password}" required>
			</div>
			
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input type="text"
					name="first_name" class="form-control" value="${user.user_first_name}" required>
			</div>
			
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input type="text"
					name="last_name" class="form-control" value="${user.user_last_name}" required>
			</div>
			
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input type="email"
					name="email" class="form-control" value="${user.user_email}" required>
			</div>
			
			<br>
			<%-- Submit button to create user --%>
			<div style="text-align:right">
				<input type="submit" value="UPDATE">
			</div>
			
			
		</form>
		
	</div>
				
		

	
</body>
</html>