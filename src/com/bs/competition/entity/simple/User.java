package com.bs.competition.entity.simple;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.username
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.type
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private Integer type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.username
	 * @return  the value of user.username
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.username
	 * @param username  the value for user.username
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.type
	 * @return  the value of user.type
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.type
	 * @param type  the value for user.type
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.remark
	 * @return  the value of user.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.remark
	 * @param remark  the value for user.remark
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}