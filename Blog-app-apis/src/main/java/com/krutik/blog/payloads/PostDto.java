package com.krutik.blog.payloads;

import java.util.Date;

import com.krutik.blog.entities.Category;
import com.krutik.blog.entities.User;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto  user;
}
