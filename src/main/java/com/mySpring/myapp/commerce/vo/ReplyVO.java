package com.mySpring.myapp.commerce.vo;

import org.springframework.stereotype.Component;

@Component("commerce_replyVO")
public class ReplyVO {
      private int commerce_replyNO;
      private int commerce_articleNO;
      private String member_id;
      private String commerce_reply;
      public int getCommerce_replyNO() {
         return commerce_replyNO;
      }
      public void setCommerce_replyNO(int commerce_replyNO) {
         this.commerce_replyNO = commerce_replyNO;
      }
      public int getCommerce_articleNO() {
         return commerce_articleNO;
      }
      public void setCommerce_articleNO(int commerce_articleNO) {
         this.commerce_articleNO = commerce_articleNO;
      }
      public String getMember_id() {
         return member_id;
      }
      public void setMember_id(String member_id) {
         this.member_id = member_id;
      }
      public String getCommerce_reply() {
         return commerce_reply;
      }
      public void setCommerce_reply(String commerce_reply) {
         this.commerce_reply = commerce_reply;
      }
      
      
      
}