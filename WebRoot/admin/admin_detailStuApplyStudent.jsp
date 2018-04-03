<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStuApply" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	FullStuApply fullStuApply = (FullStuApply)request.getAttribute("fullStuApply");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_stuApplydetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>报名学生的详情</title>
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
                    <span>报名学生详情</span>
                </div>
            <div class="content-middle2-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        姓名：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=fullStuApply.getStudent().getName() %></div>
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
							<%if(fullStuApply.getStudent().getSex()==0){out.print("男");}else{out.print("女");} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        身份证号：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="text" placeholder="姓名">-->
                        <div class="content-middle3-right-none">
							<%String card = fullStuApply.getStuApply().getCard();
                           	  card = card.substring(0,3)+"*****************"+card.substring(15,18);
                           	%>
                           	<%=card %>
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
                        <div class="content-middle3-right-none"><%=fullStuApply.getSchool().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        作品：
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
                <%if(fullStuApply.getStudent().getScore()!=null){ %>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        新颖性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStuApply.getStudent().getNewscore())/100 %>分</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        实用性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStuApply.getStudent().getPrascore())/100 %>分</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        可行性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStuApply.getStudent().getFeascore())/100 %>分</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        综合得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStuApply.getStudent().getScore())/100 %>分</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <%} %>
                <div class="content-middle3">
                    <button class="score-btn2" onclick="window.location.href='admin_adminAction_listAllStuApplyStudent'">返回</button>
                </div>
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