$(function(){
	$(".stuApply").Validform({
	tiptype:3,
	datatype:{
		},
	});  //就这一行代码！;
});	
var input1 = document.getElementById("file");// 获得控件对象
input1.onchange = inputPath; //当控件对象 input1 有变化时执行函数 inputPath
function inputPath() {
    fileSize = $("#file")[0].files[0].size //size in kb
    fileSize = (fileSize / 1048576).toFixed(2); //size in mb

    var input2 = document.getElementById("a"); // 获取 input 对象 input2
    input2.value=('上传成功!'+' '+'文件名是：'+input1.value+" "+"文件大小:"+" "+fileSize+"MB");  // 将控件 input1 的值赋给 input2
}
$(function(){
    $("#upI1").on("change", function(){
        // Get a reference to the fileList
        var files = !!this.files ? this.files : [];

        // If no files were selected, or no FileReader support, return
        if (!files.length || !window.FileReader) return;

        // Only proceed if the selected file is an image
        if (/^image/.test( files[0].type)){

            // Create a new instance of the FileReader
            var reader = new FileReader();

            // Read the local file as a DataURL
            reader.readAsDataURL(files[0]);

            // When loaded, set image data as background of div
            reader.onloadend = function(){
                $("#upP1").css("background-image", "url("+this.result+")");
            }

        }

    });
})
function check(isApply){
	var upI1 = document.getElementById("upI1").value;
	var card = document.getElementById("card").value;
	if(isApply==1){
		alert("您已报过名请不要重复报名");
		return false;
	}
	if(upI1==""){
		alert("请上传文件");
		return false;
	}
	if(card==""||card.length!=18){
		alert("请输入正确的身份证号码");
		return false;
	}
	else{
		if(confirm("你确定要报名吗？")){
			$("#stuApply").submit();
		}else{
			return false;
		}
	}
}