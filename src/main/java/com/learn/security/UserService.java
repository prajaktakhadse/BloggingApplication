package com.learn.security;

import com.learn.entities.User;
import com.learn.payload.UserDtos;

public interface UserService {

	UserDtos createUser(User user);
}
