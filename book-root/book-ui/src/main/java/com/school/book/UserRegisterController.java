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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
@RequestMapping("/user")
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
	@RequestMapping("registerpass")
	public String list(UserInfoBean userInfoBean, Model model) throws UnsupportedEncodingException {
		String userName = userInfoBean.getUserName();
		String realName = userInfoBean.getRealName();
		userName =  new String(userName.getBytes("iso8859-1"),"utf-8");
		realName =  new String(realName.getBytes("iso8859-1"),"utf-8");
		String card15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
		Pattern regex15 = Pattern.compile(card15); 
		String card18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
		Pattern regex18 = Pattern.compile(card18); 
		Matcher matcher = null ;
		if(userInfoBean.getIdCard().length() == 18){
			matcher = regex18.matcher(userInfoBean.getUserEmail());
		}else{
			matcher = regex15.matcher(userInfoBean.getUserEmail());
		}
		
		if(userName == "" || realName == "" || userInfoBean.getUserPasswd() == "" || userInfoBean.getUserPasswdRP() == "" || userInfoBean.getIdCard() == "" || userInfoBean.getUserEmail() == ""){
			logger.info("带*号的不允许为空!");
			model.addAttribute("msg", "带*号的不允许为空!");
			model.addAttribute("userName", userName);
			model.addAttribute("realName", realName);
			model.addAttribute("idCard", userInfoBean.getIdCard());
			model.addAttribute("userEmail", userInfoBean.getUserEmail());
			return "user/regist";
		}else if(!userInfoBean.getUserPasswd().equals(userInfoBean.getUserPasswdRP())){
			logger.info("两次输入密码不一致!");
			model.addAttribute("msg", "两次输入密码不一致!");
			model.addAttribute("userName", userName);
			model.addAttribute("realName", realName);
			model.addAttribute("idCard", userInfoBean.getIdCard());
			model.addAttribute("userEmail", userInfoBean.getUserEmail());
			return "user/regist";
		}else if (!matcher.matches()) {
			logger.info("身份证格式不正确！!");
			model.addAttribute("msg", "身份证格式不正确！");
			model.addAttribute("userName", userName);
			model.addAttribute("realName", realName);
			model.addAttribute("idCard", userInfoBean.getIdCard());
			model.addAttribute("userEmail", userInfoBean.getUserEmail());
			return "user/regist";
		}else if(userInfoBean.getUserType()!= 2){
			logger.info("请勾选同意阅读条款!");
			model.addAttribute("msg", "请勾选同意阅读条款!");
			model.addAttribute("userName", userName);
			model.addAttribute("realName", realName);
			model.addAttribute("idCard", userInfoBean.getIdCard());
			model.addAttribute("userEmail", userInfoBean.getUserEmail());
			return "user/regist";
		}
		userInfoBean.setUserName(userName);
		userInfoBean.setRealName(realName);
		if (landAndRegistrationBll.checkRegisterUserName(userName) == true) {
			landAndRegistrationBll.addUserInfo(userInfoBean);
			logger.info("Welcome book store! ...");
			return "redirect:/user/login";
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
	@RequestMapping("register")
	public String show() {
		return "user/regist";
	}

}
