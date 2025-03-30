package com.example.demo.member.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.member.model.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	
	// 아이디 있나 확인
	@Select("SELECT COUNT(MEMBER_ID) FROM KKM_MEMBER WHERE MEMBER_ID = #{memberId}")
	int checkMemberId(String memberId);
	
	// 로그인
	@Select("		SELECT \r\n"
			+ "			  	  MEMBER_NO memberNo\r\n"
			+ "				, MEMBER_ID memberId\r\n"
			+ "				, MEMBER_PW memberPw\r\n"
			+ "				, EMAIL email\r\n"
			+ "				, PHONE phone\r\n"
			+ "				, TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') enrollDate\r\n"
			+ "		FROM\r\n"
			+ "				KKM_MEMBER\r\n"
			+ "		WHERE \r\n"
			+ "				MEMBER_ID = #{memberId}\r\n"
			+ "			AND	\r\n"
			+ "				MEMBER_PW = #{memberPw}")
	MemberDTO loginMember(MemberDTO member);
	
	
}
