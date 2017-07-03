$(function() {
   $("li").click(function() {
      $("li").removeClass("active");
      $(this).addClass("active");
   });
});

function includeHomeE() {
	$(".space").load('EmployeeHome.jsp');
}

function includeViewPE() {
	$(".space").load('ViewEmployPending.html');
	var receipt = "<span class=\"glyphicon glyphicon-picture\" onclick=\"showImage()\"></span>";
	var queryString = "http://localhost:8085/ERSproject/EmployPendingServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$.each(data, function(index, reimburse) {
	            $("<tr>").appendTo("table")        
	                .append($("<td>").text(reimburse.r_id))
	                .append($("<td>").text(reimburse.amount))
	                .append($("<td>").text(reimburse.type))
	                .append($("<td>").append( receipt ))
	                .append($("<td>").text(reimburse.report))
	                .append($("<td>").text(reimburse.submitted))
	                .append($("<td>").text(reimburse.status));
	        });
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function includeViewRE() {
	$(".space").load('EmployResolvedView.html');
	var receipt = "<span class=\"glyphicon glyphicon-picture\" onclick=\"showImage()\"></span>";
	var queryString = "http://localhost:8085/ERSproject/EmployResolvedServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$.each(data, function(index, reimburse) {
	            $("<tr>").appendTo("table")        
	                .append($("<td>").text(reimburse.r_id))
	                .append($("<td>").text(reimburse.amount))
	                .append($("<td>").text(reimburse.type))
	                .append($("<td>").append( receipt ))
	                .append($("<td>").text(reimburse.report))
	                .append($("<td>").text(reimburse.submitted))
	                .append($("<td>").text(reimburse.status))
	                .append($("<td>").text(reimburse.resolved))
	                .append($("<td>").text(reimburse.resolved_by));
	        });
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function showImage() {
	var imageWindow = window.open("", "", "width=800, height=500");
	imageWindow.document.write('<title>Parking Receipt</title>');
	imageWindow.document.write('<img style="width:750" alt=ALTERNATIVE src="resources/images/parking_receipt.jpg">');
}

function includeSubmitR() {
	$(".space").load('ReimbursementSubmit.html');
}

function submitReimbursement() {
	event.preventDefault();
	var queryString = "http://localhost:8085/ERSproject/SubmitReimburseServlet";
	var formData = $("#ReimburseForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status=="success"){
			includeViewPE();
			$("#submit").removeClass("active");
		    $("#p_view").addClass("active");
		} else {
			document.alert("INVALID REQUEST");
		} 
	}); 
}

function includeAccount() {
	$(".space").load('AccountView.html');
	var queryString = "http://localhost:8085/ERSproject/EmployAccountServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$("#eid").val(data.employee_id);
			$("#username").val(data.username);
			$("#pwd").val(data.password);
			$("#fname").val(data.firstname);
			$("#lname").val(data.lastname);
			$("#email").val(data.email);
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function updateAccount() {
	event.preventDefault();
	var queryString = "http://localhost:8085/ERSproject/UpdateAccountServlet";
	var formData = $("#AccountForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status=="success"){
			includeAccount();
		} else {
			document.alert("INVALID REQUEST");
		} 
	});
}

function includeHomeM() {
	$(".space").load('HomePage.jsp');
}

