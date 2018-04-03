package com.bs.competition.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.control.util.ToolsUtil;
import com.bs.competition.dao.inf.AdminMapper;
import com.bs.competition.dao.inf.FilesMapper;
import com.bs.competition.dao.inf.ImageMapper;
import com.bs.competition.dao.inf.NewsMapper;
import com.bs.competition.dao.inf.SchoolMapper;
import com.bs.competition.dao.inf.ScoreMapper;
import com.bs.competition.dao.inf.StuApplyMapper;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.dao.inf.TeacherMapper;
import com.bs.competition.dao.inf.UserMapper;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullScore;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.AdminExample;
import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.FilesExample;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.ImageExample;
import com.bs.competition.entity.simple.News;
import com.bs.competition.entity.simple.NewsExample;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.ScoreExample;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.StuApplyExample;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.StudentExample;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.TeacherExample;
import com.bs.competition.entity.simple.User;
import com.bs.competition.service.inf.IAdminService;

/**
 * 管理员实现层
 * @author luxinhuo
 */

@Service("front_adminServiceImpl")
public class AdminServiceImpl implements IAdminService{
	@Autowired
	@Resource(name = "bs_teacher")
	private TeacherMapper teacherMapper;
	
	@Autowired
	@Resource(name = "bs_student")
	private StudentMapper studentMapper;
	
	@Autowired
	@Resource(name = "bs_user")
	private UserMapper userMapper;
	
	@Autowired
	@Resource(name = "bs_school")
	private SchoolMapper schoolMapper;
	
	@Autowired
	@Resource(name = "bs_image")
	private ImageMapper imageMapper;
	
	@Autowired
	@Resource(name = "bs_files")
	private FilesMapper filesMapper;
	
	
	@Autowired
	@Resource(name = "bs_news")
	private NewsMapper newsMapper;
	
	@Autowired
	@Resource(name = "bs_admin")
	private AdminMapper adminMapper;
	
	@Autowired
	@Resource(name = "bs_stuApply")
	private StuApplyMapper stuApplyMapper;
	
	@Autowired
	@Resource(name = "bs_score")
	private ScoreMapper scoreMapper;
	
	
	/**
	 * 分页查询大赛管理员列表的条数
	 * @author luxinhuo
	 * @param admin
	 * @return int
	 */
	public int getAdminCountBy(Admin admin){
		
		if(admin==null){
			return 0;
		}
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria adminCri = adminExample.createCriteria();
		if(ToolsUtil.notEmpty(admin.getName())){
			adminCri.andNameLike("%" + admin.getName() + "%");
		}
		if (admin.getStatus() == null) {
			adminCri.andStatusEqualTo(1);
		} else if (admin.getStatus() == 3) {
			adminCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			adminCri.andStatusEqualTo(admin.getStatus());
		}
		int record = adminMapper.countByExample(adminExample);
		return record;
	}
	
	/**
	 * 分页查询大赛管理员列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<Admin>
	 */
	public List<Admin> getPagingByAdminParam(PagingUtil pageing){
		
		if(pageing==null){
			return null;
		}
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria adminCri = adminExample.createCriteria();
		Admin admin = (Admin)pageing.getParam();
		if(ToolsUtil.notEmpty(admin.getName())){
			adminCri.andNameLike("%" + admin.getName() + "%");
		}
		if (admin.getStatus() == null) {
			adminCri.andStatusEqualTo(1);
		} else if (admin.getStatus() == 3) {
			adminCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			adminCri.andStatusEqualTo(admin.getStatus());
		}
		adminExample.setStart(pageing.getDbIndex());
		adminExample.setEnd(pageing.getDbNumber());
		adminExample.setOrderByClause("addtime desc");
		
		List<Admin> listAdmin = adminMapper.selectByExamplePaging(adminExample);
		return listAdmin;
	}
	
