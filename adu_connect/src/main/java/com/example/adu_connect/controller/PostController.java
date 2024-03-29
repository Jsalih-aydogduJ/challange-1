package com.example.adu_connect.controller;

import java.util.List;
import java.util.Optional;
import com.example.adu_connect.entities.Post;
import com.example.adu_connect.requests.PostCreateRequest;
import com.example.adu_connect.requests.PostUpdateRequest;
import com.example.adu_connect.responses.PostResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adu_connect.services.PostService;
import com.example.adu_connect.services.UserService;

@RestController
@RequestMapping("/posts")
public class PostController {

	
	private PostService postService;
	

	public PostController(PostService postService,UserService userService) {
				this.postService = postService;
				
	}
	
	
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		
		return postService.createOnePost(newPostRequest);
	}
	
	
	
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updateRequest) {
		return postService.updateOnePostById(postId,updateRequest);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		 postService.deleteOnePostById(postId);
	}
	

	
	
	
	
	
	
	
	
	
	
}
