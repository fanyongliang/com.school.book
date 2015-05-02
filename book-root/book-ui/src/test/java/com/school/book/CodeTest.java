package com.school.book;

import org.apache.ibatis.session.SqlSessionFactory;

import com.school.book.dao.MyBatisConnectionFactory;

public class CodeTest {
	
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory;
		sqlSessionFactory = MyBatisConnectionFactory
				.getSqlAccountSessionFactory();
		System.out.println(sqlSessionFactory);
	}
}
