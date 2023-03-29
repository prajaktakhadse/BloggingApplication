package com.learn.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entities.User;
import com.learn.exception.ApiException;
import com.learn.payload.JWTAuthRequest;
import com.learn.payload.JWTAuthResponse;
import com.learn.payload.UserDtos;
import com.learn.repository.UserRepo;
import com.learn.security.JWTTokenHelper;
import com.learn.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/auth/")
public class AuthController {

	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> createToken(@RequestBody JWTAuthRequest request ) throws Exception{
		
		this.authenticate(request.getUsername(), request.getPassword());
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(userDetails);//here got the token
		
		JWTAuthResponse response = new JWTAuthResponse();
		response.setToken(token);
		
		
		return new  ResponseEntity<JWTAuthResponse>(response, HttpStatus.OK);
	}
	
	
	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.authenticationManager.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Details !!");
			throw new ApiException("Invalid username or password !!");
		}

	}
	
	//register new user api
	

	@PostMapping("/register")
	public ResponseEntity<UserDtos> registerUser(@Valid @RequestBody UserDtos userDto) {
		UserDtos registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDtos>(registeredUser, HttpStatus.CREATED);
	}


	@GetMapping("/current-user/")
	public ResponseEntity<UserDtos> getUser(Principal principal) {
		User user = this.userRepo.findByEmail(principal.getName()).get();
		return new ResponseEntity<UserDtos>(this.mapper.map(user, UserDtos.class), HttpStatus.OK);
	}
	
	
}

























