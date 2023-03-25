package com.krutik.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krutik.blog.entities.Category;
import com.krutik.blog.entities.Post;
import com.krutik.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
