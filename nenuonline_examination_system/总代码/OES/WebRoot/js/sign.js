function testPass(){
	var passHTML = document.getElementById("wrong");
	passHTML.innerText = "密码设置错误，请重新设置";
	var passNumber = document.getElementById("signStudentPassword").value;
	var passReg1=/^[a-zA-Z0-9]{8,16}$/;
	var passWorry = passReg1.test(passNumber);
	if (passWorry == true){
		passHTML.style.visibility ='hidden';
	}
	else if(passWorry == false){
		passHTML.style.visibility = 'visible';
	}
	
}

function testPassAgain(){
	var passHTML = document.getElementById("wrong");
	passHTML.innerText = "两次密码输入不一致，请核对后重新输入";
	var passNumber = document.getElementById("signStudentPassword").value;
	var passNumberAgain = document.getElementById("SignPasswordAgain").value;
	
	if (passNumber == passNumberAgain){
		passHTML.style.visibility ='hidden';
	}
	else if(passNumber != passNumberAgain){
		passHTML.style.visibility = 'visible';
	}
	
}