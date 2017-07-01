<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="com.revature.pojos.*, com.revature.dao.*" %>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html" %>



<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
    </c:if>
    
    <%
		User u = (User)session.getAttribute("user");
	%>
    
    <div class="window" id="reimb">
        <div class="window_header col-md-12">
            User
        </div>
        <br>
        <br>
        <c:if test="${issue != null}">
        	<span style='color:red'><strong><c:out value="${issue}"/></strong></span><br>
        	<br>
       	</c:if>
        No fields are required. If you change password, Current and New Password will both be required
        <form action="editUser.do" method="post">
        	<div class="col-md-6">
        		First Name<br>
        		<input type="text" value="<%= u.getFirstname() %>" name="fname">
        		<br>
        		Username<br>
        		<input type="text" value="<%= u.getUsername() %>" name="uname">
        		<br>
        		Current Password<br>
        		<input type="password" name="oldpass">
        	</div>
        	<div class="col-md-6">
        		Last Name<br>
        		<input type="text" value="<%= u.getLastname() %>" name="lname">
        		<br>
        		Email<br>
        		<input type="text" value="<%= u.getEmail() %>" name="email">
        		<br>
        		New Password<br>
        		<input type="password" name="newpass">
        	</div>
        	<div class="col-md-12"><br></div>
        	<input type="submit" value="Update Profile">
        </form>
   </div>
<%@include file="resources/inc/taskbar.jsp" %>

</body>
</html>