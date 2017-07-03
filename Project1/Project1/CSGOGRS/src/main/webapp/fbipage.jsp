<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<c:choose>
	<c:when test="${ sessionScope.page == 'viewreqs' }">
		<div class="well">
			<h1 class="darkfont">VIEWING PENDING REQUESTS</h1>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Gun Type</th>
						<th>Cost Estimate</th>
						<th>Request Description</th>
						<th>Personnel</th>
						<th>Submitted</th>
						<th>Request Form</th>
						<th>Resolve</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" begin="0"
						end="${ sessionScope.preqslength < 0 ? 0 : sessionScope.preqslength }">
						<c:if test="${ sessionScope.pendingreqs[j][10] == 1 }">
							<tr>
								<th scope="row"><c:out
										value="${ sessionScope.pendingreqs[j][0] }"></c:out></th>
								<td><c:out value="${ sessionScope.pendingreqs[j][1] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][2] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][3] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][4] }"></c:out></td>
								<td>
									<form method="post" action="viewpic.do" target="_blank">
										<input type="hidden" name="thegid"
											value="${ sessionScope.pendingreqs[j][7] }"> <input
											type="submit" value="View">
									</form>
								</td>
								<td>
									<form method="post" action="approve.do">
										<input type="hidden" name="thej" value="${ j }"> <input
											type="hidden" name="approve"
											value="${ sessionScope.pendingreqs[j][7] }"> <input
											type="submit" value="Approve">
									</form>
									<form method="post" action="deny.do">
										<input type="hidden" name="thej" value="${ j }"> <input
											type="hidden" name="deny"
											value="${ sessionScope.pendingreqs[j][7] }"> <input
											type="submit" value="Deny">
									</form>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:when test="${ sessionScope.page == 'viewoldreqs' }">
		<div class="well">
			<h1 class="darkfont">VIEWING RESOLVED REQUESTS</h1>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Gun Type</th>
						<th>Cost Estimate</th>
						<th>Request Description</th>
						<th>Personnel</th>
						<th>Submitted</th>
						<th>Closed</th>
						<th>Resolver</th>
						<th>Request Form</th>
						<th>Resolution</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" begin="0"
						end="${ sessionScope.preqslength < 0 ? 0 : sessionScope.preqslength }">
						<c:if test="${ sessionScope.pendingreqs[j][10] != 1 }">
							<tr>
								<th scope="row"><c:out
										value="${ sessionScope.pendingreqs[j][0] }"></c:out></th>
								<td><c:out value="${ sessionScope.pendingreqs[j][1] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][2] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][3] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][4] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][5] }"></c:out></td>
								<td><c:out value="${ sessionScope.pendingreqs[j][8] }"></c:out></td>

								<td>
									<form method="post" action="viewpic.do" target="_blank">
										<input type="hidden" name="thegid"
											value="${ sessionScope.pendingreqs[j][7] }"> <input
											type="submit" value="View">
									</form>
								</td>
								<td><c:out value="${ sessionScope.pendingreqs[j][6] }"></c:out></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:when test="${ sessionScope.page == 'viewcts' }">



		<c:if test="${ sessionScope.viewSingle == null }">
			<div class="well">
				<h1 class="darkfont">VIEWING ALL CTS</h1>

				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Username</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Position</th>
							<th>Requests</th>
							<th>Promotion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="j" begin="0"
							end="${ sessionScope.peoplelength < 0 ? 0 : sessionScope.peoplelength }">
							<tr>
								<th scope="row"><c:out
										value="${ sessionScope.people[j][0] }"></c:out></th>
								<td><c:out value="${ sessionScope.people[j][1] }"></c:out></td>
								<td><c:out value="${ sessionScope.people[j][2] }"></c:out></td>
								<td><c:out value="${ sessionScope.people[j][3] }"></c:out></td>
								<td><c:out value="${ sessionScope.people[j][4] }"></c:out></td>
								<td>
									<form method="post" action="viewsingle.do">
										<input type="hidden" name="thej" value="${ j }"> <input
											type="hidden" name="ct"
											value="${ sessionScope.people[j][1].toString().concat(' ').concat(sessionScope.people[j][2].toString()) }">
										<input type="submit" value="View">
									</form>
								</td>
								<c:if
									test="${ sessionScope.people[j][4].toString().equals('Counter-Terrorist') }">
									<td>
										<form method="post" action="promote.do">
											<input type="hidden" name="thej" value="${ j }"> <input
												type="hidden" name="promote"
												value="${ sessionScope.people[j][5] }"> <input
												type="submit" value="Promote!">
										</form>
									</td>
								</c:if>
								<td><c:out value="${ sessionScope.viewSingle }"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>

		<c:if test="${ sessionScope.viewSingle != null }">
			<div class="well">
				<h1 class="darkfont">
					VIEWING
					<c:out value="${ sessionScope.viewSingle }"></c:out>
					REQUESTS
				</h1>

				<table class="table table-striped table-condensed">
					<thead>
						<tr>
							<th>Gun Type</th>
							<th>Cost Estimate</th>
							<th>Request Description</th>
							<th>Submitted</th>
							<th>Closed</th>
							<th>Resolver</th>
							<th>Request Form</th>
							<th>Resolution</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="j" begin="0"
							end="${ sessionScope.preqslength < 0 ? 0 : sessionScope.preqslength }">
							<c:if
								test="${ sessionScope.pendingreqs[j][3].toString().equals(sessionScope.viewSingle) }">
								<tr>
									<th scope="row"><c:out
											value="${ sessionScope.pendingreqs[j][0] }"></c:out></th>
									<td><c:out value="${ sessionScope.pendingreqs[j][1] }"></c:out></td>
									<td><c:out value="${ sessionScope.pendingreqs[j][2] }"></c:out></td>
									<td><c:out value="${ sessionScope.pendingreqs[j][4] }"></c:out></td>
									<td><c:out value="${ sessionScope.pendingreqs[j][5] }"></c:out></td>
									<td><c:out value="${ sessionScope.pendingreqs[j][8] }"></c:out></td>

									<td>
										<form method="post" action="viewpic.do" target="_blank">
											<input type="hidden" name="thegid"
												value="${ sessionScope.pendingreqs[j][7] }"> <input
												type="submit" value="View">
										</form>
									</td>
									<td><c:out value="${ sessionScope.pendingreqs[j][6] }"></c:out></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>

	</c:when>

	<c:otherwise>

		<div class=well>
			<h1 class="darkfont">THE FBI MANAGER PAGE</h1>
		</div>

		<form method="post" action="viewreqs.do">
			<button type="submit">View All Pending Requests</button>
		</form>

		<form method="post" action="viewoldreqs.do">
			<button type="submit">View All Resolved Requests</button>
		</form>

		<form method="post" action="viewcts.do">
			<button type="submit">View All Employees</button>
		</form>


	</c:otherwise>
</c:choose>
<%-- Ensure user does not access this page directly --%>
<c:redirect url="/" />


