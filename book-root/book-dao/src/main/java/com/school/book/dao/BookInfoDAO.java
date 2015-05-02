package com.school.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.book.bean.BookInfoBean;

/**
 * 图书信息数据处理类
 */
public class BookInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IBookInfoMapper iBookInfoMapper ;

	public BookInfoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * @注     释：根据参数来返回书籍信息
	 * @参     数：Integer is    0:is_new  1:is_hot  2:is_high
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectByIs(Integer is){
		SqlSession session = sqlSessionFactory.openSession();
		List<BookInfoBean> bookInfoList = null;
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			switch(is){
			case 0 : bookInfoList = iBookInfoMapper.selectByIsNew();
					 break;
			case 1 : bookInfoList = iBookInfoMapper.selectByIsHot();
					 break;
			case 2 : bookInfoList = iBookInfoMapper.selectByIsHigh();
					 break;
			}			
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return bookInfoList;
	}
	/**
	 * @注     释：按书籍类别查找书籍信息
	 * @参     数：bookType : 书籍类别
	 * @返回值：List<BookInfoBean>
	 */
	public List<BookInfoBean> selectByType(String bookType){
		SqlSession session = sqlSessionFactory.openSession();
		List<BookInfoBean> bookInfoList = null;
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			bookInfoList = iBookInfoMapper.selectBytype(bookType);			
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return bookInfoList;
	}
}
