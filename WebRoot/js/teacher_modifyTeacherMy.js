var demo = false;
$(function(){
	demo = $(".modifyMy").Validform({
		tiptype:3,
		datatype:{
			},
		});  //就这一行代码！;
    $(".nav-ul .nav-ul-li").hover(function(){
        $(this).find($(".drop-list")).show();
    },function(){
        $(this).find($(".drop-list")).hide();
    })
})
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

function modifyMy(teacherId,old){
	if(demo.check()){
		var password1 = document.getElementById("newpassword1").value;
		var password2 = document.getElementById("newpassword2").value;
	//	alert(password1);
	//	alert(password2);
		if(password1!=password2){
			alert("两次密码不一致，请重新输入");
			return false;
		}else{
			if(confirm("你确定要修改个人信息吗？"))
			{
				if(password1==""||password2==""){
					$("#newpassword2").val(old);
				}
//				$.ajax({
//					type:"POST",
//					data:$('#modifyMy').serialize(),
//					url:"front_teacherAction_doModifyTeacherMy?teacherId="+teacherId,
//					datatype:'text',
//					success:function(data){
//						if(data=="success"){
//							alert("修改成功");
//							window.location.href="front_teacherAction_modifyTeacherMy?teacherId="+teacherId;
//						}
//						if(data=="fail"){
//							alert("修改失败");
//							window.location.href="front_teacherAction_modifyTeacherMy?teacherId="+teacherId;
//						}
//					}
//				});
				$("#modifyMy").submit();
			}else
			{
				return false;
			}
		}
	}
}