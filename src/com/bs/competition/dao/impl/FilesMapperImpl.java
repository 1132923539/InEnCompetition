package com.bs.competition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bs.competition.dao.inf.FilesMapper;
import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.FilesExample;



@Repository("bs_files")
public class FilesMapperImpl implements FilesMapper {

	private final Logger logger = Logger.getLogger(FilesMapperImpl.class);

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	private String range = "com.bs.competition.dao.inf.FilesMapper";

	public String sqlId(String idSql) {

		String position = this.range + "." + idSql;
		return position;
	}

	public int countByExample(FilesExample example) {

		logger.debug("<[int countByExample(FilesExample example) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.selectOne(sqlId("countByExample"),
				example);
	}

	public int deleteByPrimaryKey(String id) {

		logger.debug("<[int deleteByPrimaryKey(Long id) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.delete(sqlId("deleteByPrimaryKey"), id);
	}

	public int insert(Files record) {

		logger.debug("<[int insert(Files record) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.insert(sqlId("insert"), record);
	}

	public int insertSelective(Files record) {

		logger.debug("<[int insertSelective(Files record) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.insert(sqlId("insertSelective"), record);
	}

	public List<Files> selectByExample(FilesExample example) {

		logger.debug("<[List<Files> selectByExample(FilesExample example) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.selectList(sqlId("selectByExample"),
				example);

	}

	public List<Files> selectByExamplePaging(FilesExample example) {

		logger.debug("<[List<Files> selectByExamplePaging(FilesExample example) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.selectList(
				sqlId("selectByExamplePaging"), example);
	}

	public Files selectByPrimaryKey(String id) {

		logger.debug("<[Files selectByPrimaryKey(Long id) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.selectOne(sqlId("selectByPrimaryKey"),
				id);
	}

	public int updateByPrimaryKeySelective(Files record) {

		logger.debug("<[int updateByPrimaryKeySelective(Files record) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.update(
				sqlId("updateByPrimaryKeySelective"), record);
	}

	public int updateByPrimaryKey(Files record) {

		logger.debug("int updateByPrimaryKey(Files record) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.update(sqlId("updateByPrimaryKey"),
				record);
	}

	public List<Files> selectByExampleWithBLOBs(FilesExample example) {

		logger.debug("<[List<Files> selectByExampleWithBLOBs(FilesExample example) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.selectList(
				sqlId("selectByExampleWithBLOBs"), example);
	}

	public int updateByPrimaryKeyWithBLOBs(Files record) {

		logger.debug("<[int updateByPrimaryKeyWithBLOBs(Files record) at FilesMapperImpl]>");

		return this.sqlSessionTemplate.update(
				sqlId("updateByPrimaryKeyWithBLOBs"), record);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int deleteByExample(FilesExample example) {
		return this.sqlSessionTemplate
				.delete(sqlId("deleteByExample"), example);
	}

	public int updateByExampleSelective(Files record, FilesExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExampleSelective"),map);
	}

	public int updateByExampleWithBLOBs(Files record, FilesExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExampleWithBLOBs"),map);
	}

	public int updateByExample(Files record, FilesExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExample"),map);
	}

}
