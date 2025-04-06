package com.example.demo.member.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.member.model.dto.MemberDTO;
import com.example.demo.member.model.vo.Member;

@Mapper
public interface MemberDAO {

	@Select("		SELECT \r\n"
			+ "			  MEMBER_NO memberNo\r\n"
			+ "			, MEMBER_ID memberId\r\n"
			+ "			, MEMBER_PW memberPw\r\n"
			+ "			, MEMBER_NAME memberName\r\n"
			+ "			, EMAIL \r\n"
			+ "			, ENROLL_DATE enrollDate\r\n"
			+ "			, STATUS \r\n"
			+ "			, ROLE\r\n"
			+ "		FROM\r\n"
			+ "			PP_MEMBER\r\n"
			+ "		WHERE\r\n"
			+ "			MEMBER_ID = #{memberId}")
	MemberDTO mung(String memberId);
	
	@Insert("		INSERT\r\n"
			+ "		  INTO\r\n"
			+ "			PP_MEMBER\r\n"
			+ "		VALUES\r\n"
			+ "			(\r\n"
			+ "				  PP_MEM_SEQ.NEXTVAL\r\n"
			+ "				, #{memberId}\r\n"
			+ "				, #{memberPw}\r\n"
			+ "				, #{memberName}\r\n"
			+ "				, #{email}\r\n"
			+ "				, SYSDATE\r\n"
			+ "				, 'Y'\r\n"
			+ "				, #{role}\r\n"
			+ "			)	")
	int insertMember(Member member);
	
	@Update("UPDATE PP_MEMBER SET MEMBER_NAME = #{memberName} , EMAIL = #{email} WHERE MEMBER_NO = #{memberNo}")
	int updateMember(Member member);
	
	@Delete("DELETE PP_MEMBER WHERE MEMBER_NO = #{memberNo}")
	int deleteMember(Long memberNo);
}
