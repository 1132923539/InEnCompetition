var demo = false;
$(function(){
	demo=$(".addteacher").Validform({
		tiptype:3,
		datatype:{
			},
	});  //就这一行代码！;
	$(".nav-ul .nav-ul-li").hover(function(){
        $(this).find($(".drop-list")).show();
    },function(){
        $(this).find($(".drop-list")).hide();
    })
});	
function addteacher(){
	if(demo.check()){
		$.ajax({
			type:"GET",
			data:$('#addtea').serialize(),
			url:"admin_adminAction_doAddTeacher",
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("添加成功");
					window.location.href="admin_adminAction_listAllTeacher";
				}
				if(data=="fail"){
					alert("添加失败");
					window.location.href="admin_adminAction_addTeacher";
				}
			}
		}); 
	}
}
