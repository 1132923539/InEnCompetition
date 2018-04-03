<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStuApply" %>
<%@ page import="com.bs.competition.control.util.PagingUtil" %>
<%@ page import="com.bs.competition.control.util.TimeUtil"%>
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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/front_listAllStuApply.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
</head>
<body>
<div class="content">
	<%@include file="/front/navigation.jsp" %>
    <div class="content-middle">
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>作品列表</span>
            </div>
            
            <div class="content-middle2-content">
                <div class="table-tr-th">
                    <div class="table-td-2">作者</div>
                    <div class="table-td-2">作品名</div>
                    <div class="table-td-3">报名时间</div>
                    <div class="table-td-3">操作</div>
                    <div class="clear"></div>
                </div>
                <%if(listFullStuApply==null||listFullStuApply.size()==0){ %>
                
                <%}else{ 
                	for(int i=0;i<listFullStuApply.size();i++){
                %>
                <div class="table-tr-td">
                    <div class="table-td-22">
                        <%=listFullStuApply.get(i).getStudent().getName() %>
                    </div>
                    <div class="table-td-22">
                        <%=listFullStuApply.get(i).getFiles().getName() %>
                    </div>
                    <div class="table-td-33">
                        <%=TimeUtil.dateFormateYMDHM(new Date(listFullStuApply.get(i).getStuApply().getAddtime()))%>
                    </div>
                    <div class="table-td-222">
                        <div class="ck-details">
                            <a href="front_indexAction_detailStuApply?stuApplyId=<%=listFullStuApply.get(i).getStuApply().getId()%>">查看信息</a>
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


<%@include file="/admin/alertUtil.jsp" %>
</body>
</html>