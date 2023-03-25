package com.krutik.blog.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krutik.blog.payloads.ApiResponse;
import com.krutik.blog.payloads.UserDto;
import com.krutik.blog.services.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/users")
public class UserController{
	@Autowired
	private UserService userService;
	
	//Post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//put-update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId)
	{
		UserDto updatedIser = this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedIser);
	}
	
	
	// get - get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	// get - get user
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId)
		{
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
	
	// delete-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId)
	{
		this.userService.deleteuser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
	}
}
