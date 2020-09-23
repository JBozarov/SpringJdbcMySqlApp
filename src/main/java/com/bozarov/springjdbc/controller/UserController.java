package com.bozarov.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bozarov.springjdbc.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository; 
	
	@GetMapping("/test")
	public String check() {
		return "Welcome"; 
	}
	
	@GetMapping("/usernames")
	public List<String> getAllUserNames() {
		return userRepository.getAllUserNames(); 
	}
}
