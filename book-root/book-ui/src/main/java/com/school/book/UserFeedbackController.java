package com.school.book;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.book.bean.NavListBean;
import com.school.book.bean.ShoppingCarBean;
import com.school.book.bean.UserAddressBean;
import com.school.book.bean.UserFeedbackBean;
import com.school.book.bean.UserInfoBean;
import com.school.book.bll.BookCompareBll;
import com.school.book.bll.BookInfoBll;
import com.school.book.bll.BookOrderBll;
import com.school.book.bll.BookReviewsBll;
import com.school.book.bll.LandAndRegistrationBll;
import com.school.book.bll.NavListBll;
import com.school.book.bll.ShoppingCarBll;
import com.school.book.bll.UserAddressBll;
import com.school.book.bll.UserFeedbackBll;
import com.school.book.bll.UserInfoBll;

/**
 * 用户反馈管理
 */
@Controller
@RequestMapping("user")
public class UserFeedbackController {
	private NavListBll NavListBll = new NavListBll();
	private BookInfoBll bookInfoBll = new BookInfoBll();
	private BookReviewsBll bookReviewsBll = new BookReviewsBll();
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	private BookCompareBll bookCompareBll = new BookCompareBll();
	private ShoppingCarBll shoppingCarBll = new ShoppingCarBll();
	private BookOrderBll bookOrderBll = new BookOrderBll();
	private UserInfoBll userInfoBll = new UserInfoBll();
	private UserAddressBll userAddressBll = new UserAddressBll();
	private UserFeedbackBll userFeedbackBll = new UserFeedbackBll();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserRegisterController.class);
	/**
	 * 增加反馈
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("feedbackadd")
	@ResponseBody
	public void add(UserFeedbackBean userFeedbackBean){
		userFeedbackBll.insertFeedback(userFeedbackBean);
	}
	/**
	 * 查看反馈
	 */
	@RequestMapping("feedbackselcet")
	@ResponseBody
	public void selcet(Model model) {
		List<UserFeedbackBean> feedbackList = userFeedbackBll.selectFeedback();
		model.addAttribute("feedbackList", feedbackList);
	}
	/**
	 * 反馈
	 */
	@RequestMapping("feedbackshow")
	public String selcetUserInfo(Model model,HttpServletRequest request) 
			throws IOException, TimeoutException, InterruptedException,
			MemcachedException{
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			logger.info("Cookie数量:" + cookies.length);
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("accountuuid")) {
					logger.info("-------true & false-----:"
							+ cookie.getName().equals("accountuuid"));
					String value = cookie.getValue();
					logger.info("value:"+value);
					if (landAndRegistrationBll.getMem(value) == null) {
						logger.info("memcache中不存在信息!");
						model.addAttribute("realName", "");
						model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
						List<NavListBean> navList = NavListBll.selectNavListIsShow();
						model.addAttribute("navList", navList);
						List<ShoppingCarBean> shoppingCarList = new ArrayList<ShoppingCarBean>();
						model.addAttribute("shoppingCarList", shoppingCarList);
						return "user/contact_us";
					} else {
						UserInfoBean bean = (UserInfoBean) landAndRegistrationBll.getMem(value);
						if(bean.getRealName() == null){
							model.addAttribute("realName", "");
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							List<ShoppingCarBean> shoppingCarList = new ArrayList<ShoppingCarBean>();
							model.addAttribute("shoppingCarList", shoppingCarList);
							return "user/contact_us";
						}else{
							model.addAttribute("realName", bean.getUserName());
							model.addAttribute("userName", bean.getUserName());
							model.addAttribute("userCode", bean.getCode());
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							List<ShoppingCarBean> shoppingCarList = shoppingCarBll.selectToCar(bean.getCode());
							for (ShoppingCarBean shoppingCarBean : shoppingCarList) {
								shoppingCarBean.setBookInfoBean(bookInfoBll.selectBookInfoByCode(shoppingCarBean.getBookCode()));
							}
							model.addAttribute("shoppingCarList", shoppingCarList);
							return "user/contact_us";
						}
					}
				}else{
					model.addAttribute("realName", "");
					model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
					List<NavListBean> navList = NavListBll.selectNavListIsShow();
					model.addAttribute("navList", navList);
					List<ShoppingCarBean> shoppingCarList = new ArrayList<ShoppingCarBean>();
					model.addAttribute("shoppingCarList", shoppingCarList);
					return "user/contact_us";
				}
			}
		}else{
			logger.info("Cookie中不存在有效信息！");
			model.addAttribute("realName", "");
			model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
			List<NavListBean> navList = NavListBll.selectNavListIsShow();
			model.addAttribute("navList", navList);
			List<ShoppingCarBean> shoppingCarList = new ArrayList<ShoppingCarBean>();
			model.addAttribute("shoppingCarList", shoppingCarList);
			return "user/contact_us";
		}
		model.addAttribute("realName", "");
		model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
		List<NavListBean> navList = NavListBll.selectNavListIsShow();
		model.addAttribute("navList", navList);
		List<ShoppingCarBean> shoppingCarList = new ArrayList<ShoppingCarBean>();
		model.addAttribute("shoppingCarList", shoppingCarList);
		return "user/contact_us";
	}	
}
