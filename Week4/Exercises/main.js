window.onload = function() {
	document.getElementById("para2").innerHTML = "ALTERED VIA EXTERNAL SCRIPT";
}

var count = 0;
function logit() {
	var localVarablie = "heya";
	count++;
	console.log("Log #" + count)
};

function addName() {
	var first = document.getElementById("first").value;
	var last = document.getElementById("last").value;

	var text1 = document.createTextNode(first);
	var text2 = document.createTextNode(last);

	var td1 = document.createElement('td');
	var td2 = document.createElement('td');

	var row = document.createElement('tr');

	td1.appendChild(text1);
	td2.appendChild(text2);

	row.appendChild(td1);
	row.appendChild(td2);

	document.getElementById("table").appendChild(row);

	document.getElementById("first").value = " ";
	document.getElementById("last").value = " ";

	/*
	 * DOM MANIPULATION METHODS document.createElement(tag)
	 * document.removeChild(element) document.appendChild(element)
	 * document.replaceChild(element) document.write("stuff")
	 * 
	 * element.innerHTML = "stuff" element.attribute = "stuff"
	 * element.setAtrribute("attribute","value") element.style.property =
	 * "stuff"
	 * 
	 * 
	 * SELECTION METHODS getElementById getElementsByTagName <----NOTE: PLURAL
	 * getElementsByClassName <----NOTE: PLURAL
	 * 
	 * Further navigation from current element(Node) parentNode childNodes[]
	 * firstChild lastChild nextSibling previousSibling
	 * 
	 */
};

function fizzBuzz() {
	   var min = parseInt(document.getElementById("min").value);
	    var max = parseInt(document.getElementById("max").value);
	    
	    if(min <= max){
	    	document.getElementById("bigmin").innerHTML="  ";
	        for(min; min<= max; min++){
	                if(min % 15 ==0){
	                    
	                    document.getElementById("bigmin").innerHTML+="FizzBuzz ";
	                    document.getElementById("bigmin").innerHTML+="<br>";
	                }
	                else if(min % 5 ==0){
	                
	                    document.getElementById("bigmin").innerHTML+="Buz";
	                    document.getElementById("bigmin").innerHTML+="<br>";
	                }
	                else if(min % 3 ==0){
	                    document.getElementById("bigmin").innerHTML+="Fizz";
	                    document.getElementById("bigmin").innerHTML+="<br>";
	                }
	                else{
	                    document.getElementById("bigmin").innerHTML+= min;
	                    document.getElementById("bigmin").innerHTML+="<br>";
	                }
	            }
	        }else if(min > max){
	            document.getElementById("bigmin").innerHTML +="Minimum Number must be smaller than maximum number";
	        }
}
