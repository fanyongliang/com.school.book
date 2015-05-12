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
	 * 新增未上架图书
	 * @param bookInfoBean
	 */
	public void addOutStoreBook(BookInfoBean bookInfoBean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.addOutStoreBook(bookInfoBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	/**
	 * 查询所有未上架的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectOutStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectOutStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 删除未上架图书
	 */
	public void deleteOutStoreBook(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.deleteOutStoreBook(code);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 修改未上架图书
	 * @param bookInfoBean
	 */
	public void updateOutStoreBook(BookInfoBean bookInfoBean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.updateOutStoreBook(bookInfoBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 未上架-->上架
	 */
	public void inOutStoreBook(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.inOutStoreBook(code);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 查询所有已上架的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectInStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectInStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 添加折扣
	 * @param bookInfoBean
	 */
	public void instorebookdisc(BookInfoBean bookInfoBean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.instorebookdisc(bookInfoBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 新书推荐
	 */
	public void instorebooknew(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.instorebooknew(code);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 热门推荐
	 */
	public void instorebookhot(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.instorebookhot(code);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 评分推荐
	 */
	public void instorebookhigh(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.instorebookhigh(code);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 查询所有有折扣的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectDiscStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectDiscStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 修改折扣
	 * @param bookInfoBean
	 */
	public void instorebookdiscupdate(BookInfoBean bookInfoBean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			iBookInfoMapper.instorebookdiscupdate(bookInfoBean);
		} finally {
			session.commit();
			session.close();
		}
	}
	/**
	 * 查询所有NEW的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectNewStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectNewStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 查询所有HOT的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectHotStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectHotStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 查询所有HIGH的图书
	 * @param bookInfoBean
	 */
	public List<BookInfoBean> selectHighStoreBook(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectHighStoreBook();
		} finally {
			session.close();
		}
	}
	/**
	 * 根据图书ID查询图书
	 * @param bookInfoBean
	 */
	public BookInfoBean selectBookInfoByCode(Integer code){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			iBookInfoMapper = session.getMapper(IBookInfoMapper.class);
			return iBookInfoMapper.selectBookInfoByCode(code);
		} finally {
			session.close();
		}
	}
}
