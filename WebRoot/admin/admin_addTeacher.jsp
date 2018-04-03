<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.simple.School" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<School> listSchool = (List<School>)request.getAttribute("listSchool");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_addteacher.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
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
                <span>新增评委老师</span>
            </div>
            <form method="post" id="addtea" class="addteacher">
	            <div class="content-middle2-content">
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        姓名：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="text" placeholder="姓名" name="name" datatype="*1-15" nullmsg="不能为空" errormsg="最多15个字！">
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        性别：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="radio" name="sex" value="0" checked="checked"><span>男</span>
	                        <input type="radio" name="sex" value="1"><span>女</span>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        手机号：
	                    </div>
	                    <div class="content-middle3-right">
	                        <input type="text" placeholder="请填写手机号" name="mobliephone" datatype="m" nullmsg="不能为空" errormsg="请输入正确的手机号">
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3">
	                    <div class="content-middle3-left">
	                        学校：
	                    </div>
	                    <div class="content-middle3-right">
	                        <!--<input type="text" placeholder="用户名">-->
	                        <select name="schoolId" datatype="*" nullmsg="请选择学校">
		                        <option value="">-请选择-</option>
		                        <%if(listSchool!=null&&listSchool.size()>0){
		                        	for(int i=0;i<listSchool.size();i++){
		                         %>
		                        <option value="<%=listSchool.get(i).getId() %>"><%=listSchool.get(i).getName() %></option>
		                        <%}} %>
	                    	</select>
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3 mt-20">
	                    <div class="content-middle3-left">
	                        备注：
	                    </div>
	                    <div class="content-middle3-right">
	                        <textarea type="text" placeholder="请填写备注" name="remark" datatype="*0-100" errormsg="最多100个字！"></textarea>
	                    	<div class="form-error Validform_checktip"></div>
	                    </div>
	                    <div class="clear"></div>
	                </div>
	                <div class="content-middle3 mt-50">
	                    <button class="score-btn2" type="button" onclick="addteacher();">提交</button>
	                </div>
	            </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="<%=path%>/js/admin_addTeacher.js"></script>
</body>
</html>