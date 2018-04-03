package com.bs.competition.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bs.competition.control.util.ToolsUtil;
import com.bs.competition.dao.inf.FilesMapper;
import com.bs.competition.dao.inf.SchoolMapper;
import com.bs.competition.dao.inf.ScoreMapper;
import com.bs.competition.dao.inf.StuApplyMapper;
import com.bs.competition.dao.inf.StudentMapper;
import com.bs.competition.dao.inf.TeacherMapper;
import com.bs.competition.dao.inf.UserMapper;
import com.bs.competition.entity.complex.FullStudent;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.ScoreExample;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.StuApplyExample;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.TeacherExample;
import com.bs.competition.entity.simple.User;
import com.bs.competition.service.inf.IStudentService;

/**
 * 学生实现层
 * @author luxinhuo
 */

@Service("front_studentServiceImpl")
public class StudentServiceImpl implements IStudentService{
	@Autowired
	@Resource(name = "bs_student")
	private StudentMapper studentMapper;
	
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
	@Resource(name = "bs_files")
	private FilesMapper filesMapper;
	
	@Autowired
	@Resource(name = "bs_score")
	private ScoreMapper scoreMapper;
	
	@Autowired
	@Resource(name = "bs_teacher")
	private TeacherMapper teacherMapper;
	
	
	/**
	 * 查看学生详情
	 * @author luxinhuo
	 * @param studentId
	 * @return FullStudent
	 */
	public FullStudent detailStudent(String studentId){
		if(!ToolsUtil.notEmpty(studentId)){
			return null;
		}
		FullStudent fullStudent = new FullStudent();
		Student student = studentMapper.selectByPrimaryKey(studentId);
		fullStudent.setStudent(student);
		fullStudent.setSchool(schoolMapper.selectByPrimaryKey(student.getSchoolid()));
		fullStudent.setUser(userMapper.selectByPrimaryKey(student.getUserid()));
		if(student.getIsapply()==1){
			StuApplyExample stuApplyExample = new StuApplyExample();
			StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
			stuApplyCri.andStudentidEqualTo(studentId);
			List<StuApply> listStuApply = stuApplyMapper.selectByExample(stuApplyExample);
			if(listStuApply.size()>0){
				fullStudent.setStuApply(listStuApply.get(0));
				fullStudent.setFiles(filesMapper.selectByPrimaryKey(listStuApply.get(0).getFileid()));
				if(listStuApply.get(0).getGroups()!=null){
					TeacherExample teacherExample = new TeacherExample();
					TeacherExample.Criteria teacherCri = teacherExample.createCriteria();
					teacherCri.andGroupsEqualTo(listStuApply.get(0).getGroups());
					List<Teacher> listTeacher = teacherMapper.selectByExample(teacherExample);
					if(listTeacher.size()>0){
						fullStudent.setTeacher(teacherMapper.selectByExample(teacherExample).get(0));
				
					}
				}
			}
		}
		return fullStudent;
	}
	
	/**
	 * 删除学生
	 * @author luxinhuo
	 * @param student
	 * @return int
	 */
	public int deleteStudentById(Student student){
		if(student==null){
			return 0;
		}
		int res = studentMapper.updateByPrimaryKeySelective(student);
		return res;
	}
	
	/**
	 * 修改个人信息
	 * @author luxinhuo
	 * @param student
	 * @param user
	 * @return int
	 */
	public int modifyMySelfByEntity(Student student,User user){
		if(student==null||user==null){
			return 0;
		}
		int result = studentMapper.updateByPrimaryKeySelective(student);
		if(result>0){
			Student stu = studentMapper.selectByPrimaryKey(student.getId());
			user.setId(stu.getUserid());
			result = userMapper.updateByPrimaryKeySelective(user);
		}
		return result;
	}
	
	/**
	 * 报名
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int apply(StuApply stuApply){
		if(stuApply==null){
			return 0;
		}
		int res =0;
		res = stuApplyMapper.insertSelective(stuApply);
		Student student = new Student();
		student.setId(stuApply.getStudentid());
		student.setIsapply(1);
		res = studentMapper.updateByPrimaryKeySelective(student);
		return res;
	}
	
	/**
	 * 修改我的报名信息
	 * @author luxinhuo
	 * @param stuApply
	 * @return int
	 */
	public int updateStuApplyByEntity(StuApply stuApply){
		if(stuApply==null){
			return 0;
		}
		int res=stuApplyMapper.updateByPrimaryKeySelective(stuApply);
		return res;
	}
	
	/**
	 * 查看我的作品是否有老师评分
	 * @author luxinhuo
	 * @param studentId
	 * @return int
	 */
	public int checkModify(String studentId){
		if(!ToolsUtil.notEmpty(studentId)){
			return 0;
		}
		ScoreExample scoreExample = new ScoreExample();
		ScoreExample.Criteria scoreCri = scoreExample.createCriteria();
		scoreCri.andStudentidEqualTo(studentId);
		List<Score> listScore = scoreMapper.selectByExample(scoreExample);
		if(listScore.size()>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 查看某组的人数 
	 * @author luxinhuo
	 * @param groups
	 * @return int
	 */
	public int getApplyByGroups(Integer groups){
		if(groups==0){
			return 0;
		}
		StuApplyExample stuApplyExample = new StuApplyExample();
		StuApplyExample.Criteria stuApplyCri = stuApplyExample.createCriteria();
		stuApplyCri.andGroupsEqualTo(groups);
		int record = stuApplyMapper.countByExample(stuApplyExample);
		return record;
	}
}
