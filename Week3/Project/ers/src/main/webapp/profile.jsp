<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body id="profile">
<%@include file="navbar.jsp" %>
	<form method="post" id="profile-form" action="Profile.do">
		<div id="profile-box" class="container-fluid">
			<div class="well">
			<%@include file="MessageContainer.jsp" %>
				<div id="username" class="input-group">
					<span class="input-group-addon input-label">Username </span> 
					<input type="text" name="username" class="form-control" value="<%=session.getAttribute("username") %>" readonly />
				</div>
				<div id="password" class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
					<input type="password" name="password" class="form-control" placeholder="Password" />
				</div>
				<div id="firstname" class="input-group">
					<span class="input-group-addon input-label">First name</span> 
					<input type="text" name="firstname" class="form-control" value="<%=session.getAttribute("firstname") %>" />
				</div>
				<div id="lastname" class="input-group">
					<span class="input-group-addon input-label">Last name</span> 
					<input type="text" name="lastname" class="form-control" value="<%=session.getAttribute("lastname") %>" />
				</div>
				<div id="userRole" class="input-group">
					<span class="input-group-addon input-label">User Role</span> 
					<input type="text" name="userRole" class="form-control" value="<%=session.getAttribute("userRole")  %>" readonly />
				</div>
				<div id="email" class="input-group">
					<span class="input-group-addon input-label">Email</span> 
					<input type="text" name="email" class="form-control" value="<%=session.getAttribute("email") %>" />
				</div>
				<div class="button-container">
					<input class="submit-button" type="submit" value="UPDATE PROFILE" />
				</div>
				
				
			</div>
		</div>
	</form>
</body>
</html>