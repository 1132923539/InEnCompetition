<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/way.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>报名流程</title>
</head>
<body>
<%@include file="/front/head.jsp" %>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    参赛报名
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li onclick="window.location.href='front_indexAction_condition';">参赛条件</li>
                        <li class="color" onclick="window.location.href='front_indexAction_way';">报名流程</li>
                        <li onclick="window.location.href='front_indexAction_reward';">奖励机制</li>
                    </ul>
                </div>
            </div>
            <div class="content-main-left-bottom">
                <div class="content-main-left-bottom-1">
                    <span>联系方式：</span>
                </div>
                <div class="content-main-left-bottom-1">
                    <span>E-mail:1111111111@qq.com</span>
                </div>
                <div class="content-main-left-bottom-1">
                    <span>通讯地址：</span>
                </div>
            </div>
        </div>
        <div class="content-main-right">
            <div class="content-main-right-title">
                <span>当前位置：</span>
                <span>大学生创新创业大赛</span>
                <span>></span>
                <span>报名流程</span>
            </div>
            <div class="content-main-right-title1">
                <span>报名流程</span>
            </div>
            <div class="content-main-right-content1">
                <span>一、注册账号</span>
            </div>
            <div class="content-main-right-content">
                按要求完整、准确、真实地填写个人信息并注册，登录系统；
            </div>
            <div class="content-main-right-content1">
                <span>二、提交报名信息</span>
            </div>
            <div class="content-main-right-content">
               按要求完整、准确、真实地填报参赛相关信息，上传参赛作品；
            </div>
            <div class="content-main-right-content1">
                <span>三、修改参赛作品</span>
            </div>
            <div class="content-main-right-content">
                在规定时间内修改完善参赛作品。
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>


<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %>
 --%>
<script type="text/javascript">
    $(function(){
        $(".nav-ul .nav-ul-li").hover(function(){
            $(this).find($(".drop-list")).show();
        },function(){
            $(this).find($(".drop-list")).hide();
        })
    })
</script>
</body>
</html>