package com.school.book.bean;

import java.util.Date;

public class BookOrderBean {
	/**
	 * 编号
	 */
	private int code;
	/**
	 * 订单编号
	 */
	private int orderCode;
	/**
	 * 下单时间
	 */
	private Date orderTime;
	/**
	 * 是否付款
	 */
	private int isPay;
	/**
	 * 总价
	 */
	private double total;
	/**
	 * 收货地址
	 */
	private String userAddress;
	/**
	 * 用户编号
	 */
	private int userCode;

	public BookOrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookOrderBean(int code, int orderCode, Date orderTime, int isPay,
			double total, String userAddress, int userCode) {
		super();
		this.code = code;
		this.orderCode = orderCode;
		this.orderTime = orderTime;
		this.isPay = isPay;
		this.total = total;
		this.userAddress = userAddress;
		this.userCode = userCode;
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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

}