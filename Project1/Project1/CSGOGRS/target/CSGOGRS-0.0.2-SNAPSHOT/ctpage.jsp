<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<c:choose>
	<c:when test="${ sessionScope.page == 'gunrequest' }">
		<div class="well">
			<h1 class="darkfont">REQUEST A GUN</h1>

			<form method="post" action="#" enctype="multipart/form-data">
				<table border="0">
					<tr>
						<td>Pick file #1:</td>
						<td><input type="file" name="fileUpload" size="50" /></td>
					</tr>
					<tr>
						<td>Pick file #2:</td>
						<td><input type="file" name="fileUpload" size="50" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Upload" /></td>
					</tr>
				</table>
			</form>
		</div>
	</c:when>

	<c:when test="${ sessionScope.page == 'viewprofile' }">
		<div class="well">
			<h1 class="darkfont">Profile</h1>
		</div>

		<div class="jumbotron">
			<form action="updateprofile.do" method="post">
				<ul style="list-style-type: none;">
					<li>First Name</li>
					<li><input type="text" name="fname" placeholder="${ sessionScope.fname }"></li>
					<li>Last Name</li>
					<li><input type="text" name="lname" placeholder="${ sessionScope.lname }"></li>
					<li>Email</li>
					<li><input type="email" name="email" placeholder="${ sessionScope.email }"></li>
					<li>Password</li>
					<li><input type="password" name="password" placeholder="*******"></li>
				</ul>

				<input type="submit" value="Update Profile">
			</form>
		</div>
	</c:when>

	<c:otherwise>

		<div class=well>
			<h1 class="darkfont">Main Menu</h1>
		</div>

		<form method="post" action="gunrequest.do">
			<button type="submit">Submit a Reimbursement Request</button>

		</form>

		<form method="post" action="viewprofile.do">
			<button type="submit">View Profile Information</button>

		</form>


		<h2>Status of Requests</h2>


	</c:otherwise>
</c:choose>

<%-- Ensure user does not access this page directly --%>
<c:redirect url="/" />

