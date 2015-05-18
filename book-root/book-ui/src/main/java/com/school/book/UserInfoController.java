package com.school.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.book.bean.UserInfoBean;
import com.school.book.bll.UserInfoBll;

/**
 * 用户个人信息管理
 */
@Controller
@RequestMapping("user")
public class UserInfoController {
	private UserInfoBll userInfoBll;
	/**
	 * 更新个人信息
	 */
	@RequestMapping("updateInfo")
	@ResponseBody
	public void updateInfo(UserInfoBean userInfoBean) {
		userInfoBll.updateUserInfo(userInfoBean);
	}
	/**
	 * 查看个人信息
	 */
	@RequestMapping("selcetUserInfo")
	@ResponseBody
	public void selcetUserInfo(String userName) {
		userInfoBll.selectUserByName(userName);
	}
}
