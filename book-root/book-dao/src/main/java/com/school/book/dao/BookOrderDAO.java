package com.school.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.book.bean.BookOrderBean;

/**
 * 订单数据处理类
 */
public class BookOrderDAO {
	private SqlSessionFactory sqlSessionFactory;
	private IBookOrderMapper iBookOrderMapper ;

	public BookOrderDAO() {
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
	}
	/**
	 * 插入BookOrderBean
	 * @param bookOrderBean
	 */
	public void insertBookOrder(BookOrderBean bookOrderBean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookOrderMapper = session.getMapper(IBookOrderMapper.class);
			iBookOrderMapper.insertBookOrder(bookOrderBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 查找订单按用户
	 */
	public List<BookOrderBean> selectBookOrderByUserCode(Integer userCode){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookOrderMapper = session.getMapper(IBookOrderMapper.class);
			return iBookOrderMapper.selectBookOrderByUserCode(userCode);
		} finally {
			session.close();
		}
	}
	/**
	 * 查找订单按状态
	 */
	public List<BookOrderBean> selectBookOrderByStatus(Integer status){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookOrderMapper = session.getMapper(IBookOrderMapper.class);
			return iBookOrderMapper.selectBookOrderByStatus(status);
		} finally {
			session.close();
		}
	}
	/**
	 * 用户查找订单按状态
	 */ 
	public List<BookOrderBean> selectUserBookOrderByStatus(Integer status,Integer userCode){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookOrderMapper = session.getMapper(IBookOrderMapper.class);
			return iBookOrderMapper.selectUserBookOrderByStatus(status, userCode);
		} finally {
			session.close();
		}
	}
	/**
	 * 更新订单发货状态
	 * @param orderCode
	 */
	public void updateBookOrderStatus(Integer orderCode, Integer status){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookOrderMapper = session.getMapper(IBookOrderMapper.class);
			iBookOrderMapper.updateBookOrderStatus(orderCode ,status);
		} finally {
			session.commit();
			session.close();
		}
	}
}
