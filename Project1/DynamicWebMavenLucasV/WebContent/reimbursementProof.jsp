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

<style>
ul {
  list-style-type: none;
}
</style>
</head>
<body background="resources/images/MonsterHunterWallpaper.jpg">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Monster Hunter World</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="indexJSTL.jsp">BACK TO OPTIONS</a></li>
			</ul>
		</div>
	</nav>
	
	<c:set var = "role" scope = "session" value = "${role}"/>
	<c:if test="${role > 2}">
	<div class="well" class="darkfont">
		<form method="post" action="upload.do">	
			<div class="input-group">			
				<input type="file">
			</div>
			<div class="darkfont">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>
	</c:if>

</body>
</html>