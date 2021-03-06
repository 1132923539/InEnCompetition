package com.bs.competition.dao.inf;

import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int countByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insert(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insertSelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	List<Admin> selectByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	Admin selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Admin record,
			@Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExample(@Param("record") Admin record,
			@Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKeySelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKey(Admin record);

	public List<Admin> selectByExamplePaging(AdminExample example);
}