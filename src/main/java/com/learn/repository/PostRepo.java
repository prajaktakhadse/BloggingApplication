package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
