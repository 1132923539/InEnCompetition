<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/consultation.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>创业咨询</title>
</head>
<body>
<%@include file="/front/head.jsp" %>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    创业政策
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li onclick="window.location.href='front_indexAction_support';">政策标准</li>
                        <li class="color" onclick="window.location.href='front_indexAction_consultation';">创业咨询</li>
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
                <span>创业咨询</span>
            </div>
            <div class="content-main-right-title1">
                <span>创业咨询</span>
            </div>
            <div class="content-main-right-content1">
              	  大学生就业指导中心：<a href="http://xsc.njue.edu.cn/jyzd/" target="_blank">http://www.baidu.com/</a>
            </div>
            <div class="content-main-right-content1">
               	 西南大学大学生创业教育网：<a href="http://www.3idea.cn/" target="_blank">http://www.baidu.cn/</a>
            </div>
            <div class="content-main-right-content1">
                	重庆大学生创业指导服务中心：<a href="http://nanjing07588.11467.com/" target="_blank">http://www.baidu.com/</a>
            </div>
        </div>
        <div class="clear: both;"></div>
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