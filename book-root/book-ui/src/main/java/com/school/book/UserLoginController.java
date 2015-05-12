package com.school.book;
/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：
 * 联系方式：
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理用户登录的控制器
-------------------------------------------------------------------------*/

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bean.UserInfoBean;
import com.school.book.bean.UserPasswdBean;
import com.school.book.bll.LandAndRegistrationBll;
/**
 * 管理用户登录
 */
@Controller
@RequestMapping("user")
public class UserLoginController {
	/**
	 * 创建UserInfoBLL对象实例
	 */
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserLoginController.class);

	/**
	 * 验证用户登录,添加Cookie
	 * 
	 * @param userLogin
	 * @param model
	 * @return
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws IOException
	 */
	@RequestMapping("loginpass")
	public String pass(UserPasswdBean userPasswdBean, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, TimeoutException, InterruptedException,
			MemcachedException {
		String userName = new String(userPasswdBean.getUserName().getBytes("iso8859-1"),"utf-8");
		String userPasswd = new String(userPasswdBean.getUserPasswd().getBytes("iso8859-1"),"utf-8");
		String validateCode = new String(userPasswdBean.getValidateCode().getBytes("iso8859-1"),"utf-8");
		validateCode = validateCode.toLowerCase();
		UserInfoBean u = landAndRegistrationBll.getUserInfoBySelect(userName);
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("validatecode");
		if(code != null){
			code = code.toLowerCase();
		}
        if(!validateCode.equals(code)){
        	logger.info("user:"+validateCode+"---sys:"+code);
			model.addAttribute("msg", "验证码输入错误!");
			return "user/login";
        }
		
		if(u == null){
			logger.info("用户名或密码错误!");
			model.addAttribute("msg", "用户名或密码错误!");
			return "user/login";
		}else{
			if (landAndRegistrationBll.checkLoginAccount(userName,
					userPasswd) == true) {
				// cookie
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				Cookie cUUID = new Cookie("accountuuid", uuid);
				cUUID.setMaxAge(3600);
				response.addCookie(cUUID);
				// memcache
				landAndRegistrationBll.setMem(uuid, u);
				return "redirect:index";
			} else {
				logger.info("用户名或密码错误!");
				model.addAttribute("msg", "用户名或密码错误!");
				return "user/login";
			}
		}

	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String show() {
		return "user/login";
	}

}
