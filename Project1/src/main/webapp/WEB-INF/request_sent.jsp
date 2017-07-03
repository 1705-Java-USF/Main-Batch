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
		
		<div class="well">
			<div class="starter-template">
				<div class="row">
					<div class="col-xs-12">

					    <center><h2>You have created a new reimbursement request</h2></center>
					
					    <center><h3>Here is the information that you entered:</h3></center>
	
						<div class="col-xs-12" style="text-align:center">
							<br>
							
							<label>Request ID</label> <c:out value="${rebs_id}" /><br />
							<label>Type:</label> <c:if test="${rebs_type==1}">Business Expense</c:if>
							<c:if test="${rebs_type==2}">Travel</c:if>
							<c:if test="${rebs_type==3}">Medical</c:if><br />
							<label>Status:</label> <c:if test="${rebs_type==1}">Pending</c:if>
							<c:if test="${rebs_type==2}">Approved</c:if>
							<c:if test="${rebs_type==3}">Declined</c:if><br />
							<label>Amount:</label> $<c:out value="${rebs_amount}" /><br />
							<label>Description:</label> <c:out value="${rebs_description}" /><br />
							<label>Time submitted:</label> <c:out value="${time_submitted}" /><br />
							
							<br>

						<form method="get" class="form-horizontal" action="${pageContext.request.contextPath}/employees/">
									<input type="submit" value="Return">
						</form>

						</div>

					</div>
				</div>
			</div> <!-- end starter-template -->
 		</div> <!-- end container -->
		
		
		
	</body>
</html>