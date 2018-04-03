<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullNews" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
<%@ page import="com.bs.competition.control.util.TimeUtil"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<FullNews> listFullNews = (List<FullNews>)request.getAttribute("listFullNews");
	PagingUtil pageing = (PagingUtil)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/news.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>大赛公告</title>
</head>
<body>
<%@include file="/front/head.jsp" %>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    新闻中心
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li onclick="window.location.href='front_indexAction_listAllNotice';">通知公告</li>
                        <li class="color" onclick="window.location.href='front_indexAction_listAllNews';">大赛新闻</li>
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
                <span>大赛新闻</span>
            </div>
            <div class="content-main-right-title1">
                <span>大赛新闻</span>
            </div>
            <%if(listFullNews==null||listFullNews.size()==0){ %>
            
            <%}else{ 
            	for(int i=0;i<listFullNews.size();i++){
            %>
            <div class="content-main-right-content-img">
                <a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>">
                <%if(listFullNews.get(i).getNews().getImageid()==null){ %>
                	<img src="<%=path%>/img/news.jpg" class="content-main-right-content-img1"/>
                <%}else{ %>
                	<img src="admin_adminAction_drawOneByNum?imageId=<%=listFullNews.get(i).getNews().getImageid() %>" class="content-main-right-content-img1"/>
                <%} %>
                </a>
                <a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>"><div class="content-main-right-content-img2"><%=listFullNews.get(i).getNews().getTitle() %></div></a>
                <div class="content-main-right-content-img2"><%=TimeUtil.dateFormateYMDHM(new Date(listFullNews.get(i).getNews().getAddtime())) %></div>
                <div class="clear"></div>
            </div>
            <%}} %>
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