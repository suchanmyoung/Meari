package com.mySpring.myapp.member.vo;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProfileVO {

   @Id
   private String user_profileNO;
   private String user_imageFileName;
   private String user_content;
   private String member_id;
   public String getUser_profileNO() {
      return user_profileNO;
   }
   public void setUser_profileNO(String user_profileNO) {
      this.user_profileNO = user_profileNO;
   }
   public String getUser_imageFileName() {
      return user_imageFileName;
   }
   public void setUser_imageFileName(String user_imageFileName) {
      this.user_imageFileName = user_imageFileName;
   }
   public String getUser_content() {
      return user_content;
   }
   public void setUser_content(String user_content) {
      this.user_content = user_content;
   }
   public String getMember_id() {
      return member_id;
   }
   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }
   
   
}