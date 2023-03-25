// You can take those fields which you want to take from the user as well as you can also take those fields which you gonna counting from it. 
package com.krutik.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor	
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(generator = "id",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="id" , sequenceName = "Id" , initialValue = 1 , allocationSize = 1)
	private int id;
	
	@Column(nullable = false , length = 100)
	private String name;
	
	@Email
	private String email;
	
	private String password;
	
	private String about;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
}
