<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page
	import="com.revature.pojos.*, com.revature.dao.*, java.util.*, javax.servlet.*, com.revature.services.*"%>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html"%>



<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
	</c:if>

	<%
		User u = (User) session.getAttribute("user");
		Select selector = new Select();
		List<Reimbursement> pending = selector.getPendingFor(u.getId());
		List<Reimbursement> resolved = selector.getResolvedFor(u.getId());
	%>

	<div class="window" id="reimb">
		<div class="window_header col-md-12">Reimbursements</div>
		<br> <br>
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
						<th><div>Resolved</div> <%
 	for (Reimbursement r : resolved) {
 		out.println("<tr onclick=\"window.open('viewReimb.do?id=" + r.getId() + "', '_self');\"><td>$"
 				+ r.getAmount() + "<td>" + r.getDescription() + "<td>" + r.getResolver_id() + "<td>"
 				+ r.getResolved());
 	}
 %>
				</table>
				<br> <br>
			</div>
		</div>
		<form action="newReimbursement.jsp">
			<input type="submit" value="New Reimbursement">
		</form>
	</div>


	<%@include file="resources/inc/taskbar.jsp"%>

</body>
</html>