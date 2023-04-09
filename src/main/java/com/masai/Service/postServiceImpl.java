package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.PostDao;
import com.masai.Dao.UserDao;
import com.masai.Model.Post;
import com.masai.Model.User;
import com.masai.exception.PostException;
import com.masai.exception.UserException;


@Service
public class postServiceImpl implements PostService{
	@Autowired
	private PostDao pDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public Post addPost(Integer user_id, Post post) throws UserException, PostException {
		
		Optional<User> opt=uDao.findById(user_id);
		
		if(opt.isPresent()) {
			Post p=pDao.save(post);
			return p;
		}
		else
			throw new UserException("User not found...");
	}

	@Override
	public Post getPostById(Integer pid) throws PostException {
		Optional<Post> opt=pDao.findById(pid);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else
			throw new PostException("User not found...");
	}

	@Override
	public Post updatePostById(Integer pid,Post post) throws PostException {

		Optional<Post> opt= pDao.findById(pid);
		
		if(opt.isPresent()) {
			
			Post updatedPost= pDao.save(post);
			return updatedPost;
			
		}else
			throw new PostException("Invalid Post details..");
	
	}

	@Override
	public Post deletePost(Integer pid) throws PostException {
		
		Optional<Post> opt= pDao.findById(pid);
		
		if(opt.isPresent()) {
			
			Post existingPost= opt.get();
			pDao.delete(existingPost);
			
			return existingPost;
			
			
		}else
			throw new PostException("Post does not exist with Id :"+pid);


	}

	

}
