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
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bean.UserInfoBean;
import com.school.book.bean.UserPasswdBean;
import com.school.book.bll.LandAndRegistrationBll;
/**
 * 管理用户登录
 * @author fanyongliang
 *
 */
@Controller
@RequestMapping("login")
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
	 * 验证用户登录
	 * 
	 * @param userLogin
	 * @param model
	 * @return
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws IOException
	 */
	@RequestMapping("/pass")
	public String pass(UserPasswdBean userPasswdBean, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, TimeoutException, InterruptedException,
			MemcachedException {
		String userName = userPasswdBean.getUserName();
		String userPasswd = userPasswdBean.getUserPasswd();
		UserInfoBean u = landAndRegistrationBll.getUserInfoBySelect(userName);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			logger.info("Cookie数量:" + cookies.length);
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accountuuid")) {
					logger.info("-------true & false-----:"
							+ cookie.getName().equals("accountuuid"));
					String value = cookie.getValue();
					if (landAndRegistrationBll.getMem(value) == null) {
						logger.info("memcache中不存在信息!");
						model.addAttribute("msg", "memcache不存在!");
						return "user/login";
					} else {
						UserInfoBean bean = (UserInfoBean) landAndRegistrationBll.getMem(value);
						if(bean.getRealName() == null){
							model.addAttribute("realName", "");
						}else{
							model.addAttribute("realName", bean.getRealName());
						}
						
						//
						return "user/index";
					}
				} else {
					logger.info("Cookie不存在或者已经过期!");
					model.addAttribute("msg", "Cookie已经过期!");
					return "user/login";
				}
			}
		}
		
		if(u == null){
			model.addAttribute("realName", "");
			return "user/index";
		}else{
			if (landAndRegistrationBll.checkLoginAccount(userName,
					userPasswd) == true) {
				// cookie
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				Cookie cUUID = new Cookie("accountuuid", uuid);
				cUUID.setMaxAge(100);
				response.addCookie(cUUID);
				// memcache
				landAndRegistrationBll.setMem(uuid, u);
				model.addAttribute("realName", u.getRealName());
				return "user/index";
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
	@RequestMapping("/")
	public String show() {
		return "user/login";
	}

}
