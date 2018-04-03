package com.bs.competition.dao.inf;

import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int countByExample(TeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByExample(TeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insert(Teacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insertSelective(Teacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	List<Teacher> selectByExample(TeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	Teacher selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Teacher record,
			@Param("example") TeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExample(@Param("record") Teacher record,
			@Param("example") TeacherExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKeySelective(Teacher record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table teacher
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKey(Teacher record);

	public List<Teacher> selectByExamplePaging(TeacherExample example);
}