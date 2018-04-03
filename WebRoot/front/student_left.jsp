<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.simple.Student" %>
<%  
	
	String currentUrl = (String)request.getAttribute("currentUrl");
	Student stu = (Student)request.getSession().getAttribute("student");
%>
<script type="text/javascript">
    $(function(){
    	if("<%=currentUrl%>"=="student_studentMyDetail"){
			$("#mydetail").addClass("color");
		}if("<%=currentUrl%>"=="student_modifyStudentMy"){
			$("#modifyMy").addClass("color");
		}if ("<%=currentUrl%>"=="student_stuApply") {
			$("#stuApply").addClass("color");
		}if("<%=currentUrl%>"=="student_modifyMyApply"){
			$("#modifyMyApply").addClass("color");
		}if ("<%=currentUrl%>"=="student_myScore") {
			$("#myscore").addClass("color");
		}
	});
	function modify(isapply){
		if(isapply==0){
			alert("您还没有报名，请先提交报名信息");
			return false;
		}else{
			$.ajax({
			type:"GET",
			data:$('#addNotice').serialize(),
			url:"front_studentAction_checkModify",
			datatype:'text',
			success:function(data){
				if(data=="success"){
					alert("已有老师进行评分，请勿修改作品");
					window.location.reload();
				}
				if(data=="fail"){
					window.location.href="front_studentAction_modifyMyApply";
				}
			}
		});
		}
	}
	function score(score){
		if(score==null){
			alert("得分还没出来，请耐心等待");
			return false;
		}else{
			window.location.href="front_studentAction_myScore";
		}
	}
</script>
<div class="content-middle1">

	<%if(stu!=null){ %>
     <div class="content-middle1-head">
         <div class="content-middle1-head1">
         	 <%if(stu.getImageid()==null){ %>
             	<img src="<%=request.getContextPath()%>/img/head.jpg"/>
             <%}else{ %>
             	<img src="admin_adminAction_drawOneByNum?imageId=<%=stu.getImageid() %>"/>
             <%} %>
         </div>
         <div class="content-middle1-head2">
            <%=stu.getName() %>
         </div>
         <div class="clear: both;"></div>
     </div>
     <%} %>
     <div class="content-middle1-title">
         个人中心
     </div>
     <div class="content-middle11">
         <ul>
             <li><a href="front_studentAction_studentMyDetail" id="mydetail">查看个人信息</a></li>
             <li><a href="front_studentAction_modifyStudentMy" id="modifyMy">修改个人信息</a></li>
             <li><a href="front_studentAction_stuApply" id="stuApply">报名</a></li>
             <li><a href="javascript:void(0)" id="modifyMyApply" onclick="modify(<%=stu.getIsapply()%>);">修改我的作品</a></li>
             <li><a href="javascript:void(0)" id="myscore" onclick="score(<%=stu.getScore()%>)">查看我的得分</a></li>
         </ul>
     </div>
 </div>