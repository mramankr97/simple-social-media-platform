package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Post;

public interface PostDao extends JpaRepository<Post, Integer>{

}
