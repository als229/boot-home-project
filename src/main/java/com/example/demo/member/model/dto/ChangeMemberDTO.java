package com.example.demo.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ChangeMemberDTO {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String email;
	private Long memberNo;
}
