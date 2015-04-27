package com.school.book.bean;

public class UserInfoBean {
	/**
	 * 编号
	 */
	private int code;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 密保邮箱
	 */
	private String userEmail;
	/**
	 * 帐号类型
	 */
	private String userType;

	public UserInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoBean(int code, String userName, String realName,
			String idCard, String userEmail, String userType) {
		super();
		this.code = code;
		this.userName = userName;
		this.realName = realName;
		this.idCard = idCard;
		this.userEmail = userEmail;
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
