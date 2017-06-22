function printTable() {
	var new_tb = document.createElement('tbody');
	new_tb.setAttribute('id','tbody');
	var x = Number(document.getElementById("min").value);
	var y = Number(document.getElementById("max").value);
	for (var i = x; i <= y; i++) {
		var text;
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var row = document.createElement('tr');
		if (i%3 == 0 && i%5 == 0) {
			// print 'FizzBuzz'
			text = 'FizzBuzz';
		} else if (i%3 == 0) {
			// print 'Fizz'
			text = 'Fizz';
		} else if (i%5 == 0) {
			// print 'Buzz'
			text = 'Buzz';
		} else {
			text = '---';
		}
		td1.appendChild(document.createTextNode(i));
		td2.appendChild(document.createTextNode(text));
		row.appendChild(td1);
		row.appendChild(td2);
		new_tb.appendChild(row);
	}
	var old = document.getElementById('tbody');
	document.getElementById('table').replaceChild(new_tb, old);
	document.getElementById("min").value = "";
	document.getElementById("max").value = "";
};