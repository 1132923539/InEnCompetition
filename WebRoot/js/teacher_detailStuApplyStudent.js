$(function(){
    $(".nav-ul .nav-ul-li").hover(function(){
        $(this).find($(".drop-list")).show();
    },function(){
        $(this).find($(".drop-list")).hide();
    })
})

function addScore(studentId,isScore){
	if(isScore==1){
		alert("您已评过分了，请不要重复评分");
		return false;
	}else{
		$("#studentId").val(studentId);
		$(".mask").fadeIn();
		$(".hvt_addr").fadeIn();
	}
}

$(".close-img").click(function(){
    $(".mask").fadeOut();
    $(".hvt_addr").fadeOut();
})
$(".cancel-btn").click(function(){
    $(".mask").fadeOut();
    $(".hvt_addr").fadeOut();
})

function check(){
	var newscore = document.getElementById("newscore").value;
	var prascore = document.getElementById("prascore").value;
	var feascore = document.getElementById("feascore").value;
	var a = /^(\d(\.\d)?|10)$/;
	if(newscore==""||!a.test(newscore)){
		alert("新颖性分数必须为0-10之间的数字");
		return false;
	}
	if(prascore==""||!a.test(prascore)){
		alert("实用性分数必须为0-10之间的数字");
		return false;
	}
	if(feascore==""||!a.test(feascore)){
		alert("可行性分数必须为0-10之间的数字");
		return false;
	}else{
		$.ajax({
			type:"post",
			data:$('#addScore').serialize(),
			url:"front_teacherAction_addScore",
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("评分成功");
					window.location.href="front_teacherAction_listStuApplyStudent";
				}
				if(data=="fail"){
					alert("评分失败");
					window.location.href="front_teacherAction_listStuApplyStudent";
				}
			}
		});
	}
}
function checkDown(fileId){
	if(confirm("你确定要下载该作品吗？")){
		window.location.href="admin_adminAction_download?fileId="+fileId;
	}else{
		return false;
	}
}