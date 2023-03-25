package com.krutik.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krutik.blog.payloads.CategoryDto;


public interface CategoryService {
	
	// Create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	// update
	public CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	
	// Read (get)
	CategoryDto getCategory(Integer categoryId);
	
	//get all
	List<CategoryDto> getCategories();
	
}
