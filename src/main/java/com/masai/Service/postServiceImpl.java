package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.PostDao;
import com.masai.Dao.UserDao;

@Service
public class postServiceImpl implements PostService{
	@Autowired
	private PostDao pDao;
	
	@Autowired
	private UserDao uDao;

}
