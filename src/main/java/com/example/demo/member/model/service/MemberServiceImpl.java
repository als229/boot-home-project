package com.example.demo.member.model.service;


import org.springframework.stereotype.Service;

import com.example.demo.member.model.dao.MemberDAO;
import com.example.demo.member.model.dto.MemberDTO;
import com.example.demo.member.model.util.MemberValidator;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;
	private final MemberValidator memberValidator;
	
	@Override
	public MemberDTO loginMember(MemberDTO member, HttpSession session) {

		memberValidator.checkMemberDTO(member);
		
		MemberDTO loginMember = memberDAO.loginMember(member);
		
		return loginMember;
	}

	@Override
	public MemberDTO insertMember(MemberDTO member) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
