var demo = false;
$(function(){
	demo=$(".login").Validform({
		tiptype:3,
		datatype:{
			},
	});  //就这一行代码！;
});	
var code ; //在全局 定义验证码      
function createCode(){       
code = "";      
var codeLength = 4;//验证码的长度      
var checkCode = document.getElementById("checkCode");      
checkCode.value = "";      
var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
      
for(var i=0;i<codeLength;i++) {      
   var charIndex = Math.floor(Math.random()*60);      
  code +=selectChar[charIndex];      
}      
if(code.length != codeLength){      
  createCode();      
}      
checkCode.value = code;      
}      
      
     
function validate () {      
	var inputCode = document.getElementById("input1").value.toUpperCase();      
	var codeToUp=code.toUpperCase();  
	if(inputCode.length <=0) {      
	  alert("请输入验证码！");      
	  return false;      
	}      
	else if(inputCode != codeToUp ){      
	   alert("验证码输入错误！");      
	   createCode();      
	   return false;      
	}      
	else {
		if(demo.check()){
			$.ajax({
				type:"post",
				data:$('#login').serialize(),
				url:"front_userAction_tologin",
				dataType:"json",
				success:function(data){
					if(data.info=="admin"){
						window.location.href="admin_adminAction_MyDetailAdmin";
					}
					if(data.info=="teacher"){
						window.location.href="front_teacherAction_teacherMyDetail";
					}
					if(data.info=="student"){
						window.location.href="front_studentAction_studentMyDetail";
					}
					if(data.info=="fail"){
						alert("用户名或密码错误");
						window.location.reload(); 
					}
				}
			}); 
		}
	}           
} 
document.onkeydown = function(event) {  
    var target, code, tag;  
    if (!event) {  
        event = window.event; //针对ie浏览器  
        target = event.srcElement;  
        code = event.keyCode;  
        if (code == 13) {  
            tag = target.tagName;  
            if (tag == "TEXTAREA") { return true; }  
            else { return false; }  
        }  
    }  
    else {  
        target = event.target; //针对遵循w3c标准的浏览器，如Firefox  
        code = event.keyCode;  
        if (code == 13) {  
            tag = target.tagName;  
            if (tag == "INPUT") { return false; }  
            else { return true; }   
       }  
    }  
};