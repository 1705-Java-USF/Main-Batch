/**
 * 
 */
function printFizzBuzz()
{
	var min = document.getElementById("min").value;
	var max = document.getElementById("max").value;
	
	min = Number(min);
	max = Number(max);
	if (min > max)
	{
		let a = min;
		min = max;
		max = a;
	}
	var totalStr = "";
	for(let i = min; i <= max; i++)
	{
		var str;
		if(i%5 == 0 && i%3 == 0)
		{
			str = "FizzBuzz";
		}else if(i%5 == 0)
		{
			str = "Buzz";
		}else if(i%3 == 0)
		{
			str = "Fizz";
		}else
		{
			str = "" + i;
		}
		totalStr += " " + str + ",";
	}
	changeFontSize();
	changeColor();
	document.getElementById("printFizzBuzz").innerHTML = totalStr;
	
	
}
function changeFontSize()
{
	var font = document.getElementById("fontSize").value;
	if(font <= 0)
	{
		font = 12;
	}
	document.getElementById("printFizzBuzz").style.fontSize = font + "pt";
}
function changeColor()
{
	var color = document.getElementById("color").value;
	document.getElementById("printFizzBuzz").style.color = color;
}
