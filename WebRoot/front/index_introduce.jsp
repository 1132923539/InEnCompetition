<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/introduce.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>大赛介绍</title>
</head>
<body>
<%@include file="/front/head.jsp" %>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    赛事概况
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li class="color" onclick="window.location.href='front_indexAction_introduce';">大赛介绍</li>
                        <li onclick="window.location.href='front_indexAction_organization';">组织架构</li>
                        <li onclick="window.location.href='front_indexAction_arrange';">赛事安排</li>
                        <li onclick="window.location.href='front_indexAction_contact';">联系方式</li>
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
                <span>大赛介绍</span>
            </div>
            <div class="content-main-right-title1">
                <span>大赛介绍</span>
            </div>
            <div class="content-main-right-content1">
                &nbsp;&nbsp;&nbsp;正为了响应国家号召,鼓励大学生创业、自拓道路,进一步激发青年人创新创业热情,鼓励高校学生积极从事发明创造与技术创新。本系统主要提供专业人士交流创新创业信息；方便学生相互交流自己的创新创业想法；方便举办单位能够及时了解到参赛选手的情况；也能够让学生更加自主地参加创新创业大赛，在大学期间能够更好地发挥自己的水平。同时，通过大学生创新创业大赛系统也能够使得大赛做到公平、公正、公开的原则，只要是符合参赛要求的同学都可以报名参加，这可能也会激发一些平时自己看不到的能力。
            </div>
            <div class="content-main-right-content1">
                &nbsp;&nbsp;&nbsp;本系统采用B/S架构,实现客户端的零维护，利用当前使用的mysql数据库结合Java语言以及CSS3进行设计，采用面向对象的开发模式，为参加创新创业大赛的学生、评委老师和举办单位提供方便。主要实现学生登录、注册、报名、发布参赛作品、在规定时间内可以修改发布的参赛作品；老师浏览学生的参赛作品、修改自己的个人信息；举办单位了解评委老师及学生的动态，查看学生上传的参赛作品、管理评委老师的信息。使其能够代替传统的作品申请报告，具有实时性好，效率高等特点。
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