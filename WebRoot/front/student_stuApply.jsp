<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStudent" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    FullStudent fullStudent = (FullStudent)request.getAttribute("fullStudent");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/apply.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
</head>
<body>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-middle">
        <%@include file="/front/student_left.jsp" %>
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>参赛学生</span>
                <span>|</span>
                <span>报名</span>
            </div>
            <form id="stuApply" class="stuApply" action="front_studentAction_doStuApply" method="post" enctype="multipart/form-data">
	            <div class="content-middle3-content">
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        姓名：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=fullStudent.getStudent().getName() %></div>
	                    </div>
	                    <div class="clear: both;"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        性别：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none">
								<%if(fullStudent.getStudent().getSex()==0){out.print("男");}else{out.print("女");} %>
							</div>
	                    </div>
	                    <div class="clear: both;"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        学校：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none"><%=fullStudent.getSchool().getName() %></div>
	                    </div>
	                    <div class="clear: both;"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        身份证号：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="text" name="card" id="card">
	                    </div>
	                    <div class="clear: both;"></div>
	                </div>
	
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        我的作品：
	                    </div>
	                    <div>
							<a class="file1">上传文件
								<input class="uploadImage1" id="upI1" type="file" name="upload" onchange="PreviewImage();">
							</a>
                        </div>
	                    <div class="clear: both;"></div>
	                </div>
	                <div class="apply">
	                    <button type="submit" class="button2" onclick="return check(<%=fullStudent.getStudent().getIsapply()%>);">报名</button>
	                </div>
	                <div class="clear: both;"></div>
	            </div>
	        </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %> --%>
<script type="text/javascript" src="<%=path%>/js/my.js"></script>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/student_stuApply.js"></script>
<%@include file="/admin/alertUtil.jsp" %>
</body>
</html>