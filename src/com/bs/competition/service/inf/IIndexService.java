package com.bs.competition.service.inf;

import java.util.List;

import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.paramEntity.NewsParam;

/*大赛首页实现层*/

/**
 * 
 * 
 * @author Administrator
 */
public interface IIndexService {

	/**
	 * 查询大赛新闻列表的条数
	 * @author luxinhuo
	 * @param newsParam
	 * @return int
	 */
	public int getNewsCountBy(NewsParam newsParam);
	
	/**
	 * 查询大赛新闻列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullNews>
	 */
	public List<FullNews> getPagingByNewsParam(PagingUtil pageing);
	
	/**
	 * 查看大赛新闻详情
	 * @author luxinhuo
	 * @param newsId
	 * @return FullNews
	 */
	public FullNews getNewsById(String newsId);
	
	/**
	 * 查看报名学生列表的条数
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int getStuApplyCountBy(StuApply stuApply);
	
	/**
	 * 查看报名学生的列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByStuApplyParam(PagingUtil pageing);
	
	/**
	 * 查看作品详情
	 * @author luxinhuo
	 * @param stuApplyId
	 * @return FullStuApply
	 */
	public FullStuApply getStuApplyById(String stuApplyId);
	
	/**
	 * 查询所有新闻列表
	 * @author luxinhuo
	 * @param newsParam
	 * @return
	 */
	public List<FullNews> getFullNewsByEntity(NewsParam newsParam);
}
