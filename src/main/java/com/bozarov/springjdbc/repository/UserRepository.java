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
	public User createUser(User user) {
		User createdUser = null; 
		try {
			String sql = "INSERT INTO users(id, email, name) values (?, ?, ?)"; 
			jdbcTemplate.update(sql, user.getId(), user.getEmail(), user.getName()); 
			createdUser = getUser(user.getId()); 
		} catch (Exception e) {
			System.out.println(e);
		}
		return createdUser;
	}
	
	
	@Override
	public User getUser(String id) {
		User foundUser = null; 
		String sql = "select * from users where id=?"; 
		foundUser = jdbcTemplate.queryForObject(sql, new Object[] {id}, User.class); 
		return foundUser; 
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>(); 
		String sql = "select * from users"; 
		allUsers.addAll(jdbcTemplate.queryForList(sql, User.class)); 
		return allUsers; 
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
	public List<String> getAllUserNames() {
		List<String> usernameList = new ArrayList<>(); 
		usernameList.addAll(jdbcTemplate.queryForList("select name from users;", String.class)); 
		return usernameList; 
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
	public User updateUser(String id, User oldUser) {
		User updatedUser = null; 
		String sql = "UPDATE users SET email=?, name=? where id=?"; 
		jdbcTemplate.update(sql, oldUser.getEmail(), oldUser.getName(), id); 
		updatedUser = getUser(id); 
		return updatedUser;
	}




	

}
