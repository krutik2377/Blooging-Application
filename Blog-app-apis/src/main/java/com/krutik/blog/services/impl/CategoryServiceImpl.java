package com.krutik.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krutik.blog.entities.Category;
import com.krutik.blog.exceptions.ResourceNotFoundException;
import com.krutik.blog.payloads.CategoryDto;
import com.krutik.blog.repositories.CategoryRepo;
import com.krutik.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		cat.setCategorytitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories= this.categoryRepo.findAll();
		
		List<CategoryDto> catDtos  = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
