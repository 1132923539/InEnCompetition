<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/login.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <title></title>
</head>
<body onload="createCode();">
<div class="content">
    <%@include file="/front/top.jsp" %>
    
    <div class="login_main">
        <form action="front_userAction_tologin" method="post" class="login" id="login">
            <div class="login_main_right">
                <div class="title">
                    <span>创新创业大赛</span>
                </div>

                <div class="login_main_right-span">
                    <span>用户名：</span>
                    <input type="text" style="margin-left: 10px;" placeholder="请填写用户名" name="name" datatype="*1-15" nullmsg="不能为空" errormsg="最多15个字！">
                    <div class="form-error Validform_checktip"></div>
                </div>
                <div class="login_main_right-span pa-20">
                    <span class="le">密码：</span>
                    <input type="password" placeholder="请填写密码" name="password" datatype="*1-30" nullmsg="不能为空" errormsg="最多30个字！">
                	<div class="form-error Validform_checktip"></div>
                </div>
                <div class="login_main_right-span pa-20">
                    <span>验证码：</span>
                    <input type="text" style="margin-left: 10px;width:80px;" id="input1">    
                  	<input type="text" id="checkCode" class="code" style="width: 65px;border: none;" />
                   	<div class="yzm-change">
                   		<a href="#" class="yzm" onclick="createCode()">看不清</a> 
					</div>
                </div>
                <div class="login_main_right-button">
                    <button type="button" onclick="validate();">登&nbsp;录</button>
                </div>
            </div>
        </form>
    </div>
    <!-- 底部导航-->
   <%--  <%@include file="/front/footer.jsp" %> --%>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/user_login.js"></script>
</body>
</html>
