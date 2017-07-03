<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERS Home</title>
</head>
<body id="dashboard">
	<!-- Top Nav -->
	<%@include file="navbar.jsp" %>
	
	<% if(request.getAttribute("message") != null){ %>
	<div id="message-container" class="container-fluid">
		<div class="well">
			<div id="message">
				<h3><%=request.getAttribute("message") %></h3>
			</div>
		</div>
	</div>
	<%} %>
	<!-- User Dashboard -->
		<!-- View Your Reimbursement Requests -->
		<!-- Create a Reimbursement Request -->
		<!-- View Profile -->
	<div id="u-dash" class="container-fluid">
		<div class="well">
			<div id="u-container-head">
				<h2 class="dash-header">Employee Dashboard</h2>
			</div>
			<div id="u-v-req" class="dash-cont">
				<h3 class="dash-head"><a href="ViewRequests" class="dash-link">View Your Reimbursement Requests</a></h3>
			</div>
			<div id="u-c-req" class="dash-cont">
				<h3 class="dash-head"><a href="CreateReimbursement.jsp" class="dash-link">Create a Reimbursement Request</a></h3>
			</div>
			<div id="u-v-prof" class="dash-cont">
				<h3 class="dash-head"><a href="profile.jsp" class="dash-link">View Your Profile</a></h3>
			</div>
		</div>
	</div>
	<!-- Manager Dashboard -->
		<!-- Manage Unresolved Reimbursement Requests -->
		<!-- Create User -->
		<!-- Manage Users -->
	<%if(session.getAttribute("userRole").equals("manager")){ %>
	<div id="m-dash" class="container-fluid">
		<div class="well">
			<div id="m-container-head">
				<h2 class="dash-header">Manager Dashboard</h2>
			</div>
			<div id="m-v-req" class="dash-cont">
				<h3 class="dash-head"><a href="ManageRequests.jsp" class="dash-link">Manage Requests</a></h3>
			</div>
			<div id="m-c-req" class="dash-cont">
				<h3 class="dash-head"><a href="CreateUser.jsp" class="dash-link">Create User</a></h3>
			</div>
			<div id="m-v-prof" class="dash-cont">
				<h3 class="dash-head"><a href="ManageUsers" class="dash-link">Manage User</a></h3>
			</div>
		</div>
	</div> 
	<%} %>

</body>
</html>