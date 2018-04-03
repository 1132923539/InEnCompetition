package com.bs.competition.control.admin;

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
import com.bs.competition.control.util.SessionUtil;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullScore;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.News;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;
import com.bs.competition.service.inf.IAdminService;
import com.bs.competition.service.inf.IStudentService;
import com.bs.competition.service.inf.ITeacherService;
import com.bs.competition.service.inf.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("admin_adminAction")
@Scope("request")
public class AdminAction extends ActionSupport{
	
	
	@Resource(name = "front_adminServiceImpl")
	private IAdminService adminService;
	
	
	@Resource(name = "front_userServiceImpl")
	private IUserService userService;
	
	
	@Resource(name = "front_studentServiceImpl")
	private IStudentService studentService;
	
	
	@Resource(name = "front_teacherServiceImpl")
	private ITeacherService teacherService;
	
	
	private Teacher teacher = new Teacher();//教师的实体类
	private User user = new User();//用户的实体类
	private FullTeacher fullTeacher= new FullTeacher();//复杂的教师实体类
	private Student student = new Student();//学生实体类
	private FullStudent fullStudent = new FullStudent();//复杂的学生实体类
	private News news = new News();//消息的实体类
	private FullNews fullNews = new FullNews();//复杂的消息实体类
	private Image image = new Image();//图片的实体类
	private Teacher tea = new Teacher();//评委老师的实体类
	private Admin admin = new Admin();//大赛管理员实体类
	private StuApply stuApply = new StuApply();//学生报名表
	private FullStuApply fullStuApply = new FullStuApply();//复杂的学生报名详情
	private FullScore fullScore = new FullScore();//统计得分的复杂实体
	private Files files = new Files();//文件的实体类
	
	private List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();//学生报名情况列表
	private List<School> listSchool = new ArrayList<School>();//学校的实体类列表
	private List<FullTeacher> listFullTeacher = new ArrayList<FullTeacher>();//老师的复杂实体类列表
	private List<FullStudent> listFullStudent = new ArrayList<FullStudent>();//学生的复杂实体类列表
	private List<FullNews> listFullNews = new ArrayList<FullNews>();//大赛新闻的复杂实体类列表
	private List<Admin> listAdmin = new ArrayList<Admin>();//大赛管理员的实体类列表
	private List<FullScore> listFullScore = new ArrayList<FullScore>();//统计得分的复杂实体类列表
	private PagingUtil page = new PagingUtil();//分页
	
	private InputStream json;
	private String actionurl; // 重定向
	private String teacherId;//教师id
	private String name;//教师姓名
	private Integer sex;//教师性别
	private String mobliephone;//手机号
	private String schoolId;//学校id
	private String remark;//备注
	private String password;//密码
	private String currentPage;//当前页
	private String totalNumber;//总条数
//	private String totalPage;//总页数
	private String studentId;//学生id
	private String currentUrl;//当前路径
	private String title;//新闻标题
	private String content;//新闻内容
	private String imagenum;//图片编号
	private String uploadFileName;// 上传文件名
	private File upload;// 上传图片
	private String newsId;//大赛新闻的id
	private Integer sysstatus;//系统状态
	private String imageId;//图片id
	private Integer status;//系统状态
	private String adminId;//大赛管理员id
	private String stuApplyId;//报名学生的id
	private Integer groups;//小组
	private String fileId;//文件id
	private InputStream fileInput;
	private String fileName;
	
	
	