	/**
	 * 新增大赛管理员
	 * @author luxinhuo
	 * @param admin
	 * @param user
	 * @return int
	 */
	public int insertAdminByEntity(Admin admin,User user){
		
		if(admin==null||user==null){
			return 0;
		}
		int result = userMapper.insertSelective(user);
		admin.setUserid(user.getId());
		if(result>0){
			result=adminMapper.insert(admin);
		}
		return result;
	}
	
	
	/**
	 * 根据id查询大赛管理员详情
	 * @author luxinhuo
	 * @param adminId
	 * @return Admin
	 */
	public Admin getAdminById(String adminId){
		if(!ToolsUtil.notEmpty(adminId)){
			return null;
		}
		Admin admin = adminMapper.selectByPrimaryKey(adminId);
		return admin;
	}
	
	/**
	 * 删除还原大赛管理员
	 * @author luxinhuo
	 * @param admin
	 * @return int
	 */
	public int deleteAdminById(Admin admin){
		if(admin==null){
			return 0;
		}
		int res = adminMapper.updateByPrimaryKeySelective(admin);
		return res;
	}
	
	
	
	//评委老师
	/**
	 * 分页查询评委老师列表的条数
	 * @author luxinhuo
	 * @param teacher
	 * @return int
	 */
	public int getTeacherCountBy(Teacher teacher){
		TeacherExample teacherExample = new TeacherExample();
		TeacherExample.Criteria teacherCri = teacherExample.createCriteria();
		if(ToolsUtil.notEmpty(teacher.getName())){
			teacherCri.andNameLike("%" + teacher.getName() + "%");
		}
		if (teacher.getStatus() == null) {
			teacherCri.andStatusEqualTo(1);
		} else if (teacher.getStatus() == 3) {
			teacherCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			teacherCri.andStatusEqualTo(teacher.getStatus());
		}
		
		int record = teacherMapper.countByExample(teacherExample);
		return record;
	}
	/**
	 * 分页查询评委老师列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullTeacher>
	 */
	public List<FullTeacher> getPagingByTeacherParam(PagingUtil pageing){
		if(pageing==null){
			return null;
		}
		TeacherExample teacherExample = new TeacherExample();
		TeacherExample.Criteria teacherCri = teacherExample.createCriteria();
		Teacher teacher = (Teacher)pageing.getParam();
		if(ToolsUtil.notEmpty(teacher.getName())){
			teacherCri.andNameLike("%" + teacher.getName() + "%");
		}
		if (teacher.getStatus() == null) {
			teacherCri.andStatusEqualTo(1);
		} else if (teacher.getStatus() == 3) {
			teacherCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			teacherCri.andStatusEqualTo(teacher.getStatus());
		}
		teacherExample.setStart(pageing.getDbIndex());
		teacherExample.setEnd(pageing.getDbNumber());
		teacherExample.setOrderByClause("addtime desc");
		List<Teacher> listTeacher = teacherMapper.selectByExamplePaging(teacherExample);
		List<FullTeacher> listFullTeacher = new ArrayList<FullTeacher>();
		if(listTeacher.size()>0){
			for(int i=0;i<listTeacher.size();i++){
				FullTeacher fullTeacher = new FullTeacher();
				Teacher teacher1 = new Teacher();
				teacher1=listTeacher.get(i);
				fullTeacher.setTeacher(teacher1);
				fullTeacher.setSchool(schoolMapper.selectByPrimaryKey(teacher1.getSchoolid()));
				listFullTeacher.add(fullTeacher);
			}
		}
		return listFullTeacher;
	}
	
	/**
	 * 新增评委老师
	 * @author luxinhuo
	 * @param teacher
	 * @param user
	 * @return int
	 */
	public int insertTeacherByEntity(Teacher teacher,User user){
		
		if(teacher==null||user==null){
			return 0;
		}
		int result = userMapper.insertSelective(user);
		teacher.setUserid(user.getId());
		if(result>0){
			result=teacherMapper.insert(teacher);
		}
		return result;
	}
	
	
	//参赛学生
	/**
	 * 分页查询注册学生列表的条数
	 * @author luxinhuo
	 * @param student
	 * @return int
	 */
	public int getStudentCountBy(Student student){
		
		if(student==null){
			return 0;
		}
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentCri = studentExample.createCriteria();
		if(ToolsUtil.notEmpty(student.getName())){
			studentCri.andNameLike("%" + student.getName() + "%");
		}
		if (student.getStatus() == null) {
			studentCri.andStatusEqualTo(1);
		} else if (student.getStatus() == 3) {
			studentCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			studentCri.andStatusEqualTo(student.getStatus());
		}
		int record = studentMapper.countByExample(studentExample);
		return record;
	}
	
