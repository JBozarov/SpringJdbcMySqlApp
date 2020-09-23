package com.bozarov.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bozarov.springjdbc.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository; 
	
	@GetMapping("/{id}")
	public String getSingleUsername(@PathVariable String id ) {
		System.out.println(id);
		return userRepository.getSingleUsername(id);
	}
	
	@GetMapping("/usernames")
	public List<String> getAllUserNames() {
		return userRepository.getAllUserNames(); 
	}
}
