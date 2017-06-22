function fizzbuzz() {
	
	var min = parseInt(document.getElementById("min").value);
	var max = parseInt(document.getElementById("max").value);
	
	if (max <= min) {
		document.getElementById("answer").innerHTML = "<p>Uh oh, Spaghettios!</p>";
		document.getElementById("answer").innerHTML += "<p>Make sure your maximum number is bigger than your minimum number!</p>";
	} else {
	
		document.getElementById("answer").innerHTML = "<p>"
	
		for (i = min; i <= max; i++) {
			num = true;
			if (i % 3 == 0) {
				num = false;
				document.getElementById("answer").innerHTML += "fizz";
			}
			if (i % 5 == 0) {
				num = false;
				document.getElementById("answer").innerHTML += "buzz";
			}
		
			if (num) {
				document.getElementById("answer").innerHTML += i;
			}
		
			document.getElementById("answer").innerHTML += " ";
		}
	
	}
	
}