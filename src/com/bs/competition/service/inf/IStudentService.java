package com.bs.competition.service.inf;

import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.User;

/**
 * 学生实现层接口
 * @author luxinhuo
 */
public interface IStudentService {
	
	/**
	 * 查看学生详情
	 * @author luxinhuo
	 * @param studentId
	 * @return FullStudent
	 */
	public FullStudent detailStudent(String studentId);
	
	/**
	 * 删除学生
	 * @author luxinhuo
	 * @param student
	 * @return int
	 */
	public int deleteStudentById(Student student);
	
	/**
	 * 修改个人信息
	 * @author luxinhuo
	 * @param student
	 * @param user
	 * @return int
	 */
	public int modifyMySelfByEntity(Student student,User user);
	
	/**
	 * 报名
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int apply(StuApply stuApply);
	
	/**
	 * 修改我的报名信息
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int updateStuApplyByEntity(StuApply stuApply);
	
	/**
	 * 查看我的作品是否有老师评分
	 * @author luxinhuo
	 * @param studentId
	 * @return int
	 */
	public int checkModify(String studentId);
	
	/**
	 * 查看某组的人数 
	 * @author luxinhuo
	 * @param groups
	 * @return int
	 */
	public int getApplyByGroups(Integer groups);
}
