package com.masai.Model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;


@Entity
@Data

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Size(min = 1,max = 50,message = "characters shouldn't be more than 50.")
	private String name;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@Size(min = 0,max = 200,message = "characters shouldn't be more than 200.")
	private String bio;
	
	private Instant created_at;
	private Instant updated_at;
		
}
