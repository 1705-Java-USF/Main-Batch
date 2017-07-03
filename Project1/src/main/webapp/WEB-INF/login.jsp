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

<!-- Select character encoding support -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/default.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project 1</title><!-- tab title  -->

</head>

<body>
	<div class="centered">  <!-- beginning of actual website display -->
		<c:choose>
			<c:when test="${sessionScope.username==null}"> <%-- if the user is not logged in --%>
				<div class="jumbotron">
					<%-- message them to login --%>
					<h2>PLEASE LOGIN!</h2>
					
					<c:if test="${issue!=null}"> <%-- if the login info is incorrect --%>
						<div class="alert alert-danger">INVALID CREDENTIALS!!!</div>
					</c:if>
					
					<%--action will be read by web container, and go to method doPost in the servlet chosen --%>
					<form method="post">
						<%-- input with glyphicon image for USERNAME. "user" is the id --%>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								name="username" class="form-control" placeholder="USERNAME" required>
						</div>
						
						<%-- input session with glyphicon for PASSWORD. "pass" is the id --%>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								name="pass" class="form-control" placeholder="PASSWORD" required>
						</div>
						
						<%-- Submit button for login --%>
						<div>
							<input type="submit" value="LOGIN">
						</div>
						
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<jsp:forward page="/WEB-INF/index.jsp"/>
			</c:otherwise>
		</c:choose>
	</div>
	
	
</body>
</html>