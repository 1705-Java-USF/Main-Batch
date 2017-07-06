/*
	jQuery
		-lightweight javscript library that wraps around javascript.
		-"write less, do more"
		-Can be used to simple AJAX calls
		-The library contains features for HTML/DOM manipulation,
			CSS manipulation, effects and animation, AJAX, and other utilities.
		-jQuery can be used, by either downloading and importing the libary, OR
			use CDN to get it.

	-jQuery is a library that utilizes closures in order to make writing
		javascript easier.
	-Basic syntax is as such:
		$(selector).action;
		(NOTE: $ is shorthand for jQuery(selector).action;
*/

//Anything inside will wait for page to load.
$(document).ready(function(){
	
	
});
var fToggle = false;
//same thing but shorter!
$(function(){
	
});

function hideit(){
	$("#check").hide();
}

function showit(){
	$("#check").show();
}

function hideh3(){
	$("h3").hide();
}

function showh3(){
	$("h3").show();
}

$(function(){
	$("#hover").hover(changeToRed, changeToBlack);
	$("#cbackcall").click(fadeToFunc);
	$("#bye").click(genericFadeout);
	$("#hi").click(genericFadein);
	$("#toggle").click(toggleFade);
});

function genericFadeout(){
	$("#everything").fadeTo(500, 0);	
}
function genericFadein(){
	$("#everything").fadeTo(500, 1);
}
function toggleFade(){
	if(toggle = !toggle){
		$("#everything").fadeTo(500, 0);
	}else{
		$("#everything").fadeTo(500, 1);
	}
}

function changeToRed(){
	$(this).css("color","#ff0000");
	var x =5;
}
function changeToBlack(){
	$(this).css("color","#000000");
}

function cback(){
	document.write("SUCCESS");
}

function fadeToFunc(){
	$(this).fadeTo(1000,0).fadeTo(1000,1).fadeTo(1000,0).fadeTo(1000,1).fadeTo(5000, 0, cback);
}

/*
	SELECTOR OPTIONS:
	#ID
	.class
	this
	element
	p.classname <-all p tags of specific id
	p:first <- very first p tag
	ul li:first <- first list item of every ul
	[href] all elements with a href attribute
	p[color] all p's with a color attribute
	
	EVENTS
	mouse events:	click, dblclick, mouseenter, mouseleave
	keyboard:		keypress, keydown, keyup
	forms:			submit, change, focus, blur
	document/window:load, resize, scroll, unload
	
	shorthand for mouseenter/leave: hover(mouseenterfunction, mouseleavefunction)
	
	Animations
	fadeIn(speed, callback)
	fadeOut(speed, callback)
	fadeTo(speed, opacity, callback)
	slideDown(speed, callback)
	slideUp(speed, callback)
	slideToggle() <- reverse direction
	animate(commaSeparatedCSSChangeMethods, speed, callback)
		-css("Attribute")
		-css(prop, value)
		-css({prop1:value, prop2:value})
	
	Methods to grab contents:
	.text() <- returns the text content of an element
	.html() <- returns text including tags
	.val() <- returns the value of a field
	.attr("attribute name") <- obvious
	
	The above content methods, return the contents. (duh)
	In order to set contents, you pass in a parameter.
	
	eg. .text("stuff") sets the text of whatever element you are appended to "stuff"
	
	DOM Manipulation
	-For adding/deleting nodes/elements
	append()  //Place new elements directly before close tag of element
	prepend() //place new elements directly after the start tag of element
	after()   //Place new elements directly after the close tag of element
	before()  //place new elements directly before the start tag of element
	
	//Methods for creating elements:
	
	HTML METHOD	 #1 - var text1 = "<p>stuff</p>"
	JS Method	 #2 - var text2 = document.createElement("p").append(document.createTextNode("stuff"));
	jQuery Method#3 - var text3 = $("<p></p>").text("stuff");
	
	$("body").append(text1, text2, text3);
*/
	function generate(){
		var text1 = "<p>text1</p>";
		var text2 = document.createElement("p");//.appendChild(document.createTextNode("text2"));
		text2.innerHTML="text2";
		var text3 = $("<p></p>").text("text3");	
		
		//$("#body").append(text1, text2, text3);
		$("#body").before(text1,text2,text3);
	}

	$(function(){
		$("#generate").click(generate);
	})
	
	/*
		Other functions you SHOULD know
		
		remove() removes selected element (As well as all children)
		empty() removes child elements
		addClass(name) <- obvious
		removeClass()
		
		Traversal methods:
		
		parent()
		parents() <-incoudes grandparents, g.g.parents etc
		parentsUntil(element) <- grab all parents until reaching one type: parameter
		children() <- only direct children
		find() <- return all children of a specific type (NOTE: find(*) grabs all children
		
		Sibling navigation
		next() 
		nextAll()
		nextUntil()
		prev()
		prevAll()
		prevUntil()
		
		first() <- first child
		last() <- last child
		eq()  return specific element with an index number
		not() opposite
		
		
		NOTE: the dollar sign is reserved for jQuery in our use. However, they are NOT
		the only library to use it. Angular also uses $ to do actions.
		If you have both libraries these will compete. You can toggle off the $
		restriction that jQuery has by the following:
		
		$.noConflict();
		//After this, all jQuerys must be written as:
		jQuery(element).etc
		
	*/
	
	/*
	 * -This is a get request a la jQuery
	 * $.get("endpoint", functionForHandlingResults(retrievedData, statusOfData){
	 * 		
	 * }
	 * 
	 * 
	 */
	
$(function(){
	$("#submitid").click(function(){
		var loading = "http://www.cuisson.co.uk/templates/cuisson/supersize/slideshow/img/progress.BAK-FOURTH.gif";
		var input = $("#pkmnid").val();
		var queryString = "http://pokeapi.co/api/v2/pokemon/" + input + "/";
		$("#myNewTable").remove();
		$("#pokediv").append("<img id='loading' src='" + loading + "'/>");
		$.get(queryString, function(data, status){
			console.log(status);
			if(status=="success"){
				var x = data;
				var table1 = "<table border=2 id='myNewTable'></table>";
				$("#loading").remove();
				$("#pokediv").append(table1);
				$("#myNewTable").append("<tr><td>Name</td><td>" + x.name + "</td></tr>");
				$("#myNewTable").append("<tr><td>Weight</td><td>" + x.weight + "</td></tr>");
				$("#myNewTable").append("<tr><td>ID</td><td>" + x.id + "</td></tr>");
				$("#myNewTable").append("<tr><td>Sprite</td><td><img src='" + x.sprites.front_default + "'/></td></tr>");
			}else{
				$("#loading").remove();
				$("#pokediv").append(table1);
				$("#myNewTable").append("<tr><td>STATUS</td><td>" + status + "</td></tr>");

			}
		})
	})
})