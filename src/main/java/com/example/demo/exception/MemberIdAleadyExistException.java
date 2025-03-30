package com.example.demo.exception;

public class MemberIdAleadyExistException extends RuntimeException{
	public MemberIdAleadyExistException(String message) {
		super(message);
	}
}
