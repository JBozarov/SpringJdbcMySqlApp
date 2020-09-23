package com.bozarov.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bozarov.springjdbc.entity.User;

@Repository
public class UserRepository implements CrudRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate; 

	@Override
	public List<String> getAllUserNames() {
		List<String> usernameList = new ArrayList<>(); 
		usernameList.addAll(jdbcTemplate.queryForList("select name from users;", String.class)); 
		return usernameList; 
	}

	
	// Make sure know the differences between query for single row and query for multiple rows
	// Also make sure query returns one value or multiple values in single row:
	// https://mkyong.com/spring/spring-jdbctemplate-querying-examples/
	@Override
	public String getSingleUsername(String id) {
		String SQL = "SELECT name from USERS where id=?";
		String result; 
		try {
			result = jdbcTemplate.queryForObject(SQL, new Object[] {id}, String.class);
		} catch (Exception e) {
			result = "User doesn't exist"; 
		}
		return result; 
	}


	@Override
	public String deleteUser(String id) {
		String SQL = "SELECT name from USERS where id=?";
		String deletedUserName = jdbcTemplate.queryForObject(SQL, new Object[] {id}, String.class);
		String deleteSql = "delete from users where id=?";
		jdbcTemplate.update(deleteSql , id); 
		return deletedUserName + " is deleted";
	}


	@Override
	public String createUser(User user) {
		String returnValue; 
		System.out.println("line 55 repo " + user.toString());
		try {
			String sql = "INSERT INTO users(id, email, name) values (?, ?, ?)"; 
			jdbcTemplate.update(sql, user.getId(), user.getEmail(), user.getName()); 
			returnValue = user.getName();
		} catch (Exception e) {
			returnValue = "Error in creating user"; 
		}
		return returnValue;
	}

}
