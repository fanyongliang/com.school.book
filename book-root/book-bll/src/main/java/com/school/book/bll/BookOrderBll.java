package com.school.book.bll;

import java.util.List;

import com.school.book.bean.BookOrderBean;
import com.school.book.bean.BookOrderInfoBean;
import com.school.book.dao.BookInfoDAO;
import com.school.book.dao.BookOrderDAO;
import com.school.book.dao.BookOrderInfoDAO;

/**
 * 图书订单业务逻辑类
 */
public class BookOrderBll {
	private BookOrderDAO bookOrderDAO;
	private BookOrderInfoDAO bookOrderInfoDAO;
	private BookInfoDAO bookInfoDAO;
	/**
	 * 增加订单
	 * @param bookOrderBean
	 */
	public String addBookOrder(BookOrderBean bookOrderBean){
		String message = null;
		//检查库存是否充足
		List<BookOrderInfoBean> orderInfoList = bookOrderInfoDAO.selectBookOrderInfoByOrderCode(bookOrderBean.getOrderCode());
		for(BookOrderInfoBean orderInfoBean :  orderInfoList){
			Integer count = bookInfoDAO.selectBookInfoByCode(orderInfoBean.getBookCode()).getBookCount();
			if(orderInfoBean.getQuantity()>count){
				return message="库存不足。";
			}
		}		
		//图书库存相应减少
		List<BookOrderInfoBean> bookOrderInfoList = bookOrderInfoDAO.selectBookOrderInfoByOrderCode(bookOrderBean.getOrderCode());
		for(BookOrderInfoBean orderInfoBean :  bookOrderInfoList){
			bookInfoDAO.updateBookCountReduce(orderInfoBean.getBookCode(), orderInfoBean.getQuantity());
		}
		bookOrderDAO.insertBookOrder(bookOrderBean);
		return message;
	}
	/**
	 * 查找订单按照状态
	 */
	public List<BookOrderBean> selectBookOrderByStatus(Integer status){
		return bookOrderDAO.selectBookOrderByStatus(status);
	}
	/**
	 * 用户查找自己的订单
	 */
	public List<BookOrderBean> selectUserBookOrderByStatus(Integer status ,Integer userCode){
		return bookOrderDAO.selectUserBookOrderByStatus(status, userCode);
	}
	/**
	 * 更新订单发货状态
	 * @param orderCode
	 */
	public void updateBookOrderStatus(Integer orderCode ,Integer status){
		bookOrderDAO.updateBookOrderStatus(orderCode, status);
	}
	/**
	 * 向BookOrderInfo表插入数据
	 * @param bookOrderInfoBean
	 */
	public void insertBookOrderInfo(BookOrderInfoBean bookOrderInfoBean){
		bookOrderInfoDAO.insertBookOrderInfo(bookOrderInfoBean);
	}
	/**
	 * 查找书本订单数据靠订单编号
	 * @param orderCode
	 * @return
	 */
	public List<BookOrderInfoBean> selectBookOrderInfoByOrderCode(Integer orderCode){
		return bookOrderInfoDAO.selectBookOrderInfoByOrderCode(orderCode);
	}
}