	/**
	 * 大赛管理员列表
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllAdmin() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = adminService.getAdminCountBy(admin);
		page.setTotalNumber(recordCnt);
		page.setParam(admin);
		
		listAdmin = adminService.getPagingByAdminParam(page);
		currentUrl = "admin_listAllAdmin";
		return SUCCESS;
		
	}
	
	/**
	 * 新增大赛管理员
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addAdmin() throws Exception{
		currentUrl = "admin_addAdmin";
		return SUCCESS;
	}
	
	/**
	 * 执行新增大赛管理员
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String doAddAdmin() throws Exception{
		
		admin.setMobliephone(mobliephone);
		admin.setName(name);
		admin.setSex(sex);
		admin.setRemark(remark);
		admin.setRemark(remark);
		admin.setStatus(1);
		admin.setAddtime(new Date().getTime());
		
		user.setPassword("123456");
		user.setType(1);
		user.setUsername(name);
		
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 2048 * 2048 * 1;
			if (contentlength <= maximumLength) {
				Image img = new Image();
				img.setName(this.uploadFileName);
				img.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertImage(img);
				if (res > 0) {
					admin.setImageid(img.getId());
				}
			} else {
				SessionUtil.setAlert("添加失败");
			}
		}
		int res=adminService.insertAdminByEntity(admin,user);
		if (res>0) {
			SessionUtil.setAlert("添加成功");
		} else {
			SessionUtil.setAlert("添加失败");
		}
		actionurl = "admin_adminAction_listAllAdmin";
		return "redirect";
	}
	
	/**
	 * 查看大赛管理员详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailAdmin() throws Exception{
		admin = adminService.getAdminById(adminId);
		return SUCCESS;
	}
	
	/**
	 * 删除大赛管理员
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String delAdmin() throws Exception{
		
		admin.setId(adminId);
		admin.setStatus(status);
		int res = adminService.deleteAdminById(admin);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 查看我的个人详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String MyDetailAdmin() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Admin ad=(Admin) session.getAttribute("admin");
		admin = adminService.getAdminById(ad.getId());
		currentUrl = "admin_MyDetailAdmin";
		return SUCCESS;
	}
	
	
	/**
	 * 评委老师列表
	 * @author luxinhuo
	 * @return 
	 * @throws Exception
	 */
	public String listAllTeacher() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = adminService.getTeacherCountBy(teacher);
		page.setTotalNumber(recordCnt);
		page.setParam(teacher);
		
