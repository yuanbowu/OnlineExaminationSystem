$(function() {
	$("#oneOption").hide();
	$("#oneAnswer").hide();
	$("#oneGrade").hide();
	$("#questionSelect").blur(function() {
		$("#oneAnswer").show();
		$("#oneGrade").show();
		var selectValue = $("#questionSelect").val();
		var choseOne = "选择题";
		var choseTwo = "填空题";
		var choseThree = "判断题";
		var choseFour = "计算题";
		var choseFive = "简答题";
		console.log(selectValue);
		if (selectValue == choseOne || selectValue == choseThree) {
			console.log(1);
			$("#oneOption").show();
		} else {
			console.log(2);
			$("#oneOption").hide();
		}

	})
})
