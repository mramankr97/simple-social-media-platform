package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
