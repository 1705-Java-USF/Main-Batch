<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements</title>
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
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">Dynasty</a><img
				src="http://icons.iconarchive.com/icons/tatice/operating-systems/128/Globe-icon.png"
				align="middle" width="25" heigth="25">
		</div>
		<ul class="nav navbar-nav">
			<li><a href="Homepage.jsp">HOME</a></li>
			<li><a href="About.jsp">About Us</a></li>
			<c:if test="${ur==1}">
				<li><a href="MPortal.jsp">Manager Portal</a></li>
			</c:if>
			<c:if test="${user!=null}">
				<li class="active"><a href="Reim.jsp">Reimbursements</a></li>
			</c:if>
		</ul>
		<c:if test="${user!=null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <span class="caret"></span> <span
						class="glyphicon glyphicon-user"></span> <c:out value="${user}" /></a>
					<ul class="dropdown-menu">
						<li><a href="AccInfo.jsp">Account Information</a></li>
					</ul></li>
				<li><a href="Logout.do"><span
						class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
			</ul>
		</c:if>
	</div>
	</nav>


	<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

	<div class="jumbotron">
	<div class="well" style="background-color:#d9dbdd">	<h2>Submit New Reimbursement</h2></div>
	<c:if test="${newR!=null}">
					<div class="alert alert-success">Reimbursement Submitted</div>

				</c:if>
		<form method="POST" action="createreim.do" enctype="multipart/form-data">
			<div class="input-group">
				Amount : <input type="number" step="0.01" min=0 name="ramount" class="form-control"
					placeholder="Amount" required />
			</div>
			<br>
			<div class="input-group">
				Description : <input type="text" name="rdescription" class="form-control"
					placeholder="Description" required />
			</div>
			<br>
			<div class="input-group">
				Receipt: <input type="file" name="receipt" class="form-control"
					placeholder="Upload"/>
			</div>
			<br>
			<div class="input-group">
			Receipt Type     <select name="rtype">
			<option>Select Option</option>
			<option value="1">Gas</option>
			<option value="2">Lodging</option>
			<option value="3">Food</option>
			<option value="4">Misc</option>
			</select>
			</div>
		
			<br> <input type="submit" value="SUBMIT">
		</form>
	</div>
	<div class="jumbotron">
	<div class="well" style="background-color:#d9dbdd">
	<h2>List All Reimbursements</h2>
	</div>
	<form method="POST" action="elistreim.do">
			<input type="submit" value="LIST">
		</form>
	
	</div>
</body>
</html>