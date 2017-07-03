$(document).ready(function(){
	
	
});

function resolve(id)
{
	if (confirm("Accept this reimbursement?") == true) 
	{
	    window.open("opprove.do?reinId="+id,"_self");
	} 
}

function promote(id)
{
	console.log("promote: "+ id);
	if (confirm("Are you sure you want to promote this Morty?") == true) 
	{
	    window.open("promote.do?promoteId="+id,"_self");
	} 
}

function expandImg(imgName)
{
	html = '<img src="';
	html += imgName;
	html += '">';
	window.alert(html);
}



