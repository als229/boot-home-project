package com.example.demo.auth.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.auth.model.vo.CustomUserDetails;
import com.example.demo.exception.CustomAuthenticationException;
import com.example.demo.member.model.dao.MemberDAO;
import com.example.demo.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	// AuthenticationManager가 실질적으로 사용자의 정보를 조회하는 클래스
	
	private final MemberDAO memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		MemberDTO user = memberDao.mung(username);
		
		if(user == null) {
			throw new CustomAuthenticationException("존재하지 않는 사용자입니다.");
		}
		
		// 사용자가 입력한 아이디 값이 테이블에 존재하긴 함
		
		
		return  CustomUserDetails.builder().memberNo(user.getMemberNo())
										  .username(user.getMemberId())
										  .password(user.getMemberPw())
										  .memberName(user.getMemberName())
										  .email(user.getEmail())
										  .authorities(Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))).build();
	}

}