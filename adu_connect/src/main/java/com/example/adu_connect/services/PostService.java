package com.example.adu_connect.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.adu_connect.entities.Post;
import com.example.adu_connect.entities.User;
import com.example.adu_connect.repository.PostRepository;
import com.example.adu_connect.requests.PostCreateRequest;
import com.example.adu_connect.requests.PostUpdateRequest;
import com.example.adu_connect.responses.PostResponse;

@Service
public class PostService {
	
	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		
		this.postRepository = postRepository;
		this.userService = userService;
	}


	//JPA Repositorye metot ekledigim kisim

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		// TODO Auto-generated method stub
		
		if(userId.isPresent()) {
		 list = postRepository.findByUserId(userId.get());
		}
		
		list = postRepository.findAll();
		return list.stream().map(p-> new PostResponse(p)).collect(Collectors.toList());
			
	}



	public Post createOnePost(PostCreateRequest newPostRequest) {
		// TODO Auto-generated method stub
		
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user==null) {
			return null;
		}
		Post toSave = new Post();
		toSave.setIcerik(newPostRequest.getIcerik());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setId(newPostRequest.getId());
		toSave.setUser(user);
		
		
		return postRepository.save(toSave);
	}

	public Post getOnePostById(Long postId) {
		// TODO Auto-generated method stub
		return postRepository.findById(postId).orElse(null);
	}



	public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setIcerik(postUpdateRequest.getIcerik());
			toUpdate.setTitle(postUpdateRequest.getTitle());
		    postRepository.save(toUpdate);
		    return toUpdate;
		}
		return null;
	}



	public void deleteOnePostById(Long postId) {
		// TODO Auto-generated method stub
		postRepository.deleteById(postId);
	}

	
	
	
	
	
	
	
	
	
}
