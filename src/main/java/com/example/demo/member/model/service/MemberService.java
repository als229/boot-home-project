package com.example.demo.member.model.service;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.member.model.dto.ChangeMemberDTO;
import com.example.demo.member.model.dto.MemberDTO;

@Service
public interface MemberService {
	
	void insertMember(MemberDTO member);
	
	Map<String, String> updateMember(ChangeMemberDTO member);
	
	void deleteMember(Long memberNo);
}
