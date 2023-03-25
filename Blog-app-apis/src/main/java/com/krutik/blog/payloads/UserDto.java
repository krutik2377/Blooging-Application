package com.krutik.blog.payloads;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(min = 4 , message = "Username must contains atleast 4 characters !!")
	private String name;
	
	@jakarta.validation.constraints.Email(message = "Your Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3 , max =10 , message = "Password must be minimum of 3 chars and be maximum of 10 chars !!")
	private String password;
	
	@NotEmpty
	private String about;
}
