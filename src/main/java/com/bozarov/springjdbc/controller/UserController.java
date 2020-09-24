package com.bozarov.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bozarov.springjdbc.entity.User;
import com.bozarov.springjdbc.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository; 
	
	@PostMapping("/newuser")
	public User createUser(@RequestBody User user) {
		return userRepository.createUser(user); 
	}
	
	@GetMapping("/single/{id}")
	public User getUser(@PathVariable String id) {
		return userRepository.getUser(id); 
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers() {
		return userRepository.getAllUsers(); 
	}
	
	
	@GetMapping("/{id}")
	public String getSingleUsername(@PathVariable String id ) {
		return userRepository.getSingleUsername(id);
	}
	
	
	@GetMapping("/usernames")
	public List<String> getAllUserNames() {
		return userRepository.getAllUserNames(); 
	}
	
	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable String id) {
		return userRepository.deleteUser(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User oldUser) {
		return userRepository.updateUser(id, oldUser); 
	}
	
	
	
}
