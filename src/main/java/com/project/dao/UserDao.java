package com.project.dao;

import java.sql.SQLException;

import com.project.model.User;

public interface UserDao {
	
	public int regUser(User user) throws SQLException;

	public int updateUser(User user) throws SQLException;

	public int deletUser(Integer userId) throws SQLException;
	
	public User authenticate(String loginName, String password) throws SQLException;

}
