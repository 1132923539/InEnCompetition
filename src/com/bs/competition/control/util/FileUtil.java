package com.bs.competition.control.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

/**
 * Description:文件相关操作类
 * 
 * @author luxinhuo
 */
public class FileUtil {

	// 定义允许上传的文件扩展名
	public static HashMap<String, String> extMap = new HashMap<String, String>();
	static {
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		// extMap.put("media",
		// "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("media", "flv,f4v,mp4");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}

	/**
	 * 根据文件实体获取文件的byte
	 * 
	 * @author luxinhuo
	 * @return byte[]
	 */
	public static byte[] getContent(File file) throws IOException {
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		fi.close();
		return buffer;
	}

	/**
	 * 根据文件路径获取文件的byte
	 * 
	 * @author luxinhuo
	 * @return byte[]
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		return getContent(file);
	}

	/**
	 * 获取文件的byte
	 * 
	 * @author luxinhuo
	 * @return byte[]
	 */
	public static byte[] getByteInFile(File file) throws IOException {
		return getContent(file);
	}

	/**
	 * 获取文件的类型
	 * 
	 * @author luxinhuo
	 * @return type 1-图片，2-音视频，3-文件
	 */
	public static int getFileIntType(String dirName) throws IOException {
		if (ToolsUtil.notEmpty(dirName)) {
			if (dirName.equalsIgnoreCase("image")) {
				return 1;
			}
			if (dirName.equalsIgnoreCase("flash")
					|| dirName.equalsIgnoreCase("media")) {
				return 2;
			}
			if (dirName.equalsIgnoreCase("file")) {
				return 3;
			}
			return 0;

		} else {
			return 0;
		}
	}

	/**
	 * 根据文件名获取文件的后缀
	 * 
	 * @author luxinhuo
	 * @return String
	 */
	public static String getFileExt(String name) throws IOException {
		if (!ToolsUtil.notEmpty(name)) {
			return null;
		}
		return name.substring(name.lastIndexOf(".") + 1).toLowerCase();
	}

	/**
	 * 根据文件后缀获取文件的类型
	 * 
	 * @author luxinhuo
	 * @return String : image-图片，flash，media-视频，file-文件
	 */
	public static String getFileType(String ext) throws IOException {
		if (!ToolsUtil.notEmpty(ext)) {
			return null;
		} else {
			Set<String> type = extMap.keySet();
			for (String i : type) {
				if (Arrays.<String> asList(extMap.get(i).split(",")).contains(
						ext)) {
					return i;
				}
			}
			return null;
		}
	}

	/**
	 * 异步上传文件获取上传的文件
	 * 
	 * @param request
	 *            request请求
	 * @param filename
	 *            文件变量名
	 * @author luxinhuo
	 * @return Map<String,File>
	 */
	public static Map<String, File> getFileFromAjax(HttpServletRequest request,
			String filename) throws IOException {
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
		// 获得上传的文件名
		String[] fileName = wrapper.getFileNames(filename);// imgFile,imgFile,imgFile
		// 获得文件过滤器
		File[] file = wrapper.getFiles(filename);
		if (fileName == null || file == null) {
			return null;
		}
		int len = file.length;
		if (len > 0) {
			Map<String, File> back = new HashMap<String, File>();
			for (int i = 0; i < len; i++) {
				back.put(fileName[i], file[i]);
			}
			return back;
		} else {
			return null;
		}
	}

	/**
	 * 异步上传文件获取上传的文件(默认路径)
	 * 
	 * @param request
	 *            request请求
	 * @author luxinhuo
	 * @return Map<String,File>
	 */
	public static Map<String, File> getFileFromAjax(HttpServletRequest request)
			throws IOException {
		return getFileFromAjax(request, "fileList");
	}
	
	/**
	 * 异步上传文件获取主图的文件
	 * 
	 * @param request
	 *            request请求
	 * @param filename
	 *            文件变量名
	 * @author luxinhuo
	 * @return Map<String,File>
	 */
	public static Map<String, File> getMainFileFromAjax(HttpServletRequest request) throws IOException {
		return getFileFromAjax(request, "imageMain");
	}
}
