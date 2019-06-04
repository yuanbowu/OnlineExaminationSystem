$(function(){
	$("#fileinp").change(function() {
		var fileAddress = $("#fileinp").val();
		$("#text").html("<form action='../servlet/ImportExcelServlet' mothon='post' id='fileForm'><input type='text' name ='path' id='fileChoose' value='"+fileAddress+"'/><input type='submit' name='fileSum' value='提交'/></form>");
		console.log($("#fileChoose").val());
	});
})
