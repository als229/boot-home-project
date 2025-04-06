package com.example.demo.exception;

public class MemberIdDuplicateException extends RuntimeException{

	public MemberIdDuplicateException(String message) {
		super(message);
	}
}
