<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="well"> 
	<h1>Welcome, <c:out value="${sessionScope.f_name}"></c:out>  <c:out value="${sessionScope.l_name}"></c:out></h1>
</div>
<div class="well" id="homeDIV"> 
	<img id="homeIMAGE" alt=ALTERNATIVE src="resources/images/reimburse_icon.png">
	<p id="homeP">
	<br> <br> <br> <br>
	The Reimbursements Hub allows you access to employees and their reimbursements. Through our hub, you can
	add register employees, approve/deny reimbursement requests, and even promote employees to managers. 
	You can also update your own account information. </p>
</div>