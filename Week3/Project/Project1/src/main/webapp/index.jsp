	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/login.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container-fluid">	
		<br>
		<c:choose>
			<c:when test="${sessionScope.user==null}">
				<div class="row darkfont">
					<div class="panel panel-default col-md-offset-4 col-md-4">
						<div class="panel-heading" style="text-align:center">
							<img alt="Revature" src="https://mv.force.com/revature/resource/1479749399000/RevatureLogo">
						</div>
						<div class="panel-body">
							<c:if test="${issue != null}">
								<div class="alert alert-danger">INVALID CREDENTIALS</div>
							</c:if>
							<form method="post" action="Login.do">
								<div>
									<h5 style="font-weight:bold">Username</h5>
									<input type="text" name="username" class="form-control" required>
									<br>
									<h5 style="font-weight:bold">Password</h5>
									<input type="password" name="password" class="form-control" required>
								</div>
								<br>
								<div class="darkfont">
									<input type="submit" name="j_id0:j_id6:j_id14" value="Login" class="btn btn-lg btn-success btn-block">
								</div>
							</form>
						</div>
						<div class="panel-heading">
							<a href="#">Forgot your password?</a>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="well darkfont"> <!-- Use expression tags to print content to the page. -->
					<c:choose>
						<c:when test="${sessionScope.role == 'Employee' }">
							<jsp:forward page="EmployeeHomepage.jsp"/>
						</c:when>
						<c:when test="${sessionScope.role == 'Manager' }">
							<jsp:forward page="ManagerHomepage.jsp"/>
						</c:when>
						<c:otherwise>
							<jsp:forward page="Error.jsp"/>
						</c:otherwise>
					</c:choose>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>