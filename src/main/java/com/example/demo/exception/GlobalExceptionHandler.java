package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	private ResponseEntity<?> makeResponseEntity(RuntimeException e, HttpStatus status){
		Map<String, String> error = new HashMap();
		error.put("error-message", e.getMessage());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(CustomAuthenticationException.class)
	public ResponseEntity<?> handleInvalidUserError(CustomAuthenticationException  e){
		
		return makeResponseEntity(e, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(MemberIdDuplicateException.class)
	public ResponseEntity<?> handleInvalidUserError(MemberIdDuplicateException  e){
		
		return makeResponseEntity(e, HttpStatus.UNAUTHORIZED);
	}

	
	
}
