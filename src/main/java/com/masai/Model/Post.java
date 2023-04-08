package com.masai.Model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_post",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "pid"))
	private int user_id;
	
	@Size(min = 1,max = 300,message = "character should be less than 300.")
	private String content;
	
	private LocalDate created_at;
	private LocalDate updated_at;
	
	
	private int like;
}
