<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ page import="com.revature.pojo.*,java.util.*,com.revature.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" type = "text/css" href = "Resources/CSS/default.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src = "Resources/js/main.js"></script>

<title>Morty Manage</title>
</head>
<body class = "container-fluid">
<img src="Resources/img/header.png" width = "100%">

<!-- NAVIGATION BAR -->
<nav id = "nv" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp" style = "color: #ffffff;">Home</a>
    </div>
    
    <c:if test="${user != null}">
    	
    	<ul class="nav navbar-nav">
    		<c:choose>
    			<c:when test="${sessionScope.role == 1}">
      				<li class="active"><a href="ersuser.jsp">Morty View</a></li>
      				<li class="active"><a href="UserPending.do">Pending Reimbursements</a></li>
      				<li class="active"><a href="UserResolved.do">Resolved Reimbursements</a></li>
   					<li class="active"><a href="create.html">Create Reimbursement</a></li>
      			</c:when>
      			<c:otherwise>
      				<li class="active"><a href="manager.jsp">Rick View</a></li>
      				<li class="active"><a href="ManageMorty.do">Morty Manage</a></li>
      				<li class="active"><a href="ManResolved.do">Resolved Reimbursements</a></li>
      				<li class="active"><a href="ManPending.do">Pending Reimbursements</a></li>
      			</c:otherwise>
      		</c:choose>
      		<li class="active"><a href="updateUser.jsp">Update Account</a></li>
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
    		<li><a href="Logout.do" style = "color: #ffffff;"><span class="glyphicon glyphicon-log-out" ></span>Logout</a></li>		
    	</ul>
    </c:if>
    
  </div>
</nav>

<%List<ErsUser> mortys = (LinkedList)session.getAttribute("emplist"); %>

<%System.out.println("morty list: " +mortys.size()); %>

<!-- DISPLAY EMPLOYEES -->
<table class="table">
 	<tr><th>ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Rick ID</th><th>Reimbursements</th><th>Promote</th></tr>
  			
  	<%for(ErsUser eu : mortys){%>
  	<tr>
  		<td><%=eu.getuId()%></td>
  		<td><%=eu.getUserName()%></td>
  		<td><%=eu.getFirstName()%></td>
  		<td><%=eu.getLastName()%></td>
  		<td><%=eu.getEmail()%></td>
  		<td><%=eu.getUrId()%></td>
  		<td><button onclick = "window.open('ViewUser.do?viewId=<%=eu.getuId()%>', '_self')">View</button></td>
  		<td><button onclick = "promote(<%=eu.getuId()%>)">Promote</button></td>
  	</tr>
  	<%}%>

</table>
<br>
</body>
</html>