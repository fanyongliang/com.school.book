package com.school.book.bll;

import java.util.List;

import com.school.book.bean.UserFeedbackBean;
import com.school.book.dao.UserFeedbackDAO;

public class UserFeedbackBll {
	private UserFeedbackDAO userFeedbackDAO;
	/**
	 * 增加用户反馈
	 * @param userFeedbackBean
	 */
	public void insertFeedback(UserFeedbackBean userFeedbackBean){
		userFeedbackDAO.insertFeedback(userFeedbackBean);
	}
	/**
	 * 查询所有反馈
	 * @return
	 */
	public List<UserFeedbackBean> selectFeedback(){
		return userFeedbackDAO.selectFeedback();
	}
}
