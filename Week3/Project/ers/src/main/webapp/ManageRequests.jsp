<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Requests</title>
<script src="resources/js/ManageRequest.js"></script>
<script src="resources/js/ViewRequests.js"></script>
</head>
<body id="manage-req">
<%@include file="navbar.jsp" %>
	<div class="container-fluid">
		<div class="well">
			<div id="mreq-bar" >
				<ul id="mreq-buttons">
					<li id="pending">Pending Requests</li>
					<li id="resolved">Resolved Requests</li>
				</ul>
			</div>
			<div id="request-container">
			
			</div>
		</div>
	</div>
	<div id="v-req-box" class="fluid-container hide">
		<div class="well">
			<%@include file="MessageContainer.jsp" %>
			<div id="manage-buttons">
				<div>
					<button id="approve">Approve</button>
					<button id="reject">Reject</button>
				</div>
			</div>
			<div id="rid" class="label-val-container">
				<span class="label">Request ID</span> 
				<span class="value"></span>
			</div>
			<div id="amount" class="label-val-container">
				<span class="label">Amount</span>
				<span class="value"></span>
			</div>
			<div id="descr" class="label-val-container">
				<span class="label">Description</span>
				<span class="value"></span>
			</div>
			<div id="author" class="label-val-container">
				<span class="label">Description</span>
				<span class="value"></span>
			</div>
			<div id="sub-time" class="label-val-container">
				<span class="label">Submitted Time</span>
				<span class="value"></span>
			</div>
			<div id="res-time" class="label-val-container">
				<span class="label">Resolved Time</span>
				<span class="value"></span>
			</div>
			<div id="resolver" class="label-val-container">
				<span class="label">Resolver</span>
				<span class="value"></span>
			</div>
			<div id="status" class="label-val-container">
				<span class="label">Status</span>
				<span class="value"></span>
			</div>
			<div id="type" class="label-val-container">
				<span class="label">Type</span>
				<span class="value"></span>
			</div>
			<div id="receipt" class="label-val-container">
				<span class="label">Receipt</span>
				<span class="value"></span>
			</div>	
		</div>
	</div>

</body>
</html>