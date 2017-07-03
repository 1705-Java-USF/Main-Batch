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
				
				<h2 align="center">New reimbursement request</h2>
				<br>
		<%--action will be read by web container, and go to method doPost in the servlet chosen --%>
		<form method="post" action="request_sent" class="form-horizontal">
				
			<div class="form-group"> 
				<%-- REBS_ID IS AUTO INCREMENTING --%> 
				
				<%-- Hidden "username" to be sent over --%>
			<input type="hidden" name="author_id" value="${user_id}">
							
				<label class="col-sm-5 control-label">Reimbursement Type:</label>
					
						  <div>
						  	<select name="type">
							  <option value="1">Business Expense</option>
							  <option value="2">Travel/Mileage</option>
							  <option value="3">Medical</option>
							 </select>
						  </div>
						
						<br>
				<%-- Hidden "status" to be sent over --%>						
				<input type="hidden" name="status" value="1" />
			
				<label class="col-sm-5 control-label">Amount:</label>
						<div class="col-sm-3 input-group">
							
							<input type="number" name="amount" class="form-control"
							placeholder="Amount" required>
						</div>
			
				<label class="col-sm-5 control-label">Attachments:</label>
					<div class="col-sm-3 input-group">
							
							<input type="text" name="attachments" class="form-control" 
							placeholder="Atachments" required>
					</div>
					
				<label class="col-sm-5 control-label">Description:</label>
					<div class="col-sm-3 input-group">
						
						<input type="text" name="description" class="form-control" 
						placeholder="Description" required>
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