<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_addnotice.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
    <style>

    </style>
</head>
<body>
<div class="content">
	<%@include file="/front/navigation.jsp" %>
    <div class="content-middle">
        <%@include file="/admin/admin_left.jsp" %>
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>管理员中心</span>
                <span>|</span>
                <span>发布大赛公告</span>
            </div>
            <form method="post" id="addNotice" class="addNotice" action="admin_adminAction_doAddNotice">
                <div class="content-middle2-content">
                    <div class="content-middle3">
                        <div class="content-middle3-left">
                            标题：
                        </div>
                        <div class="content-middle3-right">
                            <input type="text" placeholder="标题" datatype="*1-30" nullmsg="标题不能为空" errormsg="最多30个字！" name="title">
                        	<div class="form-error Validform_checktip"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="content-middle3 mt-20">
                        <div class="content-middle3-left">
                            内容：
                        </div>
                        <div class="content-middle3-right">
                            <textarea type="text" placeholder="内容" datatype="*1-1000" nullmsg="内容不能为空" errormsg="最多1000个字！" name="content"></textarea>
                        	<div class="form-error Validform_checktip" style="margin-top: -40px!important;"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="content-middle3 mt-50">
                        <button class="score-btn2" type="button" onclick="addNotice();">提交</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/admin_addNotice.js"></script>
</body>
</html>