function firstPage() {
	var temp=document.getElementById("pageingCurPage");
	if(temp.value==1||temp.value=="1")
	{
	showDTalert("当前已经是首页");
	return ;
	}
	temp.value=1;
	var fo=document.getElementById("pageingForm");
	fo.submit();
}

function perPage() {
	var temp=document.getElementById("pageingCurPage");
	if(temp.value==1||temp.value=="1")
		{
		showDTalert("当前已经是首页");
		return ;
		}
	temp.value=temp.value-1;
	var fo=document.getElementById("pageingForm");
	fo.submit();
}

function goPage(num) {
	var go=document.getElementById("gopagenum").value;
	var result = new RegExp("[^0123456789]+");
	if(go==null||go=="null"||go>num||go<1||result.test(go))
		{
		showDTalert("输入的跳转数字无效");
		return ;
		}
	var temp=document.getElementById("pageingCurPage");
	temp.value=go;
	var fo=document.getElementById("pageingForm");
	fo.submit();
}

function nextPage(num) {
	var temp=document.getElementById("pageingCurPage");
	var tempnum=Math.abs(temp.value);
	var numch=Math.abs(num);
	if(tempnum>=numch)
		{
		showDTalert("当前已经是末页");
		return ;
		}
	temp.value=tempnum+1;
	var fo=document.getElementById("pageingForm");
	fo.submit();
}


function lastPage(num) {
	var temp=document.getElementById("pageingCurPage");
	var tempnum=Math.abs(temp.value);
	var numch=Math.abs(num);
	if(tempnum==numch)
		{
		showDTalert("当前已经是末页");
		return ;
		}
	temp.value=numch;
	var fo=document.getElementById("pageingForm");
	fo.submit();
}

