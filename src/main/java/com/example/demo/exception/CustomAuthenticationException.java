package com.example.demo.exception;

public class CustomAuthenticationException extends RuntimeException{

	public CustomAuthenticationException(String message) {
		super(message);
	}
}
