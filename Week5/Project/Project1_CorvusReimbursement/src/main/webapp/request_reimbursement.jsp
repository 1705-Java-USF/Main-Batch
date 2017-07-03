<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/default.css">
	<link rel="stylesheet" type="text/css" href="resources/css/fileinput.css">
	<link rel="stylesheet" type="text/css" href="resources/css/fileinput.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/fileinput-rtl.css">
	<link rel="stylesheet" type="text/css" href="resources/css/fileinput-rtl.min.css">
	<script src="resources/js/fileinput.js"></script>
	<script src="resources/js/fileinput.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Reimbursement</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Corvus Analyzes</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="contributor.jsp">HOME</a></li>
				<li><a href="my_reimbursements.jsp">VIEW MY REIMBURSEMENTS</a></li>
				<li class="active"><a href="request_reimbursement.jsp">REQUEST REIMBURSEMENT</a></li>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.username != null}">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<span class="caret"></span>
							<span class="glyphicon glyphicon-user"></span>
							&nbsp;<c:out value="${sessionScope.username}"></c:out></a>
							<ul class="dropdown-menu">
								<li><a href="accountc.jsp">Account Information</a></li>
							</ul>
						</li>
						<li><a href="logout.corvus"><span class="glyphicon glyphicon-log-in"></span>&nbsp;LOGOUT</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<c:redirect url="login.jsp"></c:redirect>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	
	<div class="container-fluid">
		<div class="jumbotron">
			<h2 class="darkfont text-center">Request Reimbursement</h2><br />
			<c:if test="${ requestScope.issueUsername != null }">
				<div class="alert alert-danger"><c:out value="${ requestScope.issueUsername }"></c:out></div>
			</c:if>
			<c:if test="${ requestScope.issue != null }">
				<div class="alert alert-success"><c:out value="${ requestScope.issue }"></c:out></div>
			</c:if>
			
			<form method="post" action="request-reimb.corvus">
				<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
    				<input type="number" min="0" step="any" name="amount" class="form-control" placeholder="Cost" required>
				</div><br />
				
				<div class="form-group">
					<label for="description">Description:</label>
					<textarea class="form-control" rows="5" id="description" name="description" placeholder="Describe what's being reimbursed and why." required></textarea>
				</div><br />
				
				<label class="control-label">Upload Receipt(s)</label>
				<input id="fileInput" name="files[]" type="file" multiple class="file" data-allowed-file-extensions='["png", "jpg"]'>
				<script>
					$(document).on('ready', function() {
					    $("#fileInput").fileinput({showCaption: false});
					});
				</script>
				<br />
				
				<label class="radio-inline"><input type="radio" name="type" value="Game" checked="checked">Game</label>
				<label class="radio-inline"><input type="radio" name="type" value="Equipment">Equipment</label>
				
				<a class="btn btn-danger pull-right" href="contributor.jsp">Cancel</a>
				<input type="submit" class="btn btn-success pull-right btn-space" value="Submit Reimbursement">
			</form><br /><br />
		</div>
	</div>
	
</body>
</html>