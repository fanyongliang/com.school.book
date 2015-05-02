package com.school.book;

/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：
 * 联系方式：
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理用户注册的控制器
-------------------------------------------------------------------------*/



import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bean.UserInfoBean;
import com.school.book.bll.LandAndRegistrationBll;

/**
 * 管理用户注册
 *
 */
@Controller
@RequestMapping("register")
public class UserRegisterController {
	/**
	 * 创建UserInfoBLL对象实例
	 */
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserRegisterController.class);

	/**
	 * 用户注册验证，正确跳转到主页面
	 * 
	 * @param userInfo
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/pass")
	public String list(UserInfoBean userInfoBean, Model model) throws UnsupportedEncodingException {
		String userName = userInfoBean.getUserName();
		String realName = userInfoBean.getRealName();
		realName =  new String(realName.getBytes("iso8859-1"),"utf-8");
		userInfoBean.setRealName(realName);
		if (landAndRegistrationBll.checkRegisterUserName(userName) == true) {
			landAndRegistrationBll.addUserInfo(userInfoBean);
			logger.info("Welcome book store! ...");
			return "redirect:login/";
		} else {
			logger.info("用户名已存在!");
			model.addAttribute("msg", "用户名已存在,重新输入");
			model.addAttribute("realName", realName);
			model.addAttribute("idCard", userInfoBean.getIdCard());
			model.addAttribute("userEmail", userInfoBean.getUserEmail());
			return "user/regist";
		}
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String show() {
		return "user/regist";
	}

}
