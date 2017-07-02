<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="com.revature.dao.*, com.revature.pojo.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employees</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><%= session.getAttribute("title") %>Corp</a>
		</div>
		<ul>
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">HOME</a></li>
			</ul>
		</ul>
		<c:if test="${username != null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span class="caret"></span><span
						class="glyphicon glyphicon-user"></span>
					<c:out value="${username}" /></a>
					<ul class="dropdown-menu">
						<li><a href="accinfo.jsp">Account Information</a></li>
						<li><a href="reimpage.jsp">Reimbursements</a></li>
						<li class="active"><a href="viewemployees.jsp">Employees</a></li>
					</ul></li>
				<li><a href="logout.do"><span
						class="glyphicon glyphicon-log-in"></span>&nbsp;LOG-OUT</a></li>
			</ul>
		</c:if>
	</div>
	</nav>
	<c:choose>
		<c:when test="${empty param.username}">

			<h1>All Employees</h1>

			<%
				DaoUser du = new DaoUserImp();
				List<Users> users = du.getUsersExcludingId((Integer) session.getAttribute("id"));

				out.println("<table id='data'>");
				out.println("<tr><th>" + "UserId" + "<th>" + "Username" + "<th>" + "First Name" + "<th>"
						+ "Last Name" + "<th>" + "Email" + "<th>" + "User Role");
				for (Users u : users) {
					String role = du.getRole(u.getUr_id());

					out.println("<tr><td>" + u.getId() + "<td>" + u.getUsername() + "<td>" + u.getFname() + "<td>"
							+ u.getLname() + "<td>" + u.getEmail() + "<td>" + role);

				}
				out.println("</table>");
			%>
		</c:when>
		<c:otherwise>

			<h1>
				<c:out value="${param.username}'s Reimbursements"></c:out>
			</h1>

			<%
				DaoReimbursement dao = new DaoReimbursementImpl();
				DaoUser du = new DaoUserImp();
				
				List<Reimbursement> reim = dao.getReimByUsername((String)request.getParameter("username"));
				if(reim.isEmpty()) {
					
				}
				else {
				
					out.println("<table id='data'>");
					out.println("<tr><th>" + "ReimId" + "<th>" + "Amount" + "<th>" + "Descrip" + "<th>" + "Receipt"
							+ "<th>" + "DateSubmitted" + "<th>" + "DateResolved" + "<th>" + "AuthorId" + "<th>"
							+ "ResolverId" + "<th>" + "Type" + "<th>" + "Status" + "<th>" + "Approve/Deny");
	
					for (Reimbursement r : reim) {
						Users author = du.getUserById(r.getId_author());
						Users resolver = du.getUserById(r.getId_resolver());
						ReimType type = dao.getTypeById(r.getRt_id());
						ReimStatus status = dao.getStatusById(r.getRs_id());
	
						out.println("<tr><td>" + r.getId() + "<td>" + r.getAmount() + "<td>" + r.getDescription()
								+ "<td><a href='"+r.getReceiptUrl(request)+"'><img src='" + r.getReceiptUrl(request) + "' height='50px'></a><td>" + r.getSubmitted() + "<td>"
								+ r.getResolved() + "<td>" + author.getFname() + " " + author.getLname());
						if(resolver != null)
							out.println("<td>" + resolver.getFname() + " " + resolver.getLname() + "<td>" + type.getType() + "<td>" + status.getStatus() + "<td>NULL");
						else{
							out.println("<td>NULL");
							out.println("<td>" + type.getType() + "<td>" + status.getStatus() + "<td>");
							out.println("<button onclick=\"window.open('approve.do?id="+r.getId()+"', '_self');\">APPROVE</button><button onclick=\"window.open('deny.do?id="+r.getId()+"', '_self');\">DENY</button>");
						}
					}
					out.println("</table>");
				}
			%>


		</c:otherwise>
	</c:choose>

	<form method="get" action="viewemployees.jsp">
		<h2>Search reimbursements via username</h2>

		<input type="text" name="username">

		<div class="darkfont">
			<input type="submit" value="SEARCH">
		</div>
	</form>

	<c:if test="${sessionScope.username == null}">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>
	<c:if test="${sessionScope.role != 'Manager'}">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>
</body>
</html>