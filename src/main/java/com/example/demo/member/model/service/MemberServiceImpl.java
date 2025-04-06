package com.example.demo.member.model.service;


import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.auth.model.vo.CustomUserDetails;
import com.example.demo.exception.CustomAuthenticationException;
import com.example.demo.exception.MemberIdDuplicateException;
import com.example.demo.member.model.dao.MemberDAO;
import com.example.demo.member.model.dto.ChangeMemberDTO;
import com.example.demo.member.model.dto.MemberDTO;
import com.example.demo.member.model.vo.Member;
import com.example.demo.token.model.service.TokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;
	private final AuthenticationManager authenticationManager;
	
	@Override
	public void insertMember(MemberDTO member) {
		MemberDTO searchedMember = memberDAO.mung(member.getMemberId());
		
		if(searchedMember != null) {
			throw new MemberIdDuplicateException("이미 아이디가 있어유");
		}
		
		Member memberValue = Member.builder()
				.memberId(member.getMemberId())
				.memberPw(passwordEncoder.encode(member.getMemberPw()))
				.memberName(member.getMemberName())
				.email(member.getEmail())
				.role("ROLE_USER")
				.build();
		
		memberDAO.insertMember(memberValue);
		
	}

	@Override
	public Map<String, String> updateMember(ChangeMemberDTO member) {
		
		Member updateMember = Member.builder()
							  .memberName(member.getMemberName())
							  .email(member.getEmail())
							  .memberNo(member.getMemberNo())
							  .build();
		
		memberDAO.updateMember(updateMember);
		
		Authentication authentication = null;
		
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getMemberId(), member.getMemberPw()));
		}catch(AuthenticationException e) {
			throw new CustomAuthenticationException("아이디 또는 비밀번호 잘못 입력");
		}
		
		CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
		
		Map<String, String> loginResponse = tokenService.generateToken(user.getUsername()
																	  ,user.getMemberNo());
		
		loginResponse.put("memberId", user.getUsername());
		loginResponse.put("memberName", user.getMemberName());
		loginResponse.put("memberNo", String.valueOf(user.getMemberNo()));
		loginResponse.put("email", user.getEmail());
		
		return loginResponse;
		
	}

	@Override
	public void deleteMember(Long memberNo) {
		
		memberDAO.deleteMember(memberNo);
	}
	

}
