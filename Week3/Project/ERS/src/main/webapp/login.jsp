<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html" %>

<body class="container row">
    <div class="window" id="reimb">
        <div class="window_header col-md-12">
            Login
        </div>
        <br>
        <br>
        
		<c:choose>
			<c:when test="${sessionScope.user==null}">
				<script>
					$(document).ready(function() {$('#my_audio').get(0).play();});
				</script>
				<audio id='my_audio' src='resources/audio/startup.mp3'></audio>
        		<form method="post" action="Login.do">
				<div class="container-fluid">
					<div class="container-fluid col-md-1">
						<img src='resources/img/key.png' style='margin-top:20px;'>
					</div>
					<div class="container-fluid col-md-8">
						<c:if test="${issue!=null}">
							<span style='color:red'><strong><c:out value="${issue}" /></strong></span><br><br>
						</c:if>
						Type a username and password to log on to ERS
						<br>
						<br>
            				<span class="col-md-2 col-md-offset-1">Username</span>
            				<input type="text" name="username" class="col-md-6 col-md-offset-2" required><br><br>
            				<span class="col-md-2 col-md-offset-1">Password</span>
            				<input type="password" name="password" class="col-md-6 col-md-offset-2" required>
        					<br>
        				<br>
        				<br>
        			</div>
        			<div class="container-fluid col-md-3">
           				<input type="submit" name="login" value="Login" class="col-md-12"><br><br>
        				<a href="accountForm.html" id='create_account' class="col-md-12">Create Account</a>
        			</div>
        		</div>
        		</form>
        	</c:when>
        	<c:otherwise>
        		<form action="Logout.do">
        			<input type="submit" value="Logout">
        		</form>
        	</c:otherwise>
        </c:choose>
   </div>
   
   <img src="resources/img/doors.png" id="doors_logo">
 
</body>
</html>