<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/arrange.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>赛事安排</title>
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
                        <li onclick="window.location.href='front_indexAction_organization';">组织架构</li>
                        <li class="color" onclick="window.location.href='front_indexAction_arrange';">赛事安排</li>
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
                <span>赛事安排</span>
            </div>
            <div class="content-main-right-title1">
                <span>赛事安排</span>
            </div>
            <div class="content-main-right-content1">
               	（一）2017年6月1日-2017年6月3日第一轮审核<br>
				审核报名学生是否符合参赛条件，第一轮审核将由系统管理员完成。<br>
            </div>
            <div class="content-main-right-content1">
                                               （二）2017年6月4日-2017年6月10日第一轮评分<br>
				由系统安排的评委老师对学生进行第一轮评分，由管理员统计出综合得分，每组淘汰30%人，剩余的人将进入第二轮复赛。<br>
            </div>
            <div class="content-main-right-content1">
                                               （三）2017年6月30日第二轮复试<br>
                                                 第二轮复试将在举办，届时请各位参加复试的学生做好充分准备。<br>
            </div>
            <div class="content-main-right-content1">
                                                （四）2017年7月30日总决赛<br>
                                                 总决赛将在举办，届时请各位参加复试的学生做好充分准备。<br>
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