/**
 * 
 */

function retrieve(){
	var idField = document.getElementById("EID");
	var url = "EmployeeLookup?eid=" + idField.value;
	
	if(typeof XMLHttpRequest != "undefined") {
		req = new XMLHttpRequest();
	}else if(window.ActiveXObject){ //For browsers that dont support XMLHttpRequest
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//Make a call to the server
	//Use open(HttpMethod, endpoint, useAsynchronous)
	req.open("GET", url, true);
	req.onreadystatechange = callback;
	req.send(null);
	/*
	 * There exists 5 states for an AJAX request:
	 * 0 - Request is not initialized
	 * 		-We created our XMLHttpRequest object, but have NOT called open()
	 * 1 - Request has been set up
	 * 		-We have called open(), but not send()
	 * 2 - Request has been sent
	 * 		-we have called send()
	 * 3 - Request is in process
	 * 		-Communication with server has been established, but response not sent yet
	 * 4 - Request has completed
	 * 		-Request completed, response received
	 * 
	 * There are also status
	 * -404, 200, etc
	 */
}

function callback(){
	if(req.readyState == 4){
		if(req.status == 200){
			parseMessage(req.responseXML);
			
			function parseMessage(xmlText){
				var table = document.getElementById("endTable");
				
				
				
				var message = xmlText.getElementsByTagName("employee")[0];
				
				//[0]=id, [1]=first name [2]= last name
				var table = document.createElement("tr");
				var text1 = document.createTextNode(message.childNodes[0].innerHTML);
				var text2 = document.createTextNode(message.childNodes[1].innerHTML);
				var text3 = document.createTextNode(message.childNodes[2].innerHTML);

				var tdata = document.createElement("td");
				tdata.appendChild(text1);
				table.appendChild(tdata);
				tdata = document.createElement("td");
				tdata.appendChild(text2);
				table.appendChild(tdata);
				tdata = document.createElement("td");
				tdata.appendChild(text3);
				table.appendChild(tdata);
				
				document.getElementById("endTable").append(table);
			}
			
		}
	}
}