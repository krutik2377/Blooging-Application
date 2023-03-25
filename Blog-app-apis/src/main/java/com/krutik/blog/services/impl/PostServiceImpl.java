package com.krutik.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.ResourceClosedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krutik.blog.entities.Category;
import com.krutik.blog.entities.Post;
import com.krutik.blog.entities.User;
import com.krutik.blog.exceptions.ResourceNotFoundException;
import com.krutik.blog.payloads.PostDto;
import com.krutik.blog.payloads.UserDto;
import com.krutik.blog.repositories.CategoryRepo;
import com.krutik.blog.repositories.PostRepo;
import com.krutik.blog.repositories.UserRepo;
import com.krutik.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id",userId));
		Category category  = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id",categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCategory(category); 
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postsDtos = posts.stream().map((post) -> this.modelMapper.map(posts , PostDto.class)).collect(Collectors.toList());
		return postsDtos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
