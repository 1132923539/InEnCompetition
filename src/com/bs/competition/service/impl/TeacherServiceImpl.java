package com.bs.competition.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.competition.control.util.PagingUtil;
import com.bs.competition.control.util.ToolsUtil;
import com.bs.competition.dao.inf.FilesMapper;
import com.bs.competition.dao.inf.SchoolMapper;
import com.bs.competition.dao.inf.ScoreMapper;
import com.bs.competition.dao.inf.StuApplyMapper;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.dao.inf.TeacherMapper;
import com.bs.competition.dao.inf.UserMapper;
import com.bs.competition.entity.complex.FullStuApply;
import com.bs.competition.entity.complex.FullTeacher;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.ScoreExample;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.StuApplyExample;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.StudentExample;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;
import com.bs.competition.paramEntity.StuApplyParam;
import com.bs.competition.service.inf.ITeacherService;

/**
 * 指导老师实现层
 * @author luxinhuo
 */

@Service("front_teacherServiceImpl")
public class TeacherServiceImpl implements ITeacherService{
	
	@Autowired
	@Resource(name = "bs_teacher")
	private TeacherMapper teacherMapper;
	
	@Autowired
	@Resource(name = "bs_school")
	private SchoolMapper schoolMapper;
	
	@Autowired
	@Resource(name = "bs_user")
	private UserMapper userMapper;
	
	@Autowired
	@Resource(name = "bs_stuApply")
	private StuApplyMapper stuApplyMapper;
	
	@Autowired
	@Resource(name = "bs_student")
	private StudentMapper studentMapper;
	
	@Autowired
	@Resource(name = "bs_score")
	private ScoreMapper scoreMapper;
	
	@Autowired
	@Resource(name = "bs_files")
	private FilesMapper filesMapper;
	
	
	/**
	 * 查询评委老师的详情
	 * @author luxinhuo
	 * @param teacherId
	 * @return FullTeacher
	 */
	public FullTeacher getTeacherById(String teacherId){
		
		if(!ToolsUtil.notEmpty(teacherId)){
			return null;
		}
		FullTeacher fullTeacher = new FullTeacher();
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
		fullTeacher.setTeacher(teacher);
		fullTeacher.setSchool(schoolMapper.selectByPrimaryKey(teacher.getSchoolid()));
		fullTeacher.setUser(userMapper.selectByPrimaryKey(teacher.getUserid()));
		return fullTeacher;
	}
	/**
	 * 删除评委老师
	 * @author luxinhuo
	 * @param teacherId
	 * @return int
	 */
	public int deleteTeacherById(Teacher teacher){
		
		int res = teacherMapper.updateByPrimaryKeySelective(teacher);
		return res;
	}
	
	/**
	 * 修改评委老师的个人信息
	 * @author luxinhuo
	 * @param teacher
	 * @param user
	 * @return int
	 */
	public int modifyMySelfByEntity(Teacher teacher,User user){
		
		if(teacher==null||user==null){
			return 0;
		}
		int result = teacherMapper.updateByPrimaryKeySelective(teacher);
		if(result>0){
			Teacher tea = teacherMapper.selectByPrimaryKey(teacher.getId());
			user.setId(tea.getUserid());
			result = userMapper.updateByPrimaryKeySelective(user);
		}
		return result;
	}
	
	/**
	 * 老师查看报名学生列表的条数
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int getStuApplyStudentCountBy(StuApplyParam stuApplyParam){
		
		if(stuApplyParam==null){
			return 0;
		}
		StuApplyExample stuApplyExample = new StuApplyExample();
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		stuApplyCri.andGroupsEqualTo(stuApplyParam.getGroups());
		int record = stuApplyMapper.countByExample(stuApplyExample);
		return record;
	}
	
	/**
	 * 老师查看报名学生列表
	 * @author luxinhuo
	 * @param pageing
	 * @return List<FullStuApply>
	 */
	public List<FullStuApply> getPagingByStuApplyStudentParam(PagingUtil pageing){
		
		if(pageing==null){
			return null;
		}
		StuApplyExample stuApplyExample = new StuApplyExample();
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		StuApplyParam stuApplyParam = (StuApplyParam)pageing.getParam();
		stuApplyCri.andGroupsEqualTo(stuApplyParam.getGroups());
		stuApplyExample.setStart(pageing.getDbIndex());
		stuApplyExample.setEnd(pageing.getDbNumber());
		stuApplyExample.setOrderByClause("addtime desc");
		List<StuApply> listStuApply = stuApplyMapper.selectByExamplePaging(stuApplyExample);
		List<FullStuApply> listFullStuApply = new ArrayList<FullStuApply>();
		if(listStuApply.size()>0){
			for(int i=0;i<listStuApply.size();i++){
				FullStuApply fullStuApply = new FullStuApply();
				fullStuApply.setStuApply(listStuApply.get(i));
				Student student = studentMapper.selectByPrimaryKey(listStuApply.get(i).getStudentid());
				fullStuApply.setStudent(student);
				fullStuApply.setSchool(schoolMapper.selectByPrimaryKey(student.getSchoolid()));
				ScoreExample scoreExample = new ScoreExample();
				ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
				scoreCri.andStudentidEqualTo(student.getId());
				scoreCri.andTeacheridEqualTo(stuApplyParam.getTeacherId());
				List<Score> listScore = scoreMapper.selectByExample(scoreExample);
				if(listScore.size()>0){
					fullStuApply.setIsScore(1);
				}else{
					fullStuApply.setIsScore(0);
				}
				listFullStuApply.add(fullStuApply);
			}
		}
		return listFullStuApply;
	}
	
	/**
	 * 查看报名学生的详情
	 * @author luxinhuo
	 * @param stuApplyId
	 * @return
	 */
	public FullStuApply getStuApplyStudent(String stuApplyId){
		if(!ToolsUtil.notEmpty(stuApplyId)){
			return null;
		}
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Teacher tea=(Teacher) session.getAttribute("teacher");

		FullStuApply fullStuApply = new FullStuApply();
		StuApply stuApply = stuApplyMapper.selectByPrimaryKey(stuApplyId);
		fullStuApply.setStuApply(stuApply);
		Student student = studentMapper.selectByPrimaryKey(stuApply.getStudentid());
		fullStuApply.setStudent(student);
		fullStuApply.setSchool(schoolMapper.selectByPrimaryKey(student.getSchoolid()));
		fullStuApply.setFiles(filesMapper.selectByPrimaryKey(stuApply.getFileid()));
		ScoreExample scoreExample = new ScoreExample();
		ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
		scoreCri.andStudentidEqualTo(student.getId());
		scoreCri.andTeacheridEqualTo(tea.getId());
		List<Score> listScore = scoreMapper.selectByExample(scoreExample);
		if(listScore.size()>0){
			fullStuApply.setIsScore(1);
		}else{
			fullStuApply.setIsScore(0);
		}
		return fullStuApply;
	}
	
	/**
	 * 评分
	 * @author luxinhuo
	 * @param score
	 * @return int
	 */
	public int addScore(Score score){
		
		if(score==null){
			return 0;
		}
		int res = scoreMapper.insert(score);
		return res;
	}
}
