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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_listAllStuApplyStudent.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>报名学生列表</title>
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
                <span>报名学生列表</span>
            </div>
            <div class="content-middle2-search">
            	<form method="post" action="admin_adminAction_listAllStuApplyStudent">
					<span class="spanfind">小组:&nbsp;
						<select name="stuApply.groups" class="selectfind">
							<option value="">-请选择-</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
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
                    <div class="table-td-2">学生姓名</div>
                    <div class="table-td-2">作品名称</div>
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
                        <%=listFullStuApply.get(i).getFiles().getName() %>
                    </div>
                    <div class="table-td-11">
                       <%if(listFullStuApply.get(i).getStudent().getScore()!=null){out.print("已统计");}else{out.print("未统计");} %>
                    </div>
                    <div class="table-td-222">
                        <div class="ck-details">
                            <a href="admin_adminAction_detailStuApplyStudent?stuApplyId=<%=listFullStuApply.get(i).getStuApply().getId()%>">查看信息</a>
                        </div>
                        <div class="ck-details2">
                            <!-- <a class="top-up-btn">评分</a> -->
                            <a href="javascript:void(0)" onclick="check(<%=listFullStuApply.get(i).getIsScore()%>,'<%=listFullStuApply.get(i).getStuApply().getStudentid()%>')">统计分数</a>
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
<script type="text/javascript">
    $(function(){
        $(".nav-ul .nav-ul-li").hover(function(){
            $(this).find($(".drop-list")).show();
        },function(){
            $(this).find($(".drop-list")).hide();
        })
    })
    function check(isScore,studentId){
    	if(isScore==1){
    		alert("您已经统计过该分数，请不要重复统计");
    		return false;
    	}else{
    		window.location.href="admin_adminAction_accountScore?studentId="+studentId;
    	}
    }
</script>
</body>
</html>