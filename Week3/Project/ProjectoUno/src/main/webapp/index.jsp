<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="com.revature.pojo.*,java.util.*,com.revature.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" type = "text/css" href = "Resources/CSS/default.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Login</title>
</head>
<body class = "container-fluid">

<img src="Resources/img/header.png" width = "100%">

<!-- NAVIGATION BAR -->
<nav id = "nv" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp" style = "color: #ffffff;">Home</a>
    </div>
    
    <c:if test="${user != null}">
    	<%ErsUser currentUser = (ErsUser)session.getAttribute("user");%>
    	<ul class="nav navbar-nav">
    		<c:choose>
    			<c:when test="${sessionScope.role == 1}">
      				<li class="active"><a href="ersuser.jsp">Morty View</a></li>
      				<li class="active"><a href="UserPending.do">Pending Reimbursements</a></li>
      				<li class="active"><a href="UserResolved.do">Resolved Reimbursements</a></li>
   					<li class="active"><a href="create.html">Create Reimbursement</a></li>
      			</c:when>
      			<c:otherwise>
      				<li class="active"><a href="manager.jsp">Rick View</a></li>
      				<li class="active"><a href="ManageMorty.do">Morty Manage</a></li>
      				<li class="active"><a href="ManPending.do">Pending Reimbursements</a></li>
      				<li class="active"><a href="ManResolved.do">Resolved Reimbursements</a></li>
      			</c:otherwise>
      		</c:choose>
      		<li class="active"><a href="updateUser.jsp">Update Account</a></li>
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
    		<li><a href="Logout.do" style = "color: #ffffff;"><span class="glyphicon glyphicon-log-out" ></span>Logout</a></li>		
    	</ul>
    </c:if>
    <c:if test="${user == null}">
    <ul class="nav navbar-nav navbar-right">
    		<li><a href="createAccount.html" style = "color: #ffffff;"><span class="glyphicon glyphicon-plus" ></span> CreateAccount</a></li>		
    </ul>
    </c:if>
  </div>
</nav>

<!-- DISPLAY LOG IN, OR WELCOME MESSAGE -->
<c:choose>
	<c:when test="${sessionScope.user == null}">
		
		<div id = "jd" class = "jumbotron">
			<div class = "row">
				<div class = "col-lg-6">
					<div id = "wl" class = "well">
						<h2>Login</h2>
					</div>
					
					
					<c:if test="${issue != null}">
						<div class = "alert alert-danger">Invalid credentials!!</div>
					</c:if>
					
					<form method = "post" action = "Login.do">
					
						<div class = "input-group">
							<span class = "input-group-addon"> <i class = "glyphicon glyphicon-user"></i> </span>
							<input type = "text" name = "user" class = "form-control" placeholder = "username" required>
						</div>
						<br>
						<div class = "input-group">
							<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
							<input type = "password" name = "pass" class = "form-control" placeholder = "password" required>
						</div>
					
						<br>
						<div>
							<input type = "submit" class="btn btn-default" value = "Login" aria-label="Left Align">
						</div>	
					</form>
				</div>
				<div class = "col-lg-1"></div>
				<div class = "col-lg-4">
					<img src="Resources/img/portalgun.png" width = "100%">
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div id = "jd" class = "jumbotron">
			<div class = "row">
				<div class = "col-lg-6">
					<br>
					<br>
					<%ErsUser currentUser = (ErsUser)session.getAttribute("user"); %>
					<h1 id = "wl" class = "well">Welcome <%= session.getAttribute("position")%>, you are logged in as <%= currentUser.getUserName()%>!</h1>
				</div>
				<div class = "col-lg-2"></div>
				<div class = "col-lg-6">
					<img src="Resources/img/portal.png" width = "75%">
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>

</body>
</html>