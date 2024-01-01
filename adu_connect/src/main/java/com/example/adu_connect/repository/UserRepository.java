package com.example.adu_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adu_connect.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
