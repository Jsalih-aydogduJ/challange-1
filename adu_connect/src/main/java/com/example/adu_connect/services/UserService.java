package com.example.adu_connect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.adu_connect.entities.User;
import com.example.adu_connect.repository.UserRepository;

@Service
public class UserService {

	
	UserRepository userRepository;
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}




	public User saveOneUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}


	public User getOneUserById(Long userId){
		//custom exception
		return userRepository.findById(userId).orElse(null);
	}



	public User updateOneUser(Long userId, User newUser) {
	    Optional<User> user = userRepository.findById(userId);
	    if (user.isPresent()) {
	        User foundUser = user.get();
	        foundUser.setUserName(newUser.getUserName());
	        foundUser.setSurname(newUser.getSurname());
	        foundUser.setNickname(newUser.getNickname());
	        foundUser.setTelefonNumarasi(newUser.getTelefonNumarasi());
	        foundUser.setUserSifre(newUser.getUserSifre());
	        userRepository.save(foundUser);
	        return foundUser;
	    } else {
	        return null;
	    }
	}




	public void deleteOneUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}




}
