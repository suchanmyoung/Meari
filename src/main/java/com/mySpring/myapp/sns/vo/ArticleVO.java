package com.mySpring.myapp.sns.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
   private int sns_articleNO;
   private String sns_content;
   private String member_id;
   private Date  sns_writeDate;
   private int sns_heart;
   
   
 


public ArticleVO() {
      System.out.println("ArticleVO  깮 꽦 옄");
   }


public int getSns_heart() {
	return sns_heart;
}




public void setSns_heart(int sns_heart) {
	this.sns_heart = sns_heart;
}


   
   
public int getSns_articleNO() {
	return sns_articleNO;
}


public void setSns_articleNO(int sns_articleNO) {
	this.sns_articleNO = sns_articleNO;
}


public String getSns_content() {
	return sns_content;
}


public void setSns_content(String sns_content) {
	this.sns_content = sns_content;
}


public String getMember_id() {
	return member_id;
}


public void setMember_id(String member_id) {
	this.member_id = member_id;
}


public Date getSns_writeDate() {
	return sns_writeDate;
}


public void setSns_writeDate(Date sns_writeDate) {
	this.sns_writeDate = sns_writeDate;
}

 


   
   
}