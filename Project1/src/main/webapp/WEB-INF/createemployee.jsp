<!-- JSTL tags -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%-- importing pojo and dao packages --%>
<%@ page import="com.revature.pojo.*, com.revature.dao.*" %>

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

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/default.js"></script>
<!-- Select character encoding support -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/default.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project 1</title><!-- tab title  -->

</head>

	<body>
	
	<%@ include file="nav_bar.jsp" %>  <%-- Bringing in nav bar  --%>
	
	<c:if test="${sessionScope.role_id!=1 }">  <%-- User can only access this page with manager credentials --%>
			<jsp:forward page="/WEB-INF/index.jsp"/>
		</c:if>
	
	<div class="well" style='background:white;'>
		<div class="starter-template">
			<div class="row">
				<div class="col-xs-12">
				
				<h2 align="center">Enter the information for the new employee</h2>
				<br>
		<%--action will be read by web container, and go to method doPost in the servlet chosen --%>
		<form method="post" action="thanks" class="form-horizontal">
				
			<div class="form-group"> 
				<%-- USER_ID IS AUTO INCREMENTING --%> 
				<!-- <label class="col-xs-5 control-label">User id:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>
						<input type="number" name="user_id" class="form-control"
						 placeholder="user id" required>	
					</div> -->
			
				<label class="col-sm-5 control-label">Role id:</label>
					<fieldset>  <%-- Has employee checked by default on radio --%>
						  <div class="radio-class">
				  			<input type="radio" class="radio" name="role_type" value="2" id="y" checked/>
					    		<label for=2 class="radio-label">Employee</label>
					    	<input type="radio" class="radio" name="role_type" value="1" id="z"/>
				   				<label for=1 class="radio-label">Manager</label>
						  </div>
						</fieldset>
			
				<label class="col-sm-5 control-label">First Name:</label>
						<div class="col-sm-3 input-group">
							<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>  
							<input type="text" name="first_name" class="form-control"
							placeholder="first name" required>
						</div>
			
				<label class="col-sm-5 control-label">Last Name:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> 
						<input type="text" name="last_name" class="form-control" 
						placeholder="last name" required>
					</div>
			
				<label class="col-sm-5 control-label">Username:</label>
					<div class="col-sm-3 input-group">
							<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> 
							<input type="text" name="username" class="form-control" 
							placeholder="username" required>
					</div>
		
			<!-- input session with glyphicon for PASSWORD. "pass" is the id -->
				<label class="col-sm-5 control-label">Password:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>  
						<input type="password" name="password" class="form-control" 
						placeholder="role id" required>
					</div>
			
				<label class="col-sm-5 control-label">Email:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>  
						<input type="email"
						name="email" class="form-control" 
						placeholder="email" required>
					</div>
					<br>
				<label class="col-sm-5 control-label">Active or Inactive</label> <%-- Has toggle "checked" by default --%>
					<div class="col-sm-3 input-group">
						<div class="onoffswitch">
							<input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
						 	<label class="onoffswitch-label" for="myonoffswitch">
						        <span class="onoffswitch-inner"></span>
						        <span class="onoffswitch-switch"></span>
						  	</label>
						    
						</div>
						 <%-- <input type="number" name="user_status" class="form-control" value="${user.user_status}" required> --%>
					</div>
			
			<br>
			<%-- Submit button to create user --%>
			<div style="text-align:center">
				<input type="submit" value="CREATE">
			</div>
			
			</div>
		</form>
			
				</div>
			</div>
		</div>
	</div>
				
		

	
</body>
</html>