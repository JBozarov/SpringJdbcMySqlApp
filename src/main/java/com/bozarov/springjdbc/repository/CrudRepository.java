package com.bozarov.springjdbc.repository;

import java.util.List;

import com.bozarov.springjdbc.entity.User;

public interface CrudRepository {
	
	public List<String> getAllUserNames();

	String getSingleUsername(String id);

	String deleteUser(String id);

	String createUser(User user); 
}
