package com.mySpring.myapp.commerce.vo;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

@Component("commerce_imageVO")
public class ImageVO {
	private int commerce_imageFileNO;
	private String commerce_imageFileName;
	private Date commerce_regDate;
	private int commerce_articleNO;
	
	public int getCommerce_imageFileNO() {
		return commerce_imageFileNO;
	}
	
	public void setCommerce_imageFileNO(int commerce_imageFileNO) {
		this.commerce_imageFileNO = commerce_imageFileNO;
	}
	
	public String getCommerce_imageFileName() {
		return commerce_imageFileName;
	}
	
	public void setCommerce_imageFileName(String commerce_imageFileName) {
		try {
			if(commerce_imageFileName!= null && commerce_imageFileName.length()!=0) {
				this.commerce_imageFileName = URLEncoder.encode(commerce_imageFileName,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public Date getCommerce_regDate() {
		return commerce_regDate;
	}
	
	public void setCommerce_regDate(Date commerce_regDate) {
		this.commerce_regDate = commerce_regDate;
	}
	
	public int getCommerce_articleNO() {
		return commerce_articleNO;
	}
	
	public void setCommerce_articleNO(int commerce_articleNO) {
		this.commerce_articleNO = commerce_articleNO;
	}
	
}