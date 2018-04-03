package com.bs.competition.dao.inf;

import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.FilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int countByExample(FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByExample(FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insert(Files record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insertSelective(Files record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	List<Files> selectByExampleWithBLOBs(FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	List<Files> selectByExample(FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	Files selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Files record,
			@Param("example") FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Files record,
			@Param("example") FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExample(@Param("record") Files record,
			@Param("example") FilesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKeySelective(Files record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Files record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table files
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKey(Files record);
}