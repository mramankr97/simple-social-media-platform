package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.User;
import com.masai.Service.UserService;
import com.masai.exception.UserException;


@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		
		User savedUser=uService.addUser(user);
		
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/user/{user_id}")
	public ResponseEntity<User> updateUserHandler(@PathVariable("user_id")Integer user_id,@RequestBody User user) throws UserException{
		
		User updateUser=uService.updateUserById(user_id, user);
		
		return new ResponseEntity<User>(updateUser,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException {
		
		List<User> user=uService.getAllUser();
		
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("user_id")Integer user_id) throws UserException{
		
		User existingUser= uService.getUserById(user_id);
		
		return new ResponseEntity<User>(existingUser,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/users/{Id}")
	public ResponseEntity<User> deleteUserByIdHandler(@PathVariable("Id")Integer user_id) throws UserException{
		
		User delUser=uService.deleteUser(user_id);
		
		return new ResponseEntity<User>(delUser,HttpStatus.OK);
	}
}
