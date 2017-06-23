function addName(){
	var last = document.getElementById("last").value;
	
	var text2 = document.createTextNode(FizzBuzz());
	
	var td2 = document.createElement('td');	
	
	var row = document.createElement('tr');

	td2.appendChild(text2);
	
	row.appendChild(td2);	
	
	document.getElementById("table").appendChild(row);
	
	document.getElementById("first").value = "";
	
	document.getElementById("last").value = "";
}
function FizzBuzz(){
	if(isNaN(document.getElementById("first").value) == false){
		if(isNaN(document.getElementById("last").value) == false){
			
			var minimum = document.getElementById("first").value;
			var maximum = document.getElementById("last").value;
			var result = "";
			var compare1 = parseInt(minimum);
			var compare2 = parseInt(maximum);
			
			if(compare1 < compare2){
				for(z = minimum; z <= parseInt(maximum); z++){
					if(z%3==0){
						result += "Fizz";
						if(z%5==0){
							result += "Buzz";
						}
					}
					else if(z%5==0){
						result += "Buzz";
					}
					else{
						result += z;
					}
					result += " ";
				}		
					return result;
			}else{
				return "Invalid Input!!!!";
			}
	
		}
	}
	return "Invalid Input!!!!";
}