	/**
	 * 分页查询注册学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStudent>
	 */
	public List<FullStudent> getPagingByStudentParam(PagingUtil pageing){
		
		if(pageing==null){
			return null;
		}
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentCri = studentExample.createCriteria();
		Student student = (Student)pageing.getParam();
		if(ToolsUtil.notEmpty(student.getName())){
			studentCri.andNameLike("%" + student.getName() + "%");
		}
		if (student.getStatus() == null) {
			studentCri.andStatusEqualTo(1);
		} else if (student.getStatus() == 3) {
			studentCri.andStatusGreaterThanOrEqualTo(0);
		} else {
			studentCri.andStatusEqualTo(student.getStatus());
		}
		studentExample.setStart(pageing.getDbIndex());
		studentExample.setEnd(pageing.getDbNumber());
		studentExample.setOrderByClause("addtime desc");
		List<Student> listStudent = studentMapper.selectByExamplePaging(studentExample);
		List<FullStudent> listFullStudent = new ArrayList<FullStudent>();
		if(listStudent.size()>0){
			for(int i=0;i<listStudent.size();i++){
				FullStudent fullStudent = new FullStudent();
				Student student1 = new Student();
				student1 = listStudent.get(i);
				fullStudent.setSchool(schoolMapper.selectByPrimaryKey(student1.getSchoolid()));
				fullStudent.setStudent(student1);
				listFullStudent.add(fullStudent);
			}
		}
		return listFullStudent;
	}
	
	
	//参赛学生
	/**
	 * 分页查询参赛学生列表的条数
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int getApplyStudentCountBy(StuApply stuApply){
		
		if(stuApply==null){
			return 0;
		}
		StuApplyExample stuApplyExample = new StuApplyExample(); 
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		if(stuApply.getGroups()!=null){
			stuApplyCri.andGroupsEqualTo(stuApply.getGroups());
		}
		int record = stuApplyMapper.countByExample(stuApplyExample);
		return record;
	}
	
	/**
	 * 分页查询参赛学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByApplyStudentParam(PagingUtil pageing){
		if(pageing==null){
			return null;
		}
		StuApplyExample stuApplyExample = new StuApplyExample(); 
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		StuApply stuApply = (StuApply)pageing.getParam();
		if(stuApply.getGroups()!=null){
			stuApplyCri.andGroupsEqualTo(stuApply.getGroups());
		}
		stuApplyExample.setStart(pageing.getDbIndex());
		stuApplyExample.setEnd(pageing.getDbNumber());
		stuApplyExample.setOrderByClause("addtime desc");
		List<StuApply> listStuApply = stuApplyMapper.selectByExamplePaging(stuApplyExample);
		List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();
		if(listStuApply.size()>0){
			for(int i=0;i<listStuApply.size();i++){
				FullStuApply fullStuApply = new FullStuApply();
				fullStuApply.setStuApply(listStuApply.get(i));
				Student student = studentMapper.selectByPrimaryKey(listStuApply.get(i).getStudentid());
				fullStuApply.setStudent(student);
				fullStuApply.setSchool(schoolMapper.selectByPrimaryKey(student.getSchoolid()));
//				ScoreExample scoreExample = new ScoreExample();
//				ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
//				scoreCri.andStudentidEqualTo(student.getId());
//				List<Score> listScore = scoreMapper.selectByExample(scoreExample);
				fullStuApply.setFiles(filesMapper.selectByPrimaryKey(listStuApply.get(i).getFileid()));
				if(student.getScore()!=null){
					fullStuApply.setIsScore(1);
				}else{
					fullStuApply.setIsScore(0);
				}
				listFullStuApply.add(fullStuApply);
			}
		}
		return listFullStuApply;
	}
	
	/**
	 * 统计学生得分
	 * @author luxinhuo
	 * @param studentId
	 * @return List<FullScore>
	 */
	public List<FullScore> accountScore(String studentId){
		
		if(!ToolsUtil.notEmpty(studentId)){
			return null;
		}
		ScoreExample scoreExample = new ScoreExample();
		ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
		scoreCri.andStudentidEqualTo(studentId);
		List<Score> listScore = scoreMapper.selectByExample(scoreExample);
		List<FullScore> listFullScore = new ArrayList<FullScore>();
		if(listScore.size()>0){
			for(int i=0;i<listScore.size();i++){
				FullScore fullScore = new FullScore();
				int newscore = listScore.get(i).getNewscore();
				int prascore = listScore.get(i).getPrascore();
				int feascore = listScore.get(i).getFeascore();
				fullScore.setNewscore(newscore);
				fullScore.setPrascore(prascore);
				fullScore.setFeascore(feascore);
				fullScore.setTeacher(teacherMapper.selectByPrimaryKey(listScore.get(i).getTeacherid()));
				fullScore.setStudent(studentMapper.selectByPrimaryKey(studentId));
				listFullScore.add(fullScore);
			}
		}
		return listFullScore;
	}

