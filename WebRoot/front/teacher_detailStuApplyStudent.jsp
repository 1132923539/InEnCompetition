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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/studentdetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>报名学生的详情</title>
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
                    <button class="score-btn top-up-btn" onclick="addScore('<%=fullStuApply.getStuApply().getStudentid()%>',<%=fullStuApply.getIsScore()%>)">评分</button>
                    <button class="score-btn2" onclick="window.location.href='front_teacherAction_listStuApplyStudent'">返回</button>
                </div>
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
                    <input type="text" class="form-control" placeholder="请输入创新分数，最多10分" name="newscore" id="newscore">
                </div>
                <div class="clear"></div>
            </div>
            <div class="form-group clear">
                <div class="form-group-left">
                    实用性：
                </div>
                <div class="form-group-right">
                    <input type="text" class="form-control" placeholder="请输入创新分数，最多10分" name="prascore" id="prascore">
                </div>
                <div class="clear"></div>
            </div>
            <div class="form-group clear">
                <div class="form-group-left">
                    可行性：
                </div>
                <div class="form-group-right">
                    <input type="text" class="form-control" placeholder="请输入创新分数，最多10分" name="feascore" id="feascore">
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

<script type="text/javascript" src="<%=path%>/js/teacher_detailStuApplyStudent.js"></script>
</body>
</html>