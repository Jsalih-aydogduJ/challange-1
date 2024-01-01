package com.example.adu_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adu_connect.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	
	
	

	
	 List<Post> findByUserId(Long userId);

}
