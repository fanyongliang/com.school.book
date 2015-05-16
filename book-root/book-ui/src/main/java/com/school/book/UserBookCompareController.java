package com.school.book;

/*------------------------------------------------------------------------- 
 * 作者：
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 比较信息管理
 -------------------------------------------------------------------------*/



import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.school.book.bean.BookCompareBean;
import com.school.book.bean.BookInfoBean;
import com.school.book.bean.NavListBean;
import com.school.book.bean.UserInfoBean;
import com.school.book.bll.BookCompareBll;
import com.school.book.bll.BookInfoBll;
import com.school.book.bll.BookReviewsBll;
import com.school.book.bll.LandAndRegistrationBll;
import com.school.book.bll.NavListBll;



@Controller
@RequestMapping("/user")
public class UserBookCompareController {
	private NavListBll NavListBll = new NavListBll();
	private BookInfoBll bookInfoBll = new BookInfoBll();
	private BookReviewsBll bookReviewsBll = new BookReviewsBll();
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	private BookCompareBll bookCompareBll = new BookCompareBll();
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserBookCompareController.class);

	/**
	 * 添加图书比较
	 * @param bookCompareBean
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/bookcompareadd")
	@ResponseBody
	public void bookcompareadd(Integer userCode,Integer bookCode,String bookName,Model model) throws UnsupportedEncodingException {
		bookName = new String(bookName.getBytes("iso8859-1"),"utf-8");
		BookCompareBean bookCompareBean = new BookCompareBean();
		bookCompareBean.setUserCode(userCode);
		bookCompareBean.setBookCode(bookCode);
		bookCompareBean.setBookName(bookName);
		bookCompareBll.addBookCompareInfo(bookCompareBean);
	}
	/**
	 * 比较商品根据code删除
	 * @param code
	 * @param model
	 */
	@RequestMapping("/bookcompareremove")
	@ResponseBody
	public void bookcompareremove(Integer code,Model model) {
		bookCompareBll.deleteBookCompareInfoByCode(code);
	}
	/**
	 * 清除某用户图书比较信息
	 * @param userCode
	 * @param model
	 */
	@RequestMapping("/bookcompareremoveall")
	@ResponseBody
	public void bookcompareremoveall(Integer userCode,Model model) {
		bookCompareBll.deleteBookCompareInfoAll(userCode);
	}
	/**
	 * 比较展示
	 * @param bookfirst
	 * @param booksecond
	 * @param model
	 * @return
	 */
	@RequestMapping("/bookcompare")
	public String bookcompare(Integer bookfirst,Integer booksecond,Model model,HttpServletRequest request) 
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
						BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
						BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
						model.addAttribute("bookInfoFirst", bookInfoFirst);
						model.addAttribute("bookInfoSecond", bookInfoSecond);
						return "user/compare";
					} else {
						UserInfoBean bean = (UserInfoBean) landAndRegistrationBll.getMem(value);
						if(bean.getRealName() == null){
							model.addAttribute("realName", "");
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
							BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
							model.addAttribute("bookInfoFirst", bookInfoFirst);
							model.addAttribute("bookInfoSecond", bookInfoSecond);
							return "user/compare";
						}else{
							model.addAttribute("realName", bean.getRealName());
							model.addAttribute("userCode", bean.getCode());
							model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
							List<NavListBean> navList = NavListBll.selectNavListIsShow();
							model.addAttribute("navList", navList);
							BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
							BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
							model.addAttribute("bookInfoFirst", bookInfoFirst);
							model.addAttribute("bookInfoSecond", bookInfoSecond);
							return "user/compare";
						}
					}
				}else{
					logger.info("找不到名为accountuuid的Cookie!");
					model.addAttribute("realName", "");
					model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
					List<NavListBean> navList = NavListBll.selectNavListIsShow();
					model.addAttribute("navList", navList);
					BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
					BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
					model.addAttribute("bookInfoFirst", bookInfoFirst);
					model.addAttribute("bookInfoSecond", bookInfoSecond);
					return "user/compare";
				}
			}
		}else{
			logger.info("Cookie中不存在有效信息！");
			model.addAttribute("realName", "");
			model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
			List<NavListBean> navList = NavListBll.selectNavListIsShow();
			model.addAttribute("navList", navList);
			BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
			BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
			model.addAttribute("bookInfoFirst", bookInfoFirst);
			model.addAttribute("bookInfoSecond", bookInfoSecond);
			return "user/compare";
		}
		model.addAttribute("imagesPath", "http://www.fanshu.com/images/");
		List<NavListBean> navList = NavListBll.selectNavListIsShow();
		model.addAttribute("navList", navList);
		BookInfoBean bookInfoFirst = bookInfoBll.selectBookInfoByCode(bookfirst);
		BookInfoBean bookInfoSecond = bookInfoBll.selectBookInfoByCode(booksecond);
		model.addAttribute("bookInfoFirst", bookInfoFirst);
		model.addAttribute("bookInfoSecond", bookInfoSecond);
		return "user/compare";
	}
}
