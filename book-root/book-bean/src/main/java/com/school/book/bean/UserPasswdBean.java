package com.school.book.bean;

public class UserPasswdBean {
	/**
	 * 编号
	 */
	private int code;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPasswd;
	/**
	 * key
	 */
	private String passwdKey;
	/**
	 * 帐号类型
	 */
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserPasswdBean(int code, String userPasswd,
			String passwdKey, String userType) {
		super();
		this.code = code;
		this.userPasswd = userPasswd;
		this.passwdKey = passwdKey;
		this.userType = userType;
	}

	public UserPasswdBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getPasswdKey() {
		return passwdKey;
	}

	public void setPasswdKey(String passwdKey) {
		this.passwdKey = passwdKey;
	}

}
