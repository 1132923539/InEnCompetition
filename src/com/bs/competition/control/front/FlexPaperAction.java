package com.bs.competition.control.front;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bs.competition.control.util.ConvertUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("front_flexPaperAction")
@Scope("request")
public class FlexPaperAction extends ActionSupport{

	private String filePath;
	private String pathName;
	private String swfPath;
	
	
	public String show(){
		swfPath = ConvertUtil.beginConvert(filePath,pathName);
		return SUCCESS;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getSwfPath() {
		return swfPath;
	}

	public void setSwfPath(String swfPath) {
		this.swfPath = swfPath;
	}

}
