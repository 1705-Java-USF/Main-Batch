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

	<div class="well" class="darkfont">
		<form method="post" action="Submit.do">		
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" name="RT_TYPE" class="form-control" placeholder="Type ID" required>
			</div>
			<div class="darkfont">
				<input type="submit" value="SUBMIT">
			</div>
		</form>
	</div>
	
	<div class="well" class="darkfont"> 
		<h1 class="darkfont"><c:out value="${user}"></c:out>, Here Are Your Options:</h1>
	</div>
	

	<h6><b>Novice Hunter Quests</b></h6>
	<ul>
		<li>10: <a href="resources/images/Popo.png">Popo</a></li>
		<li>11: <a href="resources/images/Kelbi.jpg">Kelbi</a></li>
		<li>12: <a href="resources/images/Blango.png">Blango</a></li>
	</ul>

	<c:set var = "role" scope = "session" value = "${role}"/>
	<c:if test="${role > 3}">
	<h6><b>Intermediate Hunter Quests</b></h6>
	<ul>
		<li>20: <a href="resources/images/Velocidrome.jpg">Velocidrome</a></li>
		<li>21: <a href="resources/images/Bulldrome.png">Bulldrome</a></li>
		<li>22: <a href="resources/images/KutKu.jpg">Kut-Ku</a></li>
	</ul>
	</c:if>
	<c:if test="${role > 4}">
	<h6><b>Experienced Hunter Quests</b></h6>
	<ul>
		<li>30: <a href="resources/images/Gypceros.jpg">Gypceros</a></li>
		<li>31: <a href="resources/images/Khezu.png">Khezu</a></li>
		<li>32: <a href="resources/images/Plesioth.jpg">Plesioth</a></li>
	</ul>
	</c:if>
	<c:if test="${role > 5}">
	<h6><b>Veteran Hunter Quests</b></h6>
	<ul>
		<li>40: <a href="resources/images/Basarios.jpg">Basarios</a></li>
		<li>41: <a href="resources/images/Monoblos.jpg">Monoblos</a></li>
		<li>42: <a href="resources/images/KushalaDaora.jpg">Kushala Daora</a></li>
	</ul>
	</c:if>
	<c:if test="${role > 6}">
	<h6><b>Expert Hunter Quests</b></h6>
	<ul>
		<li>50: <a href="resources/images/Diablos.jpg">Diablos</a></li>
		<li>51: <a href="resources/images/Kirin.jpg">Kirin</a></li>
		<li>52: <a href="resources/images/Tigrex.jpg">Tigrex</a></li>
	</ul>
	</c:if>
	<c:if test="${role > 7}">
	<h6><b>Master Hunter Quests</b></h6>
	<ul>
		<li>60: <a href="resources/images/Teostra.jpg">Teostra</a></li>
		<li>61: <a href="resources/images/Rathian.jpg">Rathian</a>+<a href="resources/images/Rathalos.jpg">Rathalos</a></li>
		<li>62: <a href="resources/images/LaoShanLung.jpg">Lao-Shan Lung</a></li>
	</ul>
	</c:if>
</body>
</html>