<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullNews" %>
<%@ page import="com.bs.competition.control.util.TimeUtil"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    FullNews fullNews = (FullNews)request.getAttribute("fullNews");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/front_newsdetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <title></title>
</head>
<body>
<div class="content">
	<%@include file="/front/navigation.jsp" %>
    <div class="content-middle">
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>大赛新闻详情</span>
            </div>
            <div class="content-middle2-content">
                <div class="content-middle2-content-title">
                	<span><%=fullNews.getNews().getTitle() %></span>
                </div>
                <div class="content-middle2-content-time">
	                <div class="content-middle2-content-time1">
	                	<%=TimeUtil.dateFormateYMDHMS(new Date(fullNews.getNews().getAddtime())) %>
	                </div>
	                <div class="content-middle2-content-time2">
	                	<%=fullNews.getAdmin().getName() %>
	                </div>
	            </div>
	            <%if(fullNews.getNews().getImageid()!=null){ %>
	            <div class="content-middle2-content-img">
	            	<img src="admin_adminAction_drawOneByNum?imageId=<%=fullNews.getNews().getImageid() %>" width="350px" height="150px"/>
	            </div>
	            <%} %>
	            <div class="content-middle2-content-content">
	            	<%=fullNews.getNews().getContent() %>
	            </div>
        	</div>
        <div class="clear"></div>
    	</div>
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