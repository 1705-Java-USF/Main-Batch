window.onload = function() {
	document.getElementById("para2").innerHTML = "ALTERED VIA EXTERNAL SCRIPT!";
};

var count = 0;
function logit() {
	var localVariable = "Heya";
	count++;
	console.log("Log #" + count)
};

function addName() {
	var first = document.getElementById("first").value;
	var last = document.getElementById("last").value;
	
	var text1 = document.createTextNode(first);	//firstname
	var text2 = document.createTextNode(last);	//lastname
	
	var td1 = document.createElement('td'); //<td></td>
	var td2 = document.createElement('td');	//<td></td>
	
	var row = document.createElement('tr'); //<tr></tr>
	
	td1.appendChild(text1);	//<td>firstname</td>
	td2.appendChild(text2);	//<td>lastname</td>
	
	row.appendChild(td1); //<tr><td>firstname</td></tr>
	row.appendChild(td2);	//<tr><td>firstname</td><td>lastname</td></tr>
	
	document.getElementById("table").appendChild(row);
	
	document.getElementById("first").value = "";
	document.getElementById("last").value = "";
}
	
	/*
	 * 
	 * DOM MANIPULATION METHODS
	 * document.createElement(tag)
	 * document.removeChild(element)
	 * document.appendChild(element)
	 * document.replaceChild(element)
	 * document.write("stuff")
	 * 
	 * element.innerHTML = "stuff"
	 * element.attribute = "stuff"
	 * element.setAttribute("attribute", "value")
	 * element.style.property = "stuff"
	 * 
	 * SELECTION METHODS
	 * getElementById
	 * get ElementsByTagName	<---NOTE: PLURAL
	 * getElementsByClassName	<---NOTE: PLURAL
	 * 
	 *  Further navigation from current element(Node)
	 *  parenNode
	 *  childNodes[]
	 *  firstChild
	 *  lastChild
	 *  nextSibling
	 *  previousSibling
	 */
	
	function fizzBuzz() {
		
		var min = document.getElementById("min").value;
		var max = document.getElementById("max").value;
		
		min = Number(min);
		max = Number(max);
		
		if(min <= max) {
		
			for(min; min <= max; min++) {
			
				if(min % 15 == 0) {
					document.getElementById("alert").innerHTML += "FizzBuzz";
					document.getElementById("alert").innerHTML += "<br>";
				}
				if(min % 3 == 0) {
					document.getElementById("alert").innerHTML += "Buzz";
					document.getElementById("alert").innerHTML += "<br>";
				}
				if(min % 5 == 0) {
					document.getElementById("alert").innerHTML += "Fizz";
					document.getElementById("alert").innerHTML += "<br>";
				}
				else {
					document.getElementById("alert").innerHTML += min;
					document.getElementById("alert").innerHTML += "<br>";
				}
			}
		}
		else if(min > max) {
			document.getElementById("alert").innerHTML = "Minimum range must be less than max range!<br>";
		}
}