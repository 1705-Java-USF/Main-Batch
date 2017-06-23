function printTable() {
	var new_tb = $("<tbody id="tbody"></tbody>");
	var x = Number($("min").val());
	var y = Number($("max").val());
	for (var i = x; i <= y; i++) {
		var td1 = $("<td></td>");
		var td2 = $("<td></td>");
		var row = $("<tr></tr>");
		if (i%3 == 0 && i%5 == 0) {
			// print 'FizzBuzz'
			td2.text('FizzBuzz');
		} else if (i%3 == 0) {
			// print 'Fizz'
			td2.text('Fizz');
		} else if (i%5 == 0) {
			// print 'Buzz'
			td2.text('Buzz');
		} else {
			td2.text('---');
		}
		td1.val(i);
		row.append(td1);
		row.append(td2);
		new_tb.append(row);
	}
	var old = $('tbody');
	$('table').replace(new_tb, old);
	$("min").val("");
	$("max").val("");
};