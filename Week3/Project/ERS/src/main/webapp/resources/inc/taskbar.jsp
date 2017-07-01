<%@ page import="com.revature.pojos.*, com.revature.dao.*" %>
<%  
	User use = (User)session.getAttribute("user");
%>
<div id='start_menu' class='col-md-2' onload="toggledisplay('start_menu');">
	<div id="start_text" class="rotate90"><strong>Doors</strong><span style='color:white;'>95</span></div>
	<ul>
		<%
			if(use.getUr_id() == 2){
				out.println("<li><a href='management.jsp' class='col-md-12'><img src='resources/img/manage.png' style='height:35px;'></img>&nbsp;&nbsp;&nbsp;&nbsp;Management</a>");
			}
		%>
		<li><a href='reimbursements.jsp' class='col-md-12'><img src='resources/img/reimb.png' style='height:35px;'></img>&nbsp;&nbsp;&nbsp;&nbsp;Reimbursements</a>
		<li><a href='index.jsp' class='col-md-12'><img src='resources/img/user.png' style='height:35px;'></img>&nbsp;&nbsp;&nbsp;&nbsp;User Account</a>
		<li><a href='Logout.do' class='col-md-12'><img src='resources/img/key.png' style='height:35px;' class="rotate90"></img>&nbsp;&nbsp;&nbsp;&nbsp;Log Off</a>
	</ul>
</div>
<div id='taskbar'>
	<!--  <input type='submit' value='Start' id='start_button' class="taskbar_button" onclick="toggledisplay('start_menu');"> -->
	<button type='submit' id='start_button' class="taskbar_button" onclick="toggledisplay('start_menu');"><img src="resources/img/doors.png" height=25px></img>&nbsp;&nbsp;Start</button>
	
	<div id="task_time"><%= new java.util.Date().getHours() + ":" + new java.util.Date().getMinutes() %></div>
</div>