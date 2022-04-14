package com.mySpring.myapp.member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Member {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "REGDATE")
	private Timestamp regDate;

	public Member(Member member) {
		this.id = member.getId();
		this.password = member.getPassword();
		this.name = member.getName();
		this.email = member.getEmail();
		this.regDate = member.getRegDate();
	}
}