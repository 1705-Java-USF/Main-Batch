<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/create-req.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Reimbursement</title>
</head>
<body id="create-req">
	<%@include file="navbar.jsp"%>

	<form class="create-req-box" enctype="multipart/form-data" method="post" , action="CreateReq.do">
		<div class="jumbotron">
			<div class="jumbotron-header">
				<h2 id="req-header">Create Request</h2>
			</div>
			<%@include file="MessageContainer.jsp" %>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-usd"></i></span>
				<input id="req-amount" type="number" class="form-control" name="amount" placeholder="Amount" required />
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-pencil"></i></span>
				<input id="req-descr" type="text" class="form-control" name="description" placeholder="Description" required />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Image of Receipt: <i
					class="glyphicon glyphicon-camera"></i></span>
				<input id="req-receipt" type="file" class="form-control" name="receipt"  />
			</div>
			<div class="input-group">
				<span class="input-group-addon"></span>
				<select id="req-type" class="form-control" name="type">
					<option>Select a type of expense</option>
					<option>Travel</option>
					<option>Parking</option>
					<option>Maintenance</option>
					<option>Charging Fees</option>
					<option>Software Upgrade</option>
					<option>Other</option>
				</select>
			</div>
			<div class="button-container">
				<input id="req-button" class="submit-button" type="submit" value="Create Reimbursement" />
			</div>
			
		</div>
	</form>
</body>
</html>