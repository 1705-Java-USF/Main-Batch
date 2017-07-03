<!-- JSTL tags -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%-- importing pojo and dao packages --%>
<%@ page import="com.revature.pojo.*, com.revature.dao.*, java.util.*" %>

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
	
		<c:if test="${sessionScope.role_id!=1 }"> <%-- User can only access this page with manager credentials --%>
			<jsp:forward page="/WEB-INF/index.jsp"/>
		</c:if>
				
		<div class="well">
			<div class="starter-template">
				<div class="row">
					<div class="col-xs-7 col-xs-offset-3">
			
			<%-- href to "new" which will take it to employees/new =  createemployee.jsp --%>
			<h4><a href="new"><input class="pull-right" type="submit" 
			 value="Create an employee"></a></h4>
			
			
			<h2>All employees</h2>
			
			<div class="table-responsive" align="center" >
				<table class="table table-striped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
							<th>Email</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
					
					<c:forEach var="user" items="${users}"> <%-- Getting "users" from front controller --%>
						<tr>
							
							<td><c:out value="${user.user_first_name}" /></td>
							<td><c:out value="${user.user_last_name}" /></td>
							<td><c:out value="${user.user_username}" /></td>
							<td><c:out value="${user.user_email}" /></td>
							<%--if stm to check if they're active or inactive --%>
							<c:if test="${user.user_status==1}">
							<td id="icon-green">Active</td></c:if>
							<c:if test="${user.user_status==2}">
							<td id="icon-red">Inactive</td></c:if>
							
							<td>
								<form class="form-horizontal" action="modify">
									<input type="hidden" name="username" value="${user.user_username}" />
									<input type="submit" value="Edit" />
								</form>
							</td>

							<%-- <td>
								<form onsubmit="return confirm('Do you really want to delete record?');"
										action="employees"
										method="post">
									<input type="hidden" name="username" value="${user.user_username}" />
									<input type="submit" value="Delete" />
								</form>
							</td> --%>
							
						</tr>	
					</c:forEach> 
					</tbody>

				</table>

			</div><!-- end table-responsive -->
		</div>
		</div>
		</div>
		</div>
	
</body>
</html>