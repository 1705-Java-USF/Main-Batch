function fizzbuzz() {
	var first = Number(document.getElementById("first").value);
	var last = Number(document.getElementById("last").value);
	
	document.getElementById("output").innerHTML = "";
	
	for(let i = first; i < last; i++) {
		if(i % 3 == 0 && i % 5 == 0) {
			document.getElementById("output").innerHTML += "FizzBuzz<br />";
		} else if(i % 3 == 0) {
			document.getElementById("output").innerHTML += "Fizz<br />";
		} else if(i % 5 == 0) {
			document.getElementById("output").innerHTML += "Buzz<br />";
		} else {
			document.getElementById("output").innerHTML += i + "<br />";
		}
	}
	
	if(first > last) {
		document.getElementById("output").innerHTML = "First number must be less than the second number.";
	}
}

function changeColor() {
	document.getElementById("output").style.color = document.getElementById("color").value;
}