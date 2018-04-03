<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.simple.Teacher" %>
<%  
	
	String currentUrl = (String)request.getAttribute("currentUrl");
	Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
%>
<script type="text/javascript">
    $(function(){
    	if("<%=currentUrl%>"=="teacher_teacherMyDetail"){
			$("#teadetail").addClass("color");
		}if("<%=currentUrl%>"=="teacher_modifyTeacherMy"){
			$("#teaModify").addClass("color");
		}if ("<%=currentUrl%>"=="teacher_listStuApplyStudent") {
			$("#listStuApplyStudent").addClass("color");
		}
	});
</script>
<div class="content-middle1">
	<%if(tea!=null){ %>
    <div class="content-middle1-head">
        <div class="content-middle1-head1">
            <%if(tea.getImageid()==null){ %>
             	<img src="<%=request.getContextPath()%>/img/head.jpg"/>
             <%}else{ %>
             	<img src="admin_adminAction_drawOneByNum?imageId=<%=tea.getImageid() %>"/>
             <%} %>
        </div>
        <div class="content-middle1-head2">
          <%=tea.getName() %>
        </div>
        <div class="clear: both;"></div>
    </div>
    <%} %>
    <div class="content-middle1-title">
        个人中心
    </div>
    <div class="content-middle11">
        <ul>
        	<li><a href="front_teacherAction_teacherMyDetail" id="teadetail">个人信息详情</a></li>
            <li><a href="front_teacherAction_modifyTeacherMy" id="teaModify">修改个人信息</a></li>
            <li><a href="front_teacherAction_listStuApplyStudent" id="listStuApplyStudent">报名学生列表</a></li>
        </ul>
    </div>
</div>