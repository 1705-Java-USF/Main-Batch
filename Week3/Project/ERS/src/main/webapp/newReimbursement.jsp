<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="com.revature.pojos.*, com.revature.dao.*,java.util.*, javax.servlet.*, com.revature.services.*" %>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html" %>

<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
    </c:if>
	<div class="window" id="login">
    	<div class="window_header col-md-12">
    		User
    	</div>
        <br>
        <br>
        <c:if test="${issue != null}">
        	<span style='color:red'><strong><c:out value="${issue}"/></strong></span><br>
        	<br>
       	</c:if>
        <form action="newReimbursement.do" method="post">
        	Amount<br>
        	<input type="number" name="amount" step="any" required><br>
        	Description<br>
        	<input type="text" name="description"><br>
        	Receipt<br>
        	<input type="text" name='receipt'><br>
        	Type<br>
        	<select name="rtype">
        	<%
				User u = (User)session.getAttribute("user");
        		Select selector = new Select();
				List<ReimbursementType> rtypes = selector.getReimbursementTypes();
				for(ReimbursementType rt : rtypes){
					out.println("<option value='"+rt.getId()+"'>"+rt.getType()+"</option>");
				}
			%>
        	</select><br>
        	<div class="col-md-12"><br></div>
        	<input type="submit" id="done-button" value="Submit Request">
        </form>	
   	</div>
    
    <%@include file="resources/inc/taskbar.jsp" %>
</body>
</html>