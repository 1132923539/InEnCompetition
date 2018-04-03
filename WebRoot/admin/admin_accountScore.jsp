<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullScore" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<FullScore> listFullScore = (List<FullScore>)request.getAttribute("listFullScore");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/admin_accountScore.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>管理员统计得分</title>
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
                <span>统计得分</span>
            </div>
            <form method="post" id="total" action="">
	            <div class="content-middle2-content">
	                <%if(listFullScore!=null&&listFullScore.size()>0){
	                	for(int i=0;i<listFullScore.size();i++){	
	                 %>
	                <div class="content-middle2-content-left">
	                    <div class="content-middle3-left">
	                        评委老师：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=listFullScore.get(i).getTeacher().getName() %></div>
	                    </div>
	                    <div class="content-middle3-left1">
	                        新颖性：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=(double)(listFullScore.get(i).getNewscore())/100 %>分</div>
	                    </div>
	                    <div class="content-middle3-left1">
	                        实用性：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=(double)(listFullScore.get(i).getPrascore())/100 %>分</div>
	                    </div>
	                    <div class="content-middle3-left1">
	                        可行性：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=(double)(listFullScore.get(i).getFeascore())/100 %>分</div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <%} %>
	                <div class="content-middle3">
	                    <button class="score-btn2" type="button" onclick="total('<%=listFullScore.size()%>','<%=listFullScore.get(0).getStudent().getId()%>');">合计</button>
	                </div>
	                <%}else{ %>
	                <div class="content-middle3">
	                    <button class="score-btn2" type="button" onclick="out();">合计</button>
	                </div>
	                <%} %>
	            </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/admin_accountScore.js"></script>
</body>
</html>