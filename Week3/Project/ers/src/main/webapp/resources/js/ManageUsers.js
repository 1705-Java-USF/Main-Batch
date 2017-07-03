/**
 * 
 */

$(document).ready(function(){
	$("#user-container .user-table tr.u-row").click(trclick);
	$("#promote").click(promoteUser);
});

function trclick()
{
	var id = $(this).attr("id");
	id = "#" + id;
	
	var uid = $(id + " .u-id").html();
	var username = $(id + " .u-username").html();
	var email = $(id + " .u-email").html();
	var fname = $(id + " .u-fname").html();
	var lname = $(id + " .u-lname").html();
	var role = $(id + " .u-role").html();
	
	$("#id .value").html(uid);
	$("#username .value").html(username);
	$("#email .value").html(email);
	$("#fname .value").html(fname);
	$("#lname .value").html(lname);
	$("#role .value").html(role);
	$("#s-user").removeClass("hide");
}
function promoteUser()
{
	var id = Number($("#id .value").html());
	var url = "PromoteUser.do";
	var param ={};
	param.uid = id;
	req = $.post(url, param, promoteCallback);
}

function promoteCallback()
{
	if(req.readyState == 4)
	{
		if(req.status == 200)
		{
			var message = req.responseXML.getElementsByTagName("message")[0].innerHTML;
			$(".message").html(message).show();
		}
	}
}