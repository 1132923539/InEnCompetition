<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullNews" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/notice.css">
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
                        <li class="color" onclick="window.location.href='front_indexAction_listAllNotice';">通知公告</li>
                        <li onclick="window.location.href='front_indexAction_listAllNews';">大赛新闻</li>
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
                <span>通知公告</span>
            </div>
            <div class="content-main-right-title1">
                <span>通知公告</span>
            </div>
            <%if(listFullNews==null||listFullNews.size()==0){ %>
            
            <%}else{ 
            	for(int i=0;i<listFullNews.size();i++){
            %>
	        <div class="content-main-right-content1">
	        	<span><%=i+1 %>、</span>
	            <a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>">
	                <%=listFullNews.get(i).getNews().getTitle() %>
	        	</a>
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