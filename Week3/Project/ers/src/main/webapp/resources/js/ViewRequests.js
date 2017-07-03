/**
 * 
 */
$(document).ready(function(){
	// add event Listeners on table rows
	$("#r-table tr").on("click",trClick);
});

function trClick()
{
	var tr = $(this);
	$("#rid span.value").html(tr.children(".r-rid").html());
	$("#amount span.value").html(tr.children(".r-amount").html());
	$("#descr span.value").html(tr.children(".r-descr").html());
	$("#author span.value").html(tr.children(".r-author").html());
	$("#sub-time span.value").html(tr.children(".r-sub-time").html());
	$("#res-time span.value").html(tr.children(".r-res-time").html());
	$("#resolver span.value").html(tr.children(".r-resolver").html());
	$("#status span.value").html(tr.children(".r-status").html());
	$("#type span.value").html(tr.children(".r-type").html());
	$("#v-req-box").removeClass("hide");
	$("#receipt .value").empty();
	var url = "GetReceipt.do";
	var param = {};
	param.rid = Number($("#rid .value").html());
	req = $.post(url, param, recieptCallback);
}
function recieptCallback()
{
	if(req.readyState == 4)
	{
		if(req.status == 200)
		{
			parseMessage(req.responseXML);
			function  parseMessage(xmlText)
			{
				var message = xmlText.getElementsByTagName("filename")[0].innerHTML;
				var image = $('<img></img>').attr({src:message});
				
				
				if(message != "null")
				{
					$("#receipt .value").append(image);
					$("#receipt .value img").css({width:"400px",height:"400px"});
				}
				
				
			}
		}
	}
}