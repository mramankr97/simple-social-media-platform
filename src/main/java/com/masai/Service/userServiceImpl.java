package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.UserDao;
import com.masai.Model.User;
import com.masai.exception.UserException;

@Service
public class userServiceImpl implements UserService{

	@Autowired
	private UserDao uDao;

	
	@Override
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer user_id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserById(Integer user_id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Integer user_id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getAllUser() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
