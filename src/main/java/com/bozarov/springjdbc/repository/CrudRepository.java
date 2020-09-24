package com.bozarov.springjdbc.repository;

import java.util.List;

import com.bozarov.springjdbc.entity.User;

public interface CrudRepository {
	
	User createUser(User user);
	
	User getUser(String id);
	
	List<User> getAllUsers();
	
	String getSingleUsername(String id);
	
	public List<String> getAllUserNames();

	String deleteUser(String id);

	

	

	 
}
