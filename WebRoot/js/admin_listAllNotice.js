function delNotice(newsId){
	if(confirm("你确定要删除该公告吗？"))
	{
		$.ajax({
			type:"GET",
			url:"admin_adminAction_delNotice?newsId="+newsId+"&sysstatus="+0,
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("删除成功");
					window.location.href="admin_adminAction_listAllNotice";
				}
				if(data=="fail"){
					alert("删除失败");
					window.location.href="admin_adminAction_listAllNotice";
				}
			}
		});
		
	}else
	{
		return false;
	}
	
}

function redNotice(newsId){
	if(confirm("你确定要还原该公告吗？"))
	{
		$.ajax({
			type:"GET",
			url:"admin_adminAction_delNotice?newsId="+newsId+"&sysstatus="+1,
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("还原成功");
					window.location.href="admin_adminAction_listAllNotice";
				}
				if(data=="fail"){
					alert("还原失败");
					window.location.href="admin_adminAction_listAllNotice";
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