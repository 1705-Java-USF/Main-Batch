/**
 * 
 */

$(document).ready(function(){
	$("#pending").click(getRequestButtonClicked);
	$("#resolved").click(getRequestButtonClicked);
	$("#approve").click(updateRequest);
	$("#reject").click(updateRequest);
});

function getRequestButtonClicked()
{
	var type = $(this).attr("id");
	var param = {};
	param.type = type;
	var url = "ManageRequests.do";
	req = $.post(url, param, receiptCallback);
	
}

function receiptCallback()
{
	if(req.readyState == 4)
	{
		if(req.status == 200)
		{
			parseMessage(req.responseXML);
			
			
		}
		
	}
}
function parseMessage(xmlText)
{
	var table = $('<table></table>');
	var headerRow = $("<tr></tr>");
	headerRow.append($("<th></th").html("Request Id"));
	headerRow.append($("<th></th").html("Amount"));
	headerRow.append($("<th></th").html("Description"));
	headerRow.append($("<th></th").html("Author"));
	headerRow.append($("<th></th").html("Submitted Time"));
	headerRow.append($("<th></th").html("Resolved Time"));
	headerRow.append($("<th></th").html("Resolver"));
	headerRow.append($("<th></th").html("Status"));
	headerRow.append($("<th></th").html("Type"));
	table.append(headerRow);
	var rems = xmlText.getElementsByTagName("reimbursement");
	var row;
	var td;
	for(let i = 0; i < rems.length; i++)
	{
		row = $('<tr></tr>');
		td = $('<td></td>');
		var id = rems[i].getElementsByTagName("id")[0].innerHTML;
		var amount = rems[i].getElementsByTagName("amount")[0].innerHTML;
		var description = rems[i].getElementsByTagName("description")[0].innerHTML;
		var author = rems[i].getElementsByTagName("author")[0].innerHTML;
		var subtime = rems[i].getElementsByTagName("subtime")[0].innerHTML;
		var restime = rems[i].getElementsByTagName("restime")[0].innerHTML;
		var resolver = rems[i].getElementsByTagName("resolver")[0].innerHTML;
		var status = rems[i].getElementsByTagName("status")[0].innerHTML;
		var type = rems[i].getElementsByTagName("type")[0].innerHTML;
		td.html(id);
		td.attr("class", "r-rid");
		row.append(td);
		td = $('<td></td>').html(amount);
		td.attr("class", "r-amount");
		row.append(td);
		td = $('<td></td>').html(description);
		td.attr("class", "r-descr");
		row.append(td);
		td = $('<td></td>').html(author);
		td.attr("class", "r-author");
		row.append(td);
		td = $('<td></td>').html(subtime);
		td.attr("class", "r-sub-time");
		row.append(td);
		td = $('<td></td>').html(restime);
		td.attr("class", "r-res-time");
		row.append(td);
		td = $('<td></td>').html(resolver);
		td.attr("class", "r-resolver");
		row.append(td);
		td = $('<td></td>').html(status);
		td.attr("class", "r-status");
		row.append(td);
		td = $('<td></td>').html(type);
		td.attr("class", "r-type");
		row.append(td);
		row.attr("class", "r-row" + (i + 1));
		table.append(row);
		
	}
	$("#request-container").empty();
	$("#request-container").append(table);
	$("#request-container table").attr("id", "r-table");
	$("#r-table tr").on("click",trClick);
	
}

function updateRequest()
{
	var status = $(this).attr("id");
	var id = Number($("#rid .value").html());
	var url = "UpdateRequest.do";
	var param = {};
	param.status = status;
	param.rid = id;
	ureq = $.post(url, param, updateCallback);
}

function updateCallback()
{
	if(ureq.readyState == 4)
	{
		if(ureq.status == 200)
		{
			message = ureq.responseXML;
			message = message.getElementsByTagName("message")[0].innerHTML;
			$(".message").html(message).show();
		}
	}
	
}
