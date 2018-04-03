<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String swfPath = (String)request.getAttribute("swfPath");
    String endPath = swfPath.substring(61);
%>
<!DOCTYPE html>
<html>	
    <head> 
        <title></title>         
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
        <style type="text/css" media="screen"> 
			html, body	{ height:100%; }
			body { margin:0; padding:0; overflow:auto; }   
			#flashContent { display:none; }
        </style> 
		
		<script type="text/javascript" src="<%=path%>/js/flexPaper/swfobject/swfobject.js"></script>
		<script type="text/javascript" src="<%=path%>/js/flexPaper/flexpaper_flash.js"></script>
		<script type="text/javascript"> 
            var swfVersionStr = "10.0.0";
         /*    var xiSwfUrlStr = "playerProductInstall.swf"; */
            var xiSwfUrlStr = "";  //值可以任意
            var endPath = '<%=path%>/files/<%=endPath%>';
            var flashvars = { 
                  SwfFile : escape(endPath),   //swf文件路径   
                  /* SwfFile : escape("ilearn.swf"),   //swf文件路径  */
				  Scale : 0.6, 
				  ZoomTransition : "easeOut",
				  ZoomTime : 0.5,
  				  ZoomInterval : 0.1,
  				  FitPageOnLoad : false,
  				  FitWidthOnLoad : true,
  				  PrintEnabled : true,
  				  FullScreenAsMaxWindow : false,
  				  ProgressiveLoading : true,
  				  
  				  PrintToolsVisible : true,
  				  ViewModeToolsVisible : true,
  				  ZoomToolsVisible : true,
  				  FullScreenVisible : true,
  				  NavToolsVisible : true,
  				  CursorToolsVisible : true,
  				  SearchToolsVisible : true,
  				  
  				  localeChain: "en_US"
				  };
				  
			 var params = {
				
			    }
            params.quality = "high";
            params.bgcolor = "#ffffff";
            params.allowscriptaccess = "sameDomain";
            params.allowfullscreen = "true";
            var attributes = {};
            attributes.id = "FlexPaperViewer";
            attributes.name = "FlexPaperViewer";
            swfobject.embedSWF(
                "FlexPaperViewer.swf", "flashContent", 
                "800", "600",
                swfVersionStr, xiSwfUrlStr, 
                flashvars, params, attributes);
			swfobject.createCSS("#flashContent", "display:block;text-align:center;");
        </script> 
        
    </head> 
    <body> 
    	<div style="position:absolute;left:200px;top:10px;">
	        <div id="flashContent"> 
	       </div> 
        </div>
   </body> 
</html> 