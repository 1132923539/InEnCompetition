<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStudent" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<FullStudent> listFullStudent = (List<FullStudent>)request.getAttribute("listFullStudent");
	PagingUtil pageing = (PagingUtil)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_studentlist.css">
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
                <span>注册学生列表</span>
            </div>
            <div class="content-middle2-search">
            	<form method="post" action="admin_adminAction_listAllStudent">
                    <span class="spanfind">姓名:&nbsp; 
						<input name="student.name" type="text" class="inputfind" > 
					</span>
					<span class="spanfind">删除状态:&nbsp;
						<select name="student.status" class="selectfind">
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
                    <div class="table-td-1">学生姓名</div>
                    <div class="table-td-2">学校名称</div>
                    <!-- <div class="table-td-1">评委老师</div> -->
                    <div class="table-td-1">状态</div>
                    <div class="table-td-3">操作</div>
                    <div class="clear"></div>
                </div>
                <%if(listFullStudent==null||listFullStudent.size()==0){ %>
                
                <%}else{ 
                	for(int i=0;i<listFullStudent.size();i++){
                %>
                <div class="table-tr-td">
                    <div class="table-td-11">
                        <%=listFullStudent.get(i).getStudent().getName() %>
                    </div>
                    <div class="table-td-22">
                        <%=listFullStudent.get(i).getSchool().getName() %>
                    </div>
                    <!-- <div class="table-td-11">
                        张老师
                    </div> -->
                    <div class="table-td-11">
                        <%if(listFullStudent.get(i).getStudent().getIsapply()==1){out.print("已报名");}else{out.print("未报名");} %>
                    </div>
                    <div class="table-td-222">
                        <div class="ck-details">
                            <a href="admin_adminAction_detailStudent?studentId=<%=listFullStudent.get(i).getStudent().getId()%>">查看信息</a>
                        </div>
                        <div class="ck-details2">
                            <%if(listFullStudent.get(i).getStudent().getStatus()==1){ %>
                            	<a href="javascript:void(0);" onclick="return delStudent('<%=listFullStudent.get(i).getStudent().getId()%>');">删除</a>
                            <%}else{ %>
                            	<a href="javascript:void(0);" onclick="return redStudent('<%=listFullStudent.get(i).getStudent().getId()%>');">还原</a>
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


<script type="text/javascript" src="<%=path%>/js/admin_listAllStudent.js"></script>

</body>
</html>