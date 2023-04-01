package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
