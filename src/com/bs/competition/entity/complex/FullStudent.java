package com.bs.competition.entity.complex;

import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;

public class FullStudent {
	private Student student;
	private School school;
	private StuApply stuApply;
	private User user;
	private Files files;
	private Teacher teacher;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public StuApply getStuApply() {
		return stuApply;
	}
	public void setStuApply(StuApply stuApply) {
		this.stuApply = stuApply;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
