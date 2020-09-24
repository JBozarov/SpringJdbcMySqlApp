package com.bozarov.springjdbc.repository;

import org.springframework.jdbc.core.RowMapper;

import com.bozarov.springjdbc.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getString("id"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));

        return user;

    }
}