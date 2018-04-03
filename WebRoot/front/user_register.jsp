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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/register.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <title></title>
</head>
<body>
<div class="content">
    <%@include file="/front/top.jsp" %>
    
    <div class="register_main">
        <form action="front_userAction_toRegister" method="post" class="register">
            <div class="register_main_right">
                <div class="title">
                    <span>创新创业大赛</span>
                </div>

                <div class="register_main_right-span">
                    <span class="le">姓名：</span>
                    <input type="text" placeholder="请填写姓名" name="name" datatype="*1-15" nullmsg="不能为空" errormsg="最多15个字！">
                	<div class="form-error Validform_checktip"></div>
                </div>
                <div class="pa-10 register_main_right-span">
                    <span class="le">姓别：</span>
                    <input type="radio" checked="checked" name="sex" value="0">男
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="radio" name="sex" value="1">女
                </div>
                <div class="register_main_right-span">
                    <span>手机号：</span>
                    <input type="text" style="margin-left: 10px;" placeholder="请填写手机号" name="mobliephone" datatype="m" nullmsg="不能为空" errormsg="请输入正确的手机号">
                	<div class="form-error Validform_checktip"></div>
                </div>
                <div class="pa-10 register_main_right-span">
                    <span class="le">密码：</span>
                    <input type="password" placeholder="请填写密码" name="password" datatype="*1-30" nullmsg="不能为空" errormsg="最多30个字！">
                	<div class="form-error Validform_checktip"></div>
                </div>
                <div class="pa-20 register_main_right-span">
                    <span class="le">学校：</span>
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
                <div class="register_main_right-button">
                    <button type="submit">注&nbsp;册</button>
                </div>
            </div>
        </form>
    </div>
    <!-- 底部导航-->
    <%-- <%@include file="/front/footer.jsp" %> --%>
</div>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(function(){
	$(".register").Validform({
	tiptype:3,
	datatype:{
		},
	});  //就这一行代码！;
});
</script>
</body>
</html>