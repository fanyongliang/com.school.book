package com.school.book.bean;

public class BookOrderInfoBean {
	/**
	 * 编号
	 */
	private int code;
	/**
	 * 订单号
	 */
	private int orderCode;
	/**
	 * 图书编号
	 */
	private int bookCode;
	/**
	 * 数量
	 */
	private int quantity;
	/**
	 * 单价
	 */
	private double payPrice;

	public BookOrderInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookOrderInfoBean(int code, int orderCode, int bookCode,
			int quantity, double payPrice) {
		super();
		this.code = code;
		this.orderCode = orderCode;
		this.bookCode = bookCode;
		this.quantity = quantity;
		this.payPrice = payPrice;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(double payPrice) {
		this.payPrice = payPrice;
	}

}
