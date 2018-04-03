<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStuApply" %>
<%@ page import="com.bs.competition.control.util.TimeUtil"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    FullStuApply fullStuApply = (FullStuApply)request.getAttribute("fullStuApply");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/front_detailStuApply.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/page.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <title></title>
</head>
<body>
<div class="content">
	<%@include file="/front/navigation.jsp" %>
    <div class="content-middle">
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>作品详情</span>
            </div>
            <div class="content-middle2-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                      作品名：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
                        	<a href="javascript:void(0)" onclick="return checkDown('<%=fullStuApply.getFiles().getId()%>');">
                        		<%=fullStuApply.getFiles().getName() %>
                        	</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                
                <div class="content-middle3">
                    <div class="content-middle3-left">
                       作者：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%=fullStuApply.getStudent().getName() %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                       报名时间：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%=TimeUtil.dateFormateYMDHM(new Date(fullStuApply.getStuApply().getAddtime())) %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".nav-ul .nav-ul-li").hover(function(){
            $(this).find($(".drop-list")).show();
        },function(){
            $(this).find($(".drop-list")).hide();
        })
    })
    function checkDown(fileId){
		if(confirm("你确定要下载该作品吗？")){
			window.location.href="admin_adminAction_download?fileId="+fileId;
		}else{
			return false;
		}
	}
</script>
</body>
</html>