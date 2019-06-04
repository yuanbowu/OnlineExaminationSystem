$(function(){
	$("#quertionContent").blur(function(){
		var myDate = new Date();
		var mytime=myDate.toLocaleTimeString();     //获取当前时间
		var timeTody =  myDate.toLocaleString( );        //获取日期与时间
		$("#questionOption").val(timeTody);
		
	})
	
})