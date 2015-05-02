package com.school.book.bll;

import java.util.List;

import com.school.book.bean.BookInfoBean;
import com.school.book.dao.BookInfoDAO;

public class SelectBookBLL {
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	/**
	 * @注     释：根据参数来返回书籍信息
	 * @参     数：Integer is    0:is_new  1:is_hot  2:is_high
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> getByIs(Integer is){
		return  bookInfoDAO.selectByIs(is);
	}
	/**
	 * @注     释：按书籍类别查找书籍信息
	 * @参     数：bookType : 书籍类别
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> getByType(String bookType){
		return bookInfoDAO.selectByType(bookType);
	}
}
