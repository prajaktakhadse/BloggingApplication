package com.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entities.Category;
import com.learn.entities.Post;
import com.learn.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);	
}
