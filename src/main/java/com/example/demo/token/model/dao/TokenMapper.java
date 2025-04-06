package com.example.demo.token.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.token.model.vo.RefreshToken;

@Mapper
public interface TokenMapper {
   
	@Insert("      INSERT\r\n"
			+ "         INTO\r\n"
			+ "            PP_TOKEN         \r\n"
			+ "         VALUES(\r\n"
			+ "               #{token}\r\n"
			+ "                ,#{memberNo}\r\n"
			+ "               ,#{expiration}\r\n"
			+ "         \r\n"
			+ "         )\r\n"
			+ "         ")
   void saveToken(RefreshToken token);
   
	@Select("		SELECT \r\n"
			+ "			TOKEN, \r\n"
			+ "			MEMBER_NO memberNo, \r\n"
			+ "			EXPIRATION \r\n"
			+ "		FROM \r\n"
			+ "			PP_TOKEN \r\n"
			+ "		WHERE \r\n"
			+ "			TOKEN = #{token}	")
   RefreshToken findByToken(RefreshToken token);
   
   @Delete("    DELETE\r\n"
   		+ "         FROM\r\n"
   		+ "            PP_TOKEN\r\n"
   		+ "      WHERE\r\n"
   		+ "            EXPIRATION < #{now}")
   void deleteExpiredRefreshToken(Long now);
}
