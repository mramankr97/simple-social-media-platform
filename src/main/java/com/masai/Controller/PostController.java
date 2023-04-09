package com.masai.Controller;

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

import com.masai.Model.Post;
import com.masai.Model.User;
import com.masai.Service.PostService;
import com.masai.exception.PostException;
import com.masai.exception.UserException;

@RestController
public class PostController {

	@Autowired
	private PostService pService;
	
	
	@PostMapping("/posts/{id}")
	public ResponseEntity<Post> registerPost(@PathVariable("id")Integer user_id,@RequestBody Post post) throws PostException,UserException{
		
		Post savedPost=pService.addPost(user_id, post);
		
		return new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/posts/{pid}")
	public ResponseEntity<Post> getPostByIdHandler(@PathVariable("pid")Integer pid) throws PostException{
		
		Post existingPost= pService.getPostById(pid);
		
		return new ResponseEntity<Post>(existingPost,HttpStatus.OK);
	}
	
	@PutMapping("/posts/{pid}")
	public ResponseEntity<Post> updatePostHandler(@PathVariable("pid")Integer pid,@RequestBody Post post) throws PostException{
		
		Post updatePost=pService.updatePostById(pid,post);
		
		return new ResponseEntity<Post>(updatePost,HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/post/{Id}")
	public ResponseEntity<Post> deletePostByIdHandler(@PathVariable("Id")Integer pid) throws PostException{
		
		Post delPost=pService.deletePost(pid);
		
		return new ResponseEntity<Post>(delPost,HttpStatus.OK);
	}
}
