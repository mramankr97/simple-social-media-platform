package com.masai.Service;

import com.masai.Model.Post;
import com.masai.Model.User;
import com.masai.exception.PostException;
import com.masai.exception.UserException;

public interface PostService {

	public Post addPost(Integer user_id,Post post)throws UserException,PostException;
	public Post getPostById(Integer pid)throws PostException;
	public Post updatePostById(Integer pid,Post post)throws PostException;
	public Post deletePost(Integer pid)throws PostException;
	
}
