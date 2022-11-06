
var dicefun = {
	init:function(){
		var container = document.getElementById('dicebox');
		$('.redpacket').remove();
		var arr = this.randomFun();
		var yy=0;
		for (var i = 0 ; i<6;i++) {
			container.appendChild(this.createDice(arr[i],i));
			yy=10*yy+arr[i];
		}
		/*var xmlhttp,url="http://localhost:8080/dice/checkResult";
		if (window.XMLHttpRequest){
			xmlhttp = new XMLHttpRequest();
		}else{
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");// IE6, IE5 浏览器执行代码
		}
		if (xmlhttp){
			xmlhttp.open("POST",url,true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");// Post请求需要设置请求头
			xmlhttp.send("Uname="+yy);
			console.log(xmlhttp.readyState);
			console.log(xmlhttp.status);
		}*/
		var out;
		$.ajax({
			method:'POST',
			url:'http://localhost:8080/dice/checkResult',
			data:{Uname: yy}
		}).done(function (msg){
			aaax=document.getElementById("demo");  // 找到元素
			aaax.innerHTML="你的成绩是"+msg;    // 改变内容
		});

	},
	randomFun:function(){
		var arr = [];
		for (var i = 0 ; i<6;i++ ) {
			var temp =Math.floor( Math.random()*6+1);
			arr.push(temp);
		}
		return arr;
	},
	createDice:function(num,i){
		var image = document.createElement('img');
   		  	image.setAttribute("class","redpacket");
   		  	image.id = "redpacket" + i;
    	  	image.src = 'img/' + num +'.jpg';
    	  	return image;
	},
}
