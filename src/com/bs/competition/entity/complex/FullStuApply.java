package com.bs.competition.entity.complex;

import com.bs.competition.entity.simple.Files;
import com.bs.competition.entity.simple.School;
import com.bs.competition.entity.simple.Score;
import com.bs.competition.entity.simple.StuApply;
import com.bs.competition.entity.simple.Student;

public class FullStuApply {

	private StuApply stuApply;
	private Student student;
	private School school;
	private Score score;
	private Integer isScore;
	private Files files;
	
	public StuApply getStuApply() {
		return stuApply;
	}
	public void setStuApply(StuApply stuApply) {
		this.stuApply = stuApply;
	}
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
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public Integer getIsScore() {
		return isScore;
	}
	public void setIsScore(Integer isScore) {
		this.isScore = isScore;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}

}
