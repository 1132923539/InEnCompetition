package com.bs.competition.entity.complex;

import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.Teacher;
import com.bs.competition.entity.simple.User;

public class FullTeacher {
	private Teacher teacher;
	private School school;
	private User user;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