	/**
	 * 统计最终得分
	 * @author luxinhuo 
	 * @param studentId
	 * @return int
	 */
	public int totalScore(String studentId){
	
		if(!ToolsUtil.notEmpty(studentId)){
			return 0;
		}
		ScoreExample scoreExample = new ScoreExample();
		ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
		scoreCri.andStudentidEqualTo(studentId);
		List<Score> listScore = scoreMapper.selectByExample(scoreExample);
		int totalscore = 0;
		int totalnew = 0;
		int totalpra = 0;
		int totalfea = 0;
		Student student = new Student();
		int res = 0;
		if(listScore.size()==4){
			for(int i=0;i<listScore.size();i++){
				int newscore = listScore.get(i).getNewscore();
				int prascore = listScore.get(i).getPrascore();
				int feascore = listScore.get(i).getFeascore();
				totalscore = totalscore+newscore+prascore+feascore;
				totalnew = totalnew+newscore;
				totalpra = totalpra+prascore;
				totalfea = totalfea+feascore;
			}
			student.setId(studentId);
			student.setNewscore(totalnew/4);
			student.setPrascore(totalpra/4);
			student.setFeascore(totalfea/4);
			student.setScore(totalscore/4);
			res = studentMapper.updateByPrimaryKeySelective(student);
		}
		return res;
	}
	
	
	//大赛新闻
	/**
	 * 分页查询大赛新闻列表的条数
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int getNewsCountBy(News news){
		
		if(news==null){
			return 0;
		}
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria newsCri = newsExample.createCriteria();
		if (news.getSysstatus() == null) {
			newsCri.andSysstatusEqualTo(1);
		} else if (news.getSysstatus() == 3) {
			newsCri.andSysstatusGreaterThanOrEqualTo(0);
		} else {
			newsCri.andSysstatusEqualTo(news.getSysstatus());
		}
		if(ToolsUtil.notEmpty(news.getTitle())){
			newsCri.andTitleLike("%" + news.getTitle() + "%");
		}
		newsCri.andTypeEqualTo(news.getType());
		int record = newsMapper.countByExample(newsExample);
		return record;
	}
	
	/**
	 * 分页查询大赛新闻列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullNews>
	 */
	public List<FullNews> getPagingByNewsParam(PagingUtil pageing){
		if(pageing==null){
			return null;
		}
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria newsCri = newsExample.createCriteria();
		News news = (News)pageing.getParam();
		if (news.getSysstatus() == null) {
			newsCri.andSysstatusEqualTo(1);
		} else if (news.getSysstatus() == 3) {
			newsCri.andSysstatusGreaterThanOrEqualTo(0);
		} else {
			newsCri.andSysstatusEqualTo(news.getSysstatus());
		}
		if(ToolsUtil.notEmpty(news.getTitle())){
			newsCri.andTitleLike("%" + news.getTitle() + "%");
		}
		newsCri.andTypeEqualTo(news.getType());
		newsExample.setStart(pageing.getDbIndex());
		newsExample.setEnd(pageing.getDbNumber());
		newsExample.setOrderByClause("addtime desc");
		List<News> listNews = newsMapper.selectByExamplePaging(newsExample);
		List<FullNews> listFullNews = new ArrayList<FullNews>();
		if(listNews.size()>0){
			for(int i=0;i<listNews.size();i++){
				FullNews fullNews = new FullNews();
				News news1 = new News();
				news1 = listNews.get(i);
				fullNews.setNews(news1);
				fullNews.setImage(imageMapper.selectByPrimaryKey(news1.getImageid()));
				listFullNews.add(fullNews);
			}
		}
		return listFullNews;
	}
	
