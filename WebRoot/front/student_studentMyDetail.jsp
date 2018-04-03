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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/mydetail.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title></title>
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
                <span>个人详情</span>
            </div>
            <div class="content-middle3-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        姓名：
                    </div>
                    <div class="content-middle3-right">
                        <!--<input type="text" placeholder="姓名">-->
                        <div class="content-middle3-right-none"><%=fullStudent.getStudent().getName() %></div>
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
                        <!--<input type="text" placeholder="学校">-->
                        <div class="content-middle3-right-none"><%=fullStudent.getSchool().getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        状态：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
                        	<%if(fullStudent.getStudent().getIsapply()==0){out.print("未报名");}else{out.print("已报名");} %>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <%if(fullStudent.getStudent().getIsapply()==1){ %>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        小组：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
                        	第<%=fullStudent.getStuApply().getGroups() %>组
                        </div>
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
                <%} %>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                       头像：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%if(fullStudent.getStudent().getImageid()==null){ %>
								<img  src="<%=path%>/img/head.jpg" width="150px" height="150px"/>
							<%}else{ %>
								<img  src="admin_adminAction_drawOneByNum?imageId=<%=fullStudent.getStudent().getImageid() %>" width="150px" height="150px"/>
							<%} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3 mt-80">
                    <div class="content-middle3-left">
                        备注：
                    </div>
                    <div class="content-middle3-right">
                        <!--<textarea type="text"></textarea>-->
                        <div class="content-middle3-right-none">
							<%if(fullStudent.getStudent().getRemark()!=null){out.print(fullStudent.getStudent().getRemark());}else{out.print("");} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                	<div class="content-middle3-right">
                		<a href="front_studentAction_stuApply"><button type="button" class="button2">报名</button></a>
                		<a href="front_studentAction_modifyStudentMy"><button type="button" class="btn1">修改</button></a>
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
<%@include file="/admin/alertUtil.jsp" %>
</body>
</html>