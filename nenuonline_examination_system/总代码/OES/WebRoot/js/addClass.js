	$(document).ready(function(){
			  $("#addButton").click(function(){
					$("#addUl").append("<input type='text' id='newLi' />");
					$("#newLi").keyup(function(event){
						if(event.keyCode ==13){
							var textValue = $("#newLi").val();
							console.log(textValue);
							$("#newLi").css("display","none");
							$("#addUl").append("<li>"+textValue+"</li>");
						}
					});
			  });
			});