		listFullTeacher = adminService.getPagingByTeacherParam(page);
		currentUrl = "admin_listAllTeacher";
		return SUCCESS;
		
	}
	
	/**
	 * 新增评委老师
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String addTeacher() throws Exception{
		
		listSchool = userService.getSchool();
		currentUrl = "admin_addTeacher";
		return SUCCESS;
	}
	
	/**
	 * 执行新增评委老师
	 * @author luxinhuo
	 * @return 
	 * @throws Exception
	 */
	public String doAddTeacher() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Admin ad=(Admin) session.getAttribute("admin");
		
		teacher.setId(teacherId);
		teacher.setName(name);
		teacher.setSex(sex);
		teacher.setMobliephone(mobliephone);
		teacher.setSchoolid(schoolId);
		teacher.setStatus(1);
		teacher.setRemark(remark);
		teacher.setAddtime(new Date().getTime());
		int recordCnt = adminService.getTeacherCountBy(tea);
		teacher.setGroups((recordCnt+1)/5+1);
		teacher.setPubid(ad.getId());
		
		user.setPassword("123456");
		user.setType(2);
		user.setUsername(name);
		int res=adminService.insertTeacherByEntity(teacher,user);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 查看评委老师详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailTeacher() throws Exception{
		
		fullTeacher = teacherService.getTeacherById(teacherId);
		return SUCCESS;
	}
	
	/**
	 * 删除评委老师
	 * @author luxinhuo
	 * @return
	 * @throws Exception
	 */
	public String delTeacher() throws Exception{
		
		teacher.setId(teacherId);
		teacher.setStatus(status);
		int res = teacherService.deleteTeacherById(teacher);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 参赛学生列表
	 * @return
	 * @throws Exception
	 */
	public String listAllStudent() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = adminService.getStudentCountBy(student);
		page.setTotalNumber(recordCnt);
		page.setParam(student);
		
		listFullStudent = adminService.getPagingByStudentParam(page);
		currentUrl = "admin_listAllStudent";
		return SUCCESS;
	}

	/**
	 * 报名学生详情
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailStudent() throws Exception{
		
		fullStudent = studentService.detailStudent(studentId);
		return SUCCESS;
	}
	
	/**
	 * 删除学生
	 * @author luxinhuo
	 * @return ajaxjson
	 * @throws Exception
	 */
	public String delStudent() throws Exception{
		
		student.setId(studentId);
		student.setStatus(status);
		int res = studentService.deleteStudentById(student);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 查看报名学生列表
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllStuApplyStudent() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = adminService.getApplyStudentCountBy(stuApply);
		page.setTotalNumber(recordCnt);
		page.setParam(stuApply);
		
		listFullStuApply = adminService.getPagingByApplyStudentParam(page);
		currentUrl = "admin_listAllStuApplyStudent";
		return SUCCESS;
	}
	
	/**
	 * 统计得分
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String accountScore() throws Exception{
		
		listFullScore = adminService.accountScore(studentId);
		return SUCCESS;
	}
	
	/**
	 * 合计成绩
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String totalScore() throws Exception{
		
		int res = adminService.totalScore(studentId);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
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
	 * 大赛新闻列表
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllNews() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		news.setType(0);
		int recordCnt = adminService.getNewsCountBy(news);
		page.setTotalNumber(recordCnt);
		page.setParam(news);
		
		listFullNews = adminService.getPagingByNewsParam(page);
		currentUrl = "admin_listAllNews";
		return SUCCESS;
	}
	
	/**
	 * 新增新闻
	 * @author luxinhuo
	 * @return	SUCCESS
	 * @throws Exception
	 */
	public String addNews() throws Exception{
		
		currentUrl = "admin_addNews";
		return SUCCESS;
	}
	
	/**
	 * 执行新增新闻内容
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String doAddNews() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Admin ad=(Admin) session.getAttribute("admin");
		news.setAddtime(new Date().getTime());
		news.setContent(content);
		news.setTitle(title);
		news.setType(0);
		news.setPubid(ad.getId());
		
		if (this.upload != null) {
			long contentlength = ServletActionContext.getRequest().getContentLength();
			long maximumLength = 2048 * 2048 * 1;
			if (contentlength <= maximumLength) {
				Image img = new Image();
				img.setName(this.uploadFileName);
				img.setContent(FileUtil.getByteInFile(this.upload));
				int res = adminService.insertImage(img);
				if (res > 0) {
					news.setImageid(img.getId());
				}
			} else {
				SessionUtil.setAlert("添加失败");
			}
		}
		int res = adminService.insertNewsByEntity(news);
		if (res>0) {
			SessionUtil.setAlert("添加成功");
		} else {
			SessionUtil.setAlert("添加失败");
		}
		actionurl = "admin_adminAction_listAllNews";
		return "redirect";
	}
	
	/**
	 * 查看大赛新闻的详情信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailNews() throws Exception{
		
		fullNews = adminService.getNewsById(newsId);
		return SUCCESS;
	}
	
	/**
	 * 删除还原大赛新闻
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String delNews() throws Exception{
		
		news.setId(newsId);
		news.setSysstatus(sysstatus);
		int res = adminService.updateNewsByEntity(news);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}

	
	/**
	 * 大赛公告列表
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllNotice() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		news.setType(1);
		int recordCnt = adminService.getNewsCountBy(news);
		page.setTotalNumber(recordCnt);
		page.setParam(news);
		
		listFullNews = adminService.getPagingByNewsParam(page);
		currentUrl = "admin_listAllNotice";
		return SUCCESS;
	}
	
	/**
	 * 新增大赛公告
	 * @author luxinhuo
	 * @return	SUCCESS
	 * @throws Exception
	 */
	public String addNotice() throws Exception{
		
		currentUrl = "admin_addNotice";
		return SUCCESS;
	}
	
	/**
	 * 执行新增公告内容
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String doAddNotice() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Admin ad=(Admin) session.getAttribute("admin");
		news.setAddtime(new Date().getTime());
		news.setContent(content);
		news.setTitle(title);
		news.setType(1);
		news.setPubid(ad.getId());
		
		int res = adminService.insertNewsByEntity(news);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}
	
	/**
	 * 查看大赛公告的详情信息
	 * @author luxinhuo
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailNotice() throws Exception{
		
		fullNews = adminService.getNewsById(newsId);
		return SUCCESS;
	}
	
	/**
	 * 删除还原大赛公告
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String delNotice() throws Exception{
		
		news.setId(newsId);
		news.setSysstatus(sysstatus);
		int res = adminService.updateNewsByEntity(news);
		if(res>0){
			this.json = new ByteArrayInputStream("success".getBytes("UTF-8"));
		}else {
			this.json = new ByteArrayInputStream("fail".getBytes("UTF-8"));
		}
		return "ajaxjson";
	}

	/**
	 * 查出一条记录图片
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String drawOneByNum() throws Exception{

		image = adminService.getImageByNum(imageId);
		if (null != image.getContent()) {
			this.json = new ByteArrayInputStream(image.getContent());
		} else {
			this.json = new ByteArrayInputStream("".getBytes());
		}
		return "ajaxjson";
	}
	
	/**
	 * 下载文件
	 * @author luxinhuo
	 * @return "ajaxjson"
	 * @throws Exception
	 */
	public String download() throws Exception{

		files = adminService.getFileById(fileId);
		if (null != files.getContent()) {
			fileName = files.getName();
			fileInput = new ByteArrayInputStream(files.getContent());
		} else {
			fileName = files.getName();
			fileInput = new ByteArrayInputStream("".getBytes());
		}
		return "file";
	}

	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobliephone() {
		return mobliephone;
	}

	public void setMobliephone(String mobliephone) {
		this.mobliephone = mobliephone;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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

	public FullTeacher getFullTeacher() {
		return fullTeacher;
	}

	public void setFullTeacher(FullTeacher fullTeacher) {
		this.fullTeacher = fullTeacher;
	}

	public List<FullTeacher> getListFullTeacher() {
		return listFullTeacher;
	}

	public void setListFullTeacher(List<FullTeacher> listFullTeacher) {
		this.listFullTeacher = listFullTeacher;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public PagingUtil getPage() {
		return page;
	}

	public void setPage(PagingUtil page) {
		this.page = page;
	}

	public String getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
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

	public List<FullStudent> getListFullStudent() {
		return listFullStudent;
	}

	public void setListFullStudent(List<FullStudent> listFullStudent) {
		this.listFullStudent = listFullStudent;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagenum() {
		return imagenum;
	}

	public void setImagenum(String imagenum) {
		this.imagenum = imagenum;
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

	public List<FullNews> getListFullNews() {
		return listFullNews;
	}

	public void setListFullNews(List<FullNews> listFullNews) {
		this.listFullNews = listFullNews;
	}

	public FullNews getFullNews() {
		return fullNews;
	}

	public void setFullNews(FullNews fullNews) {
		this.fullNews = fullNews;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Integer getSysstatus() {
		return sysstatus;
	}

	public void setSysstatus(Integer sysstatus) {
		this.sysstatus = sysstatus;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Admin> getListAdmin() {
		return listAdmin;
	}

	public void setListAdmin(List<Admin> listAdmin) {
		this.listAdmin = listAdmin;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	public FullStuApply getFullStuApply() {
		return fullStuApply;
	}

	public void setFullStuApply(FullStuApply fullStuApply) {
		this.fullStuApply = fullStuApply;
	}

	public String getStuApplyId() {
		return stuApplyId;
	}

	public void setStuApplyId(String stuApplyId) {
		this.stuApplyId = stuApplyId;
	}

	public Integer getGroups() {
		return groups;
	}

	public void setGroups(Integer groups) {
		this.groups = groups;
	}

	public FullScore getFullScore() {
		return fullScore;
	}

	public void setFullScore(FullScore fullScore) {
		this.fullScore = fullScore;
	}

	public List<FullScore> getListFullScore() {
		return listFullScore;
	}

	public void setListFullScore(List<FullScore> listFullScore) {
		this.listFullScore = listFullScore;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public InputStream getFileInput() {
		return fileInput;
	}

	public void setFileInput(InputStream fileInput) {
		this.fileInput = fileInput;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
