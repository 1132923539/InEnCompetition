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
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/modifyworks.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/valid.css">
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
                <span>修改我的作品</span>
            </div>
            <form id="modifyApply" class="modifyApply" method="post" action="front_studentAction_doModifyMyApply?stuApplyId=<%=fullStudent.getStuApply().getId() %>" enctype="multipart/form-data">
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
	                        <div class="content-middle3-right-none"><%if(fullStudent.getStudent().getSex()==0){out.print("男");}else{out.print("女");} %></div>
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
		                    <div class="content-middle3-right-none">
								<%=fullStudent.getFiles().getName() %>
								<input class="uploadImage1" id="upI1" type="file" name="upload" onchange="PreviewImage();">
							</div>
						</div>
	                    <div class="clear"></div>
	                </div>
	                <div class="apply">
	                    <button type="submit" class="button2" onclick="return check();">提交</button>
	                </div>
	                <div class="clear"></div>
	            </div>
	         </form>
        </div>
        <div class="clear"></div>
    </div>
</div>

<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %>
 --%>
<script type="text/javascript" src="<%=path%>/js/student_modifyMyApply.js"></script>
<%@include file="/admin/alertUtil.jsp" %>
</body>
</html>