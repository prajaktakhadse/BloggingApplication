package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.payload.UserDtos;
import com.learn.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDtos> createUser(@Valid @RequestBody UserDtos userDtos){
		UserDtos createUserDtos = this.userService.createUser(userDtos);
		return new ResponseEntity<UserDtos>(createUserDtos, HttpStatus.CREATED);
	}
}
