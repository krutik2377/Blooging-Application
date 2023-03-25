package com.krutik.blog.services;

import java.util.List;

import com.krutik.blog.entities.Post;
import com.krutik.blog.payloads.PostDto;

public interface PostService {
	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	Post updatePost(PostDto postDto, Integer id);
	
	//delete
	void deletePost(Integer id);
	
	//get all post
	List<Post> getAllPost();
	
	//get post by id
	Post getPostById(Integer id);
	
	//get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by id
	List<PostDto> getPostsByUser(Integer userId);
	
	//search.
	List<Post> searchPosts(String keyword);
}
