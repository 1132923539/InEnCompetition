package com.bs.competition.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.control.util.ToolsUtil;
import com.bs.competition.dao.inf.AdminMapper;
import com.bs.competition.dao.inf.FilesMapper;
import com.bs.competition.dao.inf.ImageMapper;
import com.bs.competition.dao.inf.NewsMapper;
import com.bs.competition.dao.inf.StuApplyMapper;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.dao.inf.TeacherMapper;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.simple.News;
import com.bs.competition.entity.simple.NewsExample;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.StuApplyExample;
import com.bs.competition.paramEntity.NewsParam;
import com.bs.competition.paramEntity.StuApplyParam;
import com.bs.competition.service.inf.IIndexService;


/*大赛首页实现层*/
@Service("front_indexServiceImpl")
public class IndexServiceImpl implements IIndexService{

	@Autowired
	@Resource(name = "bs_news")
	private NewsMapper newsMapper;

	@Autowired
	@Resource(name = "bs_admin")
	private AdminMapper adminMapper;

	@Autowired
	@Resource(name = "bs_stuApply")
	private StuApplyMapper stuApplyMapper;

	@Autowired
	@Resource(name = "bs_student")
	private StudentMapper studentMapper;

	@Autowired
	@Resource(name = "bs_files")
	private FilesMapper filesMapper;

	/**
	 * 查询大赛新闻列表的条数
	 * @author luxinhuo
	 * @param newsParam
	 * @return int
	 */
	public int getNewsCountBy(NewsParam newsParam){
		
		if(newsParam==null){
			return 0;
		}
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria newsCri = newsExample.createCriteria();
		newsCri.andSysstatusEqualTo(newsParam.getStatus());
		if(newsParam.getType()!=null){
			newsCri.andTypeEqualTo(newsParam.getType());
		}
		if(ToolsUtil.notEmpty(newsParam.getTitle())){
			newsCri.andTitleLike("%" + newsParam.getTitle() + "%");
		}
		int record = newsMapper.countByExample(newsExample);
		return record;
	}
	
	/**
	 * 查询大赛新闻列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullNews>
	 */
	public List<FullNews> getPagingByNewsParam(PagingUtil pageing){
		
		if(pageing==null){
			return null;
		}
		
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria newsCri = newsExample.createCriteria();
		NewsParam newsParam = (NewsParam)pageing.getParam();
		newsCri.andSysstatusEqualTo(newsParam.getStatus());
		if(newsParam.getType()!=null){
			newsCri.andTypeEqualTo(newsParam.getType());
		}
		if(ToolsUtil.notEmpty(newsParam.getTitle())){
			newsCri.andTitleLike("%" + newsParam.getTitle() + "%");
		}
		List<News> listNews = new ArrayList<News>();
		newsExample.setStart(pageing.getDbIndex());
		newsExample.setEnd(pageing.getDbNumber());
		newsExample.setOrderByClause("addtime desc");
		listNews = newsMapper.selectByExamplePaging(newsExample);
		List<FullNews> listFullNews = new ArrayList<FullNews>();
		for(int i=0;i<listNews.size();i++){
			FullNews fullNews = new FullNews();
			fullNews.setNews(newsMapper.selectByPrimaryKey(listNews.get(i).getId()));
			fullNews.setAdmin(adminMapper.selectByPrimaryKey(listNews.get(i).getPubid()));
			listFullNews.add(fullNews);
		}
		return listFullNews;
	}
	
	/**
	 * 查看大赛新闻详情
	 * @author luxinhuo
	 * @param newsId
	 * @return FullNews
	 */
	public FullNews getNewsById(String newsId){
		if(!(ToolsUtil.notEmpty(newsId))){
			return null;
		}
		FullNews fullNews = new FullNews();
		News news = newsMapper.selectByPrimaryKey(newsId);
		fullNews.setNews(news);
		fullNews.setAdmin(adminMapper.selectByPrimaryKey(news.getPubid()));
		return fullNews;
	}
	
	/**
	 * 查看报名学生列表的条数
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int getStuApplyCountBy(StuApply stuApply){
		
		if(stuApply==null){
			return 0;
		}
		StuApplyExample stuApplyExample = new StuApplyExample();
		int record = stuApplyMapper.countByExample(stuApplyExample);
		return record;
	}
	
	/**
	 * 查看报名学生的列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByStuApplyParam(PagingUtil pageing){
		if(pageing==null){
			return null;
		}
		StuApplyExample stuApplyExample = new StuApplyExample();
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		stuApplyExample.setStart(pageing.getDbIndex());
		stuApplyExample.setEnd(pageing.getDbNumber());
		stuApplyExample.setOrderByClause("addtime desc");
		List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();
		List<StuApply> listStuApply = new ArrayList<StuApply>();
		listStuApply = stuApplyMapper.selectByExamplePaging(stuApplyExample);
		for(int i=0;i<listStuApply.size();i++){
			FullStuApply fullStuApply = new FullStuApply();
			fullStuApply.setStuApply(listStuApply.get(i));
			fullStuApply.setStudent(studentMapper.selectByPrimaryKey(listStuApply.get(i).getStudentid()));
			fullStuApply.setFiles(filesMapper.selectByPrimaryKey(listStuApply.get(i).getFileid()));
			
			listFullStuApply.add(fullStuApply);
		}
		return listFullStuApply;
	}
	
	/**
	 * 查看作品详情
	 * @author luxinhuo
	 * @param stuApplyId
	 * @return FullStuApply
	 */
	public FullStuApply getStuApplyById(String stuApplyId){
		
		if(!ToolsUtil.notEmpty(stuApplyId)){
			return null;
		}
		FullStuApply fullStuApply = new FullStuApply();
		StuApply stuApply = stuApplyMapper.selectByPrimaryKey(stuApplyId);
		fullStuApply.setStuApply(stuApply);
		fullStuApply.setStudent(studentMapper.selectByPrimaryKey(stuApply.getStudentid()));
		fullStuApply.setFiles(filesMapper.selectByPrimaryKey(stuApply.getFileid()));
		return fullStuApply;
	}
	
	/**
	 * 查询所有新闻列表
	 * @author luxinhuo
	 * @param newsParam
	 * @return
	 */
	public List<FullNews> getFullNewsByEntity(NewsParam newsParam){
		if(newsParam==null){
			return null;
		}
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria newsCri = newsExample.createCriteria();
		newsCri.andSysstatusEqualTo(newsParam.getStatus());
		if(newsParam.getType()!=null){
			newsCri.andTypeEqualTo(newsParam.getType());
		}
		if(ToolsUtil.notEmpty(newsParam.getTitle())){
			newsCri.andTitleLike("%" + newsParam.getTitle() + "%");
		}
		List<News> listNews = new ArrayList<News>();
		newsExample.setOrderByClause("addtime desc");
		listNews = newsMapper.selectByExample(newsExample);
		List<FullNews> listFullNews = new ArrayList<FullNews>();
		for(int i=0;i<listNews.size();i++){
			FullNews fullNews = new FullNews();
			fullNews.setNews(newsMapper.selectByPrimaryKey(listNews.get(i).getId()));
			fullNews.setAdmin(adminMapper.selectByPrimaryKey(listNews.get(i).getPubid()));
			listFullNews.add(fullNews);
		}
		return listFullNews;
	}
}
