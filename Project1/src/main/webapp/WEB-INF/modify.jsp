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
	
	<%-- <c:if test="${sessionScope.role_id!=1 }">  User can only access this page with manager credentials
			<jsp:forward page="/WEB-INF/index.jsp"/>
		</c:if> --%>
	
	<div class="well" style='background:white;'>
		<div class="starter-template">
			<div class="row">
				<div class="col-xs-12">
				
				<h2 align="center">Please edit any information, then click the "Update" button</h2>
				<br>
		<%--action will be read by web container, and go to method doPost in the servlet chosen --%>
		
		<form method="post" action="updated" class="form-horizontal">
	
			<div class="form-group">
				<%-- USER_ID IS AUTO INCREMENTING --%>
				
				<%-- passing hidden field with user_id --%>
				<input type="hidden" name="user_id" value="${user.user_id}">	 
					
				<c:choose>			
					<c:when test="${role_id==1}">	<%-- only allow manager to change role type --%>
					<label class="col-sm-5 control-label">Role type:</label>
						
						<fieldset>  <%-- This is checking if they're a manager or employee, and it marks that radio button "checked" --%>
						  <div class="radio-class">
						  	<c:choose>
						  		<c:when test="${user.user_role_id==1}">
						  			<input type="radio" class="radio" name="role_type" value="2" id="y"/>
							    		<label for=2 class="radio-label">Employee</label>
							    	<input type="radio" class="radio" name="role_type" value="1" id="z" checked/>
						   				<label for=1 class="radio-label">Manager</label>
						  		</c:when>
						  		<c:when test="${user.user_role_id==2}">
						  			<input type="radio" class="radio" name="role_type" value="2" id="y" checked/>
							    		<label for=2 class="radio-label">Employee</label>
							    	<input type="radio" class="radio" name="role_type" value="1" id="z"/>
						   				<label for=1 class="radio-label">Manager</label>
						  		</c:when>
						  	</c:choose>
						  </div>
						</fieldset>
							 <%-- <input type="number" name="user_role_id" class="form-control" value="${user.user_role_id}" required> --%>
					</c:when>
					<c:when test="${role_id==2}">
						<%-- passing hidden field with user_id --%>
						<input type="hidden" name="role_type" value="${user.user_role_id}">
					</c:when>
				</c:choose>
			
				<label class="col-sm-5 control-label">First Name:</label>
						<div class="col-sm-3 input-group">
							<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>  
							<input type="text" name="first_name" class="form-control" value="${user.user_first_name}" required>
						</div>
			
				<label class="col-sm-5 control-label">Last Name:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> 
						<input type="text"
						name="last_name" class="form-control" value="${user.user_last_name}" required>
					</div>
					
				<label class="col-sm-5 control-label">Username:</label>
					<div class="col-sm-3 input-group">
							<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> 
							<input type="text" name="username" class="form-control" value="${user.user_username}" required>
					</div>
		
			<!-- input session with glyphicon for PASSWORD. "pass" is the id -->
				<label class="col-sm-5 control-label">Password:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>  
						<input type="password" name="password" class="form-control" value="${user.user_password}" required>
					</div>
					
				<label class="col-sm-5 control-label">Email:</label>
					<div class="col-sm-3 input-group">
						<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span>  
						<input type="email"
						name="email" class="form-control" value="${user.user_email}" required>
					</div>
					
					<br>
				
				<c:choose>
					<c:when test="${role_id==1}">
						<label class="col-sm-5 control-label">Status</label> <%-- if employee is currently inactive, the switch will not be checked --%>
							<div class="col-sm-3 input-group">
								<div class="onoffswitch">
									<c:if test="${user.user_status==1}">
									    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
									</c:if>
									<c:if test="${user.user_status==2}">
									    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch">
									</c:if>
								 	<label class="onoffswitch-label" for="myonoffswitch">
								        <span class="onoffswitch-inner"></span>
								        <span class="onoffswitch-switch"></span>
								  	</label>
								    
								</div>
								 <%-- <input type="number" name="user_status" class="form-control" value="${user.user_status}" required> --%>
							</div>
						</c:when>
						<c:when test="${role_id==2}">
							<c:if test="${user.user_status==1}">
								<input type="hidden" name="onoffswitch" value="on">
							</c:if>
							<%-- <c:if test="${role_id==2}">
							</c:if> --%>
						</c:when>
					</c:choose>
			
			<br>
			<%-- Submit button to create user --%>
				<div style="text-align:center">
					<input type="submit" value="UPDATE">		
				</div>
			
			</div>
		</form>		
			
				</div>
			</div>
		</div>
	</div>
				
		

	
</body>
</html>