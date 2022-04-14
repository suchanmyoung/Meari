package com.mySpring.myapp.member.vo;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class MemberVO {

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
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime regDate;

	public MemberVO() {

	}
}