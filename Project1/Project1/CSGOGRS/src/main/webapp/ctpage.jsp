<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<script>
	$(document).ready(function() {

	});

	function changeCost() {
		if ($('#guntype').find(":selected").text() == "Rifle") {
			$('input[readonly]').val('3000');
		} else if ($('#guntype').find(":selected").text() == "Submachine") {
			$('input[readonly]').val('2000');
		} else if ($('#guntype').find(":selected").text() == "Machine") {
			$('input[readonly]').val('4000');
		} else if ($('#guntype').find(":selected").text() == "Shotgun") {
			$('input[readonly]').val('2000');
		} else if ($('#guntype').find(":selected").text() == "Pistol") {
			$('input[readonly]').val('1000');
		} else {
			$('input[readonly]').val('0');
		}
	}
</script>


<c:choose>
	<c:when test="${ sessionScope.page == 'gunrequest' }">
		<div class="well">
			<h1 class="darkfont">REQUEST A GUN</h1>

			<form method="post" action="upload.do" enctype="multipart/form-data">
				<table border="0">
					<tr>
						<td>Upload Request Form:</td>
						<td><input type="file" accept="image/jpeg" name="fileUpload"
							size="50" required /></td>
					</tr>
					<tr>
						<td>Reason For Request:</td>
						<td><textarea name="description" required></textarea></td>
					</tr>
					<tr>
						<td>Choose Gun Type:</td>
						<td><select id="guntype" name="guntype"
							onclick="changeCost()" required>
								<option value="">Select Option</option>
								<option value="pistol">Pistol</option>
								<option value="shotgun">Shotgun</option>
								<option value="submachine">Submachine</option>
								<option value="rifle">Rifle</option>
								<option value="machine">Machine</option>
						</select></td>
					</tr>
					<tr>
						<td>Gun Cost Estimate:</td>
						<td><input type="text" name="cost" value="0" readonly></td>
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
					<li><input type="text" name="fname"
						placeholder="${ sessionScope.fname }"></li>
					<li>Last Name</li>
					<li><input type="text" name="lname"
						placeholder="${ sessionScope.lname }"></li>
					<li>Email</li>
					<li><input type="email" name="email"
						placeholder="${ sessionScope.email }"></li>
					<li>Password</li>
					<li><input type="password" name="password"
						placeholder="*******"></li>
				</ul>

				<input type="submit" value="Update Profile">
			</form>
		</div>
	</c:when>

	<c:when test="${ sessionScope.page == 'viewreqs' }">
		<div class="well">
			<h1 class="darkfont">VIEW THE GUN REQUESTS</h1>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Gun Type</th>
						<th>Cost Estimate</th>
						<th>Request Description</th>
						<th>Submitted On</th>
						<th>Closed On</th>
						<th>Status</th>
						<th>Request Form</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" begin="0"
						end="${ sessionScope.preqslength < 0 ? 0 : sessionScope.preqslength }">
						<c:if test="${sessionScope.id.equals(pendingreqs[j][9]) }">
							<tr>
								<th scope="row"><c:out
										value="${ sessionScope.pendingreqs[j][0] }"></c:out></th>
								<td><c:out value="${ sessionScope.pendingreqs[j][1] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][2] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][4] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][5] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][6] }"></c:out></td>
								<td>
									<form method="post" action="viewpic.do" target="_blank">
										<input type="hidden" name="thegid" value="${ sessionScope.pendingreqs[j][7] }"> 
										<input type="submit" value="View">
									</form>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>

	<c:otherwise>

		<div class=well>
			<h1 class="darkfont">THE CT PAGE</h1>
		</div>

		<form method="post" action="gunrequest.do">
			<button type="submit">Submit a Request</button>
		</form>

		<form method="post" action="viewprofile.do">
			<button type="submit">View Profile Information</button>
		</form>

		<form method="post" action="viewreqs.do">
			<button type="submit">View Previous Requests</button>
		</form>


	</c:otherwise>
</c:choose>

<%-- Ensure user does not access this page directly --%>
<c:redirect url="/" />

