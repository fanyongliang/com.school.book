package com.school.book.service;

import java.util.Date;
import java.util.List;

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
 * 图书预定业务拼接类
 *
 */
public class BookOrderService 
{
	private BookInfoBll bookInfoBll = new BookInfoBll();
	private ShoppingCarBll shoppingCarBll = new ShoppingCarBll();
	private BookOrderBll bookOrderBll = new BookOrderBll();
	/**
	 * 加入购物车
	 * @param bookOrderBean
	 */
	public void addToCar(BookOrderBean bookOrderBean){
		List<ShoppingCarBean> shoppingCarList = shoppingCarBll.selectToCar(bookOrderBean.getUserCode());
		//检查库存是否充足
		for(ShoppingCarBean bean:shoppingCarList){
			BookInfoBean bookInfoBean = bookInfoBll.selectBookInfoByCode(bean.getBookCode());
			if(bookInfoBean.getBookCount()<bean.getBookQuantity()){
				return;
			}
		}
		//记录订单信息
		bookOrderBll.addBookOrder(bookOrderBean);
		//记录订单详细信息
		for(ShoppingCarBean bean:shoppingCarList){
			BookInfoBean bookInfoBean = bookInfoBll.selectBookInfoByCode(bean.getBookCode());
			double payPrice = bookInfoBean.getBookPrice()*(1-bookInfoBean.getBookDiscounts());
			BookOrderInfoBean bookOrderInfoBean = new BookOrderInfoBean(bookOrderBean.getOrderCode(),bean.getBookCode(),
					bean.getBookQuantity(), payPrice);
			bookOrderBll.insertBookOrderInfo(bookOrderInfoBean);
		}
		//清空购物车
		shoppingCarBll.deleteAllToCar(bookOrderBean.getUserCode());			
	}
}
