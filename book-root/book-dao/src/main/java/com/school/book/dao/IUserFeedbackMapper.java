package com.school.book.dao;

import java.util.List;

import com.school.book.bean.UserFeedbackBean;

public interface IUserFeedbackMapper {
	/**
	 * 插入用户反馈
	 * @param userFeedbackBean
	 */
	public void insertFeedback(UserFeedbackBean userFeedbackBean);
	/**
	 * 查询搜有反馈
	 * @return
	 */
	public List<UserFeedbackBean> selectFeedback();
}
