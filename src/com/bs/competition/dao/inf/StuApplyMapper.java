package com.bs.competition.dao.inf;

import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.StuApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuApplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int countByExample(StuApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByExample(StuApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insert(StuApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int insertSelective(StuApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	List<StuApply> selectByExample(StuApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	StuApply selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExampleSelective(@Param("record") StuApply record,
			@Param("example") StuApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByExample(@Param("record") StuApply record,
			@Param("example") StuApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKeySelective(StuApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stuapply
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	int updateByPrimaryKey(StuApply record);
	
	public List<StuApply> selectByExamplePaging(StuApplyExample example);
}