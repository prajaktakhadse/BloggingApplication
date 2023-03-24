package com.learn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.User;
import com.learn.exception.ResourceNotFoundException;
import com.learn.payload.UserDtos;
import com.learn.repository.UserRepo;
import com.learn.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public UserDtos createUser(UserDtos userdto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userdto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDtos updateUser(UserDtos userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user);
		return this.userToDto(updateUser);
	}

	@Override
	public UserDtos getUserById(Integer userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDtos> getAllUsers() {
		
		List<User>	 findUser = this.userRepo.findAll();
		List<UserDtos> userDtos = findUser.stream().map(finduser -> this.userToDto(finduser)).collect(Collectors.toList());
			return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);
	}
	
	
	private User dtoToUser(UserDtos userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setUserId(userDto.getUserId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}

	
	private UserDtos userToDto(User user) {
		UserDtos userDtos  = this.modelMapper.map(user, UserDtos.class);
//		userDtos.setUserId(user.getUserId());
//		userDtos.setName(user.getName());
//		userDtos.setEmail(user.getEmail());
//		userDtos.setPassword(user.getPassword());
//		userDtos.setAbout(user.getAbout());
		return userDtos;
	}
}
