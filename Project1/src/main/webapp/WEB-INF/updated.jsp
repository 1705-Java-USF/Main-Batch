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
		
		<%-- <c:if test="${sessionScope.role_id!=1 }"> User can only access this page with manager credentials
			<jsp:forward page="/WEB-INF/index.jsp"/>
		</c:if> --%>
		
		<div class="well">
			<div class="starter-template">
				<div class="row">
					<div class="col-xs-12">

					   <center> <h2>You have successfully edited this user.</h2></center>
					
					   <center> <h3>Here is new information for this user:</h3></center>

						<div class="col-xs-12" style="text-align:center">
							<br>
							
							<label>First Name:</label> <c:out value="${updFname}" /><br />
							<label>Last Name:</label> <c:out value="${updLname}" /><br />
							<label>Username:</label> <c:out value="${updUsername}" /><br />
							<label>Role type:</label> <c:if test="${updRoleId==1}">Manager</c:if>
							<c:if test="${updRoleId==2}">Employee</c:if><br/>
							<label>Email:</label> <c:out value="${updEmail}" /><br />
							<label>Status:</label> <c:if test="${updStatus==1}">Active</c:if>
							<c:if test="${updStatus==2}">Inactive</c:if><br />
							
							<br>
						<c:choose>
							<c:when test="${updUsername==username}">
								<form method="get" class="form-horizontal" action="${pageContext.request.contextPath}/myinfo/">
											<input type="submit" value="Return">
								</form>
							</c:when>
							<c:otherwise>
								<form method="get" class="form-horizontal" action="${pageContext.request.contextPath}/employees/">
											<input type="submit" value="Return">
								</form>
							</c:otherwise>
						</c:choose>
							
						</div>
					</div>
				</div>
			</div> <!-- end starter-template -->
 		</div> <!-- end container -->
		
		
		
	</body>
</html>