package com.bozarov.springjdbc.repository;

import java.util.List;

public interface CrudRepository {
	
	public List<String> getAllUserNames();

	String getSingleUsername(String id); 
}
