package com.bs.competition.control.util;

/**
 * Description:产生二维码的工具类
 * 
 * @author chenmengqiu
 */
public class ToolsUtil {

	/**
	 * 检测字符串是否不为空(null,"","null")
	 * 
	 * @author chenmengqiu
	 * @param s
	 *            字符串
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s) {
		return s != null && !"".equals(s) && !"null".equals(s);
	}

}