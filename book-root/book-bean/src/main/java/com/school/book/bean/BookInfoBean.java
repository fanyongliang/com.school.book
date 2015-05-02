package com.school.book.bean;

import java.util.Date;

public class BookInfoBean {
	private Integer code;
	//单价
	private Double bookPrice;
	//折扣
	private Double bookDiscounts;
	//是否新书
	private Integer isNew;
	//是否热销
	private Integer isHot;
	//是否高评分
	private Integer isHigh;
	//是否折扣
	private Integer isDiscounts;
	//录入时间
	private Date inputTime;
	//作者
	private String bookAuthor;
	//出版社
	private String bookPress;
	//出版时间
	private Date bookPublictionTime;
	//分类
	private String bookType;
	//描述
	private String bookDescribe;
	//图片
	private String bookPicture;
	//是否上架
	private Integer isInstore;
	//批次号
	private Integer bookBatch;
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Double getBookDiscounts() {
		return bookDiscounts;
	}
	public void setBookDiscounts(Double bookDiscounts) {
		this.bookDiscounts = bookDiscounts;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public Integer getIsHigh() {
		return isHigh;
	}
	public void setIsHigh(Integer isHigh) {
		this.isHigh = isHigh;
	}
	public Integer getIsDiscounts() {
		return isDiscounts;
	}
	public void setIsDiscounts(Integer isDiscounts) {
		this.isDiscounts = isDiscounts;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public Date getBookPublictionTime() {
		return bookPublictionTime;
	}
	public void setBookPublictionTime(Date bookPublictionTime) {
		this.bookPublictionTime = bookPublictionTime;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookDescribe() {
		return bookDescribe;
	}
	public void setBookDescribe(String bookDescribe) {
		this.bookDescribe = bookDescribe;
	}
	public String getBookPicture() {
		return bookPicture;
	}
	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}
	public Integer getIsInstore() {
		return isInstore;
	}
	public void setIsInstore(Integer isInstore) {
		this.isInstore = isInstore;
	}
	public Integer getBookBatch() {
		return bookBatch;
	}
	public void setBookBatch(Integer bookBatch) {
		this.bookBatch = bookBatch;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public BookInfoBean(Double bookPrice, Double bookDiscounts, Integer isNew,
			Integer isHot, Integer isHigh, Integer isDiscounts, Date inputTime,
			String bookAuthor, String bookPress, Date bookPublictionTime,
			String bookType, String bookDescribe, String bookPicture,
			Integer isInstore, Integer bookBatch) {
		super();
		this.bookPrice = bookPrice;
		this.bookDiscounts = bookDiscounts;
		this.isNew = isNew;
		this.isHot = isHot;
		this.isHigh = isHigh;
		this.isDiscounts = isDiscounts;
		this.inputTime = inputTime;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPublictionTime = bookPublictionTime;
		this.bookType = bookType;
		this.bookDescribe = bookDescribe;
		this.bookPicture = bookPicture;
		this.isInstore = isInstore;
		this.bookBatch = bookBatch;
	}
	public BookInfoBean() {
		super();
	}
	
}
