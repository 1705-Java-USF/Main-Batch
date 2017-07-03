<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CommonIncludes.jsp" %>
<title>RoBroom&trade; Log-in</title>

<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
</head>
<body>
	<%
		if (session.getAttribute("user") == null) {
	%>
	<form class="login-box" method="post" action="Login.do">
		<div class="jumbotron">
			<div class="login-header-container">
				<h2 id="login-header">RoBroom&trade; ERS Portal</h2>
				<%@include file="MessageContainer.jsp" %>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i> </span> <input type="text"
					name="user" class="form-control" placeholder="Username"
					required />
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock"></i></span> <input type="password"
					name="pass" class="form-control" placeholder="Password"
					required />
			</div>
			<div class="button-container">
				<input class="submit-button" type="submit" value="LOGIN" />
			</div>
		</div>
	</form>
	<%
		} else {
	%>
	REDIRECT TO BE IMPLEMENTED
	<%
		}
	%>

</body>
</html>