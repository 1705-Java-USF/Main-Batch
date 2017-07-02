<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/default.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSGOGRS Home Page</title>
</head>
<body>
	<!-- CSGO MUSIC START
	<audio
		src="https://s3-us-west-2.amazonaws.com/nickdesign/CSGO+Menu.mp3"
		autoplay></audio>
	 CSGO MUSIC END -->

	<div class="fullscreen-bg">
		<video loop muted autoplay poster="media/videoframe.jpg"
			class="fullscreen-bg__video"> <source
			src="media/csgomindtree.webm" type="video/webm"> <source
			src="media/csgomindtree.mp4" type="video/mp4"> <source
			src="media/csgomindtree.ogg" type="video/ogg"></video>
	</div>

	<!-- \\ -->
	<!-- \\\\ -->
	<!-- Navigation Menu Start -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="loggedin.do">CS:GO - Gun Request
				System</a>
		</div>

		<c:if test="${ sessionScope.fname != null }">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <span class="caret"></span><span
						class="glyphicon glyphicon-user"></span> <c:out
							value="${ sessionScope.fname }" /></a>

					<ul class="dropdown-menu">
						<li><a href="#">Account Details</a></li>
						<li><a href="#">Account Information</a></li>
						<li><a href="#">Account Stuff</a></li>
					</ul></li>

				<li class="list__item"><a href="Logout.do"><span
						class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
			</ul>
		</c:if>
	</div>
	</nav>
	<!-- Navigation Menu End -->
	<!-- //// -->
	<!-- // -->


	<div class="container-fluid">
		<!-- csgobox start -->
		<div class="csgobox column shadow-alt">
			<div class="csgobox__header shadow">Welcome to the G.R.S.</div>
		</div>
		<!-- csgobox end -->

		<c:choose>
			<c:when test="${ sessionScope.fname == null }">
				<div class="row">
					<!-- csgobox start -->
					<div class="col-md-4 csgobox">
						<div class="darkfont csgobox__header shadow">Login</div>
						<!-- content start -->
						<div class="csgobox shadow-alt">
							<c:if test="${ issue != null }">
								<div class="alert alert-danger">INVALID CREDENTIALS</div>
							</c:if>

							<form method="post" action="login.do">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="user" class="form-control" placeholder="USERNAME"
										required>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										name="password" class="form-control" placeholder="PASSWORD"
										required>
								</div>
								<br>
								<div class="darkfont">
									<input type="submit" value="LOGIN">
								</div>
							</form>

						</div>
					</div>
					<div class="col-md-8 csgobox">
						<div class="jumbotron csgobox__content">
							<p>Lorem Ipsum is simply dummy text of the printing and
								typesetting industry. Lorem Ipsum has been the industry's
								standard dummy text ever since the 1500s, when an unknown
								printer took a galley of type and scrambled it to make a type
								specimen book. It has survived not only five centuries, but also
								the leap into electronic typesetting, remaining essentially
								unchanged. It was popularised in the 1960s with the release of
								Letraset sheets containing Lorem Ipsum passages, and more
								recently with desktop publishing software like Aldus PageMaker
								including versions of Lorem Ipsum.</p>
						</div>
					</div>
					<!-- content end -->

				</div>
				<!-- csgobox end -->
			</c:when>
			<c:when test="${ sessionScope.role == 'FBI Manager' }">
				<div class="well">
					<h1 class="darkfont">
						Welcome,
						<c:out value="${ sessionScope.fname }"></c:out>
						<jsp:include page="fbipage.jsp"></jsp:include>
					</h1>
				</div>
			</c:when>
			<c:otherwise>
				<div class="well">
					<h1 class="darkfont">
						Welcome,
						<c:out value="${ sessionScope.fname }"></c:out>
						<jsp:include page="ctpage.jsp"></jsp:include>
					</h1>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- container-fluid end -->

</body>
</html>