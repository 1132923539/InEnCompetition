<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/organization.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>组织架构</title>
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
                        <li onclick="window.location.href='front_indexAction_introduce';">大赛介绍</li>
                        <li class="color" onclick="window.location.href='front_indexAction_organization';">组织架构</li>
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
                <span>组织架构</span>
            </div>
            <div class="content-main-right-title1">
                <span>组织架构</span>
            </div>
            <div class="content-main-right-content1"style="margin-left: 45px;">
                	主办单位：
            </div>
            <div class="content-main-right-content1">
　　					承办单位：
			</div>
			<div class="content-main-right-content1">
　　					协办单位：
			</div>
			<div class="content-main-right-content1">
　　					战略合作单位：阿里巴巴
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