<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page import = "com.revature.dao.*, com.revature.pojo.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type = "text/css" href = "resources/css/default.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement Page</title>
</head>
<body>
	<nav class = "navbar navbar-inverse">
		<div class = "container-fluid">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "#"><%= session.getAttribute("title") %>Corp</a>
			</div>
			<ul>
				<ul class = "nav navbar-nav">
					<li><a href = "index.jsp">HOME</a></li>
				</ul>
			</ul>
			<c:if test = "${username != null}">
			<ul class = "nav navbar-nav navbar-right">
				<li class = "dropdown"><a class = "dropdown-toggle" data-toggle = "dropdown" href = "#"><span class = "caret"></span><span class = "glyphicon glyphicon-user"></span><c:out value = "${username}"/></a>
					<ul class = "dropdown-menu">
						<li><a href = "accinfo.jsp">Account Information</a></li>
						<li class = "active"><a href = "reimpage.jsp">Reimbursements</a></li>
						<c:if test = "${sessionScope.role == 'Manager'}">
							<li><a href = "viewemployees.jsp">Employees</a></li>
						</c:if>
					</ul>
				</li>
				<li><a href = "logout.do"><span class = "glyphicon glyphicon-log-in"></span>&nbsp;LOG-OUT</a></li>
			</ul>
			</c:if>
		</div>
	</nav>
		
	<h1>Request/View Reimbursements</h1>
	<%
	DaoReimbursement dao = new DaoReimbursementImpl();
	DaoUser du = new DaoUserImp();
	List<Reimbursement> reim = dao.getReimById((Integer)session.getAttribute("id"));
	
	if(reim.isEmpty()) {
		
	}
	else {
		out.println("<table id='data'>");
		out.println("<tr><th>" + "ReimId" + "<th>" + "Amount" + "<th>" + "Descrip" + "<th>" + "Receipt" + "<th>" + "DateSubmitted" + "<th>" + "DateResolved"
				+ "<th>" + "AuthorId" + "<th>" + "ResolverId" + "<th>" + "Type" + "<th>" + "Status");
		for(Reimbursement r: reim) {
			Users author = du.getUserById(r.getId_author());
			Users resolver = du.getUserById(r.getId_resolver());
			ReimType type = dao.getTypeById(r.getRt_id());
			ReimStatus status = dao.getStatusById(r.getRs_id());
		
			out.println("<tr><td>" + r.getId() + "<td>" + r.getAmount() + "<td>" + r.getDescription() + "<td><a href='"+r.getReceiptUrl(request)+"'><img src='" + r.getReceiptUrl(request) + "' height='50px'></a><td>" + r.getSubmitted()
			+ "<td>" + r.getResolved() + "<td>" + author.getFname() + " " + author.getLname());
		
			if(resolver != null){
				out.println("<td>" + resolver.getFname() + " " + resolver.getLname());
			}else{
				out.println("<td>--");
			}
			out.println("<td>" + type.getType() + "<td>" + status.getStatus());			
		}
		out.println("</table>");
	}
	%>
	<div class = "container-fluid">	
		<h2>Please fill out ALL fields</h2>
		<form method = "post" enctype = "multipart/form-data" action = "createreim.do">
			<ul style = "list-style-type: none;">
				<li>AMOUNT</li>
				<li><input type = "text" name = "amount" required></li>
				<li>DESCRIPTION</li>
				<li><input type = "text" name = "descrip"></li>
				<li>RECEIPT</li>
				<li><input type = "file" name = "receipt" required></li>
				<li>TYPE</li>
				<li><select name = "type" class = "weblist" required>
					<option>Parking Pass</option>
					<option>Lodging</option>
					<option>Gas</option>
					<option>Food</option>
					<option>Travel</option>
					<option>Gym Membership</option>
					<option>Other</option>
				</select></li>
			</ul>
			<input type = "submit" value = "REIM">
		</form>
	</div>
	<c:if test = "${sessionScope.username == null}">
		<jsp:forward page="index.jsp"></jsp:forward>
	</c:if>
</body>
</html>