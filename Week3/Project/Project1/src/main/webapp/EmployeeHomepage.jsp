<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/default.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Homepage</title>
</head>
<body>
	<c:if test="${sessionScope.user == null}">
		<jsp:forward page="index.jsp"/>
	</c:if>
	<c:if test="${sessionScope.role != 'Employee'}">
		<jsp:forward page="index.jsp"/>
	</c:if>
	
	<nav class="navbar navbar-default navbar-fixed-top" style="color:#000000">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-left"><img alt="Revature" src="https://mv.force.com/revature/resource/1479749399000/RevatureLogo" height="50px"></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<button style="background-color:#FF7700;color:#000000">
						<c:choose>
							<c:when test="${user.getFirstName() != '' && user.getLastName() != ''}">
								${user.getFirstName()} ${user.getLastName()}
							</c:when>
							<c:when test="${user.getFirstName() != ''}">
								${user.getFirstName()}
							</c:when>
							<c:when test="${user.getLastName() != ''}">
								${user.getLastName()}
							</c:when>
							<c:otherwise>
								${user.getUsername()}
							</c:otherwise>
						</c:choose>
					<span class="caret"></span></button></a>
					<ul class="dropdown-menu">
						<li><a href="Logout.do"><span class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<br><br><br>
	<nav class="navbar navbar-inverse" style="background-color:#888888">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li style="background-color:#FF7700"><a href="index.jsp"><div style="color:#000000">Homepage</div></a>
				<li><a href="PersonalInformation.jsp"><div style="color:#000000">Personal Information</div></a></li>
				<li><a href="Reimbursements.do"><div style="color:#000000">Reimbursements</div></a></li>
			</ul>
		</div>
	</nav>
	
	<div class="well">
		<h1>Welcome 
		<c:choose>
			<c:when test="${user.getFirstName() != '' && user.getLastName() != ''}">
			${user.getFirstName()} ${user.getLastName()},
			</c:when>
			<c:when test="${user.getFirstName() != ''}">
			${user.getFirstName()},
			</c:when>
			<c:when test="${user.getLastName() != ''}">
			${user.getLastName()},
			</c:when>
			<c:otherwise>
			${user.getUsername()},
			</c:otherwise>
		</c:choose>This is the Employee Homepage
		</h1>
		
		Super Important Company Notifications
		<ul>
			<li><b>Canceled</b> <s>Ice cream social @ 11730 Plaza America Dr at 3:00 pm</s></li>
			<li>No further announcements at this time</li>
		</ul>
	</div>
	
</body>
</html>