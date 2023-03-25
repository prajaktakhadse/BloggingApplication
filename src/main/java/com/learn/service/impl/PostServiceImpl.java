package com.learn.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entities.Category;
import com.learn.entities.Post;
import com.learn.entities.User;
import com.learn.exception.ResourceNotFoundException;
import com.learn.payload.PostDto;
import com.learn.payload.UserDtos;
import com.learn.repository.CategoryRepo;
import com.learn.repository.PostRepo;
import com.learn.repository.UserRepo;
import com.learn.service.PostService;

public class PostServiceImpl implements PostService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","userId" , userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() ->
		new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(postDto.getAddedDate());
		post.setUser(user);
		post.setCategory(category);
		
		Post newpost = this.postRepo.save(post);
		return this.modelMapper.map(newpost, PostDto.class);
	}

	@Override
	public PostDto updatepost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> 
					new ResourceNotFoundException("Post","postId", postId));
		
		Category category = this.categoryRepo.findById(postDto.getCategory().getCategoryId()).get();
			post.setTitle(postDto.getTitle());
	        post.setContent(postDto.getContent());
	        post.setImageName(postDto.getImageName());
	        post.setCategory(category);
	        
	        Post updatedpost = this.postRepo.save(post);

		return this.modelMapper.map(updatedpost,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDtos> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
