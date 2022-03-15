package com.mySpring.myapp.commerce.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("commerce_articleVO")
public class ArticleVO {
	
	//데이터베이스에서 받을때 정보 저장..
	private String commerce_title;
	private String commerce_content;
	private String commerce_price;
	private int commerce_articleNO;
	private String member_id;
	private Date  commerce_writeDate;
	private int commerce_like;
	private String commerce_thumbnailfilename;
	
	public String getCommerce_price() {
		return commerce_price;
	}

	public void setCommerce_price(String commerce_price) {
		this.commerce_price = commerce_price;
	}

	public int getCommerce_like() {
		return commerce_like;
	}

	public void setCommerce_like(int commerce_like) {
		this.commerce_like = commerce_like;
	}

	public String getCommerce_thumbnailfilename() {
		return commerce_thumbnailfilename;
	}
	
	public void setCommerce_thumbnailfilename(String commerce_thumbnailfilename) {
		this.commerce_thumbnailfilename = commerce_thumbnailfilename;
	}

	public int getCommerce_articleNO() {
		return commerce_articleNO;
	}
	
	public void setCommerce_articleNO(int commerce_articleNO) {
		this.commerce_articleNO = commerce_articleNO;
	}
	
	public String getCommerce_title() {
		return commerce_title;
	}
	
	public void setCommerce_title(String commerce_title) {
		this.commerce_title = commerce_title;
	}
	
	public String getCommerce_content() {
		return commerce_content;
	}
	
	public void setCommerce_content(String commerce_content) {
		this.commerce_content = commerce_content;
	}

	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public Date getCommerce_writeDate() {
		return commerce_writeDate;
	}
	
	public void setCommerce_writeDate(Date commerce_writedate) {
		this.commerce_writeDate = commerce_writedate;
	}
}