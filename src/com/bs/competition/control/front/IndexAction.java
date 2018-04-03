package com.bs.competition.control.front;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.paramEntity.NewsParam;
import com.bs.competition.service.inf.IAdminService;
import com.bs.competition.service.inf.IIndexService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("front_indexAction")
@Scope("request")
public class IndexAction extends ActionSupport{
	
	@Resource(name = "front_indexServiceImpl")
	private IIndexService indexService;
	
	
	@Resource(name = "front_adminServiceImpl")
	private IAdminService adminService;
	
	
	private List<FullNews> listFullNews = new ArrayList<FullNews>();
	private List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();//复杂的学生报名实体类列表
	private PagingUtil page = new PagingUtil();//分页
	private List<FullTeacher> listFullTeacher = new ArrayList<FullTeacher>();//老师的复杂实体类列表
	
	private FullNews fullNews = new FullNews();//复杂的新闻实体类
	private StuApply stuApply = new StuApply();//学生报名实体类
	private FullStuApply fullStuApply = new FullStuApply();//报名学生实体类
	private Teacher teacher = new Teacher();//教师的实体类
	
	private NewsParam newsParam = new NewsParam();
	private String actionurl; // 重定向
	private String currentPage;//当前页
	private Integer type;//新闻类型
	private String newsId;//新闻的ID
	private String stuApplyId;//报名学生ID
	
	/**
	 * 进入大赛首页
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String index() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		newsParam.setStatus(1);
		int recordCnt = indexService.getNewsCountBy(newsParam);
		page.setTotalNumber(recordCnt);
		page.setParam(newsParam);
		
		listFullNews = indexService.getFullNewsByEntity(newsParam);
		
		listFullStuApply = indexService.getPagingByStuApplyParam(page);
		return SUCCESS;
	}

	/**
	 * 查看大赛新闻的列表
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllNews() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		newsParam.setStatus(1);
		newsParam.setType(0);
		int recordCnt = indexService.getNewsCountBy(newsParam);
		page.setTotalNumber(recordCnt);
		page.setParam(newsParam);
		
		listFullNews = indexService.getPagingByNewsParam(page);
		return SUCCESS;
	}
	
	/**
	 * 查看大赛公告的列表
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllNotice() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		newsParam.setStatus(1);
		newsParam.setType(1);
		int recordCnt = indexService.getNewsCountBy(newsParam);
		page.setTotalNumber(recordCnt);
		page.setParam(newsParam);
		
		listFullNews = indexService.getPagingByNewsParam(page);
		return SUCCESS;
	}
	
	
	/**
	 * 查看新闻的详情
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailNews() throws Exception{
		
		fullNews = indexService.getNewsById(newsId);
		return SUCCESS;
	}
	
	/**
	 * 查看作品列表
	 * @author chenmegnqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	
	public String listAllStuApply() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = indexService.getStuApplyCountBy(stuApply);
		page.setTotalNumber(recordCnt);
		
		listFullStuApply = indexService.getPagingByStuApplyParam(page);
		return SUCCESS;
	}

	/**
	 * 查看作品详情
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String detailStuApply() throws Exception{
		
		fullStuApply = indexService.getStuApplyById(stuApplyId);
		return SUCCESS;
	}
	
	/**
	 * 查询评委老师列表
	 * @author chenmegnqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String listAllTeacher() throws Exception{
		
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null || !pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		int recordCnt = adminService.getTeacherCountBy(teacher);
		page.setTotalNumber(recordCnt);
		page.setParam(teacher);
		
		listFullTeacher = adminService.getPagingByTeacherParam(page);
		return SUCCESS;
	}
	
	/**
	 * 进入大赛介绍页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String introduce() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入组织架构页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String organization() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入赛事安排页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String arrange() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入联系方式页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String contact() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入政策标准页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String support() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入创业咨询页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String consultation() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入参赛条件准页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String condition() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入报名流程页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String way() throws Exception{
		
		return SUCCESS;
	}
	
	/**
	 * 进入奖励机制页面
	 * @author chenmengqiu
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String reward() throws Exception{
		
		return SUCCESS;
	}
	
	public List<FullNews> getListFullNews() {
		return listFullNews;
	}

	public void setListFullNews(List<FullNews> listFullNews) {
		this.listFullNews = listFullNews;
	}

	public PagingUtil getPage() {
		return page;
	}

	public void setPage(PagingUtil page) {
		this.page = page;
	}

	public NewsParam getNewsParam() {
		return newsParam;
	}

	public void setNewsParam(NewsParam newsParam) {
		this.newsParam = newsParam;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getActionurl() {
		return actionurl;
	}

	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public FullNews getFullNews() {
		return fullNews;
	}

	public void setFullNews(FullNews fullNews) {
		this.fullNews = fullNews;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public List<FullStuApply> getListFullStuApply() {
		return listFullStuApply;
	}

	public void setListFullStuApply(List<FullStuApply> listFullStuApply) {
		this.listFullStuApply = listFullStuApply;
	}

	public StuApply getStuApply() {
		return stuApply;
	}

	public void setStuApply(StuApply stuApply) {
		this.stuApply = stuApply;
	}

	public FullStuApply getFullStuApply() {
		return fullStuApply;
	}

	public void setFullStuApply(FullStuApply fullStuApply) {
		this.fullStuApply = fullStuApply;
	}

	public String getStuApplyId() {
		return stuApplyId;
	}

	public void setStuApplyId(String stuApplyId) {
		this.stuApplyId = stuApplyId;
	}

	public List<FullTeacher> getListFullTeacher() {
		return listFullTeacher;
	}

	public void setListFullTeacher(List<FullTeacher> listFullTeacher) {
		this.listFullTeacher = listFullTeacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
