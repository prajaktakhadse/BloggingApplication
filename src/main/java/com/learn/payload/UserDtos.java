package com.learn.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDtos {
	
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private String about;
}
