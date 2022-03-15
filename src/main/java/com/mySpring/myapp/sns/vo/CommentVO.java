package com.mySpring.myapp.sns.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("CommentVO")
public class CommentVO {
   private int sns_articleNO;
   private String sns_comment;
   private Date sns_writeDate;
public int getSns_articleNO() {
	return sns_articleNO;
}
public void setSns_articleNO(int sns_articleNO) {
	this.sns_articleNO = sns_articleNO;
}
public String getSns_comment() {
	return sns_comment;
}
public void setSns_comment(String sns_comment) {
	this.sns_comment = sns_comment;
}
public Date getSns_writeDate() {
	return sns_writeDate;
}
public void setSns_writeDate(Date sns_writeDate) {
	this.sns_writeDate = sns_writeDate;
}
   
   
  
}