<%@page import="com.bs.competition.control.util.SessionUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%
  String str=SessionUtil.getAlert();
if(str!=null && str!="")
{
SessionUtil.deleteAlert();
 %>
 <script type="text/javascript">
     alert("<%=str%>");
</script>
 <%} %>
