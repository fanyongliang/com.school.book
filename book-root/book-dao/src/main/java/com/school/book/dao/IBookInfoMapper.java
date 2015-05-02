package com.school.book.dao;

import java.util.List;

import com.school.book.bean.BookInfoBean;

public interface IBookInfoMapper {
	/**
	 * @注     释：返回新书书籍信息
	 * @参     数：
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectByIsNew();
	/**
	 * @注     释：返回热销书籍信息
	 * @参     数：
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectByIsHot();
	/**
	 * @注     释：返回高评分书籍信息
	 * @参     数：
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectByIsHigh();
	/**
	 * @注     释：返回参数类型书籍信息
	 * @参     数：bookType ： 书籍类型
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectBytype(String bookType);
}
