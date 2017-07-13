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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- This will ensure that mobile will work with site by allowing proper formatting when zooming in -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Select character encoding support -->
<link rel="stylesheet" type="text/css"
	href="resources/css/default.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vance Hunter's Guild</title>
</head>
<body background="resources/images/MonsterHunterWallpaper.jpg">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Monster Hunter World</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">WELCOME</a></li>
				<li class="active"><a href="indexJSTL.jsp">OPTIONS</a></li>
			</ul>
			<c:if test="${user!=null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" 
												data-toggle="dropdown" 
												href="#">
												<span class="caret"></span>
												<span class="glyphicon glyphicon-user"></span>
												<c:out value="${user}"/></a>
						<ul class="dropdown-menu">
							<li><a href="resources/music/Monster Hunter Music Main Theme.mp3">Theme Music</a></li>
							<li><a href="resources/music/Monster Hunter Orchestral.mp3">Orchestral Music</a></li>
						</ul>
					</li>
					<li><a href="Logout.do"><span class="glyphicon glyphicon-log-in"></span>LOGOUT</a></li>
				</ul>
			</c:if>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="well darkfont">
			<h1>Vance Hunter's Guild</h1>
		</div>
		
		<c:choose>
			<c:when test="${sessionScope.user==null}">
				<div class="jumbotron">
					<h2 class="darkfont">PLEASE LOGIN!</h2>
					<!-- SCRIPTLETS: Execute any java code within page.
						executes every time page is loaded. -->
					<c:if test="${issue!=null}">
						<div class="alert alert-danger">INVALID CREDENTIALS</div>
					</c:if>
					<form method="post" action="Login.do">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" name="user" class="form-control" placeholder="USERNAME" required>
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input type="password" name="pass" class="form-control" placeholder="PASSWORD" required>
						</div>
						<div class="darkfont">
							<input type="submit" value="LOGIN">
						</div>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="well" class="darkfont"> 
					<h1 class="darkfont"><c:out value="${role_name}"></c:out></h1>
					<h3 class="darkfont">Please Select From The Following Options:</h3>
						<c:set var = "role" scope = "session" value = "${role}"/>
	     				<c:if test="${role < 3}">
							<div class="pagination">
								<ul class="pagination">
									<li><a href="viewHunters.jsp">View All Guild Members</a></li>
									<li><a href="viewPending.jsp">View Quest Requests</a></li>
									<li><a href="reimbursementProof.jsp">View Proof of Completion</a></li>
									<li><a href="resolveCompleted.jsp">Resolve Quest Reward</a></li>									
									<li><a href="viewResolved.jsp">View Completed Quests</a></li>
								</ul>
							</div>
						</c:if>
	     				<c:if test="${role > 2}">
							<div class="pagination">
								<ul class="pagination">
									<li><a href="submitRequest.jsp">Submit Quest Request</a></li>
									<li><a href="reimbursementProof.jsp">Upload Proof of Completion</a></li>
									<li><a href="viewPending.jsp">View Pending Quests</a></li>
									<li><a href="viewResolved.jsp">View Completed Quests</a></li>
									<li><a href="viewHunters.jsp">View Personal Info</a></li>									
								</ul>
							</div>
						</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>