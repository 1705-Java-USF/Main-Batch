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

<title>Reimbursements</title>
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



<%ErsUser currentUser = (ErsUser)session.getAttribute("user"); %>
<%List<ReinBurst> list = (LinkedList)session.getAttribute("list"); %>
<%List<RtType> types = (LinkedList)session.getAttribute("types"); %>


<!-- SHOW REIMBURSEMENTS -->
<table class="table">
 	<tr><th>ID</th><th>Type</th><th>Amount</th><th>Author ID</th><th>Description</th><th>Submitted</th><th>Resolved</th><th>Resolver ID</th><th>Status</th><th>Receipt</th></tr>
  			
  	<%for(ReinBurst re : list){%>
  		<tr>
  			<td><%=re.getrId()%></td>
  			<%for(RtType t : types)
  			{
  				if(re.getType().equals(t.getId()))
  				{%>
  					<td><%=t.getType()%></td>
  				<%break;
  				}%>
  			<%}%>
  			<td>$<%=re.getAmmount()%></td>
  			<td><%=re.getuIdAuthor()%></td>
  			<td><%=re.getDescription()%></td>
  			
  			<td><%=re.getSubmitted()%></td>
 
  			<%if(re.getResolved() == null)
  			{%>	<td>--</td>
  				<td>--</td>
  				<%if(currentUser.getUrId().equals(1)){%><td>No</td><%}else{%><td><button onclick = "resolve(<%=re.getrId()%>)">Resolve</button></td><% }%>
  
  			<%}else{%>	
				<td><%=re.getResolved()%></td>
  				<td><%=re.getuIdResolver()%></td>
  				<td>Resolved</td>
  			<%} %>
  			
  			<%if(re.getReceipt() != null) {%>
  			<td><a href = "Resources/img/<%=re.getReceipt()%>"><img src="Resources/img/thumb/<%=re.getReceipt()%>"></a></td>
  			<%}else{%>
  			<td><img src="Resources/img/null.png"></td>
  			<%}%>
  		</tr>
	<% }%>

</table>

</body>
</html>