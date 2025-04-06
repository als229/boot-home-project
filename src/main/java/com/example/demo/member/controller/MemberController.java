package com.example.demo.member.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.model.dto.ChangeMemberDTO;
import com.example.demo.member.model.dto.MemberDTO;
import com.example.demo.member.model.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping
	public ResponseEntity<?> insertMember(@RequestBody @Valid MemberDTO member){
		log.info("여기오닝? {}", member);
		memberService.insertMember(member);
//		log.info("여기오닝? {}", member);
		
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<?> updateMember(@RequestBody @Valid ChangeMemberDTO member){
		log.info("비밀번호 잘넘어옴? : {} " , member);
		Map<String, String> loginResponse = memberService.updateMember(member);
		
		return ResponseEntity.ok(loginResponse);
	}
	
	@DeleteMapping("/{memberNo}")
	public ResponseEntity<ChangeMemberDTO> update(@PathVariable(name="memberNo") Long memberNo){
		
		log.info("삭제넘어오냐? {}" ,memberNo);
		memberService.deleteMember(memberNo);
		return ResponseEntity.status(201).build();
	}
	
}