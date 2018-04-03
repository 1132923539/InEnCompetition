<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/support.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/font-awesome-4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" src="<%=path%>/js/jquery-1.11.3.min.js"></script>
    <title>政策标准</title>
</head>
<body>
<%@include file="/front/head.jsp" %>
<div class="content">
    <%@include file="/front/navigation.jsp" %>

    <div class="content-main">
        <div class="content-main-left">
            <div class="content-main-left-top">
                <div class="content-main-left-top-title">
                    创业政策
                </div>
                <div class="content-main-left-top-content">
                    <ul>
                        <li class="color" onclick="window.location.href='front_indexAction_support';">政策标准</li>
                        <li onclick="window.location.href='front_indexAction_consultation';">创业咨询</li>
                    </ul>
                </div>
            </div>
            <div class="content-main-left-bottom">
                <div class="content-main-left-bottom-1">
                    <span>联系方式：</span>
                </div>
                <div class="content-main-left-bottom-1">
                    <span>E-mail:1111111111@qq.com</span>
                </div>
                <div class="content-main-left-bottom-1">
                    <span>通讯地址：</span>
                </div>
            </div>
        </div>
        <div class="content-main-right">
            <div class="content-main-right-title">
                <span>当前位置：</span>
                <span>大学生创新创业大赛</span>
                <span>></span>
                <span>政策标准</span>
            </div>
            <div class="content-main-right-title1">
                <span>政策标准</span>
            </div>
            <div class="content-main-right-content1">
                	（一）大学毕业生在毕业后两年内自主创业，到创业实体所在地的工商部门办理营业执照，注册资金（本）在50万元以下的，允许分期到位，首期到位资金不低于注册资本的10%（出资额不低于3万元），1年内实缴注册资本追加到50%以上，余款可在3年内分期到位。
            </div>
            <div class="content-main-right-content1">
                	（二）大学毕业生新办咨询业、信息业、技术服务业的企业或经营单位，经税务部门批准，免征企业所得税两年；新办从事交通运输、邮电通讯的企业或经营单位，经税务部门批准，第一年免征企业所得税，第二年减半征收企业所得税；新办从事公用事业、商业、物资业、对外贸易业、旅游业、物流业、仓储业、居民服务业、饮食业、教育文化事业、卫生事业的企业或经营单位，经税务部门批准，免征企业所得税一年。
            </div>
            <div class="content-main-right-content1">
                	（三）各国有商业银行、股份制银行、城市商业银行和有条件的城市信用社要为自主创业的毕业生提供小额贷款，并简化程序，提供开户和结算便利，贷款额度在2万元左右。贷款期限最长为两年，到期确定需延长的，可申请延期一次。贷款利息按照中国人民银行公布的贷款利率确定，担保最高限额为担保基金的5倍，期限与贷款期限相同。
            </div>
            <div class="content-main-right-content1">
                	（四）政府人事行政部门所属的人才中介服务机构，免费为自主创业毕业生保管人事档案（包括代办社保、职称、档案工资等有关手续）2年；提供免费查询人才、劳动力供求信息，免费发布招聘广告等服务；适当减免参加人才集市或人才劳务交流活动收费；优惠为创办企业的员工提供一次培训、测评服。
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>


<!-- 底部导航-->
<%-- <%@include file="/front/footer.jsp" %>
 --%>
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