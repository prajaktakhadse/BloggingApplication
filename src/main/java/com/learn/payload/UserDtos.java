package com.learn.payload;


import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDtos {
	
	private Integer userId;
	@NotEmpty 
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String name;
	
	@Email(message = "Email address is not valid !!")
	@NotEmpty(message = "Email is required !!")
	@NotNull   
	private String email;
	

	@NotEmpty 
	@Size(min = 6, max = 15, message = "Password must be min of 6 chars and max of 15 chars !!")
	private String password;
	
	@NotEmpty 
	private String about;
	

}
