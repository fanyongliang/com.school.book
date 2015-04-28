package com.school.book.bean;

import java.util.Date;

public class BookReviewsBean {
	/**
	 * 编号
	 */
	private int code;
	/**
	 * 图书编号
	 */
	private int bookCode;
	/**
	 * 用户信息编号
	 */
	private int userCode;
	/**
	 * 星级
	 */
	private int bookQuality;
	/**
	 * 添加书评时间
	 */
	private Date bookReviewsTime;
	/**
	 * 评论内容
	 */
	private String bookReviews;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getBookQuality() {
		return bookQuality;
	}

	public void setBookQuality(int bookQuality) {
		this.bookQuality = bookQuality;
	}

	public Date getBookReviewsTime() {
		return bookReviewsTime;
	}

	public void setBookReviewsTime(Date bookReviewsTime) {
		this.bookReviewsTime = bookReviewsTime;
	}

	public String getBookReviews() {
		return bookReviews;
	}

	public void setBookReviews(String bookReviews) {
		this.bookReviews = bookReviews;
	}

	public BookReviewsBean(int code, int bookCode, int userCode,
			int bookQuality, Date bookReviewsTime, String bookReviews) {
		super();
		this.code = code;
		this.bookCode = bookCode;
		this.userCode = userCode;
		this.bookQuality = bookQuality;
		this.bookReviewsTime = bookReviewsTime;
		this.bookReviews = bookReviews;
	}

	public BookReviewsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
