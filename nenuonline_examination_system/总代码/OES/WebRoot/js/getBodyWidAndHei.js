$(function(){
	var bodyHight = $(window).height();//浏览器实际的宽高，如果浏览器经过了调整大小，则在调整过的浏览器页面也能全部显示
	var bodyWidth = $(window).width();
	//整体大小和浏览器大小相同
	$("body").css("height",bodyHight);
	$("body").css("width",bodyWidth);
	

})