function includeViewPM() {
	$(".space").load('AllPendingView.html');
	var receipt = "<span class=\"glyphicon glyphicon-picture\" onclick=\"showImage()\"></span>";
	var queryString = "http://localhost:8085/ERSproject/AllPendingServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$.each(data, function(index, reimburse) {
				$("<tr>").appendTo("table")        
	                .append($("<td>").text(reimburse.r_id))
	                .append($("<td>").text(reimburse.amount))
	                .append($("<td>").text(reimburse.type))
	                .append($("<td>").append(receipt))
	                .append($("<td>").text(reimburse.report))
	                .append($("<td>").text(reimburse.author))
	                .append($("<td>").text(reimburse.submitted))
	                .append($("<td>").text(reimburse.status))
	                .append($("<td>").append( $("<button>").attr("type", "button").attr("class", "btn btn-primary")
	                		.attr("onclick", "resolveView("+reimburse.r_id+")").text("Resolve") ));
	        });
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function resolveView(r_id) {
	$(".space").load('ResolveRequestView.html');
	var queryString = "http://localhost:8085/ERSproject/GetRequestServlet?r_id=" + r_id;
	$.get(queryString, function(data, status){
		if(status=="success"){
			$("#rid").val(data.r_id);
			$("#amount").val(data.amount);
			$("#type").val(data.type);
			$("#report").val(data.report);
			$("#submitted").val(data.submitted);
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function resolveRequest() {
	event.preventDefault();
	var r_id = $("#rid").val();
	var queryString = "http://localhost:8085/ERSproject/ResolveRequestServlet?rid=" + r_id;
	var formData = $("#ResolveForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status=="success"){
			includeViewRM();
			$("#p_view").removeClass("active");
		    $("#r_view").addClass("active");
		} else {
			document.alert("INVALID REQUEST");
		} 
	});
}

function includeViewRM() {
	$(".space").load('AllResolvedView.html');
	var receipt = "<span class=\"glyphicon glyphicon-picture\" onclick=\"showImage()\"></span>";
	var queryString = "http://localhost:8085/ERSproject/AllResolvedServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$.each(data, function(index, reimburse) {
	            $("<tr>").appendTo("table")        
	                .append($("<td>").text(reimburse.r_id))
	                .append($("<td>").text(reimburse.amount))
	                .append($("<td>").text(reimburse.type))
	                .append($("<td>").append(receipt))
	                .append($("<td>").text(reimburse.report))
	                .append($("<td>").text(reimburse.author))
	                .append($("<td>").text(reimburse.submitted))
	                .append($("<td>").text(reimburse.status))
	                .append($("<td>").text(reimburse.resolved))
	                .append($("<td>").text(reimburse.resolved_by));
	        });
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function includeViewEmploys() {
	$(".space").load('ViewAllEmploys.html');
	var queryString = "http://localhost:8085/ERSproject/ViewEmployServlet";
	$.get(queryString, function(data, status){
		if(status=="success"){
			$.each(data, function(index, employee) {
	            $("<tr>").appendTo("table")        
	                .append($("<td>").text(employee.employee_id))
	                .append($("<td>").text(employee.username))
	                .append($("<td>").text(employee.firstname))
	                .append($("<td>").text(employee.lastname))
	                .append($("<td>").text(employee.email))
	                .append($("<td>").append( $("<button>").attr("type", "button").attr("class", "btn btn-info")
            		.attr("onclick", "employeeRequests("+employee.employee_id+")").text("View Requests") ))
            		.append($("<td>").append( $("<button>").attr("type", "button").attr("class", "btn btn-primary")
            		.attr("onclick", "promote("+employee.employee_id+")").text("Promote To Manager") ));
	        });
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function employeeRequests(e_id) {
	$(".space").load('EmployeeRequests.html');
	var receipt = "<span class=\"glyphicon glyphicon-picture\" onclick=\"showImage()\"></span>";
	var queryString = "http://localhost:8085/ERSproject/EmployRequestServlet?eid=" + e_id;
	$.get(queryString, function(data, status){
		if(status=="success"){
			var author = "";
			$.each(data, function(index, reimburse) {
				author = reimburse.author;
	            $("<tr>").appendTo("table")        
	                .append($("<td>").text(reimburse.r_id))
	                .append($("<td>").text(reimburse.amount))
	                .append($("<td>").text(reimburse.type))
	                .append($("<td>").append(receipt))
	                .append($("<td>").text(reimburse.report))
	                .append($("<td>").text(reimburse.submitted))
	                .append($("<td>").text(reimburse.status))
	                .append($("<td>").text(reimburse.resolved))
	                .append($("<td>").text(reimburse.resolved_by));
	        });
			$(".requesttitle").text("ALL REQUESTS SENT BY EMPLOYEE ID: " + author);
		} else {
			document.alert("INVALID REQUEST");
		}
	});
}

function promote(e_id) {
	if (confirm('Are you sure you want to promote '+ e_id + ' to Manager?')) {
		event.preventDefault();
		var queryString = "http://localhost:8085/ERSproject/PromoteServlet?eid=" + e_id;
		$.get(queryString, function(data, status){
			if(status=="success"){
				includeViewEmploys();
			} else {
				document.alert("INVALID REQUEST");
			} 
		});
    } 
}

function includeRegisterEmploys() {
	$(".space").load('RegisterEmployee.html');
}

function registerEmployee() {
	event.preventDefault();
	var queryString = "http://localhost:8085/ERSproject/CreateEmployeeServlet";
	var formData = $("#RegisterForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status=="success"){
			includeViewEmploys();
			$("#register").removeClass("active");
		    $("#e_view").addClass("active");
		} else {
			document.alert("INVALID REQUEST");
		} 
	});
}
