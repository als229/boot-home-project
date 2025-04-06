package com.example.demo.auth.service;

import java.util.Map;

import com.example.demo.auth.model.vo.CustomUserDetails;
import com.example.demo.member.model.dto.MemberDTO;

public interface AuthService {

	Map<String, String> login(MemberDTO member);
	
	CustomUserDetails getUserDetails();
}