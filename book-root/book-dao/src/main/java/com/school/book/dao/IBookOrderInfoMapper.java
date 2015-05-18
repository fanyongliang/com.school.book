package com.school.book.dao;

import java.util.List;

import com.school.book.bean.BookOrderInfoBean;

public interface IBookOrderInfoMapper {
	/**
	 * 插入数据
	 * @param bookOrderInfoBean
	 */
	public void insertBookOrderInfo(BookOrderInfoBean bookOrderInfoBean);
	/**
	 * 查找书本订单数据靠订单编号
	 * @param orderCode
	 * @return
	 */
	public List<BookOrderInfoBean> selectBookOrderInfoByOrderCode(Integer orderCode);
}
