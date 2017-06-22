window.onload = function(){
	
	
	document.getElementById("para2").innerHTML = "altered via external scrip tag";
};

var count = 0;
function logit()
{
	var lacalVar = "yoyo";
	
	count++;
	
	console.log("log: " + count);
}

function sum(x, y)
{
	if(y)
	{
		return (x + y);
	}
	return function(z)
	{
		return (x + z);
	}
	
}

var counter = (function() {
    var privateCounter = 0;
    function changeBy(val) {
        privateCounter += val;
   }
    return {
        increment: function() {
            changeBy(1);
       },
        decrement: function() {
            changeBy(-1);
       },
        value: function() {
            return privateCounter;
       },
        reset: function() {
            privateCounter = 0;
       }
   };
})();

function addname()
{
	var first = document.getElementById("first").value;
	var last = document.getElementById("last").value;
	
	var text1 = document.createTextNode(first);//fistname
	var text2 = document.createTextNode(last);//lastname
	
	var td1 = document.createElement('td');//td
	var td2 = document.createElement('td');//td
	
	var row = document.createElement('tr');//tr
	
	td1.appendChild(text1);
	td2.appendChild(text2);
	
	row.appendChild(td1);
	row.appendChild(td2);
	
	document.getElementById("table").appendChild(row);
}

/*
 * dom manipulation
 * document.createElement(tag);
 * document.removeChild(element);
 * document.appendChild(element);
 * document.replaceChild(element);
 * document.write("stuff");
 * 
 * element.innerHTML = "stuff";
 * element.attribute = "stuff";
 * element.setAttribute("attribute","value");
 * element.style.property = "stuff";
 * 
 * Selection methods
 * getelEmentbyId
 * getElementsByTagName   <- singular
 * getElementsByClassName <- plural
 * 
 * Further navigation
 * parentNode
 * childNodes[]
 * lastChild
 * nextSibling
 * previousSibling
 * 
 * 
 * Page with:
 * - minimum range
 * - max range
 * - FizzFuzz button
 * 
 * FizzFuzz
 * - print numbers from min to max
 * - if number is divisible by 3 print 'fizz'
 * - if number is divisible by 5 print 'buzz'
 * - if number is divisible by 3 & 5 print 'fizzbuzz'
 */




