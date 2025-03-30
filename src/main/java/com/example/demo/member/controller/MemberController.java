package com.example.demo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.member.model.dto.MemberDTO;
import com.example.demo.member.model.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	// 로그인 화면으로 이동
	@GetMapping("member-login-form.me")
	public String goMemberLoginEnrollForm() {
		return "member/member_login_form";
	}
	
	// 로그인 기능
	@PostMapping("member-login.me")
	public String loginMember(HttpSession session, MemberDTO member) {
		
		MemberDTO loginMember = memberService.loginMember(member, session);
		
		if(loginMember == null) {
			session.setAttribute("message", "로그인 정보가 없는디유?");
			return "redirect:member-login-form.me";
		}else {
			session.setAttribute("message", "어서 오세융~");
			session.setAttribute("loginMember", loginMember);
			
			return "redirect:/";
		}
		
	}
	
	// 로그아웃 기능
	@GetMapping("logout-Member.me")
	public String logoutMember(HttpSession session) {
		session.removeAttribute("loginMember");
		session.setAttribute("message", "로그아웃 되었습니다유");
		return "redirect:/";
	}
	
	// 회원가입 화면으로 이동
	@GetMapping("member-enroll-form.me")
	public String goMemberEnrollForm() {
		return "member/member_enroll_form";
	}
	
	
}