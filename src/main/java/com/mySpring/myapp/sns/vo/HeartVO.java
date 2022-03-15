package com.mySpring.myapp.sns.vo;

import org.springframework.stereotype.Component;

@Component("HeartVO")
public class HeartVO {
	private int sns_articleNO;
	private String member_id;
	private String sns_heartcnt;
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
	public String getSns_heartcnt() {
		return sns_heartcnt;
	}
	public void setSns_heartcnt(String sns_heartcnt) {
		this.sns_heartcnt = sns_heartcnt;
	}
	
	
	
	
 
}