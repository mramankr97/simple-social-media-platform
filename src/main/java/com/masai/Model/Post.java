package com.masai.Model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "user_id")
	private User user;
	
	@Size(min = 1,max = 300,message = "character should be less than 300.")
	private String content;
	
//	private Instant created_at;
//	private Instant updated_at;
//	
//	
//	private int like;
}
