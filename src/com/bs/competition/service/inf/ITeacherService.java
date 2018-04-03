package com.bs.competition.service.inf;

import java.util.List;

import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;
import com.bs.competition.paramEntity.StuApplyParam;

/**
 * 指导老师实现层接口
 * @author luxinhuo
 */
public interface ITeacherService {
	
	/**
	 * 查询评委老师的详情
	 * @author luxinhuo
	 * @param teacherId
	 * @return FullTeacher
	 */
	public FullTeacher getTeacherById(String teacherId);
	
	/**
	 * 删除评委老师
	 * @author luxinhuo
	 * @param Teacher
	 * @return int
	 */
	public int deleteTeacherById(Teacher teacher);
	
	/**
	 * 修改评委老师的个人信息
	 * @author luxinhuo
	 * @param teacher
	 * @param user
	 * @return int
	 */
	public int modifyMySelfByEntity(Teacher teacher,User user);
	
	/**
	 * 老师查看报名学生列表的条数
	 * @author luxinhuo
	 * @param stuApplyParam
	 * @return int
	 */
	public int getStuApplyStudentCountBy(StuApplyParam stuApplyParam);
	
	/**
	 * 老师查看报名学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByStuApplyStudentParam(PagingUtil pageing);
	
	/**
	 * 查看报名学生的详情
	 * @author luxinhuo
	 * @param stuApplyId
	 * @return
	 */
	public FullStuApply getStuApplyStudent(String stuApplyId);
	
	/**
	 * 评分
	 * @author luxinhuo
	 * @param score
	 * @return int
	 */
	public int addScore(Score score);
}
