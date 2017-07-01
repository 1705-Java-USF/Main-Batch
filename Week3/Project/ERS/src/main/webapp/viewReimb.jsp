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
		Reimbursement viewed = (Reimbursement) request.getAttribute("viewed");
		Select selector = new Select();
		User author = selector.getUser(viewed.getAuthor_id());
		User resolver = selector.getUser(viewed.getResolver_id());
		ReimbursementStatus status = selector.getReimbursementStatus(viewed.getReimb_status());
		ReimbursementType type = selector.getReimbursementType(viewed.getReimb_type());
	%>

	<div class='uncentered_window col-md-4 col-md-offset-4'
		id='manage_reimb_window' style='margin-top: 20%;'>
		<div class='window_header col-md-12'>Reimbursement</div>
		<div class='col-md-4 col-md-offset-2'>
			<br>
			<span style="font-size:18px;"><%= author.getFirstname() + " " + author.getLastname() %></span>
			<br> $<%=viewed.getAmount()%><br> Type:
			<%=type.getType()%><br> Status: 
			<%=status.getStatus()%><br>
			<%=viewed.getDescription()%><br> Submitted:
			<%=viewed.getSubmitted()%><br> <br>
		</div>
		<div class='col-md-4'>
			<br>
			<br>
			<%
				if (viewed.getResolver_id() > 0) {
					out.println("Resolver: " + resolver.getFirstname() + " " + resolver.getLastname() + "<br>" + "Resolved: " + viewed.getResolved());
				} else if (viewed.getAuthor_id() != (((User) session.getAttribute("user")).getId())) {
					out.println("<button class='window_button' onclick='window.open(\"approveReimb.do?id=" + viewed.getId()
							+ "\", \"_self\");'>&nbsp;Approve&nbsp;</button><br><br>"
							+ "<button class='window_button'onclick='window.open(\"denyReimb.do?id=" + viewed.getId()
							+ "\", \"_self\");'>&nbsp;Deny&nbsp;</button>");
				}
			%>

		</div>
	</div>

	<%@include file="resources/inc/taskbar.jsp"%>

</body>