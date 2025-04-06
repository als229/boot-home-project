package com.example.demo.token.model.vo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RefreshToken {
	private String token;
	private Long memberNo;
	private Long expiration;
	
	
}
