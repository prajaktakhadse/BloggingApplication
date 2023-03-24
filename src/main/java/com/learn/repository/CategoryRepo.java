package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
