<%-- <%@ page language="java" pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/page.css">
<script src="<%=request.getContextPath()%>/js/pageing.js"></script>
	<form action="" id="pageingForm" method="post">
	<!-- paging -->
	<input type="hidden" name="currentPage" id="pageingCurPage" value="<%=pageing.getCurrentPage()%>" />
          <div class="section-second-paging clear mt-30 mb-80" style="float:right;">
              <div class="fr">
                  <div class="second-paging-btn second-paging-btn1"><button type="button" type="button" class="common-font">第<%=pageing.getCurrentPage()%>页</button></div>
                  <div class="second-paging-btn second-paging-btn2">
                  	<button type="button" class="common-font ml-15" style="width:100px;">共<%=pageing.getTotalNumber()%>记录</button>
                      <button type="button" class="common-font ml-15">共<%=pageing.getTotalPage()%>页</button>
                      <button class="common-font ml-15" type="button" onclick="firstPage()">首页</button>
                      <button class="common-font ml-15" type="button" onclick="perPage();">上一页</button>
                  </div>
                  <div class="second-paging-btn ml-15 second-paging-btn3">
                      <input type="text" name="gopagenum" id="gopagenum"/>
                      <button class="common-font" type="button" onclick="goPage(<%=pageing.getCurrentPage()+1%>);">转</button>
				  </div>

                  <div class="second-paging-btn second-paging-btn2">
                      <button class="common-font ml-15" type="button" onclick="nextPage(<%=pageing.getCurrentPage()+1%>);">下一页</button>
                      <button class="common-font ml-15" type="button" onclick="lastPage(<%=pageing.getCurrentPage()+1%>);">尾页</button>
                  </div>
              </div>
              <div class="clear"></div>
          </div>
      </form>
 --%>