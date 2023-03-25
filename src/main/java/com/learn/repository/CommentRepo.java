package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
