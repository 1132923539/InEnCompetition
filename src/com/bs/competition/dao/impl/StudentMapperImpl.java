package com.bs.competition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.StudentExample;


@Repository("bs_student")
public class StudentMapperImpl implements StudentMapper {
	private final Logger logger = Logger.getLogger(StudentMapperImpl.class);
	private String range = "com.bs.competition.dao.inf.StudentMapper";
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		logger.debug("sqlId = " + position);
		return position;
	}

	public int countByExample(StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at countByExample");
		return sqlSessionTemplate.selectOne(sqlId("countByExample"), example);
	}

	public int deleteByExample(StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at deleteByExample");
		return sqlSessionTemplate.delete(sqlId("deleteByExample"), example);
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		logger.debug("at deleteByPrimaryKey");
		return sqlSessionTemplate.delete(sqlId("deleteByPrimaryKey"), id);
	}

	public int insert(Student record) {
		// TODO Auto-generated method stub
		logger.debug("at insert");
		return sqlSessionTemplate.insert(sqlId("insert"), record);
	}

	public int insertSelective(Student record) {
		// TODO Auto-generated method stub
		logger.debug("at insertSelective");
		return sqlSessionTemplate.insert(sqlId("insertSelective"), record);
	}

	public List<Student> selectByExample(StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at selectByExample");
		return sqlSessionTemplate.selectList(sqlId("selectByExample"), example);
	}

	
	public List<Student> selectByExamplePaging(StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at selectByExample");
		return sqlSessionTemplate.selectList(sqlId("selectByExamplePaging"), example);
	}

	
	
	public Student selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		logger.debug("at selectByPrimaryKey");
		return sqlSessionTemplate.selectOne(sqlId("selectByPrimaryKey"), id);
	}

	public int updateByExampleSelective(Student record, StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at updateByExampleSelective");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return sqlSessionTemplate
				.update(sqlId("updateByExampleSelective"), map);

	}

	public int updateByExample(Student record, StudentExample example) {
		// TODO Auto-generated method stub
		logger.debug("at updateByExample");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return sqlSessionTemplate.update(sqlId("updateByExample"), map);
	}

	public int updateByPrimaryKeySelective(Student record) {
		// TODO Auto-generated method stub
		logger.debug("at updateByPrimaryKeySelective");
		return sqlSessionTemplate.update(sqlId("updateByPrimaryKeySelective"),
				record);
	}

	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		logger.debug("at updateByPrimaryKey");
		return sqlSessionTemplate.update(sqlId("updateByPrimaryKey"), record);
	}

}
