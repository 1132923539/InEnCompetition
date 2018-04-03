<%@page import="com.bs.competition.control.util.ToolsUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	page import="com.bs.competition.entity.complex.FullNews" %>
<%@	page import="com.bs.competition.entity.complex.FullStuApply" %>
<%@ page import="com.bs.competition.control.util.TimeUtil"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<FullNews> listFullNews = (List<FullNews>)request.getAttribute("listFullNews");
    List<FullStuApply> listFullStuApply = (List<FullStuApply>)request.getAttribute("listFullStuApply");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/banner.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/index.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <title></title>
</head>
<body>
    <%@include file="/front/head.jsp" %>
    <div class="content">
        <%@include file="/front/navigation.jsp" %>

        <div class="content-main">
            <div class="content-main-left">
                <div class="content-main-left-banner">
                    <div id="banner_tabs" class="flexslider" >
                        <ul class="slides">
                            <li>
                                <a title="" target="_blank" href="#">
                                    <img width="100%" height="400" src="<%=path%>/img/banner/banner1.jpg">
                                </a>
                            </li>
                            <li >
                                <a title="" href="#">
                                    <img width="100%" height="400" src="<%=path%>/img/banner/banner2.jpg">
                                </a>
                            </li>
                            <li>
                                <a title="" href="#">
                                    <img width="100%" height="400" src="<%=path%>/img/banner/banner3.jpg">
                                </a>
                            </li>
                        </ul>
                        <ul class="flex-direction-nav">
                            <li><a class="flex-prev" href="javascript:;">Previous</a></li>
                            <li><a class="flex-next" href="javascript:;">Next</a></li>
                        </ul>
                        <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
                            <li><a>1</a></li>
                            <li><a>2</a></li>
                            <li><a>2</a></li>
                        </ol>
                    </div>
                </div>

                <div class="content-main-right">
                    <div class="content-main-right-title">
                        <span>大赛公告</span>
                    </div>
                    <%
					if(listFullNews!=null&&listFullNews.size()!=0){
					int sum1=0;
					for(int i=0;i<listFullNews.size();i++){ 
					if(sum1++<8&&listFullNews.get(i).getNews().getType()==1){
					%>
                    <div class="content-main-right-middle">
                        <img src="<%=path%>/img/ico-right.png"/>
                        <a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>"><span><%=listFullNews.get(i).getNews().getContent() %></span></a>
                    </div>
                    <%}}} %>
                    <a href="front_indexAction_listAllNotice" style="text-decoration: none;color:black;">
	                    <div class="more">
	                        更多<i class="fa fa-angle-double-right"></i>
	                    </div>
                    </a>
                    <div class="clear"></div>
                </div>
                <!-- <div class="instance">
                    <div class="instance-time1">
                        <span>距报名截止</span>
                    </div>
                    <div class="instance-time2">
                        <span>02天</span>
                        <span>30时</span>
                    </div>
                </div> -->
                <div class="clear"></div>
            </div>
        </div>


        <div class="middle">
            <div class="content-main-middle">
                <div class="content-main-middle-title">
                    <span>新闻中心</span>
                </div>
                <a href="front_indexAction_listAllNews?type=0">
                    <div class="content-main-middle-img">
                        <img src="<%=path%>/img/more.png"/>
                    </div>
                </a>
                <div class="clear"></div>
				<div>
				<%
					if(listFullNews!=null&&listFullNews.size()!=0){
					int sum=0;
					for(int i=0;i<listFullNews.size();i++){ 
					if(listFullNews.get(i).getNews().getType()==0&&sum++<6){
					%>
					
	                <div class="content-main-middle-1">
	                    <div class="content-main-middle-left">
	                    	<a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>">
	                        <%if(listFullNews.get(i).getNews().getImageid()==null){ %>
								<img  src="<%=path%>/img/news.jpg" width="150px" height="150px"/>
							<%}else{ %>
								<img  src="admin_adminAction_drawOneByNum?imageId=<%=listFullNews.get(i).getNews().getImageid() %>" width="150px" height="150px"/>
							<%} %>
							</a>
	                    </div>
	                    <div class="content-main-middle-right">
	                        <a href="front_indexAction_detailNews?newsId=<%=listFullNews.get(i).getNews().getId()%>" style="text-decoration: none;">
		                        <div class="content-main-middle-right-title">
		                            <span><%=listFullNews.get(i).getNews().getTitle() %></span>
		                        </div>
	                        </a>
	                        <div class="content-main-middle-right-content">
	                            <span><%=listFullNews.get(i).getNews().getContent() %></span>
	                        </div>
	                        <div class="content-main-middle-right-time">
	                            <span><%=TimeUtil.dateFormateYMDHM(new Date(listFullNews.get(i).getNews().getAddtime())) %></span>
	                        </div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
               
                <%}}} %> </div>
                <div class="clear"></div>
            </div>
            <div class="content-main-guide">
                <span>大赛指南</span>
            </div>
            <div class="content-main-guide-img">
                <img src="<%=path%>/img/more.png"/>
            </div>
            <div class="content-main-guide-1">
                <ul>
                    <li class="ico1" onclick="window.location.href='front_indexAction_condition';">参赛条件</li>
                    <li class="ico2" onclick="window.location.href='front_indexAction_way';">报名方式</li>
                    <li class="ico3" onclick="window.location.href='front_indexAction_arrange';">赛程安排</li>
                    <li class="ico4" onclick="window.location.href='front_indexAction_support';">政策标准</li>
                    <!-- <li class="ico5" onclick="window.location.href='front_indexAction_download';">参赛资料下载</li> -->
                </ul>
            </div>
            <div class="content-main-guide-2">
                <span>作品展示</span>
            </div>
            <a href="front_indexAction_listAllStuApply">
	            <div class="content-main-guide-2-img">
	                <img src="<%=path%>/img/more.png"/>
	            </div>
            </a>
            <div class="content-main-guide-3">
                
                <%if(listFullStuApply!=null&&listFullStuApply.size()>0){ 
                	for(int i=0;i<listFullStuApply.size();i++){
                	if(i<8){
                %>
                <div class="content-main-guide-3-3">
                    <%-- <a href="front_indexAction_detailStuApply?stuApplyId=<%=listFullStuApply.get(i).getStuApply().getId()%>"> --%>
					<%-- <a onclick="return checkDown('<%=listFullStuApply.get(i).getFiles().getId()%>');"> --%>
					<a href="front_flexPaperAction_show?filePath=C:\Users\Administrator\Desktop&pathName=<%=listFullStuApply.get(i).getFiles().getName()%>">                    
                        <span><%=listFullStuApply.get(i).getFiles().getName()%></span>
                    </a>
                </div>
                <div class="content-main-guide-3-4">
                    <span>作者：</span>
                    <span><%=listFullStuApply.get(i).getStudent().getName() %></span>
                </div>
                <%}}} %>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-- 底部导航-->
    <%-- <%@include file="/front/footer.jsp" %>
 --%>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/banner.js"></script>
    <script type="text/javascript" src="<%=path%>/js/index_index.js"></script>
    
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
