<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<c:choose>
	<c:when test="${ sessionScope.page == 'viewreqs' }">
		<div class="well">
			<h1 class="darkfont">VIEW THE GUN REQUESTS</h1>
		</div>
	</c:when>

	<c:when test="${ sessionScope.page == 'viewcts' }">
		<div class="well">
			<h1 class="darkfont">VIEW ALL THE CTS</h1>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Username</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Position</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" begin="0" end="${ sessionScope.peoplelength }">
					<tr>
						<th scope="row"><c:out value="${ sessionScope.people[j][0] }"></c:out></th>
						<td><c:out value="${ sessionScope.people[j][1] }"></c:out></td>
						<td><c:out value="${ sessionScope.people[j][2] }"></c:out></td>
						<td><c:out value="${ sessionScope.people[j][3] }"></c:out></td>
						<td><c:out value="${ sessionScope.people[j][4] }"></c:out></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</c:when>

	<c:otherwise>

		<div class=well>
			<h1 class="darkfont">THE MANAGER PAGE</h1>
		</div>

		<form method="post" action="viewreqs.do">
			<button type="submit">View All Pending Requests</button>

		</form>

		<form method="post" action="viewcts.do">
			<button type="submit">View All Employees</button>

		</form>


		<h2>Status of Requests</h2>


	</c:otherwise>
</c:choose>
<%-- Ensure user does not access this page directly --%>
<c:redirect url="/" />


