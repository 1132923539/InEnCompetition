<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_addnews.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
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
                <span>发布大赛新闻</span>
            </div>
            <form method="post" id="addNews" class="addNews" action="admin_adminAction_doAddNews" enctype="multipart/form-data">
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
                    <div class="content-middle3" style="margin-top: 10px;">
                        <div class="content-middle3-left">
                            内容：
                        </div>
                        <div class="content-middle3-right">
                            <textarea placeholder="内容" datatype="*1-1000" nullmsg="内容不能为空" errormsg="最多1000个字！" name="content"></textarea>
                        	<div class="form-error Validform_checktip" style="margin-top: -50px!important;"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="content-middle3" style="margin-top: 60px;">
                        <div class="content-middle3-left" for="image">
                            图片：
                        </div>
                        <div>
                        	<div class="uploadPreview2" id="upP1"></div>
							<a class="file1">上传图片
								<input class="uploadImage1" id="upI1" type="file" name="upload" onchange="PreviewImage();">
							</a>
                        </div>
                    </div>
                    
                    <div class="content-middle3 mt-50">
                        <button class="score-btn2" onclick="return check();">提交</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/my.js"></script>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/admin_addNews.js"></script>
</body>
</html>