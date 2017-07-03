$(function() {
	setupAndSendCall()
	
	$("select").on("change", function() {
		  setupAndSendCall();
	});
});

function setupAndSendCall() {
	var statusFilter = document.getElementById("statusFilter");
	var url = "ReimbursementLookup?statusFilter=" + statusFilter[statusFilter.selectedIndex].value;
	
	if(typeof XMLHttpRequest != "undefined") {
		req = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	req.open("GET", url, true);
	req.onreadystatechange = callback;
	req.send(null);
}

function callback() {
	
	if(req.readyState == 4) {
		if(req.status == 200) {
			parseMessage(req.responseXML);
			
			function parseMessage(xmlText) {
				var reimbursement = xmlText.getElementsByTagName("reimbursement");
				
				$("#contributorTable tbody").remove();
				
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
				
				$("#contributorTable").append(tbody);
				

			}
		}
	}
}