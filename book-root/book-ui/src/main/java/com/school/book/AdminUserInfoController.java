package com.school.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.book.bean.UserInfoBean;
import com.school.book.bll.UserInfoBll;

/**
 * 管理员用户个人信息管理
 */
@Controller
@RequestMapping("admin")
public class AdminUserInfoController {
	private UserInfoBll userInfoBll;
	/**
	 * 更新个人信息
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public void deleteUser(String userName) {
		userInfoBll.deleteUser(userName);
	}
	/**
	 * 查询所有用户信息
	 */
	@RequestMapping("getAllUser")
	@ResponseBody
	public void getAllUser(Model model) {
		List<UserInfoBean> userInfoList = userInfoBll.selectAllUser();
		model.addAttribute("userInfoList", userInfoList);
	}
	/**
	 * 查询某个用户信息
	 */
	public void getUserInfo(String userName,Model model){
		UserInfoBean userInfoBean = userInfoBll.selectUserByName(userName);
		model.addAttribute("userInfoBean", userInfoBean);
	}
}
