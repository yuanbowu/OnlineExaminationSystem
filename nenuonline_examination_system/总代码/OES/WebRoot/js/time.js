window.onload = function() {

  	daojishi();
  }

  var counttime = 120 * 60; //总秒钟

  function daojishi() {
  	if (counttime >= 0) {
  		// var ms = counttime%60;//余数 89%60==29秒
  		var mis = Math.floor(counttime / 60); //分钟
  		if (mis >= 60) {
  			var hour = Math.floor(mis / 60);

  			mis = Math.floor((counttime - hour * 60 * 60) / 60);

  			document.getElementById("mss").innerText = hour + ":" + mis;
  		} else if (mis >= 1) {
  			document.getElementById("mss").innerText = "00:" + mis;
  		} else {
  			document.getElementById("mss").innerText = ms + "s";
  		}


  		counttime--;
  		vartt = window.setTimeout("daojishi()", 1000);
  	} else {
  		window.clearTimeout(vartt);
  		window.confirm("考试时间结束,请单击提交");
  		tijiao();

  	}


  }

  function tijiao() {
  	document.getElementById("pageForm").submit();
  }
