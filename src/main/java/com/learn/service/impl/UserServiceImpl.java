package com.learn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.entities.User;
import com.learn.exception.ResourceNotFoundException;
import com.learn.payload.UserDtos;
import com.learn.repository.UserRepo;
import com.learn.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDtos createUser(UserDtos userdto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userdto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDtos updateUser(UserDtos userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user);
		return this.userToDto(updateUser);
	}

	@Override
	public UserDtos getUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDtos> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub
		
	}
	
	
	private User dtoToUser(UserDtos userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}

	
	private UserDtos userToDto(User user) {
		UserDtos userDtos  = new UserDtos();
		userDtos.setUserId(user.getUserId());
		userDtos.setName(user.getName());
		userDtos.setEmail(user.getEmail());
		userDtos.setPassword(user.getPassword());
		userDtos.setAbout(user.getAbout());
		return userDtos;
	}
}
