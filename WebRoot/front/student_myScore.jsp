<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bs.competition.entity.complex.FullStudent" %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	FullStudent fullStudent = (FullStudent)request.getAttribute("fullStudent");
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/myscore.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>参赛学生-查看我的得分</title>
</head>
<body>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-middle">
        <%@include file="/front/student_left.jsp" %>
        
        <div class="content-middle2">
            <div class="content-middle2-title">
                <span>参赛学生</span>
                <span>|</span>
                <span>我的得分</span>
            </div>
            <div class="content-middle3-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        姓名：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=fullStudent.getStudent().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        性别：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
                        	<%if(fullStudent.getStudent().getSex()==0){out.print("男");}else{out.print("女");} %>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        学校：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=fullStudent.getSchool().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        身份证号：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%String card = fullStudent.getStuApply().getCard();
                           	  card = card.substring(0,3)+"*****************"+card.substring(15,18);
                           	%>
                           	<%=card %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="content-middle3">
                    <div class="content-middle3-left">
                        我的作品：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><a href=""><%=fullStudent.getFiles().getName() %></a></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        新颖性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStudent.getStudent().getNewscore())/100 %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        实用性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStudent.getStudent().getPrascore())/100 %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        可行性得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStudent.getStudent().getFeascore())/100 %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        综合得分：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=(double)(fullStudent.getStudent().getScore())/100 %></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %> --%>

<script type="text/javascript">
    $(function(){
        $(".nav-ul .nav-ul-li").hover(function(){
            $(this).find($(".drop-list")).show();
        },function(){
            $(this).find($(".drop-list")).hide();
        })
    })
</script>
</body>
</html>