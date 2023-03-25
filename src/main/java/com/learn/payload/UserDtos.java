package com.learn.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