	/**
	 * 上传图片
	 * @author luxinhuo
	 * @param image
	 * @return int
	 */
	public int insertImage(Image image){
		
		if(image==null){
			return 0;
		}
		int res = imageMapper.insert(image);
		return res;
	}
	
	/**
	 * 上传文件
	 * @author luxinhuo
	 * @param files
	 * @return
	 */
	public int insertFile(Files files){
		
		if(files==null){
			return 0;
		}
		int res = filesMapper.insert(files);
		return res;
	}
	
	/**
	 * 新增新闻
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int insertNewsByEntity(News news){
		
		if(news==null){
			return 0;
		}
		int res = newsMapper.insertSelective(news);
		return res;
	}
	
	/**
	 * 查看大赛新闻的详情
	 * @author luxinhuo
	 * @param newsId
	 * @return FullNews
	 */
	public FullNews getNewsById(String newsId){
		if(!ToolsUtil.notEmpty(newsId)){
			return null;
		}
		FullNews fullNews = new FullNews();
		News news = newsMapper.selectByPrimaryKey(newsId);
		fullNews.setNews(news);
		fullNews.setImage(imageMapper.selectByPrimaryKey(news.getImageid()));
		fullNews.setAdmin(adminMapper.selectByPrimaryKey(news.getPubid()));
		return fullNews;
	}
	
	/**
	 * 删除大赛新闻
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int updateNewsByEntity(News news){
		if(news==null){
			return 0;
		}
		int res = newsMapper.updateByPrimaryKeySelective(news);
		return res;
	}
	
	/**
	 * 根据imageId查询
	 * @author luxinhuo
	 * @param imageId
	 * @return Image
	 */
	public Image getImageByNum(String imageId){
		if(!ToolsUtil.notEmpty(imageId)){
			return null;
		}
		ImageExample imageExample = new ImageExample();
		ImageExample.Criteria imageCri = imageExample.createCriteria();
		imageCri.andIdEqualTo(imageId);
		List<Image> listImage = imageMapper.selectByExampleWithBLOBs(imageExample);
		if (listImage == null || listImage.size() == 0) {
			return null;
		} else {
			return listImage.get(0);
		}
	}
	
	/**
	 * 下载文件
	 * @author luxinhuo
	 * @param fileId
	 * @return Files
	 */
	public Files getFileById(String fileId){
		
		if(!ToolsUtil.notEmpty(fileId)){
			return null;
		}
		FilesExample filesExample = new FilesExample();
		FilesExample.Criteria filesCri = filesExample.createCriteria();
		filesCri.andIdEqualTo(fileId);
		List<Files> listFiles = filesMapper.selectByExampleWithBLOBs(filesExample);
		if(listFiles==null||listFiles.size()==0){
			return null;
		}else{
			return listFiles.get(0);
		}
	}
}
