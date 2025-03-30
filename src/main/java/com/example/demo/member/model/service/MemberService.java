package com.example.demo.member.model.service;


import org.springframework.stereotype.Service;

import com.example.demo.member.model.dto.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Service
public interface MemberService {
	// 로그인
	MemberDTO loginMember(MemberDTO member, HttpSession session);
	
	// 회원가입
	MemberDTO insertMember(MemberDTO member);
}
