<%@page import="com.revature.ers.DataObjects.Reimbursement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="CommonIncludes.jsp"%>
<script src="resources/js/ViewRequests.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/view-req.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Requests</title>
</head>
<body id="view-req">
	<%@include file="navbar.jsp"%>

	<div class="fluid-container">
		<div class="well">
			<table id="r-table">
				<tr>
					<th>Reimbursement ID</th>
					<th>Amount</th>
					<th>Description</th>
					<th>Submitted time</th>
					<th>Resolved Time</th>
					<th>Resolver</th>
					<th>Status</th>
					<th>type</th>
				</tr>
				<%
					java.util.List<Reimbursement> reqs = (java.util.List<Reimbursement>) request.getAttribute("reqs");
					int i = 1;
					for (Reimbursement r : reqs) {
				%>
				<tr id=<%="r-row" + i %> >
					<td class="r-rid"><%=r.getId() %></td>
					<td class="r-amount"><%=r.getAmount() %></td>
					<td class="r-descr"><%=r.getDescription() %></td>
					<td class="r-sub-time"><%=r.getSubmittedTime() %></td>
					<td class="r-res-time"><%=r.getResolvedTime() %></td>
					<td class="r-resolver"><%=r.getResolver() %></td>
					<td class="r-status"><%=r.getReimbursementStatus() %></td>
					<td class="r-type"><%=r.getReimbursementType() %></td>
				</tr>
				<% 
					i++;
					}
				%>
				
			</table>
		</div>
	</div>
	
	<div id="v-req-box" class="fluid-container hide">
		<div class="well">
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