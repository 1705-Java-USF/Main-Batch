$(function() {
	var url = "ContributorLookup";
	
	if(typeof XMLHttpRequest != "undefined") {
		req = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	req.open("GET", url, true);
	req.onreadystatechange = callback;
	req.send(null);
	
	// On select dropdown list change.
	$("select").on("change", function() {
		var userFilter = document.getElementById("contributorsSelect");
		if(userFilter[userFilter.selectedIndex].value == "All") {
			var url = "ContributorLookup";
		} else {
			var url = "ContributorLookup?userFilter=" + userFilter[userFilter.selectedIndex].value;
		}
		if(typeof XMLHttpRequest != "undefined") {
			req = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		req.open("GET", url, true);
		
		if(userFilter[userFilter.selectedIndex].value == "All") {
			req.onreadystatechange = callback;
		} else {
			req.onreadystatechange = callback2;
		}
		req.send(null);
	});
});

function callback() {
	
	if(req.readyState == 4) {
		if(req.status == 200) {
			parseMessage(req.responseXML);
			
			function parseMessage(xmlText) {
				var contributor = xmlText.getElementsByTagName("contributor");
				
				$("#contributorsSelect").find("option").remove();
				
				$("#view-c-table thead").remove();
				$("#view-c-table tbody").remove();
				
				var thead = $("<thead></thead>");
				var rowH = $("<tr></tr>");
				rowH.append($("<th></th>").text("Username"));
				rowH.append($("<th></th>").text("First Name"));
				rowH.append($("<th></th>").text("Last Name"));
				rowH.append($("<th></th>").text("Email"));
				rowH.append($("<th></th>").text("Role"));
				rowH.append($("<th></th>").text("Promote/Demote"));
				thead.append(rowH);
				
				var tbody = $("<tbody></tbody>");
				var row = $("<tr></tr>");
				
				var options = $("#contributorsSelect");
				options.append($("<option />").val("All").text("--"));
				
				for(let i = 0; i < contributor.length; i++) {
					row.append($("<td></td>").text(contributor[i].childNodes[0].innerHTML));
					row.append($("<td></td>").text(contributor[i].childNodes[1].innerHTML));
					row.append($("<td></td>").text(contributor[i].childNodes[2].innerHTML));
					row.append($("<td></td>").text(contributor[i].childNodes[3].innerHTML));
					row.append($("<td></td>").text(contributor[i].childNodes[4].innerHTML));
					row.append($("<td></td>").html('<button class="btn btn-default btn-promotedemote" type="button">Promote/Demote</button>'));
					tbody.append(row);
					row = $("<tr></tr>");
					
					options.append($("<option />").val(contributor[i].childNodes[0].innerHTML).text(contributor[i].childNodes[0].innerHTML));
				}
				
				$("#view-c-table").append(thead);
				$("#view-c-table").append(tbody);
				
				buttonEvent();
			}
		}
	}
}

function buttonEvent() {
	$("button.btn-promotedemote").click(function(){
		var role_inner = $(this).parent().parent().children().siblings()[4].innerHTML;
    	var username_inner = $(this).parent().parent().children().siblings()[0].innerHTML;
    	
    	var url = "ChangeRoleButton?username=" + username_inner + "&curRole=" + role_inner;
    	
    	if(typeof XMLHttpRequest != "undefined") {
    		req = new XMLHttpRequest();
    	} else if(window.ActiveXObject) {
    		req = new ActiveXObject("Microsoft.XMLHTTP");
    	}
    	
    	req.open("GET", url, true);
    	req.onreadystatechange = callback;
    	req.send(null);
    } );
}

function callback2() {
	
	if(req.readyState == 4) {
		if(req.status == 200) {
			parseMessage(req.responseXML);
			
			function parseMessage(xmlText) {
				var reimbursement = xmlText.getElementsByTagName("reimbursement");
				
				$("#view-c-table thead").remove();
				$("#view-c-table tbody").remove();
				
				var thead = $("<thead></thead>");
				var rowH = $("<tr></tr>");
				rowH.append($("<th></th>").text("ID"));
				rowH.append($("<th></th>").text("Amount"));
				rowH.append($("<th></th>").text("Author"));
				rowH.append($("<th></th>").text("Description"));
				rowH.append($("<th></th>").text("Date Submitted"));
				rowH.append($("<th></th>").text("Type"));
				rowH.append($("<th></th>").text("Receipt"));
				rowH.append($("<th></th>").text("Status"));
				rowH.append($("<th></th>").text("Resolver"));
				rowH.append($("<th></th>").text("DateResolved"));
				thead.append(rowH);
				
				var tbody = $("<tbody></tbody>");
				var row = $("<tr></tr>");
				
				for(let i = 0; i < reimbursement.length; i++) {
					row.append($("<td></td>").text(reimbursement[i].childNodes[0].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[1].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[2].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[3].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[4].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[5].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[6].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[7].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[8].innerHTML));
					row.append($("<td></td>").text(reimbursement[i].childNodes[9].innerHTML));
					tbody.append(row);
					row = $("<tr></tr>");
				}
				
				$("#view-c-table").append(thead);
				$("#view-c-table").append(tbody);
			}
		}
	}
}