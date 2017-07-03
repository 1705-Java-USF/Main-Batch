/**
 * 
 */

$(function(){
	if($.trim($("#dashboard").html()))
	{
		$("#nav-dash-link").addClass("active");
	}else if($.trim($("#create-req").html()))
	{
		$("#nav-createreq-link").addClass("active");
	}else if($.trim($("#view-req").html()))
	{
		$("#nav-viewreq-link").addClass("active");
	}else if($.trim($("#profile").html()))
	{
		$("#nav-profile-link").addClass("active");
	}else if($.trim($("#manage-req").html()))
	{
		$("#nav-manreq-link").addClass("active");
	}else if($.trim($("#create-user").html()))
	{
		$("#nav-createuser-link").addClass("active");
	}else if($.trim($("#manage-user").html()))
	{
		$("#nav-manageuser-link").addClass("active");
	}	
	
	if(!$(".message").html().trim())
	{
		$(".message").hide();
	}
	
});