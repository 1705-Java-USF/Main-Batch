<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RoBroom&trade;</a>
			</div>
			<ul class="nav navbar-nav">
				<li id="nav-dash-link" ><a href="ERS-Home.jsp">Dashboard</a></li>
				<li id="nav-viewreq-link"><a href="ViewRequests">View Requests</a></li>
				<li id="nav-createreq-link"><a href="CreateReimbursement.jsp">Create Request</a></li>
				<li id="nav-profile-link"><a href="profile.jsp">Profile</a></li>
				<%if(session.getAttribute("userRole").equals("manager")){ %>
					<li id="nav-manreq-link"><a href="ManageRequests.jsp">Manage Requests</a></li>
					<li id="nav-createuser-link"><a href="CreateUser.jsp">Create User</a></li>
					<li id="nav-manageuser-link"><a href="ManageUsers">Manage Users</a></li>
				<% } %>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Logout.do"><span  class="glyphicon glyphicon-log-in"></span>LOGOUT</a></li>
			</ul>
		</div>
	</nav>