<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.simple.Admin" %>
<%  

	String currentUrl = (String)request.getAttribute("currentUrl");
	Admin ad = (Admin)request.getSession().getAttribute("admin");
%>
<script type="text/javascript">
    $(function(){
    	if("<%=currentUrl%>"=="admin_MyDetailAdmin"){
			$("#admindetail").addClass("color");
		}if("<%=currentUrl%>"=="admin_listAllAdmin"){
			$("#adminlist").addClass("color");
		}if ("<%=currentUrl%>"=="admin_addAdmin") {
			$("#addadmin").addClass("color");
		}if("<%=currentUrl%>"=="admin_listAllStudent"){
			$("#studentlist").addClass("color");
		}if ("<%=currentUrl%>"=="admin_listAllTeacher") {
			$("#tealist").addClass("color");
		}if("<%=currentUrl%>"=="admin_addTeacher"){
			$("#addteacher").addClass("color");
		}if("<%=currentUrl%>"=="admin_listAllNews"){
			$("#newslist").addClass("color");
		}if("<%=currentUrl%>"=="admin_addNews"){
			$("#addnews").addClass("color");
		}if("<%=currentUrl%>"=="admin_listAllNotice"){
			$("#noticelist").addClass("color");
		}if("<%=currentUrl%>"=="admin_addNotice"){
			$("#addnotice").addClass("color");
		}if("<%=currentUrl%>"=="admin_listAllStuApplyStudent"){
			$("#listAllStuApplyStudent").addClass("color");
		}
	});
</script>
<div class="content-middle1">
	<%if(ad!=null){ %>
    <div class="content-middle1-head">
        <div class="content-middle1-head1">
            <%if(ad.getImageid()!=null){ %>
            <img src="admin_adminAction_drawOneByNum?imageId=<%=ad.getImageid() %>"/>
            <%}else{ %>
            <img src="<%=request.getContextPath()%>/img/head.jpg"/>
            <%} %>
        </div>
        <div class="content-middle1-head2">
           <%=ad.getName() %>
        </div>
        <div class="clear: both;"></div>
    </div>
    <%} %>
    <div class="content-middle1-title">
        管理员中心
    </div>
    <div class="content-middle11">
        <ul>
        	<li><a href="admin_adminAction_MyDetailAdmin" id="admindetail">我的个人信息</a></li>
        	<li><a href="admin_adminAction_listAllAdmin" id="adminlist">管理员列表</a></li>
        	<li><a href="admin_adminAction_addAdmin" id="addadmin">新增管理员</a></li>
            <li><a href="admin_adminAction_listAllStudent" id="studentlist">注册学生列表</a></li>
            <li><a href="admin_adminAction_listAllStuApplyStudent" id="listAllStuApplyStudent">报名学生列表</a></li>
            <li><a href="admin_adminAction_listAllTeacher" id="tealist">评委老师列表</a></li>
            <li><a href="admin_adminAction_addTeacher" id="addteacher">新增评委老师</a></li>
            <li><a href="admin_adminAction_listAllNews" id="newslist">大赛新闻列表</a></li>
            <li><a href="admin_adminAction_addNews" id="addnews">发布大赛新闻</a></li>
            <li><a href="admin_adminAction_listAllNotice" id="noticelist">大赛公告列表</a></li>
            <li><a href="admin_adminAction_addNotice" id="addnotice">发布公告通知</a></li>
        </ul>
    </div>
</div>