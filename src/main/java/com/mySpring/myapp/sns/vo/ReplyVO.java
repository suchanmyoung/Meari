package com.mySpring.myapp.sns.vo;

import org.springframework.stereotype.Component;

@Component("replyVO")
public class ReplyVO {
   
   private int sns_replyNO;
   private int sns_articleNO;
   private String member_id;
   private String sns_reply;
   public int getSns_replyNO() {
      return sns_replyNO;
   }
   public void setSns_replyNO(int sns_replyNO) {
      this.sns_replyNO = sns_replyNO;
   }
   public int getSns_articleNO() {
      return sns_articleNO;
   }
   public void setSns_articleNO(int sns_articleNO) {
      this.sns_articleNO = sns_articleNO;
   }
   public String getMember_id() {
      return member_id;
   }
   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }
   public String getSns_reply() {
      return sns_reply;
   }
   public void setSns_reply(String sns_reply) {
      this.sns_reply = sns_reply;
   }
      

}