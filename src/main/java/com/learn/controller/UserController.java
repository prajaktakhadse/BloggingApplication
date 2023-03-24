package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.payload.UserDtos;
import com.learn.service.UserService;

import jakarta.validation.Valid;

public class UserController {

	@Autowired
	private UserService userService;
	
	
	public ResponseEntity<UserDtos> createUser(@Valid @RequestBody UserDtos userDtos){
		UserDtos createUserDtos = this.userService.createUser(userDtos);
		return new ResponseEntity<UserDtos>(createUserDtos, HttpStatus.CREATED);
	}
}
