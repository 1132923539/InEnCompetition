<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullTeacher" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<FullTeacher> listFullTeacher = (List<FullTeacher>)request.getAttribute("listFullTeacher");
	PagingUtil pageing = (PagingUtil)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/teacher.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
</head>
<body>
<%@include file="/front/head.jsp" %>

<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    评审委员
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li class="color" onclick="window.location.href='teacher.html';">评委老师</li>
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
                <span>评委老师</span>
            </div>
            <div class="content-main-right-title1">
                <span>评委老师</span>
            </div>
            <%if(listFullTeacher==null||listFullTeacher.size()==0){ %>
            
            <%}else{ 
            	for(int i=0;i<listFullTeacher.size();i++){
            %>
            <div class="content-main-right-content-img">
            	<%if(listFullTeacher.get(i).getTeacher().getImageid()==null){ %>
                <img src="<%=path %>/img/head.jpg" class="content-main-right-content-img1"/>
                <%}else{ %>
                <img src="admin_adminAction_drawOneByNum?imageId=<%=listFullTeacher.get(i).getTeacher().getImageid() %>" class="content-main-right-content-img1"/>
                <%} %>
                <div class="content-main-right-content-img2"><%=listFullTeacher.get(i).getTeacher().getName() %></div>
                <div class="content-main-right-content-img2"><%=listFullTeacher.get(i).getSchool().getName() %></div>
                <div class="content-main-right-content-img2">第<%=listFullTeacher.get(i).getTeacher().getGroups() %>组评委老师</div>
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