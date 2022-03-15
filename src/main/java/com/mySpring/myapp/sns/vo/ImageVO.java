package com.mySpring.myapp.sns.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("imageVO")
public class ImageVO {
	private int sns_imageFileNO;
	private String sns_imageFileName;
	private Date sns_regDate;
	private int sns_articleNO;
	
	
	public int getSns_imageFileNO() {
		return sns_imageFileNO;
	}
	public void setSns_imageFileNO(int sns_imageFileNO) {
		this.sns_imageFileNO = sns_imageFileNO;
	}
	public String getSns_imageFileName() {
		return sns_imageFileName;
	}
	public void setSns_imageFileName(String sns_imageFileName) {
		try {
	         if(sns_imageFileName!= null && sns_imageFileName.length()!=0) {
	            this.sns_imageFileName = URLEncoder.encode(sns_imageFileName,"UTF-8");
	         }
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
	}
	public Date getSns_regDate() {
		return sns_regDate;
	}
	public void setSns_regDate(Date sns_regDate) {
		this.sns_regDate = sns_regDate;
	}
	public int getSns_articleNO() {
		return sns_articleNO;
	}
	public void setSns_articleNO(int sns_articleNO) {
		this.sns_articleNO = sns_articleNO;
	}
	
	
	
	

}