package com.bs.competition.control.front;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.bs.competition.control.util.FileUtil;
import com.bs.competition.control.util.SessionUtil;
import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.User;
import com.bs.competition.service.inf.IAdminService;
import com.bs.competition.service.inf.IStudentService;
import com.bs.competition.service.inf.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("front_studentAction")
@Scope("request")
public class StudentAction extends ActionSupport{
	
	@Resource(name = "front_studentServiceImpl")
	private IStudentService studentService;
	
	
	@Resource(name = "front_userServiceImpl")
	private IUserService userService;
	
	
	@Resource(name = "front_adminServiceImpl")
	private IAdminService adminService;
	
	
	private Student student = new Student();//学生实体类
	private FullStudent fullStudent = new FullStudent();//复杂的学生实体类
	private User user = new User();//用户实体类
	private StuApply stuApply = new StuApply();//报名学生实体类
	
	private String studentId;//学生id
	private String remark;//个人备注
	private String password;//密码
	private InputStream json;
	private String param;
	private String uploadFileName;// 上传文件名
	private File upload;// 上传图片
	private String actionurl; // 重定向
	private String card;//身份证号码
	private String stuApplyId;//学生报名信息的id
	private String currentUrl;//当前路径
	
	
	/**
	 * 查看学生个人详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String studentMyDetail() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		fullStudent = studentService.detailStudent(stu.getId());
		currentUrl = "student_studentMyDetail";
		return SUCCESS;
	}
	
	/**
	 * 修改学生个人信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String modifyStudentMy() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		fullStudent = studentService.detailStudent(stu.getId());
		currentUrl = "student_modifyStudentMy";
		return SUCCESS;
	}
	
	/**
	 * 执行修改个人信息
	 * @author luxinhuo
	 * @return "redirect"
	 * @throws Exception
	 */
	public String doModifyStudentMy() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		student.setId(studentId);
		student.setRemark(remark);
		
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 2048 * 2048 * 1;
			if (contentlength <= maximumLength) {
				Image img = new Image();
				img.setName(this.uploadFileName);
				img.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertImage(img);
				if (res > 0) {
					student.setImageid(img.getId());
				}
			} else {
				actionurl = "front_studentAction_modifyStudentMy?studentId="+studentId;
			}
		}
		
		user.setPassword(password);
		int res = studentService.modifyMySelfByEntity(student,user);
		if(res>0){
			student.setName(stu.getName());
			student.setIsapply(stu.getIsapply());
			if(student.getImageid()==null){
				student.setImageid(stu.getImageid());
			}
			ActionContext ac = ActionContext.getContext();
		    ac.getSession().put("student",student);
			actionurl = "front_studentAction_modifyStudentMy?studentId="+studentId;
		}else {
			actionurl = "front_studentAction_modifyStudentMy?studentId="+studentId;
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
		
		fullStudent = studentService.detailStudent(studentId);
		user=userService.getUserByPassword(param,fullStudent.getStudent().getUserid());
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
	 * 报名
	 * @author luxinhuo
	 * @return "redirect"
	 * @throws Exception
	 */
	public String stuApply() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		fullStudent = studentService.detailStudent(stu.getId());
		currentUrl = "student_stuApply";
		return SUCCESS;
	}
	
	/**
	 * 执行报名
	 * @author luxinhuo
	 * @return "redirect"
	 * @throws Exception
	 */
	public String doStuApply() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		
		stuApply.setStudentid(stu.getId());
		stuApply.setAddtime(new Date().getTime());
		stuApply.setCard(card);
		stuApply.setRemark(remark);
		java.util.Random random=new java.util.Random();// 定义随机类
		Integer groups = random.nextInt(3);// 返回[0,3)集合中的整数，注意不包括3
		int rec = studentService.getApplyByGroups(groups+1);
		while(rec>10){
			groups = random.nextInt(3);
		}
		stuApply.setGroups(groups+1);// +1后，[0,3)集合变为[1,4)集合，满足要求
		
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 4096 * 4096 * 1;
			if (contentlength <= maximumLength) {
				Files files = new Files();
				files.setName(this.uploadFileName);
				files.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertFile(files);
				if (res > 0) {
					stuApply.setFileid(files.getId());
				}
				res = studentService.apply(stuApply);
				if(res>0){
					stu.setIsapply(1);
					ActionContext ac = ActionContext.getContext();
				    ac.getSession().put("student",stu);
				    SessionUtil.setAlert("报名成功！");
				    actionurl = "front_studentAction_studentMyDetail?studentId="+stu.getId();
				}else {
					SessionUtil.setAlert("报名失败！");
					actionurl = "front_studentAction_stuApply?studentId="+stu.getId();
				}
			} else {
				SessionUtil.setAlert("您的文件过大，请重新上传！");
				actionurl = "front_studentAction_stuApply?studentId="+stu.getId();
			}
		}
		return "redirect";
	}
	
	/**
	 * 修改我的报名信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String modifyMyApply() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		fullStudent = studentService.detailStudent(stu.getId());
		currentUrl = "student_modifyMyApply";
		return SUCCESS;
	}
	
	
	/**
	 * 执行修改我的报名信息
	 * @author luxinhuo
	 * @return "redirect"
	 * @throws Exception
	 */
	public String doModifyMyApply() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		stuApply.setId(stuApplyId);
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 4096 * 4096 * 1;
			if (contentlength <= maximumLength) {
				Files files = new Files();
				files.setName(this.uploadFileName);
				files.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertFile(files);
				if (res > 0) {
					stuApply.setFileid(files.getId());
				}
				res = studentService.updateStuApplyByEntity(stuApply);
				if(res>0){
					SessionUtil.setAlert("修改成功！");
					actionurl = "front_studentAction_studentMyDetail?studentId="+stu.getId();
				}else {
					SessionUtil.setAlert("修改失败！");
					actionurl = "front_studentAction_modifyMyApply?studentId="+stu.getId();
				}
			} else {
				SessionUtil.setAlert("您的文件过大，请重新上传！");
				actionurl = "front_studentAction_modifyMyApply?studentId="+stu.getId();
			}
		}
		return "redirect";
	}
	
	/**
	 * 查看我的得分
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String myScore() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		fullStudent = studentService.detailStudent(stu.getId());
		currentUrl = "student_myScore";
		return SUCCESS;
	}
	
	/**
	 * 查看参赛学生的作品是否能修改（是否有评委老师已评分）
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String checkModify() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Student stu=(Student) session.getAttribute("student");
		int res = studentService.checkModify(stu.getId());
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	} 
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public FullStudent getFullStudent() {
		return fullStudent;
	}

	public void setFullStudent(FullStudent fullStudent) {
		this.fullStudent = fullStudent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public StuApply getStuApply() {
		return stuApply;
	}

	public void setStuApply(StuApply stuApply) {
		this.stuApply = stuApply;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getStuApplyId() {
		return stuApplyId;
	}

	public void setStuApplyId(String stuApplyId) {
		this.stuApplyId = stuApplyId;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	
}
