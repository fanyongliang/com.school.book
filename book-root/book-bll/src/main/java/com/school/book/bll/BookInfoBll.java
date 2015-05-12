package com.school.book.bll;

import java.util.List;

import com.school.book.bean.BookInfoBean;
import com.school.book.dao.BookInfoDAO;


/**
 * 图书管理
 */
public class BookInfoBll {
	BookInfoDAO bookInfoDAO = new BookInfoDAO();
	
	/**
	 * 新增未上架图书
	 * @param bookInfoBean
	 */
	public void addOutStoreBook(BookInfoBean bookInfoBean) {
		bookInfoDAO.addOutStoreBook(bookInfoBean);
	}
	/**
	 * 查询所有未上架的图书
	 */
	public List<BookInfoBean> selectOutStoreBook() {
		return bookInfoDAO.selectOutStoreBook();
	}
	/**
	 *  删除未上架的图书
	 */
	public void deleteOutStoreBook(Integer code) {
		bookInfoDAO.deleteOutStoreBook(code);
	}
	/**
	 * 修改未上架图书
	 * @param bookInfoBean
	 */
	public void updateOutStoreBook(BookInfoBean bookInfoBean) {
		bookInfoDAO.updateOutStoreBook(bookInfoBean);
	}
	/**
	 *  未上架 -->上架
	 */
	public void inOutStoreBook(Integer code) {
		bookInfoDAO.inOutStoreBook(code);
	}
	/**
	 * 查询所有已上架的图书
	 */
	public List<BookInfoBean> selectInStoreBook() {
		return bookInfoDAO.selectInStoreBook();
	}
	/**
	 *  添加折扣
	 */
	public void instorebookdisc(BookInfoBean bookInfoBean) {
		bookInfoDAO.instorebookdisc(bookInfoBean);
	}
	/**
	 *  新书推荐
	 */
	public void instorebooknew(Integer code) {
		bookInfoDAO.instorebooknew(code);
	}
	/**
	 *  热门推荐
	 */
	public void instorebookhot(Integer code) {
		bookInfoDAO.instorebookhot(code);
	}
	/**
	 *  评分推荐
	 */
	public void instorebookhigh(Integer code) {
		bookInfoDAO.instorebookhigh(code);
	}
	/**
	 * 查询所有有折扣的图书
	 */
	public List<BookInfoBean> selectDiscStoreBook() {
		return bookInfoDAO.selectDiscStoreBook();
	}
	/**
	 *  修改折扣
	 */
	public void instorebookdiscupdate(BookInfoBean bookInfoBean) {
		bookInfoDAO.instorebookdiscupdate(bookInfoBean);
	}
	/**
	 * 查询所有NEW的图书
	 */
	public List<BookInfoBean> selectNewStoreBook() {
		return bookInfoDAO.selectNewStoreBook();
	}
	/**
	 * 查询所有HOT的图书
	 */
	public List<BookInfoBean> selectHotStoreBook() {
		return bookInfoDAO.selectHotStoreBook();
	}
	/**
	 * 查询所有HIGH的图书
	 */
	public List<BookInfoBean> selectHighStoreBook() {
		return bookInfoDAO.selectHighStoreBook();
	}
	/**
	 * 根据图书ID查询图书
	 */
	public BookInfoBean selectBookInfoByCode(Integer code) {
		return bookInfoDAO.selectBookInfoByCode(code);
	}
}
