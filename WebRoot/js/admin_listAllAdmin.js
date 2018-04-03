function delAdmin(adminId){
	if(confirm("你确定要删除该管理员吗？"))
	{
		$.ajax({
			type:"GET",
			url:"admin_adminAction_delAdmin?adminId="+adminId+"&status="+0,
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("删除成功");
					window.location.href="admin_adminAction_listAllAdmin";
				}
				if(data=="fail"){
					alert("删除失败");
					window.location.href="admin_adminAction_listAllAdmin";
				}
			}
		});
		
	}else
	{
		return false;
	}
	
}
function redAdmin(adminId){
	if(confirm("你确定要还原该管理员吗？"))
	{
		$.ajax({
			type:"GET",
			url:"admin_adminAction_delAdmin?adminId="+adminId+"&status="+1,
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("还原成功");
					window.location.href="admin_adminAction_listAllAdmin";
				}
				if(data=="fail"){
					alert("还原失败");
					window.location.href="admin_adminAction_listAllAdmin";
				}
			}
		});
		
	}else
	{
		return false;
	}
	
}
$(function(){
    $(".nav-ul .nav-ul-li").hover(function(){
        $(this).find($(".drop-list")).show();
    },function(){
        $(this).find($(".drop-list")).hide();
    })
})