<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page
	import="com.revature.pojos.*, com.revature.dao.*, java.util.*, com.revature.services.*"%>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html"%>



<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
	</c:if>


	<%
		User u = (User) session.getAttribute("user");

		if (u.getUr_id() != 2) {
			out.println("<jsp:forward page='login.jsp' />");
		}

		Select selector = new Select();

		List<Reimbursement> pending = selector.getPendingExcept(u.getId());
		List<Reimbursement> resolved = selector.getResolvedExcept(u.getId());
		List<User> users = selector.getUsersExcept(u.getId());
	%>

	<div class="uncentered_window col-md-4 col-md-offset-1"
		id="manage_reimb_window">
		<div class="window_header col-md-12">Pending Reimbursements</div>
		<br>
		<div class="container-fluid">
			<br>
			<%=pending.size()%>&nbsp;Pending Reimbursements<br>
			<c:if test="${issue != null}">
				<span style='color: red'><strong><c:out
							value="${issue}" /></strong></span>
				<br>
				<br>
			</c:if>
			<table class="reimbursement_table">
				<tr>
					<th><div>Author</div>
					<th><div>Amount</div>
					<th><div>Description</div> <%
 	for (Reimbursement r : pending) {
 		User temp = selector.getUser(r.getAuthor_id());
 		out.println("<tr onclick=\"window.open('viewReimb.do?id=" + r.getId() + "', '_self');\"><td>"
 				+ temp.getFirstname() + " " + temp.getLastname() + "<td>" + r.getAmount() + "<td>"
 				+ r.getDescription());
 	}
 %>
			</table>
			<br>
			<%=resolved.size()%>&nbsp;Resolved Reimbursements<br>
			<table class="reimbursement_table">
				<tr>
					<th><div>Author</div>
					<th><div>Amount</div>
					<th><div>Description</div>
					<th><div>Resolved By</div>
					<th><div>Status</div> <%
 	for (Reimbursement r : resolved) {
 		User temp = selector.getUser(r.getAuthor_id());
 		User resolve = selector.getUser(r.getResolver_id());
 		ReimbursementStatus status = selector.getReimbursementStatus(r.getReimb_status());
 		out.println("<tr onclick=\"window.open('viewReimb.do?id=" + r.getId() + "', '_self');\"><td>"
 				+ temp.getFirstname() + " " + temp.getLastname() + "<td>" + r.getAmount() + "<td>"
 				+ r.getDescription() + "<td>" + resolve.getFirstname() + " " + resolve.getLastname() + "<td>"
 				+ status.getStatus());
 	}
 %>
			</table>
			<br>
		</div>
	</div>
	<div class="uncentered_window col-md-4 col-md-offset-2"
		id="manage_user_window">
		<div class="window_header col-md-12">Manage Users</div>
		<br>
		<div class="container-fluid">
		<br>
		<c:if test="${issue != null}">
			<span style='color: red'><strong><c:out
						value="${issue}" /></strong></span>
			<br>
			<br>
		</c:if>
		
		<%= users.size() %>&nbsp;Users Found

		<table class="reimbursement_table">
			<tr>
				<th><div>Name</div>
				<th><div>Username</div>
				<th><div>Email</div>
				<th><div>Role</div> <%
 	for (User us : users) {
 		UserRole ur;
 		ur = selector.getUserRole(us.getUr_id());
 		out.println("<tr onclick=\"window.open('viewUser.do?id=" + us.getId() + "', '_self');\"><td>"
 				+ us.getFirstname() + " " + us.getLastname() + "<td>" + us.getUsername() + "<td>"
 				+ us.getEmail() + "<td>" + ur.getRole());
 	}
 %>
		</table>
		<br>
		<div class="col-md-12" style="text-align: center;">
			<button id="create_account"
				onclick='window.open("manageNewAccount.jsp", "_self");'>&nbsp;Create
				Account&nbsp;</button>
		</div>
		</div>
		<br>
	</div>

	<%@include file="resources/inc/taskbar.jsp"%>


</body>