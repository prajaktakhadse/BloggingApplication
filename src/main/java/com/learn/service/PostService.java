package com.learn.service;

import java.util.List;

import com.learn.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatepost(PostDto postDto, Integer postId);
		
	void deletePost(Integer postId);
	
	List<PostDto> getAllPost();
	
	//get post by id
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
}
