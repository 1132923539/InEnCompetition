package com.bs.competition.entity.simple;

public class StuApply {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.studentid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String studentid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.card
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String card;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.addtime
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private Long addtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.fileid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String fileid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.groups
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private Integer groups;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuapply.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.id
	 * @return  the value of stuapply.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.id
	 * @param id  the value for stuapply.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.studentid
	 * @return  the value of stuapply.studentid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getStudentid() {
		return studentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.studentid
	 * @param studentid  the value for stuapply.studentid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setStudentid(String studentid) {
		this.studentid = studentid == null ? null : studentid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.card
	 * @return  the value of stuapply.card
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getCard() {
		return card;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.card
	 * @param card  the value for stuapply.card
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setCard(String card) {
		this.card = card == null ? null : card.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.addtime
	 * @return  the value of stuapply.addtime
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public Long getAddtime() {
		return addtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.addtime
	 * @param addtime  the value for stuapply.addtime
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.fileid
	 * @return  the value of stuapply.fileid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getFileid() {
		return fileid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.fileid
	 * @param fileid  the value for stuapply.fileid
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setFileid(String fileid) {
		this.fileid = fileid == null ? null : fileid.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.groups
	 * @return  the value of stuapply.groups
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public Integer getGroups() {
		return groups;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.groups
	 * @param groups  the value for stuapply.groups
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setGroups(Integer groups) {
		this.groups = groups;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuapply.remark
	 * @return  the value of stuapply.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuapply.remark
	 * @param remark  the value for stuapply.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}