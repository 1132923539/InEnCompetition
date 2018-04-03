<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullTeacher" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	FullTeacher fullTeacher = (FullTeacher)request.getAttribute("fullTeacher");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/teadetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
</head>
<body>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-middle">
        <%@include file="/front/teacher_left.jsp" %>
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>评委老师</span>
                <span>|</span>
                <span>评委老师个人信息详情</span>
            </div>
            <div class="content-middle2-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        姓名：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="text" placeholder="姓名">-->
                        <div class="content-middle3-right-none"><%=fullTeacher.getTeacher().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        性别：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="radio"><span>男</span>
                        <input type="radio"><span>女</span>-->
                        <div class="content-middle3-right-none">
							<%if(fullTeacher.getTeacher().getSex()==0){out.print("男");}else{out.print("女");} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        学校：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="text" placeholder="用户名">-->
                        <div class="content-middle3-right-none"><%=fullTeacher.getSchool().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        第几组：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="text" placeholder="姓名">-->
                        <div class="content-middle3-right-none">第<%=fullTeacher.getTeacher().getGroups() %>组</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                       头像：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%if(fullTeacher.getTeacher().getImageid()==null){ %>
								<img  src="<%=path%>/img/head.jpg" width="150px" height="150px"/>
							<%}else{ %>
								<img  src="admin_adminAction_drawOneByNum?imageId=<%=fullTeacher.getTeacher().getImageid() %>" width="150px" height="150px"/>
							<%} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3 mt-80">
                    <div class="content-middle3-left">
                        备注：
                    </div>
                    <div class="content-middle3-right">
                        <!--<textarea type="text"></textarea>-->
                        <div class="content-middle3-right-none">
							<%if(fullTeacher.getTeacher().getRemark()!=null){out.print(fullTeacher.getTeacher().getRemark());}else{out.print("");} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                	<div class="content-middle3-right">
                		<a href="front_teacherAction_modifyTeacherMy?teacherId=<%=fullTeacher.getTeacher().getId() %>"><button type="button" class="score-btn top-up-btn">修改</button></a>
                	</div>
                	<div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %> --%>

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