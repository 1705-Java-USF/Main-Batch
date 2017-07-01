<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.revature.pojos.*, com.revature.dao.*, java.util.*, com.revature.services.*"%>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html"%>



<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
	</c:if>

	<%
		User viewedUser = (User) request.getAttribute("viewed");
		Select selector = new Select();
		List<Reimbursement> pending = selector.getPendingFor(viewedUser.getId());
		List<Reimbursement> resolved = selector.getResolvedFor(viewedUser.getId());
	%>

	<div class='window' id='reimb' style='margin-top: 20%;'>
		<div class='window_header col-md-12'>User</div>
		<div class='col-md-4 col-md-offset-2'>
		<br><span style='font-size:18px'><%=viewedUser.getFirstname()%>&nbsp;<%=viewedUser.getLastname()%></span><br>
		<%=viewedUser.getUsername()%><span style='color: darkgray'>#<%=viewedUser.getId()%></span><br>
		<%=viewedUser.getEmail()%>
		<br> <br>
		</div>
		<div class="col-md-4">
		<br><br>
		<%
			User u = ((User) session.getAttribute("user"));
			if (u.getId() != viewedUser.getId() && viewedUser.getUr_id() == 1) {
				out.println("<button id='create_account' onclick=\"window.open('promote.do?id=" + viewedUser.getId()
						+ "', '_self');\"'>&nbsp;Promote&nbsp;</button>");
			}
		%></div>

		
		<div class="container-fluid">
			<div class="col-md-12" style="text-align: left;">

				<span style="text-align: center;"><%=pending.size()%>&nbsp;Pending
					Reimbursements</span>
				<table class="reimbursement_table">
					<tr>
						<th><div>Amount</div>
						<th><div>Description</div>
						<th><div>Submitted</div>
						<th><div>Receipt</div> <%
 	for (Reimbursement r : pending) {
 		out.println("<tr onclick=\"window.open('viewReimb.do?id=" + r.getId() + "&app=0', '_self');\"><td>$"
 				+ r.getAmount() + "<td>" + r.getDescription() + "<td>" + r.getSubmitted() + "<td>"
 				+ r.getReceipt());
 	}
 %>
				</table>
				<br> <br>
			</div>
			<div class="col-md-12" style="text-align: left;">
				<span style="text-align: center;"><%=resolved.size()%>&nbsp;Resolved
					Reimbursements</span>
				<table class="reimbursement_table">
					<tr>
						<th><div>Amount</div>
						<th><div>Description</div>
						<th><div>Resolved by</div>
						<th><div>Solution</div> <%
 	for (Reimbursement r : resolved) {
 		User us = selector.getUser(r.getResolver_id());
 		ReimbursementStatus status = selector.getReimbursementStatus(r.getReimb_status());
 		out.println("<tr onclick=\"window.open('viewReimb.do?id=" + r.getId() + "', '_self');\"><td>$"
 				+ r.getAmount() + "<td>" + r.getDescription() + "<td>" + us.getFirstname() + " " + us.getLastname() + "<td>" + status.getStatus());
 	}
 %>
				</table>
				<br> <br>
			</div>
		</div>
	</div>

	<%@include file="resources/inc/taskbar.jsp"%>

</body>