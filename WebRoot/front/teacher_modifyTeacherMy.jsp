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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/teamodify.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
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
                <span>评委老师修改个人信息</span>
            </div>
            <form class="modifyMy" method="post" id="modifyMy" action="front_teacherAction_doModifyTeacherMy?teacherId=<%=fullTeacher.getTeacher().getId() %>" enctype="multipart/form-data">
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
	                        原始密码：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="password" placeholder="请输入原始密码" datatype="*1-30" errormsg="最多30个字！" ajaxurl="front_teacherAction_checkPassword?teacherId=<%=fullTeacher.getTeacher().getId() %>">
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        新密码：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="password" placeholder="请输入新密码" datatype="*0-30" errormsg="最多30个字！" id="newpassword1">
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                       确认密码：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="password" placeholder="请确认密码" name="password" datatype="*0-30" errormsg="最多30个字！" id="newpassword2">
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                       头像：
	                    </div>
	                    <div>
	                        <div class="uploadPreview2" id="upP1" style="background-image:url('admin_adminAction_drawOneByNum?imageId=<%=fullTeacher.getTeacher().getImageid() %>')"></div>
							<a class="file1">上传图片
								<input class="uploadImage1" id="upI1" type="file" name="upload" onchange="PreviewImage();">
							</a>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3 mt-120">
	                    <div class="content-middle3-left">
	                        备注：
	                    </div>
	                    <div class="content-middle3-right">
	                        <!--<textarea type="text"></textarea>-->
	                        <textarea type="text" placeholder="请输入备注" name="remark" datatype="*0-100" errormsg="最多100个字！"><%if(fullTeacher.getTeacher().getRemark()!=null){out.print(fullTeacher.getTeacher().getRemark());}else{out.print("");} %></textarea>
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                	<div class="content-middle3-right">
	                		<button type="button" class="btn1" onclick="return modifyMy('<%=fullTeacher.getTeacher().getId() %>','<%=fullTeacher.getUser().getPassword()%>');">提交</button>
	                	</div>
	                	<div class="clear"></div>
	                </div>
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
<script type="text/javascript" src="<%=path%>/js/teacher_modifyTeacherMy.js"></script>

</body>
</html>