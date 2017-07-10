<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- This will ensure that mobile will work with site by allowing proper formatting when zooming in -->
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="">Dynasty</a><img
				src="http://icons.iconarchive.com/icons/tatice/operating-systems/128/Globe-icon.png"
				align="middle" width="25" heigth="25">
		</div>
		<ul class="nav navbar-nav">
			<li><a href="Homepage.jsp">HOME</a></li>
			<li class="active"><a href="About.jsp">About Us</a></li>
			<c:if test="${ur==1}">
				<li><a href="MPortal.jsp">Manager Portal</a></li>
			</c:if>
			<c:if test="${user!=null}">
				<li><a href="Reim.jsp">Reimbursements</a></li>
			</c:if>
		</ul>
		<c:if test="${user!=null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <span class="caret"></span> <span
						class="glyphicon glyphicon-user"></span> <c:out value="${user}" /></a>
					<ul class="dropdown-menu">
						<li><a href="AccInfo.jsp">Account Information</a></li>
					</ul></li>
				<li><a href="Logout.do"><span
						class="glyphicon glyphicon-log-in"></span> LOGOUT</a></li>
			</ul>
		</c:if>
	</div>
	</nav>
	<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

	<div class="well">
		<p>
			Dynasty is an established company that provides expertise in luxury
			car maintenance for car companies on a worldwide basis, including
			sales, advertisement, and individual car maintenance. We cater to all
			major luxury car brands and individual owners. The company’s main
			home office is located here in Tampa, FL, a major continuously
			growing business center located on the west coast of Florida. Other
			company locations include: London, Dubai, Berlin, and Sevilla. We
			have over 30 years of experience in providing luxury car maintenance.
			<br> <br> Lorem ipsum dolor sit amet, consectetur
			adipiscing elit. Nam eget velit in turpis rutrum commodo ut non
			lorem. Pellentesque quis magna elementum, hendrerit leo at, facilisis
			odio. Donec nibh ligula, tristique et sapien in, blandit pretium sem.
			Etiam velit est, tincidunt et pretium ut, feugiat a lectus. Praesent
			hendrerit nisi est, quis eleifend arcu sollicitudin eu. Morbi maximus
			neque mauris, tempor gravida enim tempor sit amet. Integer vestibulum
			dolor sed mauris pharetra condimentum. Aenean rhoncus aliquet
			lobortis. Cras eget posuere nisi, ut ultricies lacus. Nullam feugiat
			semper dui nec dictum. Nunc at aliquet risus. Vestibulum ante ipsum
			primis in faucibus orci luctus et ultrices posuere cubilia Curae;
			Nullam sed dignissim arcu, vel suscipit est.<br> <br> Nullam tristique magna
			vel quam pulvinar, ac dignissim diam elementum. Proin hendrerit felis
			lectus, in tristique orci faucibus elementum. Lorem ipsum dolor sit
			amet, consectetur adipiscing elit. Nulla vitae neque a erat tristique
			lobortis. Nullam in urna vitae dolor porta volutpat quis at neque.
			Nam id mi eu arcu laoreet elementum. Aliquam eros mi, sollicitudin
			sit amet commodo eu, tempus ac nunc. Aliquam in diam posuere, ornare
			sapien vel, pretium leo. Mauris libero massa, commodo non feugiat id,
			ultricies a ipsum. Interdum et malesuada fames ac ante ipsum primis
			in faucibus. Donec suscipit enim lorem, venenatis egestas tortor
			dapibus sed. In at libero vulputate, facilisis justo sed, pulvinar
			tellus. Sed a felis pulvinar, porta tortor at, ornare urna. Fusce nec
			mauris quis diam malesuada molestie at vel leo. Nulla id risus
			pulvinar, commodo odio in, luctus enim.<br> <br> Nulla scelerisque aliquam
			imperdiet. Maecenas iaculis sem sed elementum imperdiet. Donec
			pretium, magna ac placerat dignissim, leo nibh malesuada dolor,
			lobortis iaculis est leo ut lectus. Maecenas mattis dolor sapien, a
			lobortis nulla cursus ut. Nulla fringilla lacus diam, a accumsan
			tortor varius sit amet. Quisque nec metus mauris. Mauris consequat
			ipsum neque, ac egestas mi interdum at. Phasellus dignissim turpis id
			porttitor suscipit. Donec accumsan convallis massa non cursus.
			Vestibulum eget vestibulum dolor, eget convallis ex. Fusce felis
			mauris, tincidunt eget eros vel, faucibus convallis felis. Interdum
			et malesuada fames ac ante ipsum primis in faucibus. Nulla pretium
			sodales eros, ac posuere eros elementum eleifend. Nullam ac mollis
			sem, id imperdiet ex. Sed mi arcu, laoreet sit amet imperdiet vitae,
			consectetur sed massa. Donec tempor sit amet libero ac mattis.
			Maecenas blandit diam venenatis est scelerisque rutrum. Aliquam
			libero eros, aliquam ac metus eget, convallis luctus ex. Integer
			semper mollis egestas. Morbi tincidunt laoreet consectetur. Proin ut
			lorem sem. Sed eget metus in tortor mollis imperdiet.<br> <br> Integer laoreet
			ac lectus et fringilla. Nullam fringilla fermentum mattis. Praesent
			ac pharetra mi, quis mattis mauris. Morbi et felis aliquet, tincidunt
			ligula sit amet, auctor purus. Vestibulum ante ipsum primis in
			faucibus orci luctus et ultrices posuere cubilia Curae; Praesent
			pulvinar leo sem, vitae commodo turpis aliquet at. Nam rutrum, augue
			eget facilisis pulvinar, tortor orci bibendum nisi, nec ornare urna
			felis eu libero. Interdum et malesuada fames ac ante ipsum primis in
			faucibus. Proin vitae congue sem. Nunc ac tellus nulla. Curabitur id
			varius diam, non convallis nisl. Praesent condimentum dictum mauris,
			vitae aliquam diam ultrices eget. Fusce placerat libero et nibh
			iaculis imperdiet. Curabitur quis tempus tortor, non ultricies risus.
			Curabitur placerat lacinia turpis, hendrerit iaculis ipsum placerat
			venenatis. Phasellus elementum lectus augue, eget mattis lacus
			laoreet quis. In interdum est rhoncus rhoncus elementum. Nam volutpat
			enim eget aliquam efficitur.<br> <br> Vivamus eu vulputate nulla. Donec semper
			elementum tortor sed laoreet. Aenean ultricies, nisi sed vulputate
			malesuada, lacus nisi tempus velit, in lobortis felis elit vehicula
			lacus. Nulla condimentum tincidunt sem, a porta risus scelerisque
			viverra. Morbi id ligula ut urna maximus ornare ultricies ac tortor.
			Nunc non lectus at ligula mattis ultricies sed a enim. Nullam laoreet
			ornare viverra. Vivamus tempus iaculis hendrerit. In vitae congue
			turpis, congue fermentum arcu. Vivamus et rhoncus nisl. Donec
			facilisis ornare turpis, vitae egestas sapien varius a. Aliquam
			ultrices tincidunt velit eu accumsan. Praesent fringilla pretium
			quam, eu condimentum sem tincidunt et. Maecenas vel maximus ligula.
		</p>
	</div>
</body>
</html>