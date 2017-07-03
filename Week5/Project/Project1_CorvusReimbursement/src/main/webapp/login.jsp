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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/default.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
<body>
		<div class="container-fluid portal-background">
			
			<div class="jumbotron center-on-screen portal-background">
				<h2 class="darkfont text-center">Corvus Analyzes</h2>
				<h2 class="darkfont text-center">Portal</h2> <br />
				<c:if test="${ requestScope.issue != null }">
					<div class="alert alert-danger"><c:out value="${ requestScope.issue }"></c:out></div>
				</c:if>
				<div class="container-fluid">
					<form method="post" action="login.corvus">
						<div class="col-md-12 col-md-offset-0">
							<div class="input-group">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<input type="text" name="username" class="form-control" placeholder="USERNAME" required>
								</div>
								<br />
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<input type="password" name="password" class="form-control" placeholder="PASSWORD" required>
								</div>
							</div>
							<br />
							<div class="input-group">
								<input type="submit" value="Login" class="btn btn-xl btn-default">
							</div>
						</div>
					</form>
				</div>
				<br />
			</div>
		</div>
	
</body>
</html>