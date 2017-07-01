<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page
	import="com.revature.pojos.*, com.revature.dao.*, com.revature.services.*"%>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="resources/inc/header.html"%>


<body class="container row">

	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp" />
	</c:if>

	<%
		Select selector = new Select();
		User u = (User) session.getAttribute("user");
		UserRole ur = selector.getUserRole(u.getUr_id());
	%>

	<div class="window" id="reimb">
		<div class="window_header col-md-12">User</div>
		<br>
		<div class="container-fluid">
			<div class='col-md-4 col-md-offset-2'>
				<br>
				<span style='font-size: 18px'><%=u.getFirstname()%>&nbsp;<%=u.getLastname()%></span><br>
				<%=u.getUsername()%><span style='color: darkgray'>#<%=u.getId()%></span><br>
				<%=u.getEmail()%>
				<br> <br>
			</div>
			<div class="col-md-4">
				<br>
				<br>
				<form action="editUser.jsp">
					<input type="submit" value="Edit Profile">
				</form>
			</div>
		</div>
	</div>
	<%@include file="resources/inc/taskbar.jsp"%>

</body>
</html>