package com.school.book.bll;

import java.util.List;

import com.school.book.bean.UserInfoBean;
import com.school.book.dao.UserInfoDAO;

/**
 * 用户信息业务逻辑
 */
public class UserInfoBll {
	private UserInfoDAO userInfoDAO;
	/**
	 * 修改个人信息
	 * @param userInfoBean
	 */
	public void updateUserInfo(UserInfoBean userInfoBean){
		userInfoDAO.updateUserInfo(userInfoBean);
	}
	/**
	 * 查找所有用户的信息
	 * @return
	 */
	public List<UserInfoBean> selectAllUser(){
		return userInfoDAO.selectAllUsers();
	}
	/**
	 * 删除用户
	 * @param userName
	 */
	public void deleteUser(String userName){
		userInfoDAO.deleteUser(userName);
	}
	/**
	 * 查找某个用户的信息
	 * @param userName
	 * @return
	 */
	public UserInfoBean selectUserByName(String userName){
		return userInfoDAO.selectByUserName(userName);
	}
}
