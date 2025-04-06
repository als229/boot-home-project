package com.example.demo.member.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@Builder
public class Member {
	private Long memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String email;
	private Date enrollDate;
	private String status;
	private String role;

}
