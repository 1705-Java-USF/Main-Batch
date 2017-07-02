<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type = "text/css" href = "resources/css/default.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InsTitleHere</title>
</head>
<body>
	<nav class = "navbar navbar-inverse">
		<div class = "container-fluid">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "#">InsTitleHereCorp</a>
			</div>
			<ul>
				<ul class = "nav navbar-nav">
					<li class = "active"><a href = "index.jsp">HOME</a></li>
				</ul>
			</ul>
			<c:if test = "${username != null}">
			<ul class = "nav navbar-nav navbar-right">
				<li class = "dropdown"><a class = "dropdown-toggle" data-toggle = "dropdown" href = "#"><span class = "caret"></span><span class = "glyphicon glyphicon-user"></span><c:out value = "${username}"/></a>
					<ul class = "dropdown-menu">
						<li><a href = "accinfo.jsp">Account Information</a></li>
						<li><a href = "reimpage.jsp">Reimbursements</a></li>
					</ul>
				</li>
				<li><a href = "logout.do"><span class = "glyphicon glyphicon-log-in"></span>&nbsp;LOG-OUT</a></li>
			</ul>
			</c:if>
		</div>
	</nav>
	<div class = "container-fluid">
		<c:choose>
			<c:when test = "${sessionScope.username == null}">
				<div class = "jumbotron">
				
					<form method = "post" action = "login.do">
					<tr>
						<td><input type = "text" name = "insTitle" id = "insTitle" value = "InsTitleHere" style = "width: 195px;" maxlength = "10"></td>
						<td><span style = "color: #323232;">Login</span></td>
					</tr>
					<%-- Failed Login --%>
					<c:if test = "${issue != null}">
						<div class = "alert alert-danger">INVALID CREDENTIALS</div>
					</c:if>
						<div class = "input-group">
							<span class = "input-group-addon"><i class = "glyphicon glyphicon-user"></i></span>
							<input type = "text" name = "username" class = "form-control" placeholder = "USERNAME" required>
						</div>
						<div class = "input-group">
							<span class = "input-group-addon"><i class = "glyphicon glyphicon-lock"></i></span>
							<input type = "password" name = "password" class = "form-control" placeholder = "PASSWORD" required>
						</div>
						<div class = "darkfont"> 
							<input type = "submit" value = "LOGIN">
						</div>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<%-- Successful Login --%>
				<div class = "well darkfont">
					<c:choose>
						<c:when test = "${sessionScope.role == 'Manager'}">
							<jsp:forward page="managerhome.jsp"></jsp:forward>
						</c:when>
						<c:when test = "${sessionScope.role == 'Employee'}">
							<jsp:forward page="userhome.jsp"></jsp:forward>
						</c:when>
					</c:choose>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>