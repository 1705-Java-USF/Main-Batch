function fizzbuzz()
{
	var min = document.getElementById("min").value;
	var max = document.getElementById("max").value;
	
	var result = [];
	var index = 0;
	
	for(var i = min; i <= max; i++)
	{
		if(((i % 3) == 0) && ((i % 5) == 0))
		{
			result[index] = "FizzBuzz";
			console.log("FizzBuzz");
		}
		else if((i % 3) == 0)
		{
			result[index] = "Fizz";
			console.log("Fizz");
		}
		else if((i % 5) == 0)
		{
			result[index] = "Buzz";
			console.log("Buzz");
		}
		else
		{
			result[index] = i;
			console.log(i + " ");
		}
		
		index++;
	}
	document.getElementById("result").innerHTML = result;
	
}