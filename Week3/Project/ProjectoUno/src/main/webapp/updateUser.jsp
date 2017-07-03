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

<title>Update</title>
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
    
  </div>
</nav>

<%ErsUser currentUser = (ErsUser)session.getAttribute("user");%>

<!-- UPDATE USER FORM -->
<div id = "jd" class = "jumbotron">
	<div id = "id" class = "well">
		<h3>Update you information</h3> 
	</div>
	<form method = "post" action="Update.do">
		<label>Username:</label>
		<div class = "input-group">
			<span class = "input-group-addon"> <i class = "glyphicon glyphicon-user"></i> </span>
			<input type = "text" name = "user" class = "form-control" value = "<%=currentUser.getUserName()%>" required>
		</div>
		<br>
		<label>Password:</label>
		<div class = "input-group">
			<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
			<input type = "password" name = "pass" class = "form-control" value = "<%=currentUser.getPassWord()%>" required>
		</div>
		<br>
		<label>First Name:</label>
		<div class = "input-group">
			<span class = "input-group-addon"> <i class = "glyphicon glyphicon-info-sign"></i> </span>
			<input type = "text" name = "fname" class = "form-control" value = "<%=currentUser.getFirstName()%>" required>
		</div>
		<br>
		<label>Last Name:</label>
		<div class = "input-group">
			<span class = "input-group-addon"> <i class = "glyphicon glyphicon-info-sign"></i> </span>
			<input type = "text" name = "lname" class = "form-control" value = "<%=currentUser.getLastName()%>" required>
		</div>
		<br>
		<label>Email:</label>
		<div class = "input-group">
			<span class = "input-group-addon"> <i class = "glyphicon glyphicon-envelope"></i> </span>
			<input type = "email" name = "email" class = "form-control" value = "<%=currentUser.getEmail()%>" required>
		</div>
		<br>
		<div>
			<input type = "submit" value = "Update">
		</div>
	</form>
	
</div>

</body>
</html>