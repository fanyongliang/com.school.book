package com.school.book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bean.BookInfoBean;
import com.school.book.bean.BookOrderBean;
import com.school.book.bean.BookOrderInfoBean;
import com.school.book.bean.ShoppingCarBean;
import com.school.book.bean.UserInfoBean;
import com.school.book.bll.BookCompareBll;
import com.school.book.bll.BookInfoBll;
import com.school.book.bll.BookOrderBll;
import com.school.book.bll.BookReviewsBll;
import com.school.book.bll.LandAndRegistrationBll;
import com.school.book.bll.NavListBll;
import com.school.book.bll.ShoppingCarBll;

/**
 * 管理员订单处理控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminBookOrderController {
	private NavListBll NavListBll = new NavListBll();
	private BookInfoBll bookInfoBll = new BookInfoBll();
	private BookReviewsBll bookReviewsBll = new BookReviewsBll();
	private LandAndRegistrationBll landAndRegistrationBll = new LandAndRegistrationBll();
	private BookCompareBll bookCompareBll = new BookCompareBll();
	private ShoppingCarBll shoppingCarBll = new ShoppingCarBll();
	private BookOrderBll bookOrderBll = new BookOrderBll();
	
	/**
	 * 更改订单的状态
	 * @param orderCode
	 */
	@RequestMapping("updateOrderStatus")
	public String updateOrderStatus(Integer orderCode){
		bookOrderBll.updateBookOrderStatus(orderCode, 2);
		return "redirect:orderwait";
	}
	/**
	 * 未处理订单
	 * @param 
	 */
	@RequestMapping("orderwait")
	public String orderwait(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		UserInfoBean u = (UserInfoBean) session.getAttribute("adminInfo");
		if(u == null){
			return "admin/adminlogin";
		}else{
			List<BookOrderBean> bookOrderList = bookOrderBll.selectBookOrderByStatus(1);
			if(bookOrderList != null){
				for(BookOrderBean bookOrderBean:bookOrderList){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					bookOrderBean.setOrderTimeString(sdf.format(bookOrderBean.getOrderTime()));
				}
			}
			model.addAttribute("bookOrderList", bookOrderList);
			return "admin/bookorderall";
		}
	}
	/**
	 * 已处理订单
	 * @param 
	 */
	@RequestMapping("orderpass")
	public String orderpass(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		UserInfoBean u = (UserInfoBean) session.getAttribute("adminInfo");
		if(u == null){
			return "admin/adminlogin";
		}else{
			List<BookOrderBean> bookOrderList = bookOrderBll.selectBookOrderByStatus(2);
			if(bookOrderList != null){
				for(BookOrderBean bookOrderBean:bookOrderList){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					bookOrderBean.setOrderTimeString(sdf.format(bookOrderBean.getOrderTime()));
				}
			}
			model.addAttribute("bookOrderList", bookOrderList);
			return "admin/bookorderpass";
		}
	}
	/**
	 * 已完成订单
	 * @param 
	 */
	@RequestMapping("orderfinish")
	public String orderfinish(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		UserInfoBean u = (UserInfoBean) session.getAttribute("adminInfo");
		if(u == null){
			return "admin/adminlogin";
		}else{
			List<BookOrderBean> bookOrderList = bookOrderBll.selectBookOrderByStatus(3);
			if(bookOrderList != null){
				for(BookOrderBean bookOrderBean:bookOrderList){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					bookOrderBean.setOrderTimeString(sdf.format(bookOrderBean.getOrderTime()));
				}
			}
			model.addAttribute("bookOrderList", bookOrderList);
			return "admin/bookorderfinish";
		}
	}

}
