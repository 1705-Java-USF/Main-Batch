function fizzbuzz()
{
	var x = document.getElementById("first").value;
	var y = document.getElementById("last").value;
	
	var min = Math.min(x, y);
	var max = Math.max(x, y);
	var out = "";
	
	for(let i=min; i<=max; i++)
	{
		if(i%3!=0 && i%5!=0)
		{
			out += i;
		} else
		{
			if(i%3==0)
			{
				out+="fizz";
			}
			if(i%5==0)
			{
				out+="buzz";
			}
		}
		out+="<br>";
	}
	document.write(out);
}