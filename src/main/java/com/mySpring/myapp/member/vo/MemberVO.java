package com.mySpring.myapp.member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class MemberVO {

	@Id
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPwCorr;
	private Date joinDate;

	public MemberVO() {

	}
}