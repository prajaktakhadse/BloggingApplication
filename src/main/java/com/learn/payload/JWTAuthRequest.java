package com.learn.payload;

import lombok.Data;

@Data
public class JWTAuthRequest {

	private String username;//email as username
	
	private String password;
	
}
