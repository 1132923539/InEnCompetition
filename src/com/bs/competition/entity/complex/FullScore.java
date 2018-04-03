package com.bs.competition.entity.complex;

import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;

public class FullScore {
	private Integer newscore;//新颖性
	private Integer prascore;//实用性
	private Integer feascore;//可行性
	private Integer totalscore;//综合得分
	private Teacher teacher;//老师实体类
	private Student student;//学生实体类
	
	public Integer getNewscore() {
		return newscore;
	}
	public void setNewscore(Integer newscore) {
		this.newscore = newscore;
	}
	public Integer getPrascore() {
		return prascore;
	}
	public void setPrascore(Integer prascore) {
		this.prascore = prascore;
	}
	public Integer getFeascore() {
		return feascore;
	}
	public void setFeascore(Integer feascore) {
		this.feascore = feascore;
	}
	public Integer getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(Integer totalscore) {
		this.totalscore = totalscore;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
