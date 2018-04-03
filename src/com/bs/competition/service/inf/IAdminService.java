package com.bs.competition.service.inf;

import java.util.List;
import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.entity.complex.FullNews;
import com.bs.competition.entity.complex.FullScore;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Admin;
import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.Image;
import com.bs.competition.entity.simple.News;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;

/**
 * 管理员实现层接口
 * @author luxinhuo
 */
public interface IAdminService {
	
	//大赛管理员
	/**
	 * 分页查询大赛管理员列表的条数
	 * @author luxinhuo
	 * @param admin
	 * @return int
	 */
	public int getAdminCountBy(Admin admin);
	
	/**
	 * 分页查询大赛管理员列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<Admin>
	 */
	public List<Admin> getPagingByAdminParam(PagingUtil pageing);
	
	/**
	 * 新增大赛管理员
	 * @author luxinhuo
	 * @param admin
	 * @param user
	 * @return int
	 */
	public int insertAdminByEntity(Admin admin,User user);
	
	/**
	 * 根据id查询大赛管理员详情
	 * @author luxinhuo
	 * @param adminId
	 * @return Admin
	 */
	public Admin getAdminById(String adminId);
	
	/**
	 * 删除还原大赛管理员
	 * @author luxinhuo
	 * @param admin
	 * @return int
	 */
	public int deleteAdminById(Admin admin);
	
	//评委老师
	/**
	 * 分页查询评委老师列表的条数
	 * @author luxinhuo
	 * @param teacher
	 * @return int
	 */
	public int getTeacherCountBy(Teacher teacher);
	
	/**
	 * 分页查询评委老师列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullTeacher>
	 */
	public List<FullTeacher> getPagingByTeacherParam(PagingUtil pageing);
	
	/**
	 * 新增评委老师
	 * @author luxinhuo
	 * @param teacher
	 * @param user
	 * @return int
	 */
	public int insertTeacherByEntity(Teacher teacher,User user);
	
	
	//注册学生
	/**
	 * 分页查询注册学生列表的条数
	 * @author luxinhuo
	 * @param student
	 * @return int
	 */
	public int getStudentCountBy(Student student);
	
	/**
	 * 分页查询注册学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStudent>
	 */
	public List<FullStudent> getPagingByStudentParam(PagingUtil pageing);
	
	//参赛学生
	/**
	 * 分页查询参赛学生列表的条数
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int getApplyStudentCountBy(StuApply stuApply);
	
	/**
	 * 分页查询参赛学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByApplyStudentParam(PagingUtil pageing);
	
	/**
	 * 统计学生得分
	 * @author luxinhuo
	 * @param studentId
	 * @return List<FullScore>
	 */
	public List<FullScore> accountScore(String studentId);
	
	/**
	 * 统计最终得分
	 * @author luxinhuo 
	 * @param studentId
	 * @return int
	 */
	public int totalScore(String studentId);
	
	//大赛新闻
	/**
	 * 分页查询大赛新闻列表的条数
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int getNewsCountBy(News news);
	
	/**
	 * 分页查询大赛新闻列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullNews>
	 */
	public List<FullNews> getPagingByNewsParam(PagingUtil pageing);
	
	
	//上传图片
	/**
	 * 上传图片
	 * @author luxinhuo
	 * @param image
	 * @return int
	 */
	public int insertImage(Image image);
	
	/**
	 * 上传文件
	 * @author luxinhuo
	 * @param files
	 * @return
	 */
	public int insertFile(Files files);
	
	/**
	 * 新增新闻
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int insertNewsByEntity(News news);
	
	/**
	 * 查看大赛新闻的详情
	 * @author luxinhuo
	 * @param newsId
	 * @return FullNews
	 */
	public FullNews getNewsById(String newsId);
	
	/**
	 * 删除大赛新闻
	 * @author luxinhuo
	 * @param news
	 * @return int
	 */
	public int updateNewsByEntity(News news);
	
	/**
	 * 根据imageId查询
	 * @author luxinhuo
	 * @param imageId
	 * @return Image
	 */
	public Image getImageByNum(String imageId);
	
	/**
	 * 下载文件
	 * @author luxinhuo
	 * @param fileId
	 * @return Files
	 */
	public Files getFileById(String fileId);
}
