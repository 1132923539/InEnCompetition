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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_tealist.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
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
                <span>评委老师列表</span>
                <div class="addtea"><a href="admin_adminAction_addTeacher">新增评委老师</a></div>
            </div>
            <div class="content-middle2-search">
            	<form method="post" action="admin_adminAction_listAllTeacher">
                    <span class="spanfind">姓名:&nbsp; 
						<input name="teacher.name" type="text" class="inputfind" > 
					</span>
					<span class="spanfind">删除状态:&nbsp;
						<select name="teacher.status" class="selectfind">
							<option value="">-请选择-</option>
							<option value="0">已删除</option>
							<option value="1">未删除</option>
							<option value="3">查询所有</option>
						</select>
					</span> 
					<span class="spanfind">
						<button type="submit" class="btn-default">
							<i class="icon-search"></i>搜索
						</button> 
					</span>
            	</form>
            </div>
            <div class="content-middle2-content">
                <div class="table-tr-th">
                    <div class="table-td-1">老师姓名</div>
                    <div class="table-td-2">学校</div>
                    <div class="table-td-1">小组</div>
                    <div class="table-td-1">状态</div>
                    <div class="table-td-3">操作</div>
                    <div class="clear"></div>
                </div>
                <%if(listFullTeacher==null||listFullTeacher.size()==0){ %>
                
                <%}else{
                	for(int i=0;i<listFullTeacher.size();i++){
                 %>
                <div class="table-tr-td">
                    <div class="table-td-11">
                        <%=listFullTeacher.get(i).getTeacher().getName() %>
                    </div>
                    <div class="table-td-22">
                        <%=listFullTeacher.get(i).getSchool().getName() %>
                    </div>
                    <div class="table-td-11">
                        第<%=listFullTeacher.get(i).getTeacher().getGroups()%>组
                    </div>
                    <div class="table-td-11">
                        <%if(listFullTeacher.get(i).getTeacher().getStatus()==0){ 
                        	out.print("已删除");}else{out.print("显示");}
                        %>
                    </div>
                    <div class="table-td-222">
                        <div class="ck-details">
                            <a href="admin_adminAction_detailTeacher?teacherId=<%=listFullTeacher.get(i).getTeacher().getId()%>&num=<%=pageing.getCurrentPage()%>">查看信息</a>
                        </div>
                        <div class="ck-details2">
                            <%-- <a href="admin_adminAction_delTeacher?teacherId=<%=listFullTeacher.get(i).getTeacher().getId()%>">删除</a> --%>
                            <%if(listFullTeacher.get(i).getTeacher().getStatus()==1){ %>
                            	<a href="javascript:void(0);" onclick="return delTeacher('<%=listFullTeacher.get(i).getTeacher().getId()%>');">删除</a>
                        	<%}else{ %>
                        		<a href="javascript:void(0);" onclick="return redTeacher('<%=listFullTeacher.get(i).getTeacher().getId()%>');">还原</a>
                        	<%} %>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <%}} %>
                
                <%@include file="/admin/page.jsp" %>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/admin_listAllTeacher.js"></script>

</body>
</html>