package com.mySpring.myapp.mountain.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


@Component("mountainVO")
public class MountainVO {
   private String mountain_name;
   private String mountain_activity;
   private String mountain_career;
   private String mountain_purpose;
   private String mountain_recommend;
   
   
   public String getMountain_name() {
      return mountain_name;
   }
   public void setMountain_name(String mountain_name) {
      this.mountain_name = mountain_name;
   }
   public String getMountain_activity() {
      return mountain_activity;
   }
   public void setMountain_activity(String mountain_activity) {
      this.mountain_activity = mountain_activity;
   }
   public String getMountain_career() {
      return mountain_career;
   }
   public void setMountain_career(String mountain_career) {
      this.mountain_career = mountain_career;
   }
   public String getMountain_purpose() {
      return mountain_purpose;
   }
   public void setMountain_purpose(String mountain_purpose) {
      this.mountain_purpose = mountain_purpose;
   }
   public String getMountain_recommend() {
      return mountain_recommend;
   }
   public void setMountain_recommend(String mountain_recommend) {
      this.mountain_recommend = mountain_recommend;
   }
   

}