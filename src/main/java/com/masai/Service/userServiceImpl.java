package com.masai.Service;

import java.util.List;
import java.util.Optional;

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
		User u=uDao.save(user);
		return u;
	}

	@Override
	public User getUserById(Integer user_id) throws UserException {
		
		Optional<User> opt=uDao.findById(user_id);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
			throw new UserException("User doesn't Exist");
	}

	@Override
	public User updateUserById(Integer user_id, User user) throws UserException {
		
		Optional<User> opt= uDao.findById(user_id);
		
		if(opt.isPresent()) {
			
			User updatedUser= uDao.save(user);
			return updatedUser;
			
		}else
			throw new UserException("Invalid User details..");
	}

	@Override
	public User deleteUser(Integer user_id) throws UserException {
		
		Optional<User> opt= uDao.findById(user_id);
		
		if(opt.isPresent()) {
			
			User existingUser= opt.get();
			uDao.delete(existingUser);
			
			return existingUser;
			
		}else
			throw new UserException("User does not exist with Id :"+user_id);
		
	}


	@Override
	public List<User> getAllUser() throws UserException {
		
		List<User> user= uDao.findAll();
		
		if(user.size()==0)
			throw new UserException("No User is there");
		else
		return user;
	}

}
