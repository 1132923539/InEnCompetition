package com.bs.competition.control.front;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;
import com.bs.competition.service.inf.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller("front_userAction")
@Scope("request")
public class UserAction extends ActionSupport{

	
	@Resource(name = "front_userServiceImpl")
	private IUserService userService;
	
	private Student student = new Student();//学生实体类
	private Teacher teacher = new Teacher();//评委老师的实体类
	private User user = new User();//用户实体类
	private Admin admin = new Admin();//大赛管理员实体类
	
	private List<School> listSchool = new ArrayList<School>();
	
	private String name;//姓名
	private String mobliephone;//手机号
	private Integer sex;//性别
	private String schoolId;//学校
	private InputStream json;
	private String actionurl; // 重定向
	private String password;//登录密码
	
	
	/**
	 * 用户登录
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String login() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 实现用户登录
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String tologin() throws Exception{
		
		user.setUsername(name);
		user.setPassword(password);
		
		user=userService.queryUserByEntity(user);
		if (user!=null) {
			if(user.getType()==1){
				admin = userService.queryAdminByUserId(user.getId());
				ActionContext ac = ActionContext.getContext();
			    ac.getSession().put("admin",admin);
			    String adminId = admin.getId();
				String jsonString="{\"info\":\"admin\",\"adminId\":\""+adminId+"\"}";	
				this.json = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
			}else if(user.getType()==2){
				teacher = userService.queryTeacherByUserId(user.getId());
				ActionContext ac = ActionContext.getContext();
			    ac.getSession().put("teacher",teacher);
				String jsonString="{\"info\":\"teacher\"}";	
				this.json = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
			}else{
				student = userService.queryStudentByUserId(user.getId());
				ActionContext ac = ActionContext.getContext();
			    ac.getSession().put("student",student);
				String jsonString="{\"info\":\"student\"}";
				this.json = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
			}
		} else {
			String jsonString="{\"info\":\"fail\"}";	
			this.json = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 用户注册
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String register() throws Exception{
		
		listSchool = userService.getSchool();
		return SUCCESS;
	}
	
	/**
	 * 实现用户注册
	 * @author luxinhuo
	 * @return "redirect"
	 * @throws Exception
	 */
	public String toRegister() throws Exception{
		
		student.setName(name);
		student.setSex(sex);
		student.setMobliephone(mobliephone);
		student.setSchoolid(schoolId);
		student.setStatus(1);
		student.setAddtime(new Date().getTime());
		student.setIsapply(0);
		
		user.setPassword(password);
		user.setType(3);
		user.setUsername(name);

		int res=userService.insertUserByEntity(student,user);
		if (res>0) {
			actionurl = "front_userAction_login";
		} else {
			actionurl = "front_userAction_register";
		}
		return "redirect";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public InputStream getJson() {
		return json;
	}

	public void setJson(InputStream json) {
		this.json = json;
	}

	public String getActionurl() {
		return actionurl;
	}

	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobliephone() {
		return mobliephone;
	}

	public void setMobliephone(String mobliephone) {
		this.mobliephone = mobliephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<School> getListSchool() {
		return listSchool;
	}

	public void setListSchool(List<School> listSchool) {
		this.listSchool = listSchool;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
