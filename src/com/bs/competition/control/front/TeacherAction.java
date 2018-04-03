package com.bs.competition.control.front;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.bs.competition.control.util.FileUtil;
import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;
import com.bs.competition.paramEntity.StuApplyParam;
import com.bs.competition.service.inf.IAdminService;
import com.bs.competition.service.inf.ITeacherService;
import com.bs.competition.service.inf.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("front_teacherAction")
@Scope("request")
public class TeacherAction extends ActionSupport{
	
	@Resource(name = "front_teacherServiceImpl")
	private ITeacherService teacherService;
	
	
	@Resource(name = "front_userServiceImpl")
	private IUserService userService;
	
	
	@Resource(name = "front_adminServiceImpl")
	private IAdminService adminService;
	
	
	private Teacher teacher = new Teacher();//指导老师的实体类
	private FullTeacher fullTeacher = new FullTeacher();//复杂的指导老师的实体类
	private User user = new User();//用户实体类
	private PagingUtil page = new PagingUtil();//分页
	private List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();//学生报名情况列表
	private StuApply stuApply = new StuApply();//学生报名表
	private FullStuApply fullStuApply = new FullStuApply();//复杂的学生报名详情
	private Score score = new Score();//老师评分实体类
	private StuApplyParam  stuApplyParam = new StuApplyParam();
	
	private String teacherId;//指导老师的id
	private String remark;//个人备注
	private String password;//密码
	private InputStream json;
	private String param;
	private String uploadFileName;// 上传文件名
	private File upload;// 上传图片
	private String actionurl; // 重定向
	private String currentUrl;//当前路径
	private String currentPage;//当前页
	private String stuApplyId;//报名学生的id
	private Integer newscore;//创新分数
	private Integer prascore;//实用性分数
	private Integer feascore;//可行性分数
	private String studentId;//学生id
	
	
	/**
	 * 查看指导老师的个人信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String teacherMyDetail() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");
		
		fullTeacher = teacherService.getTeacherById(tea.getId());
		currentUrl = "teacher_teacherMyDetail";
		return SUCCESS;
	}
	
	/**
	 * 修改指导老师的个人信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String modifyTeacherMy() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");
		
		fullTeacher = teacherService.getTeacherById(tea.getId());
		currentUrl = "teacher_modifyTeacherMy";
		return SUCCESS;
	}
	
	/**
	 * 执行修改指导老师的个人信息
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String doModifyTeacherMy() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");
		
		tea.setId(teacherId);
		tea.setRemark(remark);
		
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 2048 * 2048 * 1;
			if (contentlength <= maximumLength) {
				Image img = new Image();
				img.setName(this.uploadFileName);
				img.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertImage(img);
				if (res > 0) {
					tea.setImageid(img.getId());
				}
			} else {
				actionurl = "front_teacherAction_modifyTeacherMy?teacherId="+teacherId;
			}
		}
		
		user.setPassword(password);
		
		int res = teacherService.modifyMySelfByEntity(tea,user);
		if (res>0) {
//			teacher.setName(tea.getName());
//			if(teacher.getImageid()==null){
//				teacher.setImageid(tea.getImageid());
//			}
			ActionContext ac = ActionContext.getContext();
		    ac.getSession().put("teacher",tea);
			actionurl = "front_teacherAction_modifyTeacherMy?teacherId="+teacherId;
		} else {
			actionurl = "front_teacherAction_modifyTeacherMy?teacherId="+teacherId;
		}
		return "redirect";
	}

	/**
	 * 验证原始密码是否正确
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String checkPassword() throws Exception{
		
		fullTeacher = teacherService.getTeacherById(teacherId);
		user=userService.getUserByPassword(param,fullTeacher.getTeacher().getUserid());
		if(user!=null){
			String jsonString="{\"info\":\"验证通过\",\"status\":\"y\"}";					
			this.json = new ByteArrayInputStream(jsonString.getBytes("utf-8"));
		}else{
			String jsonString="{\"info\":\"原始密码错误,请重新输入\",\"status\":\"n\"}";			
			this.json = new ByteArrayInputStream(jsonString.getBytes("utf-8"));
		}
		return "ajaxjson";	   
	}
	
	/**
	 * 报名学生列表
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listStuApplyStudent() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");

		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		stuApplyParam.setGroups(tea.getGroups());
		stuApplyParam.setTeacherId(tea.getId());
		int recordCnt = teacherService.getStuApplyStudentCountBy(stuApplyParam);
		page.setTotalNumber(recordCnt);
		page.setParam(stuApplyParam);
		
		listFullStuApply = teacherService.getPagingByStuApplyStudentParam(page);
		currentUrl = "teacher_listStuApplyStudent";
		return SUCCESS;
	}
	
	/**
	 * 查看报名学生的详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailStuApplyStudent() throws Exception{
		
		fullStuApply = teacherService.getStuApplyStudent(stuApplyId);
		return SUCCESS;
	}
	
	/**
	 * 对学生进行评分
	 * @author luxinhuo
	 * @return ajaxjson
	 * @throws Exception
	 */
	public String addScore() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");

		score.setAddtime(new Date().getTime());
		score.setStudentid(studentId);
		score.setTeacherid(tea.getId());
		score.setNewscore(newscore*100);
		score.setPrascore(prascore*100);
		score.setFeascore(feascore*100);

		int res = teacherService.addScore(score);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public FullTeacher getFullTeacher() {
		return fullTeacher;
	}

	public void setFullTeacher(FullTeacher fullTeacher) {
		this.fullTeacher = fullTeacher;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InputStream getJson() {
		return json;
	}

	public void setJson(InputStream json) {
		this.json = json;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getActionurl() {
		return actionurl;
	}

	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public PagingUtil getPage() {
		return page;
	}

	public void setPage(PagingUtil page) {
		this.page = page;
	}

	public List<FullStuApply> getListFullStuApply() {
		return listFullStuApply;
	}

	public void setListFullStuApply(List<FullStuApply> listFullStuApply) {
		this.listFullStuApply = listFullStuApply;
	}

	public StuApply getStuApply() {
		return stuApply;
	}

	public void setStuApply(StuApply stuApply) {
		this.stuApply = stuApply;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public FullStuApply getFullStuApply() {
		return fullStuApply;
	}

	public void setFullStuApply(FullStuApply fullStuApply) {
		this.fullStuApply = fullStuApply;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getStuApplyId() {
		return stuApplyId;
	}

	public void setStuApplyId(String stuApplyId) {
		this.stuApplyId = stuApplyId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getNewscore() {
		return newscore;
	}

	public void setNewscore(Integer newscore) {
		this.newscore = newscore;
	}

	public Integer getPrascore() {
		return prascore;
	}

	public void setPrascore(Integer prascore) {
		this.prascore = prascore;
	}

	public Integer getFeascore() {
		return feascore;
	}

	public void setFeascore(Integer feascore) {
		this.feascore = feascore;
	}
	
}
