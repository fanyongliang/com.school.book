package com.school.book;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bean.BookInfoBean;
import com.school.book.bean.BookOrderBean;
import com.school.book.bean.BookOrderInfoBean;
import com.school.book.bean.ShoppingCarBean;
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
	public void updateOrderStatus(Integer orderCode){
		bookOrderBll.updateBookOrderStatus(orderCode, 2);
	}
	/**
	 * 根据订单的状态查找订单类表
	 * @param orderCode
	 */
	@RequestMapping("selectOrder")
	public void selectOrder(Integer status, Model model){
		List<BookOrderBean> bookOrderList = bookOrderBll.selectBookOrderByStatus(status);
		model.addAttribute("bookOrderList", bookOrderList);
	}

}
