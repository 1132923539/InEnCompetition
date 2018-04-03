<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullNews" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    FullNews fullNews = (FullNews)request.getAttribute("fullNews");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_noticedetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
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
                <span>大赛公告详情</span>
            </div>
            <div class="content-middle2-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                      标题：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=fullNews.getNews().getTitle() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        内容：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle-right-none">
                        <textarea readonly="readonly"><%=fullNews.getNews().getContent() %></textarea>
							
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        发布人：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%=fullNews.getAdmin().getName() %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3 mt-50">
                    <button class="score-btn2" onclick="window.location.href='admin_adminAction_listAllNotice'">返回</button>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
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