$(function(){
    $(".nav-ul .nav-ul-li").hover(function(){
        $(this).find($(".drop-list")).show();
    },function(){
        $(this).find($(".drop-list")).hide();
    })
})
function total(size,studentId){
	if(size!=4){
		alert("还有评委老师没评分，请稍后统计");
		return false;
	}else{
		$.ajax({
			type:"POST",
			data:$('#total').serialize(),
			url:"admin_adminAction_totalScore?studentId="+studentId,
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("统计成功");
					window.location.href="admin_adminAction_listAllStuApplyStudent";
				}
				if(data=="fail"){
					alert("统计失败");
					window.location.href="admin_adminAction_listAllStuApplyStudent";
				}
			}
		});
	}
}
function out(){
	alert("暂时还没有老师进行评分");
	return false;	
}