<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="com.revature.pojos.*, com.revature.dao.*, java.util.*" %>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html" %>



<body class="container row">
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
    </c:if>
    
    <div class="window" id="login">
        <div class="window_header col-md-12">
            Create Account
        </div>
        <br>
        <br>
        <br>
        <form method="post" action="manageCreateAccount.do">
                <input type="text" name="firstname" placeholder="First Name">
                <input type="text" name="lastname" placeholder="Last Name"><br><br>
                <input type="text" name="username" placeholder="Username" required>
                <input type="email" name="email" placeholder="Email" required><br><br>
                <input type="submit" value="Submit">
        </form>
        <br>
    </div>

<%@include file="resources/inc/taskbar.jsp" %>

</body>
</html>