package com.school.book.dao;

import java.util.List;

import com.school.book.bean.BookInfoBean;

public interface IBookInfoMapper {
	/**
	 * 新增未上架图书
	 * @param bookInfoBean
	 */
	public void addOutStoreBook(BookInfoBean bookInfoBean);
	/**
	 * 查询所有未上架的图书
	 */
	public List<BookInfoBean> selectOutStoreBook();
	/**
	 * 删除未上架图书
	 */
	public void deleteOutStoreBook(Integer code);
	/**
	 * 修改未上架图书
	 * @param bookInfoBean
	 */
	public void updateOutStoreBook(BookInfoBean bookInfoBean);
	/**
	 * 未上架-->上架
	 */
	public void inOutStoreBook(Integer code);
	/**
	 * 查询所有已上架的图书
	 */
	public List<BookInfoBean> selectInStoreBook();
	/**
	 * 添加折扣
	 * @param bookInfoBean
	 */
	public void instorebookdisc(BookInfoBean bookInfoBean);
	/**
	 * 新书推荐
	 */
	public void instorebooknew(Integer code);
	/**
	 * 热门推荐
	 */
	public void instorebookhot(Integer code);
	/**
	 * 评分推荐
	 */
	public void instorebookhigh(Integer code);
	/**
	 * 查询所有有折扣的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectDiscStoreBook();
	/**
	 * 修改折扣
	 * @param bookInfoBean
	 */
	public void instorebookdiscupdate(BookInfoBean bookInfoBean);
	/**
	 * 查询所有NEW的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectNewStoreBook();
	/**
	 * 查询所有HOT的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectHotStoreBook();
	/**
	 * 查询所有HIGH的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectHighStoreBook();
	/**
	 * 根据图书ID查询图书
	 * @param bookInfoBean
	 */
	public BookInfoBean selectBookInfoByCode(Integer code);
}
