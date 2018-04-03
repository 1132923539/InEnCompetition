package com.bs.competition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bs.competition.dao.inf.ImageMapper;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.ImageExample;



@Repository("bs_image")
public class ImageMapperImpl implements ImageMapper {

	private final Logger logger = Logger.getLogger(ImageMapperImpl.class);

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	private String range = "com.bs.competition.dao.inf.ImageMapper";

	public String sqlId(String idSql) {

		String position = this.range + "." + idSql;
		return position;
	}

	public int countByExample(ImageExample example) {

		logger.debug("<[int countByExample(ImageExample example) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.selectOne(sqlId("countByExample"),
				example);
	}

	public int deleteByPrimaryKey(String id) {

		logger.debug("<[int deleteByPrimaryKey(Long id) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.delete(sqlId("deleteByPrimaryKey"), id);
	}

	public int insert(Image record) {

		logger.debug("<[int insert(Image record) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.insert(sqlId("insert"), record);
	}

	public int insertSelective(Image record) {

		logger.debug("<[int insertSelective(Image record) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.insert(sqlId("insertSelective"), record);
	}

	public List<Image> selectByExample(ImageExample example) {

		logger.debug("<[List<Image> selectByExample(ImageExample example) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.selectList(sqlId("selectByExample"),
				example);

	}

	public List<Image> selectByExamplePaging(ImageExample example) {

		logger.debug("<[List<Image> selectByExamplePaging(ImageExample example) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.selectList(
				sqlId("selectByExamplePaging"), example);
	}

	public Image selectByPrimaryKey(String id) {

		logger.debug("<[Image selectByPrimaryKey(Long id) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.selectOne(sqlId("selectByPrimaryKey"),
				id);
	}

	public int updateByPrimaryKeySelective(Image record) {

		logger.debug("<[int updateByPrimaryKeySelective(Image record) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.update(
				sqlId("updateByPrimaryKeySelective"), record);
	}

	public int updateByPrimaryKey(Image record) {

		logger.debug("int updateByPrimaryKey(Image record) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.update(sqlId("updateByPrimaryKey"),
				record);
	}

	public List<Image> selectByExampleWithBLOBs(ImageExample example) {

		logger.debug("<[List<Image> selectByExampleWithBLOBs(ImageExample example) at ImageMapperImpl]>");

		return this.sqlSessionTemplate.selectList(
				sqlId("selectByExampleWithBLOBs"), example);
	}

	public int updateByPrimaryKeyWithBLOBs(Image record) {

		logger.debug("<[int updateByPrimaryKeyWithBLOBs(Image record) at ImageMapperImpl]>");

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

	public int deleteByExample(ImageExample example) {
		return this.sqlSessionTemplate
				.delete(sqlId("deleteByExample"), example);
	}

	public int updateByExampleSelective(Image record, ImageExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExampleSelective"),map);
	}

	public int updateByExampleWithBLOBs(Image record, ImageExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExampleWithBLOBs"),map);
	}

	public int updateByExample(Image record, ImageExample example) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(sqlId("updateByExample"),map);
	}

}
