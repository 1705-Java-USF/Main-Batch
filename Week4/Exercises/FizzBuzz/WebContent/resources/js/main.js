function fizzbuzz() {
	while (document.getElementById("numbers").hasChildNodes()) {
		document.getElementById("numbers").removeChild(document.getElementById("numbers").lastChild);
	}
	var min = Number(document.getElementById("minimum").value);
	var max = Number(document.getElementById("maximum").value);

	if(min == "") {
		document.getElementById("numbers").appendChild(
				document.createTextNode("No minimum given, using 1"));
		document.getElementById("numbers").appendChild(document.createElement('br'));
		min = 1;
	}
	if(max == "") {
		document.getElementById("numbers").appendChild(
				document.createTextNode("No maximum given, using 100"));
		document.getElementById("numbers").appendChild(document.createElement('br'));
		max = 100;
	}
	if(!isNaN(min) && !isNaN(max)) {
		if(min > max) {
			document.getElementById("numbers").appendChild(
					document.createTextNode("Minimum is greater than Max, switching values"));
			document.getElementById("numbers").appendChild(document.createElement('br'));
			document.getElementById("minimum").value = max;
			document.getElementById("maximum").value = min;
			max = min;
			min = document.getElementById("minimum").value;
		}
		for(var i=Math.ceil(min); i <= max; i++) {
			if(i%3 == 0 && i%5 == 0)
				document.getElementById("numbers").appendChild(document.createTextNode("FizzBuzz"));
			else if(i%3 == 0)
				document.getElementById("numbers").appendChild(document.createTextNode("Fizz"));
			else if(i%5 == 0)
				document.getElementById("numbers").appendChild(document.createTextNode("Buzz"));
			else
				document.getElementById("numbers").appendChild(document.createTextNode(i));
			document.getElementById("numbers").appendChild(document.createElement('br'));
		}
	}
	else {
		if(isNaN(min) || min == null || min == undefined) {
			document.getElementById("numbers").appendChild(
					document.createTextNode("Error. Invalid input for minimum value."));
			document.getElementById("numbers").appendChild(document.createElement('br'));
		}
		if(isNaN(max) || max == null || max == undefined) {
			document.getElementById("numbers").appendChild(
					document.createTextNode("Error. Invalid input for maximum value."));
			document.getElementById("numbers").appendChild(document.createElement('br'));
		}
	}
}