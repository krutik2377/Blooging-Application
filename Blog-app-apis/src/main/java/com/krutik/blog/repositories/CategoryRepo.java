package com.krutik.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krutik.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
