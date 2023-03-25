package com.krutik.blog.services;

import java.util.List;

import com.krutik.blog.entities.User;
import com.krutik.blog.payloads.UserDto;

//only add those fields that you want to take from user.
public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user , Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUsers();
	void deleteuser(Integer userId);
}
