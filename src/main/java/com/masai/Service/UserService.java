package com.masai.Service;

import java.util.List;

import com.masai.Model.User;
import com.masai.exception.UserException;

public interface UserService {

	public User addUser(User user)throws UserException;
	public User getUserById(Integer user_id)throws UserException;
	public User updateUserById(Integer user_id, User user)throws UserException;
	public User deleteUser(Integer user_id)throws UserException;
	public List<User> getAllUser()throws UserException;
	
	//GET /analytics/users/top-active: Retrieve the top 5 most active users, based on the number of posts
}
