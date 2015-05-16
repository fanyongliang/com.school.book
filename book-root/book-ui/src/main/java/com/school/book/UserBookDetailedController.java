package com.school.book;

/*------------------------------------------------------------------------- 
 * 作者：
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 图书详情
 -------------------------------------------------------------------------*/




import java.io.IOException;
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

import com.school.book.bean.BookCompareBean;
import com.school.book.bean.BookInfoBean;
import com.school.book.bean.BookReviewsBean;
import com.school.book.bean.NavListBean;
import com.school.book.bean.UserInfoBean;
import com.school.book.bll.BookCompareBll;
import com.school.book.bll.BookInfoBll;
import com.school.book.bll.BookReviewsBll;
import com.school.book.bll.LandAndRegistrationBll;
import com.school.book.bll.NavListBll;


@Controller
@RequestMapping("/user")
public class UserBookDetailedController {
	private NavListBll NavListBll = new NavListBll();
	private BookInfoBll bookInfoBll = new BookInfoBll();
	private BookReviewsBll bookReviewsBll = new BookReviewsBll();
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	private BookCompareBll bookCompareBll = new BookCompareBll();
	
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserBookDetailedController.class);


	/**
	 *  图书详细信息
	 * 
	 * @return
	 */
	@RequestMapping("bookdetailed")
	public String bookDetailed(Integer code,Model model,HttpServletRequest request) 
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
						List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
						model.addAttribute("bookInfoListHigh", bookInfoListHigh);
						BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
						model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
						List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
						model.addAttribute("bookReviewsList", bookReviewsList);
						List<BookCompareBean> bookCompareList = new ArrayList<BookCompareBean>();
						model.addAttribute("bookCompareList", bookCompareList);
						return "user/product_page";
					} else {
						UserInfoBean bean = (UserInfoBean) landAndRegistrationBll.getMem(value);
						if(bean.getRealName() == null){
							model.addAttribute("realName", "");
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
							model.addAttribute("bookInfoListHigh", bookInfoListHigh);
							BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
							model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
							List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
							model.addAttribute("bookReviewsList", bookReviewsList);
							List<BookCompareBean> bookCompareList = new ArrayList<BookCompareBean>();
							model.addAttribute("bookCompareList", bookCompareList);
							return "user/product_page";
						}else{
							model.addAttribute("realName", bean.getRealName());
							model.addAttribute("userCode", bean.getCode());
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
							model.addAttribute("bookInfoListHigh", bookInfoListHigh);
							BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
							model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
							List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
							model.addAttribute("bookReviewsList", bookReviewsList);
							List<BookCompareBean> bookCompareList = bookCompareBll.selectBookCompareInfoByUserCode(bean.getCode());
							model.addAttribute("bookCompareList", bookCompareList);
							return "user/product_page";
						}
					}
				}else{
					logger.info("找不到名为accountuuid的Cookie!");
					model.addAttribute("realName", "");
					model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
					List<NavListBean> navList = NavListBll.selectNavListIsShow();
					model.addAttribute("navList", navList);
					List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
					model.addAttribute("bookInfoListHigh", bookInfoListHigh);
					BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
					model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
					List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
					model.addAttribute("bookReviewsList", bookReviewsList);
					List<BookCompareBean> bookCompareList = new ArrayList<BookCompareBean>();
					model.addAttribute("bookCompareList", bookCompareList);
					return "user/product_page";
				}
			}
		}else{
			logger.info("Cookie中不存在有效信息！");
			model.addAttribute("realName", "");
			model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
			List<NavListBean> navList = NavListBll.selectNavListIsShow();
			model.addAttribute("navList", navList);
			List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
			model.addAttribute("bookInfoListHigh", bookInfoListHigh);
			BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
			model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
			List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
			model.addAttribute("bookReviewsList", bookReviewsList);
			List<BookCompareBean> bookCompareList = new ArrayList<BookCompareBean>();
			model.addAttribute("bookCompareList", bookCompareList);
			return "user/product_page";
		}
		model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
		List<NavListBean> navList = NavListBll.selectNavListIsShow();
		model.addAttribute("navList", navList);
		List<BookInfoBean> bookInfoListHigh = bookInfoBll.selectHighStoreBook();
		model.addAttribute("bookInfoListHigh", bookInfoListHigh);
		BookInfoBean bookInfoBeanDetail = bookInfoBll.selectBookInfoByCode(code);
		model.addAttribute("bookInfoBeanDetail", bookInfoBeanDetail);
		List<BookReviewsBean> bookReviewsList = bookReviewsBll.selectBookReviewsInfoByBookCode(code);
		model.addAttribute("bookReviewsList", bookReviewsList);
		List<BookCompareBean> bookCompareList = new ArrayList<BookCompareBean>();
		model.addAttribute("bookCompareList", bookCompareList);
		return "user/product_page";
	}

}
