package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
