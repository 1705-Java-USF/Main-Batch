window.onload = function() {
	document.getElementById("para2").innerHTML = "Stuff";
};

var count = 0;
function logIt() {
	count++;
	console.log("Log # " + count);
}

function addName() {
	var first = document.getElementById("first").value;
	var last = document.getElementById("last").value;
	
	var text1 = document.createTextNode(first); // firstname
	var text2 = document.createTextNode(last);  // lastname
	
	var td1 = document.createElement('td');  // <td></td>
	var td2 = document.createElement('td');	 // <td></td>
	
	td1.setAttribute("style","border:2px dashed #f99;background-color:#4f4;color:#330;");
	td2.setAttribute("style","border:2px dotted #a0c;background:linear-gradient(to right, red,yellow);");
	
	var row = document.createElement('tr');	// <tr></tr>
	
	td1.appendChild(text1);		// <td>firstname</td>
	td2.appendChild(text2);		// <td>lastname</td>
	
	row.appendChild(td1);	// <tr><td>firstname</td></tr>
	row.appendChild(td2);	// <tr><td>firstname</td><td>lastname</td></tr>
	
	document.getElementById("table").appendChild(row);
	
	document.getElementById("first").value = "";
	document.getElementById("last").value = "";
	
	/*
	 * DOM Manipulation Methods
	 * document.createElement(tag)
	 * document.removeChild(tag)
	 * document.appendChild(tag)
	 * document.replaceChild(tag)
	 * document.write("stuff")
	 * 
	 * element.innerHTML = "stuff"
	 * element.attribute = "stuff"
	 * element.setAttribute("attribute value")
	 * element.style."property" = "stuff"
	 * 
	 * Selection Methods
	 * getElementById
	 * getElementsByTagName
	 * getElementsByClassName
	 * 
	 * Further navigation from current element
	 * parentNode
	 * childNodes[]
	 * firstChild
	 * lastChild
	 * nextSibling
	 * previousSibling
	 */
	
}