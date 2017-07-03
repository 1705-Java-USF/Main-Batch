<%@page import="com.revature.ers.DataObjects.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>
<script src="resources/js/ManageUsers.js"></script>
</head>
<body id="manage-user">
<%@include file="navbar.jsp" %>

	<div class="container-fluid">
		<div class="well">
			<div class="m-header">
				<h3>Manage Users</h3>
			</div>
			<div id="user-container">
				<table class="user-table">
					<tr class="header-row">
						<th>User ID</th>
						<th>Username</th>
						<th>Email</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>User Role</th>
					</tr>
					<% List<User> users = (List<User>)request.getAttribute("users"); 
						for(int i = 0; i < users.size(); i++){%>
						<tr id='<%="u-row"+i %>' class="u-row">
							<td class="u-id"><%=users.get(i).getUserId() %></td>
							<td class="u-username"><%=users.get(i).getUsername() %></td>
							<td class="u-email"><%=users.get(i).getEmail() %></td>
							<td class="u-fname"><%=users.get(i).getFirstname() %></td>
							<td class="u-lname"><%=users.get(i).getLastname() %></td>
							<td class="u-role"><%=users.get(i).getUserRole() %></td>
						</tr>
					<%} %>
				</table>
			</div>
		</div>
	</div>
	<div id="s-user" class="container-fluid hide">
		<div class="well">
			<div class="buttons">
				<button id="promote">Promote User</button>
			</div>
			<%@include file="MessageContainer.jsp" %>
			<div class="User info">
				<div id="id" class="label-val-container">
					<span class="header">User Id:</span>
					<span class="value"></span>
				</div>
				<div id="username" class="label-val-container">
					<span class="header">Username:</span>
					<span class="value"></span>
				</div>
				<div id="email" class="label-val-container">
					<span class="header">Email:</span>
					<span class="value"></span>
				</div>
				<div id="fname" class="label-val-container">
					<span class="header">First Name:</span>
					<span class="value"></span>
				</div>
				<div id="lname" class="label-val-container">
					<span class="header">Last Name:</span>
					<span class="value"></span>
				</div>
				<div id="role" class="label-val-container">
					<span class="header">User Role:</span>
					<span class="value"></span>
				</div>
			</div>
		</div>
	</div>


</body>
</html>