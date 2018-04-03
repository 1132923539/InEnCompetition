function checkDown(fileId){
	if(confirm("你确定要下载该作品吗？")){
		window.location.href="admin_adminAction_download?fileId="+fileId;
	}else{
		return false;
	}
}
