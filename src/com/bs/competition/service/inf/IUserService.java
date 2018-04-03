package com.bs.competition.service.inf;

import java.util.List;

import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;

public interface IUserService {

	
	/**
	 * 
	 * @author luxinhuo
	 * @param student
	 * @return User
	 */
	public User queryUserByEntity(User user);
	
	/**
	 * 查询学校数据
	 * @author luxinhuo
	 * @return List<School>
	 */
	public List<School> getSchool();
	
	/**
	 * 注册用户
	 * @author luxinhuo
	 * @param student
	 * @param user
	 * @return int
	 */
	public int insertUserByEntity(Student student, User user);
	
	/**
	 * 根据登录的userId查询学生实体
	 * @author luxinhuo
	 * @param userId
	 * @return Student
	 */
	public Student queryStudentByUserId(String userId);
	
	/**
	 * 根据登录的userId查询评委老师的实体
	 * @author luxinhuo
	 * @param userId
	 * @return Teacher
	 */
	public Teacher queryTeacherByUserId(String userId);
	
	/**
	 * 根据登录的useId查询大赛管理员实体
	 * @author luxinhuo
	 * @param userId
	 * @return Admin
	 */
	public Admin queryAdminByUserId(String userId);
	
	/**
	 * 查看原始密码是否正确
	 * @author luxinhuo
	 * @param password
	 * @param userId
	 */
	public User getUserByPassword(String password,String userId);
	
}
