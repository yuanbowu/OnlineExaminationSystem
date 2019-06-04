function testTime (){
	var myDate = new Date();
	myhour = myDate.getHours();
	var myhours = Number(myhour);
	// console.log(myhours);
	var timeText=document.getElementById("timeHour");
	// console.log(timeText);
	console.log(myhours);
	if(myhours>=0 && myhours<11){
		timeText.innerText = "早上好";
		console.log(1);
	}
	else if(myhours>=11 && myhours<13){
		timeText.innerText = "中午好";	
		console.log(2);
	}
	else if(myhours>=13 && myhours<18 ){
		timeText.innerText = "下午好";
			console.log(3);
	}
	else if(myhours>=18 && myhours<=23 ){
		timeText.innerText = "下午好";
			console.log(3);
	}
}