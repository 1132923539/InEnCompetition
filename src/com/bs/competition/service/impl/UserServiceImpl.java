package com.bs.competition.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.competition.control.util.ToolsUtil;
import com.bs.competition.dao.inf.AdminMapper;
import com.bs.competition.dao.inf.SchoolMapper;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.dao.inf.TeacherMapper;
import com.bs.competition.dao.inf.UserMapper;
import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.AdminExample;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.SchoolExample;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.StudentExample;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.TeacherExample;
import com.bs.competition.entity.simple.User;
import com.bs.competition.entity.simple.UserExample;
import com.bs.competition.service.inf.IUserService;
/**
 * 用户实现层
 * @author luxinhuo
 */

@Service("front_userServiceImpl")
public class UserServiceImpl implements IUserService{


	@Autowired
	@Resource(name = "bs_student")
	private StudentMapper studentMapper;
	
	@Autowired
	@Resource(name = "bs_school")
	private SchoolMapper schoolMapper;
	
	@Autowired
	@Resource(name = "bs_user")
	private UserMapper userMapper;
	
	@Autowired
	@Resource(name = "bs_teacher")
	private TeacherMapper teacherMapper;
	
	@Autowired
	@Resource(name = "bs_admin")
	private AdminMapper adminMapper;
	
	/**
	 * 
	 * @author luxinhuo
	 * @param student
	 * @return int
	 */
	public User queryUserByEntity(User user){
		
		UserExample userExample = new UserExample();
		UserExample.Criteria userCri = userExample.createCriteria();
		userCri.andUsernameEqualTo(user.getUsername());
		userCri.andPasswordEqualTo(user.getPassword());
		List<User> listUser= userMapper.selectByExample(userExample);
		if(listUser.size()>0){
			return listUser.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查询学校数据
	 * @author luxinhuo
	 * @return List<School>
	 */
	public List<School> getSchool(){
		
		SchoolExample schoolExample = new SchoolExample();
		List<School> listSchool = schoolMapper.selectByExample(schoolExample);
		return listSchool;
	}
	
	/**
	 * 注册用户
	 * @author luxinhuo
	 * @param student
	 * @param user
	 * @return int
	 */
	public int insertUserByEntity(Student student, User user){
		
		if(student==null||user==null){
			return 0;
		}
		int result = userMapper.insertSelective(user);
		student.setUserid(user.getId());
		if(result>0){
			result=studentMapper.insert(student);
		}
		return result;
	}
	
	/**
	 * 根据登录的userId查询学生实体
	 * @author luxinhuo
	 * @param userId
	 * @return Student
	 */
	public Student queryStudentByUserId(String userId){
		if(!ToolsUtil.notEmpty(userId)){
			return null;
		}
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentCri = studentExample.createCriteria();
		studentCri.andUseridEqualTo(userId);
		studentCri.andStatusEqualTo(1);
		List<Student> listStudent = studentMapper.selectByExample(studentExample);
		if(listStudent.size()>0){
			return listStudent.get(0); 
		}else{
			return null;
		}
	}
	
	/**
	 * 根据登录的uderId查询评委老师的实体
	 * @author luxinhuo
	 * @param userId
	 * @return Teacher
	 */
	public Teacher queryTeacherByUserId(String userId){
		if(!ToolsUtil.notEmpty(userId)){
			return null;
		}
		TeacherExample teacherExample = new TeacherExample();
		TeacherExample.Criteria teacherCri = teacherExample.createCriteria();
		teacherCri.andUseridEqualTo(userId);
		List<Teacher> listTeacher = teacherMapper.selectByExample(teacherExample);
		if(listTeacher.size()>0){
			return listTeacher.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 根据登录的useId查询大赛管理员实体
	 * @author luxinhuo
	 * @param userId
	 * @return Admin
	 */
	public Admin queryAdminByUserId(String userId){
		if(!ToolsUtil.notEmpty(userId)){
			return null;
		}
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria adminCri = adminExample.createCriteria();
		adminCri.andUseridEqualTo(userId);
		List<Admin> listAdmin = adminMapper.selectByExample(adminExample);
		if(listAdmin.size()>0){
			return listAdmin.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 查看原始密码是否正确
	 * @author luxinhuo
	 * @param password
	 * @param userId
	 * @param userId
	 */
	public User getUserByPassword(String password,String userId){
		if((!ToolsUtil.notEmpty(password))||(!ToolsUtil.notEmpty(userId))){
			return null;
		}
		UserExample userExample = new UserExample();
		UserExample.Criteria userCri = userExample.createCriteria();
		userCri.andPasswordEqualTo(password);
		userCri.andIdEqualTo(userId);
		List<User> listUser = userMapper.selectByExample(userExample);
		if(listUser.size()>0){
			return listUser.get(0);
		}else{
			return null;
		}
	}
}
