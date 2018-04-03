<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStuApply" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<FullStuApply> listFullStuApply = (List<FullStuApply>)request.getAttribute("listFullStuApply");
	PagingUtil pageing = (PagingUtil)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/studentlist.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>报名学生列表</title>
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
                <span>报名学生列表</span>
            </div>
            <div class="content-middle2-content">
                <div class="table-tr-th">
                    <div class="table-td-2">学生姓名</div>
                    <div class="table-td-2">学校名称</div>
                    <div class="table-td-1">状态</div>
                    <div class="table-td-2">操作</div>
                    <div class="clear"></div>
                </div>
                <% if(listFullStuApply==null||listFullStuApply.size()==0){%>
                	
                <% }else{
                 for(int i=0;i<listFullStuApply.size();i++){ %>
                <div class="table-tr-td">
                    <div class="table-td-22">
                        <%=listFullStuApply.get(i).getStudent().getName() %>
                    </div>
                    <div class="table-td-22">
                        <%=listFullStuApply.get(i).getSchool().getName() %>
                    </div>
                    <div class="table-td-11">
                       <%if(listFullStuApply.get(i).getIsScore()==1){out.print("已评分");}else{out.print("未评分");} %>
                    </div>
                    <div class="table-td-222">
                        <div class="ck-details">
                            <a href="front_teacherAction_detailStuApplyStudent?stuApplyId=<%=listFullStuApply.get(i).getStuApply().getId()%>">查看信息</a>
                        </div>
                        <div class="ck-details2">
                            <!-- <a class="top-up-btn">评分</a> -->
                            <a href="javascript:void(0)" onclick="addScore('<%=listFullStuApply.get(i).getStuApply().getStudentid()%>',<%=listFullStuApply.get(i).getIsScore()%>)">评分</a>
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

<div class="hvt_addr">
    <div class="hvt_addr_top">
        <span>评分</span>
        <span class="close-img">
            <img src="<%=path %>/img/close.png">
        </span>
    </div>
    <div class="form-box">
        <form action="" method="post" id="addScore" class="addScore">
         	<input type="hidden" name="studentId" id="studentId">
            <div class="form-group clear">
                <div class="form-group-left">
                    新颖性：
                </div>
                <div class="form-group-right">
                    <input type="text" class="form-control" placeholder="请输入新颖性分数，最多10分" name="newscore" id="newscore">
                </div>
                <div class="clear"></div>
            </div>
            <div class="form-group clear">
                <div class="form-group-left">
                    实用性：
                </div>
                <div class="form-group-right">
                    <input type="text" class="form-control" placeholder="请输入实用性分数，最多10分" name="prascore" id="prascore">
                </div>
                <div class="clear"></div>
            </div>
            <div class="form-group clear">
                <div class="form-group-left">
                    可行性：
                </div>
                <div class="form-group-right">
                    <input type="text" class="form-control" placeholder="请输入可行性分数，最多10分" name="feascore" id="feascore">
                </div>
                <div class="clear"></div>
            </div>
            <div class="form-group clear mt-30">
                <div class="form-group-right">
                    <a onclick="check();" class="save-btn">确认</a>
                    <a class="cancel-btn">取消</a>
                </div>
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>
<div class="mask"></div>


<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %> --%>

<script type="text/javascript" src="<%=path%>/js/teacher_listStuApplyStudent.js"></script>
</body>
</html>