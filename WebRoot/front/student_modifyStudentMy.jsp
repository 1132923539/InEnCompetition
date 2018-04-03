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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/mymodify.css">
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
                <span>修改个人信息</span>
            </div>
            <form class="modifyMy" method="post" id="modifyMy" action="front_studentAction_doModifyStudentMy?studentId=<%=fullStudent.getStudent().getId()%>" enctype="multipart/form-data">
	            <div class="content-middle3-content">
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        姓名：
	                    </div>
	                    <div class="content-middle3-right">
	                        <!--<input type="text" placeholder="姓名">-->
	                        <div class="content-middle3-right-none"><%=fullStudent.getStudent().getName() %></div>
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
								<%if(fullStudent.getStudent().getSex()==0){out.print("男");}else{out.print("女");} %>
							</div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        学校：
	                    </div>
	                    <div class="content-middle3-right">
	                        <!--<input type="text" placeholder="学校">-->
	                        <div class="content-middle3-right-none"><%=fullStudent.getSchool().getName() %></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        状态：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none">
	                        	<%if(fullStudent.getStudent().getIsapply()==0){out.print("未报名");}else{out.print("已报名");} %>
	                        </div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <%if(fullStudent.getStudent().getIsapply()==1){ %>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        小组：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none">
	                        	第<%=fullStudent.getStuApply().getGroups() %>组
	                        </div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        身份证号：
	                    </div>
	                    <div class="content-middle3-right">
	                        <div class="content-middle3-right-none">
	                        	<%String card = fullStudent.getStuApply().getCard();
	                           	  card = card.substring(0,3)+"*****************"+card.substring(15,18);
	                           	%>
	                           	<%=card %>
	                        </div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <%} %>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        原始密码：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="password" placeholder="请输入原始密码" datatype="*1-30" nullmsg="不能为空" errormsg="最多30个字！" ajaxurl="front_studentAction_checkPassword?studentId=<%=fullStudent.getStudent().getId()%>">
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
	                        <div class="uploadPreview2" id="upP1" style="background-image:url('admin_adminAction_drawOneByNum?imageId=<%=fullStudent.getStudent().getImageid() %>')"></div>
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
	                        <textarea type="text" placeholder="请输入备注" name="remark" datatype="*0-100" errormsg="最多100个字！"><%if(fullStudent.getStudent().getRemark()!=null){out.print(fullStudent.getStudent().getRemark());}else{out.print("");} %></textarea>
							<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                	<div class="content-middle3-right">
	                		<button type="submit" class="btn1" onclick="return modifyMy('<%=fullStudent.getStudent().getId() %>','<%=fullStudent.getUser().getPassword()%>');">提交</button>
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
<script type="text/javascript" src="<%=path%>/js/student_modifyStudentMy.js"></script>
</body>
</html>