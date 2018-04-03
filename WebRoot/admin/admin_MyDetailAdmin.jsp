<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/admin_admindetail.css">
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
                <span>大赛管理员详情</span>
            </div>
            <div class="content-middle2-content">
                <div class="content-middle3">
                    <div class="content-middle3-left">
                      姓名：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none"><%=ad.getName() %></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        性别：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%if(ad.getSex()==0){out.print("男");}else{out.print("女");} %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                        手机号：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%=ad.getMobliephone() %>
						</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="content-middle3">
                    <div class="content-middle3-left">
                       图片：
                    </div>
                    <div class="content-middle3-right">
                        <div class="content-middle3-right-none">
							<%if(ad.getImageid()==null){ %>
								<img  src="<%=path%>/img/head.jpg" width="150px" height="150px"/>
							<%}else{ %>
								<img  src="admin_adminAction_drawOneByNum?imageId=<%=ad.getImageid() %>" width="150px" height="150px"/>
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
                        <!--<input type="text" placeholder="姓名">-->
                        <div class="content-middle3-right-none">
                        	<%if(ad.getRemark()!=null){out.print(ad.getRemark());}else{out.print("");} %>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <!-- <div class="content-middle3 mt-80">
                    <button class="score-btn2" onclick="window.location.href='admin_adminAction_listAllAdmin'">返回</button>
                </div> -->
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
</script>
</body>
</html>