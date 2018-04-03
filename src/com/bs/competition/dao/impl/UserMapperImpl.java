package com.bs.competition.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bs.competition.dao.inf.UserMapper;
import com.bs.competition.entity.simple.User;
import com.bs.competition.entity.simple.UserExample;


@Repository("bs_user")
public class UserMapperImpl implements UserMapper {
	private final Logger logger = Logger.getLogger(UserMapperImpl.class);
	private String range = "com.bs.competition.dao.inf.UserMapper";
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public String sqlId(String idSql) {

		String position = range + "." + idSql;
		logger.debug("sqlId = " + position);
		return position;
	}

	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at countByExample");
		return sqlSessionTemplate.selectOne(sqlId("countByExample"), example);
	}

	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at deleteByExample");
		return sqlSessionTemplate.delete(sqlId("deleteByExample"), example);
	}

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		logger.debug("at deleteByPrimaryKey");
		return sqlSessionTemplate.delete(sqlId("deleteByPrimaryKey"), id);
	}

	public int insert(User record) {
		// TODO Auto-generated method stub
		logger.debug("at insert");
		return sqlSessionTemplate.insert(sqlId("insert"), record);
	}

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		logger.debug("at insertSelective");
		return sqlSessionTemplate.insert(sqlId("insertSelective"), record);
	}

	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at selectByExample");
		return sqlSessionTemplate.selectList(sqlId("selectByExample"), example);
	}

	
	public List<User> selectByExamplePaging(UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at selectByExample");
		return sqlSessionTemplate.selectList(sqlId("selectByExamplePaging"), example);
	}

	
	
	public User selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		logger.debug("at selectByPrimaryKey");
		return sqlSessionTemplate.selectOne(sqlId("selectByPrimaryKey"), id);
	}

	public int updateByExampleSelective(User record, UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at updateByExampleSelective");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return sqlSessionTemplate
				.update(sqlId("updateByExampleSelective"), map);

	}

	public int updateByExample(User record, UserExample example) {
		// TODO Auto-generated method stub
		logger.debug("at updateByExample");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return sqlSessionTemplate.update(sqlId("updateByExample"), map);
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		logger.debug("at updateByPrimaryKeySelective");
		return sqlSessionTemplate.update(sqlId("updateByPrimaryKeySelective"),
				record);
	}

	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		logger.debug("at updateByPrimaryKey");
		return sqlSessionTemplate.update(sqlId("updateByPrimaryKey"), record);
	}

}
